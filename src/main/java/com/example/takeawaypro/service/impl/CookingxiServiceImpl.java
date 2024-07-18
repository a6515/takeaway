package com.example.takeawaypro.service.impl;

import com.example.takeawaypro.bean.Cookingxi;
import com.example.takeawaypro.bean.Result;
import com.example.takeawaypro.mapper.CookingxiMapper;
import com.example.takeawaypro.mapper.UserMapper;
import com.example.takeawaypro.service.CookingxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class CookingxiServiceImpl implements CookingxiService {
    @Autowired
    CookingxiMapper cookingxiMapper;
    @Override
    public LinkedList<Cookingxi> searchxi() {
        return cookingxiMapper.searchxi();
    }

    @Override
    public int add(String cookingxi_id, String cookingxi_name) {
        return cookingxiMapper.add(cookingxi_id,cookingxi_name);
    }
    @Override
    public int delxi(String cookingxi_id) {
        return cookingxiMapper.delxi(cookingxi_id);
    }

    @Override
    public int edit(String cookingxi_name,  String cookingxi_id) {
        return cookingxiMapper.edit(cookingxi_name,cookingxi_id);
    }

    @Override
    public LinkedList<Cookingxi> getclass() {
        return cookingxiMapper.getclass();
    }
}
