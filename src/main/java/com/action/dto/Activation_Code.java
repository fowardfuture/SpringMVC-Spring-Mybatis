package com.action.dto;

public class Activation_Code {
    private String code;
    private String date;
    public Activation_Code(){}
    public Activation_Code(String code,String date)
    {
        this.code=code;
        this.date=date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
