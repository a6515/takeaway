package com.example.takeawaypro.mapper;

import com.example.takeawaypro.bean.*;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_id=#{user_id}")
    public User findByUser_id(int user_id);
    @Select("select * from more where cookingpin_name=#{cookingpin_name} and user_id=#{user_id}")
    public More findByCookingpin_name(@Param("cookingpin_name") String cookingpin_name,@Param("user_id") int user_id);
    @Update("update more set cooking_number=cooking_number+1 where cookingpin_name=#{cookingpin_name}")
    public int cookingpin_add(String cookingpin_name);
    @Select("select * from admin where name= #{name} and password=#{password}")
    public Admin load(@Param("name") String name, @Param("password") String password);
    @Select("select * from admin where name=#{name}")
    public Admin getinfo(String name);
    @Update("update admin set avatar=#{avatar} where name=#{name}")
    public int updateAvatar(@Param("avatar") String avatar,@Param("name") String name);
    @Select("select * from user where user_id=#{user_id} and user_name= #{name} and password=#{password}")
    public User uload(@Param("user_id") int user_id,@Param("name") String name, @Param("password") String password);
    @Select("select * from user where user_id=#{user_id}")
    public User u_getinfo(int user_id);

    @Update("update user set avatar=#{avatar} where user_id=#{user_id}")
    public int uupdateAvatar(@Param("avatar") String avatar,@Param("user_id") int user_id);

    @Insert("insert into user values (#{user_id},#{user_name},#{password},#{avatar},0)")
    public int register(@Param("user_id") int user_id,@Param("user_name") String user_name, @Param("password") String password,@Param("avatar") String avatar);
    @Insert("insert into more values (#{user_id},#{cookingpin_name},#{cooking_number})")
    public int buy(@Param("user_id") int user_id, @Param("cookingpin_name") String cookingpin_name, @Param("cooking_number") int cooking_number);
    @Select("select * from more natural join cookingpin where user_id=#{user_id}")
    public LinkedList<Cart> getcart(int user_id);
    @Update("update more set cooking_number=cooking_number-1 where user_id=#{user_id} and cookingpin_name=#{cookingpin_name}")
    public int cart_del(@Param("user_id") int user_id,@Param("cookingpin_name") String cookingpin_name);

    @Update("update more set cooking_number=cooking_number+1 where user_id=#{user_id} and cookingpin_name=#{cookingpin_name}")
    public int cart_add(@Param("user_id") int user_id,@Param("cookingpin_name") String cookingpin_name);
    @Update("delete from more where user_id=#{user_id} and cookingpin_name=#{cookingpin_name}")
    public int cart_remove(@Param("user_id") int user_id,@Param("cookingpin_name") String cookingpin_name);

    @Insert("insert into orders values (#{order_id},#{sumarry},NOW(),#{remark},#{sum_price},#{user_id})")
    public int pay(@Param("order_id") int order_id,@Param("sumarry") String sumarry,@Param("remark") String remark,@Param("sum_price") float sum_price,@Param("user_id") int user_id);
    @Delete("delete from more where user_id=#{user_id}")
    public int more_del(int user_id);
    @Update("update user set password=#{password} where user_id=#{user_id} and user_name=#{user_name}")
    public int callback(@Param("user_id") int user_id,@Param("user_name") String user_name,@Param("password") String password);

    @Select("select * from orders where user_id=#{user_id}")

    public LinkedList<Order> u_getorder(int user_id);

    @Update("update user set status=1 where user_id=#{user_id} and user_name=#{name}")
    public int uplogin_status(@Param("user_id") int user_id,@Param("name") String name);


    @Update("update user set status=0 where user_id=#{user_id}")
    public int down(int user_id);

    @Select("select MAX(user_id) from user")
    public int findBYmax_id();



}
