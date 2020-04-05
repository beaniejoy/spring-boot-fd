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

    public Review addReview(Long restaurantId,
                            String name, int score, String description) {
        Review review = Review.builder()
                .restaurantId(restaurantId)
                .name(name)
                .score(score)
                .description(description)
                .build();

        return reviewRepository.save(review);
    }
}
