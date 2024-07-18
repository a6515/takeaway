package com.example.takeawaypro.service.impl;

import com.example.takeawaypro.bean.Cookingxi;
import com.example.takeawaypro.bean.Order;
import com.example.takeawaypro.mapper.AdminMapper;
import com.example.takeawaypro.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public int del_order(int order_id) {
        return adminMapper.del_order(order_id);
    }

    @Override
    public LinkedList<Order> getorders() {
        return adminMapper.getorders();
    }

    @Override
    public LinkedList<Order> go(String user_id) {
        return adminMapper.go(user_id);
    }
    @Override
    public Cookingxi findByCookingxi_id(String cookingxi_name) {
        return adminMapper.findByCookingxi_id(cookingxi_name);
    }
    @Override
    public int addfood(int cookingpin_id, String cookingpin_name, float price, String picture, String introduce, String cookingxi_name) {
        Cookingxi cookingxi=findByCookingxi_id(cookingxi_name);
        return adminMapper.addfood(cookingpin_id,cookingpin_name,price,picture,introduce,cookingxi.getCookingxi_id());
    }

    @Override
    public int del_foodpin(int cookingpin_id) {
        return adminMapper.del_foodpin(cookingpin_id);
    }
}
