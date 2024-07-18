package com.example.takeawaypro.mapper;

import com.example.takeawaypro.bean.CookingPin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedList;

@Mapper
public interface CookingpinMapper {
    @Select("select * from cookingpin natural join cookingxi")
    public LinkedList<CookingPin> getcookingPin();


}
