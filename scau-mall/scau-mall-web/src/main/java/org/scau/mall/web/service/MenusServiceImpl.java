package org.scau.mall.web.service;

import java.util.ArrayList;
import java.util.List;

import org.scau.mall.dao.PmsMenuMapper;
import org.scau.mall.service.pojo.PmsMenu;
import org.scau.mall.service.pojo.PmsMenuExample;
import org.scau.mall.web.vo.MenusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenusServiceImpl{
    
    @Autowired
    private PmsMenuMapper pmsMenuMapper;
    
    private List<PmsMenu> getAllMenus(){
        PmsMenuExample example = new PmsMenuExample();
        example.createCriteria().andStatusEqualTo(1);
        return pmsMenuMapper.selectByExample(example);
    }
    
    public List<MenusVo> getMenus() {
        List<PmsMenu> menusList = getAllMenus();
        List<MenusVo> menus = new ArrayList<MenusVo>();
        //一级菜单
        for(PmsMenu menu : menusList) {
            MenusVo vo = new MenusVo();
            if(menu.getIsLeaf() == 0) {//0：非叶子，1：叶子节点
                vo.setId(menu.getId());
                vo.setAuthName(menu.getAuthName());
                menus.add(vo);
            }
        }
        //二级菜单
        for(PmsMenu menu : menusList) {
            if(menu.getIsLeaf() == 1) {//0：非叶子，1：叶子节点
                for(MenusVo menuvo : menus) {
                    if(menu.getPid() == menuvo.getId()) {//父节点id等于一级菜单id
                        MenusVo vo = new MenusVo();
                        vo.setId(menu.getId());
                        vo.setAuthName(menu.getAuthName());
                        vo.setPath(menu.getPath());
                        if(menuvo.getChildren() == null) {
                            menuvo.setChildren(new ArrayList<MenusVo>());
                            menuvo.getChildren().add(vo);
                        }else {
                            menuvo.getChildren().add(vo);
                        }
                    }
                }
            }
        }
        return menus;
    }
   
}
