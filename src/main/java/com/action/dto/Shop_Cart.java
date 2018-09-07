package com.action.dto;

import java.util.ArrayList;

public class Shop_Cart {
    private Partshop_carts partshop_carts;
    private User user;
   private Integer pcount;
//    public ArrayList<Partshop_carts> getPartshop_carts() {
//        return partshop_carts;
//    }
//
//    public void setPartshop_carts(ArrayList<Partshop_carts> partshop_carts) {
//        this.partshop_carts = partshop_carts;
//    }

    public Partshop_carts getPartshop_carts() {
        return partshop_carts;
    }

    public void setPartshop_carts(Partshop_carts partshop_carts) {
        this.partshop_carts = partshop_carts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPcount() {
        return pcount;
    }

    public void setPcount(Integer pcount) {
        this.pcount = pcount;
    }
}
