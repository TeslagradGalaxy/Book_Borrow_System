package com.example;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void generateJwt(){
        Map<String,Object> claims=new HashMap<>();
        claims.put("id",1);
        claims.put("username","shuhan");
        String jwt= Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,"YANAwsh")
                .setExpiration(new Date(System.currentTimeMillis()+1*60*60*1000))
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void parseJwt(){
        String jwt="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJzaHVoYW4iLCJleHAiOjE3MTY1MjcxODd9.GpreRT66-ATNEbRoVLqXUkJcIHsslR-RXK7U0qBMHps";
        Map<String,Object> claims=Jwts.parser()
                .setSigningKey("YANAwsh")
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }
}
