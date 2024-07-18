package com.example.takeawaypro.service;

import com.example.takeawaypro.bean.Cookingxi;
import com.example.takeawaypro.bean.Result;
import com.example.takeawaypro.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;

public interface CookingxiService {

    public LinkedList<Cookingxi> searchxi();
    public int add(String cookingxi_id,  String cookingxi_name);
    public int delxi(String cookingxi_id);
    public int edit( String cookingxi_name, String cookingxi_id);
    public LinkedList<Cookingxi> getclass();
}
