package com.example.takeawaypro.service.impl;

import com.example.takeawaypro.bean.CookingPin;
import com.example.takeawaypro.mapper.CookingpinMapper;
import com.example.takeawaypro.service.CookingPinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class CookingPinServiceImpl implements CookingPinService {
    @Autowired
    CookingpinMapper cookingpinMapper;

    @Override
    public LinkedList<CookingPin> getcookingPin() {
        return cookingpinMapper.getcookingPin();
    }
}
