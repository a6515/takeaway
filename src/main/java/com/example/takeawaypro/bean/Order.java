package com.example.takeawaypro.bean;

import java.util.Date;

public class Order {
    private int order_id;
    private Date order_time;
    private int user_id;
    private String remark;
    private float sum_price;

    public String getSumarry() {
        return sumarry;
    }

    public void setSumarry(String sumarry) {
        this.sumarry = sumarry;
    }

    private String sumarry;
    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public float getSum_price() {
        return sum_price;
    }

    public void setSum_price(float sum_price) {
        this.sum_price = sum_price;
    }


}
