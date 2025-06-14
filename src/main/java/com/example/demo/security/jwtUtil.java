package com.example.demo.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
import java.util.jar.JarException;

public class jwtUtil  {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static  final  long EXPIRATION_TIME = 86400000;

    public static String generateToken(String nome){
        return Jwts.builder()
                .setSubject(nome)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String extractNome(String token){
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

    public static boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token);
            return true;
        }catch (JwtException e){
            return false;
        }
    }

}
