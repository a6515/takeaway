package com.example.takeawaypro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Map;

public class JwtTest {
    Map<String,Object> claims;
    @Test
    public void testGen(){
        //生成token
        String token=JWT.create()
                .withClaim("user",claims) //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*5)) //添加过期时间
                .sign(Algorithm.HMAC256("wudi")); //指定算法，配置密钥
        System.out.println(token);
    }
}
