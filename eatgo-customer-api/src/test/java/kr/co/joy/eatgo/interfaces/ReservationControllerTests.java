package kr.co.joy.eatgo.interfaces;

import kr.co.joy.eatgo.application.ReservationService;
import kr.co.joy.eatgo.domain.Reservation;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationController.class)
class ReservationControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReservationService reservationService;

    // userId와 name은 생성된 token을 가지고 실행
    @Test
    public void create() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEwMDQsIm5hbWUiOiJKb3kifQ.lrdyXLeKqaMYQm64UpyuKlHG3GPb4Nt5gXcrCQJMn5M";

        Long userId = 1004L;
        String name = "Joy";
        String date = "2020-03-10";
        String time = "20:00";
        Integer partySize = 20;

        Reservation mockReservation = Reservation.builder()
                .id(123L)
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .partySize(partySize)
                .build();

        given(reservationService.addReservation(1L, userId, name, date, time, partySize))
                .willReturn(mockReservation);

        mvc.perform(post("/restaurants/1/reservations")
                .header("Authorization", "Bearer " + token)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"date\":\"2020-03-10\",\"time\":\"20:00\",\"partySize\":20}")
        )
                .andExpect(status().isCreated());


        verify(reservationService).addReservation(
                eq(1L), eq(userId), eq(name), eq(date), eq(time), eq(partySize));
    }
}