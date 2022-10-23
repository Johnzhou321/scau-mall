package org.scau.mall.web.vo;

import java.io.Serializable;
import java.util.List;

public class MenusVo implements Serializable{

    /**
    		*
    		*/
    	
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    /*
     * 菜单名称
     */
    private String authName;
    
    /*
     * 菜单路径
     */
    private String path;
    
    /*
     * 子菜单
     */
    private List<MenusVo> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<MenusVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenusVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenusVo [id=" + id + ", authName=" + authName + ", path=" + path + ", children=" + children + "]";
    }
    
}
