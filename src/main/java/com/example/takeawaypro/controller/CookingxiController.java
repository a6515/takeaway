package com.example.takeawaypro.controller;

import com.example.takeawaypro.bean.Cookingxi;
import com.example.takeawaypro.bean.Result;
import com.example.takeawaypro.service.CookingxiService;
import com.example.takeawaypro.service.UserService;
import com.example.takeawaypro.utils.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Map;

@CrossOrigin
@RestController
public class CookingxiController {
    @Autowired
    CookingxiService cookingxiService;

    @RequestMapping("/searchxi")
    public Result<LinkedList<Cookingxi>> searchxi() {
        LinkedList<Cookingxi> cookingxis = cookingxiService.searchxi();
        return Result.success(cookingxis);

    }

    @RequestMapping("/add")
    public Result add(@RequestParam String name) {
        int n = cookingxiService.add("0", name);
        System.out.println("名字:" + name);
        System.out.println("插入受影响的行数:" + n);
        if (n > 0) {
            return Result.success();
        } else {
            return Result.error("插入失败");
        }
    }

    @RequestMapping("/delxi")
    public Result delxi(@RequestParam String cookingxi_id, HttpServletResponse response) {
        System.out.println("要删除的系号位:" + cookingxi_id);
        try {
            int n = cookingxiService.delxi(cookingxi_id);
            System.out.println("删除受影响的行数:" + n);
            return Result.success();
        } catch (Exception e) {
            response.setStatus(999);
            return Result.error("该菜系下还有菜品");
        }
    }
    @RequestMapping("/edit")
    public Result edit(@RequestParam String name,@RequestParam String id){
        int n=cookingxiService.edit(name,id);
        if(n>0){
            return Result.success();
        }
        else {
            return Result.error("编辑失败");
        }
    }
    @RequestMapping("/getclass")
    public Result<LinkedList<Cookingxi> > getclass(){
        return Result.success(cookingxiService.getclass());
    }
}
