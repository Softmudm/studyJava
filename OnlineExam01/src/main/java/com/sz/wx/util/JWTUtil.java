package com.sz.wx.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

//jwt的生成与解析工具类
public class JWTUtil {
    //签名秘钥(使用加密算法时添加的字符串)
    private static String key="testjwtlogin";
    //令牌有效时间ms
    private static long ttl=3600000;
    //创建jwt
    public static String createJwt(Map<String,Object> map){
        long l = System.currentTimeMillis();
        Date dt = new Date(l);
        Date expir = new Date(l+ttl);
        JwtBuilder jwtBuilder = Jwts.builder()
                //设置签发时间
                .setIssuedAt(dt)
                //设置过期时间
                .setExpiration(expir)
                //设置payload中携带的自定义信息
                .setClaims(map)
                //签名
                .signWith(SignatureAlgorithm.HS256,key);
        String jwtString = jwtBuilder.compact();
        System.out.println("发放的token："+jwtString);
        return jwtString;
    }
    //解析jwt
    public static Claims parseJwt(String token){
        //获取解析器对象
        Claims claims =  Jwts.parser()
                //使用签名秘钥解密
                .setSigningKey(key)
                //传入需要解析的token
                .parseClaimsJws(token)
                //得到payload部分
                .getBody();
        return claims;
    }
}
