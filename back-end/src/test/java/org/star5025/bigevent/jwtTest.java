package org.star5025.bigevent;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwtTest {

    //生成token
    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "张三");
        String token = JWT.create()
                .withClaim("user", claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*24))//添加过期时间
                .sign(Algorithm.HMAC256("Singapore"));//选择加密算法和密钥

        System.out.println(token);
    }

    //验证token
    @Test
    public void testParse() {
        //模拟用户传入的token
        //token分为头部、载荷、签名三个部分
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IuW8oOS4iSJ9LCJleHAiOjE3NjIzMjYyMDF9." +
                "kn2v9e1BdH55Hg6Kn4xQtsDDsKJtws8f1vKKF59g__8";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("Singapore")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);//验证token，生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));
    }
}
