package com.example.takeawaypro.controller;

import com.example.takeawaypro.bean.CookingPin;
import com.example.takeawaypro.bean.Result;
import com.example.takeawaypro.service.CookingPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@CrossOrigin
@RestController
public class CookingPinController {
    @Autowired
    CookingPinService cookingPinService;

    @RequestMapping("/getcookingPin")
    public Result<LinkedList<CookingPin>> getcookingPin() {
        return Result.success(cookingPinService.getcookingPin());
    }

}