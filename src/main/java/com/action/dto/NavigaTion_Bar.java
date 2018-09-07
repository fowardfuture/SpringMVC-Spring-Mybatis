package com.action.dto;

public class NavigaTion_Bar {
    private Integer cid;
    private String cname;
    public NavigaTion_Bar(){}
    public NavigaTion_Bar(Integer cid,String cname)
    {
        this.cid=cid;
        this.cname=cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
