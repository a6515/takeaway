package com.example.takeawaypro.mapper;

import com.example.takeawaypro.bean.Cookingxi;
import com.example.takeawaypro.bean.Result;
import org.apache.ibatis.annotations.*;

import java.util.LinkedList;

@Mapper
public interface CookingxiMapper {
    @Select("select * from cookingxi")
    public LinkedList<Cookingxi> searchxi();
    @Insert("insert into cookingxi values (#{cookingxi_id},#{cookingxi_name},CURDATE())")
    public int add(@Param("cookingxi_id") String cookingxi_id, @Param("cookingxi_name") String cookingxi_name);
    @Delete("delete from cookingxi where cookingxi_id=#{cookingxi_id}")
    public int delxi(String cookingxi_id);
    @Update("update cookingxi set cookingxi_name=#{cookingxi_name} where cookingxi_id=#{cookingxi_id}")
    public int edit(@Param("cookingxi_name") String cookingxi_name,@Param("cookingxi_id") String cookingxi_id);
    @Select("select cookingxi_id,cookingxi_name from cookingxi")
    public LinkedList<Cookingxi> getclass();
}
