package com.example.takeawaypro.controller;


import com.auth0.jwt.JWT;
import com.example.takeawaypro.bean.*;
import com.example.takeawaypro.service.UserService;
import com.example.takeawaypro.utils.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/load")
    public Result load(@RequestParam String name, @RequestParam String password) {
        System.out.println("接收到的值为:" + name);
        System.out.println("接收到的值为:" + password);

        Admin admin = userService.load(name, password);
        if (admin == null) return Result.error("管理员趋势了");
        else {
            Map<String, Object> claims = new HashMap<>();
            claims.put("name", admin.getName());
            String token = JwtUtils.genToken(claims);
            System.out.println("正规生成的token为:" + token);
            return Result.success(token);
        }

    }


    @RequestMapping("/getinfo")
    public Result<Admin> getinfo(@RequestHeader(name = "Authorization") String token) {
        System.out.println("到达了");
        Map<String, Object> claims = JwtUtils.parseToken(token);
        Admin admin = userService.getinfo((String) claims.get("name"));
        System.out.println("获取到的名字为:" + (String) claims.get("name"));
        if (admin != null) {
            return Result.success(admin);
        } else {
            return Result.error("用户不存在");
        }
    }

    @RequestMapping("delToken")
    public Result delToken(@RequestHeader(name = "Authorization") String token) {
        Map<String, Object> claims = JwtUtils.parseToken(token);
        claims.put("name", null);
        return Result.success();

    }

    @RequestMapping("/updateAvatar")
    public Result updateAvatar(@RequestHeader(name = "Authorization") String token, String url) {
        System.out.println("admin方法获取到的图片地址为" + url);

        int n = userService.updateAvatar(url, (String) JwtUtils.parseToken(token).get("name"));
        if (n > 0) {
            return Result.success();
        } else {
            return Result.error("更新失败");
        }

    }

    @RequestMapping("/uload")
    public Result uload(@RequestParam String id,@RequestParam String name, @RequestParam String password,HttpServletResponse response) {
        System.out.println("接收到用户的ID的值为:" + id);
        System.out.println("接收到用户的名字的值为:" + name);
        System.out.println("接收到的值为:" + password);

        User user = userService.uload(Integer.parseInt(id),name, password);
        if (user == null) return Result.error("用户名或密码错误,请检查");
        else if(user.getStatus()==0)
        {
            Map<String, Object> claims = new HashMap<>();
            claims.put("user_id", user.getUser_id());
            String token = JwtUtils.genToken(claims);
            System.out.println("正规生成的用户token为:" + token);
            return Result.success(token);
        }
        else if(user.getStatus()==1){
            response.setStatus(995);   //标志有人在线
            return Result.error("有人在线");
        }
        else return Result.error("未知错误");

    }


    @RequestMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
        System.out.println("到达了");
        System.out.println("userinfo获取到的信息为:"+token);
        Map<String, Object> claims = JwtUtils.parseToken(token);
        User user = userService.u_getinfo( (int)claims.get("user_id"));
        System.out.println("获取到的ID为:" + claims.get("user_id"));
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error("用户不存在");
        }
    }

    @RequestMapping("/user_updateAvatar")
    public Result uupdateAvatar(@RequestHeader(name = "Authorization") String token, String url) {
        System.out.println("user方法获取到的图片地址为" + url);

        int n = userService.uupdateAvatar(url, (int) JwtUtils.parseToken(token).get("user_id"));
        if (n > 0) {
            return Result.success();
        } else {
            return Result.error("更新失败");
        }

    }

    @RequestMapping("/register")
    public Result register(@RequestParam String name, @RequestParam String password) {
        System.out.println("注册:接收到用户的名字的值为:" + name);
        System.out.println("注册:接收到的值为:" + password);
        int n = userService.register(name, password);
        int user_id=userService.findBYmax_id();
        if (n > 0) return Result.success(user_id);
        else return Result.error("注册失败");
    }

    @RequestMapping("/buy")
    public Result buy(@RequestParam String user_id, @RequestParam String cookingpin_name) {
        System.out.println("正在购买物品的用户编号为:" + user_id + ",他买了:" + cookingpin_name);
        int n = userService.buy(Integer.parseInt(user_id), cookingpin_name);
        if (n > 0) return Result.success();
        else {
            return Result.error("购买失败");
        }

    }

    @RequestMapping("/getcart")
    public Result<LinkedList<Cart>> getcart(@RequestParam String user_id) {
        LinkedList<Cart> carts = userService.getcart(Integer.parseInt(user_id));
        if (carts != null) {
            return Result.success(carts);
        } else {
            return Result.error("购物车为空");
        }
    }

    @RequestMapping("/cart_del")
    public Result cart_del(@RequestParam String user_id, @RequestParam String cookingpin_name) {
        int n = userService.cart_del(Integer.parseInt(user_id), cookingpin_name);
        if (n > 0) return Result.success();
        else return Result.error("错误1");

    }

    @RequestMapping("/cart_add")
    public Result cart_add(@RequestParam String user_id, @RequestParam String cookingpin_name) {

        int n = userService.cart_add(Integer.parseInt(user_id), cookingpin_name);
        if (n > 0) return Result.success();
        else return Result.error("错误2");
    }

    @RequestMapping("/cart_remove")
    public Result cart_remove(@RequestParam String user_id, @RequestParam String cookingpin_name) {

        int n = userService.cart_remove(Integer.parseInt(user_id), cookingpin_name);
        if (n > 0) return Result.success();
        else return Result.error("错误3");
    }

    @RequestMapping("/pay")
    public Result pay(@RequestParam String user_id, @RequestParam String price,@RequestParam String remark,@RequestParam String sumarry){
        int n= userService.pay(sumarry,remark,Float.parseFloat(price),Integer.parseInt(user_id));
        if(n>0) return Result.success();
        else return Result.error("订单错误");
    }

    @RequestMapping("/callback")
    public Result callback(@RequestParam String user_id,@RequestParam String user_name,@RequestParam String password){
        int n= userService.callback(Integer.parseInt(user_id),user_name,password);
        if(n>0) return Result.success();
        else return Result.error("找回错误");
    }
    @RequestMapping("/u_getorder")
    public Result<LinkedList<Order>> u_getorder(@RequestParam String user_id){
        LinkedList<Order> orders = userService.u_getorder(Integer.parseInt(user_id));
        return Result.success(orders);
    }

    @RequestMapping("/downs")
    public Result down(@RequestParam String user_id){
        int n = userService.down(Integer.parseInt(user_id));
        System.out.println("用户"+user_id+"正在下线");
        if (n > 0) {
            return Result.success();
        } else {
            return Result.error("下线失败");
        }
    }


}
