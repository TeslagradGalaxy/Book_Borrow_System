package com.example.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static String secret="YANA";
    private static long expire=43200000L;//12hours过期
    public static String generateJwt(Map<String,Object> claims){
        String jwt= Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,secret)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return jwt;
    }

    public static Map<String,Object> parseJwt(String jwt){
        Map<String,Object> claims=Jwts.parser()
                .setSigningKey("YANAwsh")
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
