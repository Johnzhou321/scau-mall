package org.scau.mall.web.security.service;

import javax.servlet.http.HttpServletRequest;

import org.scau.mall.service.pojo.PmsUser;
import org.scau.mall.web.security.pojo.JwtUser;
import org.scau.mall.web.vo.UsersVo;

public interface IUserService {
    int insertSelective(PmsUser record);
    JwtUser getUserByName(String userName);
    UsersVo login(String username, String password, HttpServletRequest request) throws Exception;
}
