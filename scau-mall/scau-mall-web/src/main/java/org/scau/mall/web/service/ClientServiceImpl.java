package org.scau.mall.web.service;

import java.util.ArrayList;
import java.util.List;

import org.scau.mall.dao.PmsClientMapper;
import org.scau.mall.pojo.PmsClient;
import org.scau.mall.pojo.PmsClientExample;
import org.scau.mall.pojo.PmsClientExample.Criteria;
import org.scau.mall.utils.BeanUtil;
import org.scau.mall.utils.DateUtil;
import org.scau.mall.web.vo.ClientsVo;
import org.scau.mall.web.vo.PageShowVo;
import org.scau.mall.web.vo.QueryVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ClientServiceImpl {
    
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    
    @Autowired
    private PmsClientMapper pmsClientMapper;

    /**
     * 分页获取客户列表
    		* @param vo
    		* @return
     */
    public PageShowVo<ClientsVo> getClientsByPage(QueryVo vo){
        PmsClientExample example = new PmsClientExample();
        Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(vo.getQuery())) {
            criteria.andNameLike("%" + vo.getQuery() + "%");
        }
        long total = pmsClientMapper.countByExample(example);
        example.setOrderByClause("created_at desc limit " + vo.getOffSet() + "," + vo.getPagesize());
        List<PmsClient> list = pmsClientMapper.selectByExample(example);
        PageShowVo<ClientsVo> showVo = new PageShowVo<ClientsVo>();
        List<ClientsVo> uservos = new ArrayList<ClientsVo>();
        list.forEach(client ->{
            ClientsVo clientvo = new ClientsVo();
            //client.setCreatedAt(DateUtil.getFormatDate(DateUtil.DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS, client.getCreatedAt()));
            BeanUtil.copyFields(client, clientvo, new String[] {});
            clientvo.setCreatedAt(DateUtil.getFormatDate(DateUtil.DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS, client.getCreatedAt()));
            uservos.add(clientvo);
        });
        showVo.setTotal(total);
        showVo.setPagenum(vo.getPagenum());
        showVo.setList(uservos);
        return showVo;
    }
    
}
