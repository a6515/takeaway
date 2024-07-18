package com.example.takeawaypro.mapper;

import com.example.takeawaypro.bean.Cookingxi;
import com.example.takeawaypro.bean.Order;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

@Mapper
public interface AdminMapper {
    @Select("select * from orders")

    public LinkedList<Order> getorders();
    @Select("select * from orders where user_id=#{user_id}")
    public LinkedList<Order> go(String user_id);
    @Delete("delete from orders where order_id=#{order_id}")
    public int del_order(int order_id);

    @Insert("insert into cookingpin values (#{cookingpin_id},#{cookingpin_name},#{price},#{picture},#{introduce},#{cookingxi_id})")
    public int addfood(
            @Param("cookingpin_id") int cookingpin_id,
            @Param("cookingpin_name") String cookingpin_name,
            @Param("price") float price,
            @Param("picture") String picture,
            @Param("introduce") String introduce,
            @Param("cookingxi_id") int cookingxi_id



    );
    @Select("select * from cookingxi where cookingxi_name=#{cookingxi_name}")
    public Cookingxi findByCookingxi_id(String cookingxi_name);

    @Delete("delete from cookingpin where cookingpin_id=#{cookingpin_id}")
    public int del_foodpin(int cookingpin_id);
}
