package kr.co.joy.eatgo.utils;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JwtUtilTests {

    private static final String SECRET = "12345678901234567890123456789012";
    private JwtUtil jwtUtil;

    @BeforeEach
    public void setUp(){
        jwtUtil = new JwtUtil(SECRET);
    }

    @Test
    public void createToken() {
        String token = jwtUtil.createToken(1004L, "Joy", null);

        assertTrue(token.contains("."));
    }

    @Test
    public void getClaims() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb3kifQ.lrdyXLeKqaMYQm64UpyuKlHG3GPb4Nt5gXcrCQJMn5M";
        Claims claims = jwtUtil.getClaims(token);

        // Long type으로 반환을 해준다.
        assertEquals(claims.get("userId", Long.class), 1004L);
        assertEquals(claims.get("name"), "Joy");
    }
}