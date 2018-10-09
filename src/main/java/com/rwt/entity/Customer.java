package com.rwt.entity;

public class Customer {
    //客户ID
    private long id;
    //客户姓名
    private  String name;
    //联系人
    private String contact;
    //电话号码
    private String telephone;
    //邮箱地址
    private String email;
    //备注
    private String remark;

    public long getId() {
        return id;
    }

    public String getContact() {
        return contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getRemark() {
        return remark;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.contact+" "+this.telephone+" "+this.email+" "+this.remark+"\n";
    }
}
