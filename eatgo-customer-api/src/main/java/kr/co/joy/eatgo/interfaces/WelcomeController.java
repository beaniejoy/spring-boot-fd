package kr.co.joy.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String hello() {
        return "Hello, world!! I love U, Joy!!";
    }
}
