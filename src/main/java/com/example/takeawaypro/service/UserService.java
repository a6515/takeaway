package com.example.takeawaypro.service;

import com.example.takeawaypro.bean.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedList;

public interface UserService {
    public User findByUser_id(int user_id);
    public More findByCookingpin_name(String cookingpin_name,int user_id);
    public int cookingpin_add(String cookingpin_name);
    public Admin load(String name, String password);
    public Admin getinfo(String name);
    public int updateAvatar( String avatar, String name);
    public User uload(int user_id,String name, String password);
    public User u_getinfo(int user_id);
    public int uupdateAvatar(String avatar, int user_id);
    public int register( String user_name,String password);
    public int buy(int user_id, String cookingpin_name);
    public LinkedList<Cart> getcart(int user_id);

    public int cart_del( int user_id, String cookingpin_name);
    public int cart_add(int user_id, String cookingpin_name);
    public int cart_remove( int user_id, String cookingpin_name);
    public int pay(String sumarry,String remark,float sum_price,int user_id);
    public int more_del(int user_id);
    public int callback(int user_id, String user_name, String password);
    public LinkedList<Order> u_getorder(int user_id);

    public int down(int user_id);

    public int findBYmax_id();
}
