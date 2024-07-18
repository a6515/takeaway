package com.example.takeawaypro.service;

import com.example.takeawaypro.bean.Cookingxi;
import com.example.takeawaypro.bean.Order;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedList;

public interface AdminService {
    public LinkedList<Order> getorders();

    public LinkedList<Order> go(String user_id);

    public int del_order(int order_id);

    public int addfood(
            int cookingpin_id,
            String cookingpin_name,
            float price,
            String picture,
            String introduce,
            String cookingxi_name


    );

    public Cookingxi findByCookingxi_id(String cookingxi_name);

    public int del_foodpin(int cookingpin_id);
}
