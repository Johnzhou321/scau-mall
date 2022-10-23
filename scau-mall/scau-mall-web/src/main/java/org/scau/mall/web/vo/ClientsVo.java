package org.scau.mall.web.vo;

import java.io.Serializable;

public class ClientsVo implements Serializable{

    /**
    		*
    		*/
    	
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    /*
     * 姓名
     */
    private String name;
    
    private String idNumber;
    
    private String telephone;
    
    private String address;
    
    private String createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ClientsVo [id=" + id + ", name=" + name + ", idNumber=" + idNumber + ", telephone=" + telephone + ", address=" + address + ", createdAt="
                + createdAt + "]";
    }

}
