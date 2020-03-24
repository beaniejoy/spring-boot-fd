package kr.co.joy.eatgo.interfaces;

import kr.co.joy.eatgo.application.ReviewService;
import kr.co.joy.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list(){
        List<Review> reviews = reviewService.getReviews();
        return reviews;
    }
}
