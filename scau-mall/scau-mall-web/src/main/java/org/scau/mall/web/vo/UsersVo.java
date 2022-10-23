package org.scau.mall.web.vo;


public class UsersVo{

    private Integer id;
    
    /*
     * 用户名称
     */
    private String username;
    
    /*
     * 手机号码
     */
    private String mobile;
    
    /*
     * 电子邮箱
     */
    private String email;
    
    /*
     * 登录的token
     */
    private String token;
    
    /**
     * 状态，0：禁用，1：启用
     */
    private Integer status;
    /**
     * 状态，false：禁用，true：启用，前端使用
     */
    private boolean mg_state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public boolean isMg_state() {
        return status == 1 ? true : false;
    }

    @Override
    public String toString() {
        return "UsersVo [id=" + id + ", username=" + username + ", mobile=" + mobile + ", email=" + email + ", token=" + token + ", status=" + status
                + ", mg_state=" + mg_state + "]";
    }

}
