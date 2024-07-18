package com.example.takeawaypro.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static final String KEY="wudi";

    public static String genToken(Map<String,Object> claims){
        //生成token
        return JWT.create()
                .withClaim("user",claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24*10)) //添加过期时间
                .sign(Algorithm.HMAC256(KEY)); //指定算法，配置密钥
    }
    public static Map<String,Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("user")
                .asMap();
    }


}
