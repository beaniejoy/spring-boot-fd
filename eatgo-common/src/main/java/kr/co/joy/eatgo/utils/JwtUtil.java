package kr.co.joy.eatgo.utils;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String createToken(Long id, String name) {
        return "header.payload.signature";
    }
}
