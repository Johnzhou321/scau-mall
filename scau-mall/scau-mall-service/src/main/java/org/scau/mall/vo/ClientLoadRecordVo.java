package org.scau.mall.vo;

import java.io.Serializable;

public class ClientLoadRecordVo implements Serializable{

    /**
    		*
    		*/
    	
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    private String id_number;
    
    private String telephone;
    
    private String amount;
    
    private String qualification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    
}
