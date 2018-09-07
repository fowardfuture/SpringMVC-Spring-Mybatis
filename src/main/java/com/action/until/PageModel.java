package com.action.until;

public class PageModel {
     private int indexpage;//当前页数
     private int totalpage;//总页数
     private int per_pagenum=20;//默认每页数据的条数
     private int totaldatas;//需要分页的数据量


    public   int getIndexpage() {
        return this.getTotalpage()>indexpage? indexpage:this.getTotalpage();
    }

    public void setIndexpage(int indexpage) {
        this.indexpage = indexpage;
    }

    public int getTotalpage() {
        return (this.getTotaldatas()-1)/this.getPer_pagenum()+1;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getPer_pagenum() {
        return per_pagenum;
    }

    public void setPer_pagenum(int per_pagenum) {
        this.per_pagenum = per_pagenum;
    }

    public int getTotaldatas() {
        return totaldatas;
    }

    public void setTotaldatas(int totaldatas) {
        this.totaldatas = totaldatas;
    }
    public int getFirstLimit()
    {
        return (this.indexpage-1)*this.per_pagenum;
    }
}