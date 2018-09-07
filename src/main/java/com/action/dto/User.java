package com.action.dto;

public class User {
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String addr;
    private Integer state;
    private String code;
    public User(Integer uid,String username,String password,String name,String email,String phone,Integer state,String code)
    {
        this.uid=uid;
        this.username=username;
        this.password=password;
        this.name=name;
        this.email=email;
        this.phone=phone;
        this.state=state;
        this.code=code;
    }
    public User()
    {

    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
