package com.xdclass.xdvideo.utils;

import com.xdclass.xdvideo.domain.WxUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/*
jwt工具类
 */
public class JwtUtils {
    //定义发行者
    public static final String SUBJECT = "xdclass";
    //定义过期时间
    public static final long EXPIPE = 1000 * 60 * 60 * 60 * 24 * 7; //过期时间一周
    //定义秘钥
    public static final String APPSECRET = "xd666";

    public static String geneJsonWebToken(WxUser user) {
        /**
         * 生成jwt
         */
        //构建 自定义属性 发行时间
        if (user == null || user.getId() == null || user.getName() == null || user.getHeadImg() == null) {
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT).claim("id", user.getId())
                .claim("name", user.getName())
                .claim("img", user.getHeadImg())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIPE))
                .signWith(SignatureAlgorithm.HS256, APPSECRET).compact();
        return token;
    }

    /**
     * 解密:教验tokrn
     */
    public static Claims checkJwt(String token) {
        //设置秘钥.解析token
        try {
            final Claims claims = Jwts.parser().setSigningKey(APPSECRET).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }


    }
}
