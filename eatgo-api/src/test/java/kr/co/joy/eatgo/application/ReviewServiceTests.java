package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Restaurant;
import kr.co.joy.eatgo.domain.Review;
import kr.co.joy.eatgo.domain.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class ReviewServiceTests {

    private ReviewService reviewService;

    @Mock
    private ReviewRepository reviewRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        reviewService = new ReviewService(reviewRepository);
    }

    @Test
    public void addReview() {
        given(reviewRepository.save(any())).will(invocation -> {
            Review review = invocation.getArgument(0);
            review.setId(1234L);
            return review;
        });
        
        Review review = Review.builder()
                .name("JOKER")
                .score(3)
                .description("Mat-it-da")
                .build();

        Review saved = reviewService.addReview(review);

        verify(reviewRepository).save(any());
        assertEquals(saved.getName(), "JOKER");
        assertEquals(saved.getScore(), 3);
        assertEquals(saved.getDescription(), "Mat-it-da");
    }
}