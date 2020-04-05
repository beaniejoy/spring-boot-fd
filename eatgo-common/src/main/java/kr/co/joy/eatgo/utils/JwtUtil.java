package kr.co.joy.eatgo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
// 여기서 Security Token을 관리
public class JwtUtil {

    private Key key;

    public JwtUtil(String secret) {
        // 256 / 8(bits) = 32 bytes (32글자 이상 이어야 한다.)
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // token을 생성하는 부분
    public String createToken(Long userId, String name) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("name", name)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // token에서 claims를 빼오는 부분
    public Claims getClaims(String token) {
        // parser()에서 바뀐듯
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
