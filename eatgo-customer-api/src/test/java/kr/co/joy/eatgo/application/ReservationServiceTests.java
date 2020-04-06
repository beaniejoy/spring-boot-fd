package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Reservation;
import kr.co.joy.eatgo.domain.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class ReservationServiceTests {

    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        reservationService = new ReservationService(reservationRepository);
    }

    @Test
    public void addReservation() {
        Long restaurantId = 369L;
        Long userId = 1004L;
        String name = "Joy";
        String date = "2020-03-10";
        String time = "20:00";
        Integer partySize = 20;

        // willReturn으로 하면 Repository에서 return하는 작동방식을 무시하는 것이므로
        // will에서 invocation을 통해 실제 Repository에서 return 되는 것을 받도록 하자.
        given(reservationRepository.save(any())).will(invocation -> {
            Reservation reservation = invocation.getArgument(0);
            return reservation;
        });

        Reservation reservation = reservationService.addReservation(
                restaurantId, userId, name, date, time, partySize);

        assertEquals(reservation.getName(), name);

        verify(reservationRepository).save(any(Reservation.class));
    }

}