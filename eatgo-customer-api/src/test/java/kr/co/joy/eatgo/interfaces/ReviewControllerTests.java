package kr.co.joy.eatgo.interfaces;

import kr.co.joy.eatgo.application.ReviewService;
import kr.co.joy.eatgo.domain.Review;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReviewController.class)
class ReviewControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReviewService reviewService;

    @Test
    public void createWithValidAttributes() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb3kifQ.lrdyXLeKqaMYQm64UpyuKlHG3GPb4Nt5gXcrCQJMn5M";

        given(reviewService.addReview(1L, "Joy", 3, "mat-it-da"))
                .willReturn(Review.builder().id(123L).build());

        mvc.perform(post("/restaurants/1/reviews")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"score\":3,\"description\":\"mat-it-da\"}")
        )
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/restaurants/1/reviews/123"));

        verify(reviewService).addReview(eq(1L), eq("Joy"), eq(3), eq("mat-it-da"));
    }

    @Test
    public void createWithInvalidAttributes() throws Exception {
        mvc.perform(post("/restaurants/1/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")
        )
                .andExpect(status().isBadRequest());

    }
}