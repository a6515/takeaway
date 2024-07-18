package com.example.takeawaypro.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class Cookingxi {
    int cookingxi_id;
    String cookingxi_name;
    Date hiredate;

    public int getCookingxi_id() {
        return cookingxi_id;
    }

    public void setCookingxi_id(int cookingxi_id) {
        this.cookingxi_id = cookingxi_id;
    }

    public String getCookingxi_name() {
        return cookingxi_name;
    }

    public void setCookingxi_name(String cookingxi_name) {
        this.cookingxi_name = cookingxi_name;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}
