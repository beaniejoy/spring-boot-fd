package kr.co.joy.eatgo.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReviewController {

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public ResponseEntity<?> create() throws URISyntaxException {
        return ResponseEntity.created(new URI("/restaurants/1/reviews/1")).body("{}");
    }
}
