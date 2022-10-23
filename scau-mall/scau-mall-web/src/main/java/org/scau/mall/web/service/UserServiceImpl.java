package org.scau.mall.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.scau.mall.dao.PmsUserMapper;
import org.scau.mall.service.pojo.PmsUser;
import org.scau.mall.service.pojo.PmsUserExample;
import org.scau.mall.service.pojo.PmsUserExample.Criteria;
import org.scau.mall.utils.BeanUtil;
import org.scau.mall.web.security.pojo.JwtUser;
import org.scau.mall.web.security.service.IUserService;
import org.scau.mall.web.security.util.JwtTokenUtil;
import org.scau.mall.web.vo.PageShowVo;
import org.scau.mall.web.vo.QueryVo;
import org.scau.mall.web.vo.UsersVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private PmsUserMapper pmsUserMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public int insertSelective(PmsUser record) {
        return pmsUserMapper.insertSelective(record);
    }

    public JwtUser getUserByName(String userName) {
        PmsUserExample example = new PmsUserExample();
        example.createCriteria().andUsernameEqualTo(userName).andStatusEqualTo(1);
        List<PmsUser> users = pmsUserMapper.selectByExample(example);
        JwtUser jwtUser = null;
        if(users.size() > 0) {
            jwtUser = new JwtUser(users.get(0));
        }
        return jwtUser;
    }

    @Override
    public UsersVo login(String username, String password, HttpServletRequest request) throws Exception{
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails || !passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new Exception("密码错误");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                , null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        //加上Bearer 这个前缀返回给前端
        token = "Bearer " + token;
        UsersVo vo = new UsersVo();
        vo.setStatus(1);
        vo.setUsername(userDetails.getUsername());
        vo.setToken(token);
        return vo;
    }
    
    /**
     * 分页获取用户列表
    		* @param vo
    		* @return
     */
    public PageShowVo<UsersVo> getUsersByPage(QueryVo vo){
        PmsUserExample example = new PmsUserExample();
        Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(vo.getQuery())) {
            criteria.andUsernameLike("%" + vo.getQuery() + "%");
        }
        int total = pmsUserMapper.countByExample(example);
        example.setOrderByClause("created_at desc limit " + vo.getOffSet() + "," + vo.getPagesize());
        List<PmsUser> list = pmsUserMapper.selectByExample(example);
        PageShowVo<UsersVo> showVo = new PageShowVo<UsersVo>();
        List<UsersVo> uservos = new ArrayList<UsersVo>();
        list.forEach(user ->{
            UsersVo uservo = new UsersVo();
            BeanUtil.copyFields(user, uservo, new String[] {});
            uservos.add(uservo);
        });
        showVo.setTotal(total);
        showVo.setPagenum(vo.getPagenum());
        showVo.setList(uservos);
        return showVo;
    }
    
    public PmsUser getPmsUserByName(String userName) {
        PmsUserExample example = new PmsUserExample();
        example.createCriteria().andUsernameEqualTo(userName).andStatusEqualTo(1);
        List<PmsUser> users = pmsUserMapper.selectByExample(example);
        PmsUser user = null;
        if(users.size() > 0) {
            user = users.get(0);
        }
        return user;
    }

    /**
     * 新增用户
    		* @param user
    		* @return
     */
    @Transactional
    public UsersVo addUser(PmsUser user) throws Exception{
        //查看该用户是否已存在，存在则直接返回
        JwtUser jwtuser = getUserByName(user.getUsername());
        if(jwtuser != null) {
            logger.error("{}该用户已存在", user.getUsername());
            throw new Exception("该用户已存在");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setStatus(1);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        pmsUserMapper.insert(user);
        UsersVo vo = new UsersVo();
        BeanUtil.copyFields(user, vo, new String[] {});
        return vo;
    }

    /**
     * 修改用户状态
    		* @param id
    		* @param mg_state
    		* @return
     */
    public UsersVo changeUserStatus(Integer id, boolean mg_state) throws Exception{
        PmsUser user = pmsUserMapper.selectByPrimaryKey(id);
        if(user == null) {
            logger.error("{}该用户id不存在！");
            throw new Exception("该用户id不存在！");
        }
        Integer status = mg_state ? 1 : 0;
        user.setStatus(status);
        user.setUpdatedAt(new Date());
        pmsUserMapper.updateByPrimaryKey(user);
        UsersVo vo = new UsersVo();
        BeanUtil.copyFields(user, vo, new String[] {});
        return vo;
    }

    public UsersVo getUserById(Integer id) throws Exception{
        PmsUser user = pmsUserMapper.selectByPrimaryKey(id);
        if(user == null) {
            logger.error("{}该用户id不存在！");
            throw new Exception("该用户id不存在！");
        }
        UsersVo vo = new UsersVo();
        BeanUtil.copyFields(user, vo, new String[] {});
        return vo;
    }

    public UsersVo editUser(Integer id, String mobile, String email) throws Exception {
        PmsUser user = pmsUserMapper.selectByPrimaryKey(id);
        if(user == null) {
            logger.error("{}该用户id不存在！");
            throw new Exception("该用户id不存在！");
        }
        user.setMobile(mobile);
        user.setEmail(email);
        user.setUpdatedAt(new Date());
        pmsUserMapper.updateByPrimaryKeySelective(user);
        UsersVo vo = new UsersVo();
        BeanUtil.copyFields(user, vo, new String[] {});
        return vo;
    }

    public void deleteUser(Integer id) throws Exception{
        pmsUserMapper.deleteByPrimaryKey(id);
    }
}
