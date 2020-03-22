package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Review;
import kr.co.joy.eatgo.domain.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review addReview(Long restaurantId, Review review) {
        review.setRestaurantId(restaurantId);
        return reviewRepository.save(review);
    }
}
