package com.action.dto;

public class Partshop_carts {
    private Integer pid;
    private String pname;

    private Integer shopprice;
    private String pimage;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }



    public Integer getShopprice() {
        return shopprice;
    }

    public void setShopprice(Integer shopprice) {
        this.shopprice = shopprice;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }
}
