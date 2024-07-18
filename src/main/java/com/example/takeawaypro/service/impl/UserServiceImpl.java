package com.example.takeawaypro.service.impl;

import com.example.takeawaypro.bean.*;
import com.example.takeawaypro.mapper.UserMapper;
import com.example.takeawaypro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public LinkedList<Cart> getcart(int user_id) {
        return userMapper.getcart(user_id);
    }

    @Override
    public int cookingpin_add(String cookingpin_name) {
        return userMapper.cookingpin_add(cookingpin_name);
    }

    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUser_id(int user_id) {
        return userMapper.findByUser_id(user_id);
    }

    @Override
    public More findByCookingpin_name(String cookingpin_name,int user_id) {
        return userMapper.findByCookingpin_name(cookingpin_name,user_id);
    }

    @Override
    public Admin load(String name, String password) {

        return userMapper.load(name, password);
    }


    @Override
    public Admin getinfo(String name) {
        return userMapper.getinfo(name);
    }

    @Override
    public int updateAvatar(String avatar, String name) {
        return userMapper.updateAvatar(avatar, name);
    }

    @Override
    public User uload(int user_id,String name, String password) {
        User user =userMapper.uload(user_id,name, password);
        int status;
        if(user!=null) {
            status=user.getStatus();
            if (status==0){
                userMapper.uplogin_status(user_id,name);//此处虽然更新，但user对象还是原来的
            }
        }
        return user;
    }

    @Override
    public int down(int user_id) {
        return userMapper.down(user_id);
    }

    @Override
    public User u_getinfo(int user_id) {
        return userMapper.u_getinfo(user_id);
    }

    @Override
    public int uupdateAvatar(String avatar, int user_id) {
        return userMapper.uupdateAvatar(avatar, user_id);
    }

    @Override
    public int register(String user_name, String password) {
        //此处因为数据库user_id自动递增，所以user_id不管
        return userMapper.register(0,user_name,password,"");
    }

    @Override
    public int buy(int user_id, String cookingpin_name) {
        System.out.println("进入服务层");
        More more = findByCookingpin_name(cookingpin_name,user_id);
        if(more!=null){
            System.out.println("服务层消息:找到相同菜");
            int n=cookingpin_add(cookingpin_name);
            return n;
        }
        else {
            System.out.println("服务层消息:没有找到相同菜");
            return userMapper.buy(user_id,cookingpin_name,1);
        }
    }
    @Override
    public int cart_del(int user_id, String cookingpin_name) {
        return userMapper.cart_del(user_id,cookingpin_name);
    }


    @Override
    public int cart_add(int user_id, String cookingpin_name) {
        return userMapper.cart_add(user_id,cookingpin_name);
    }

    @Override
    public int cart_remove(int user_id, String cookingpin_name) {
        return userMapper.cart_remove(user_id,cookingpin_name);
    }

    @Override
    public int more_del(int user_id) {
        return userMapper.more_del(user_id);
    }

    @Override
    public int pay( String sumarry,String remark, float sum_price, int user_id) {
        System.out.println("进入服务层");
        int n=userMapper.pay(0,sumarry,remark,sum_price,user_id);
        more_del(user_id);
        System.out.println("购物车清空成功");
        return n;
    }

    @Override
    public int callback(int user_id, String user_name, String password) {
        return userMapper.callback(user_id,user_name,password);
    }

    @Override
    public LinkedList<Order> u_getorder(int user_id) {
        return userMapper.u_getorder(user_id);
    }


    @Override
    public int findBYmax_id() {
        return userMapper.findBYmax_id();
    }
}
