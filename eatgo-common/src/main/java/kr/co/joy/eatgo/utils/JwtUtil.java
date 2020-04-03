package kr.co.joy.eatgo.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    private Key key;

    public JwtUtil(String secret) {
        // 256 / 8(bits) = 32 bytes (32글자 이상 이어야 한다.)
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(Long userId, String name) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("name", name)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
