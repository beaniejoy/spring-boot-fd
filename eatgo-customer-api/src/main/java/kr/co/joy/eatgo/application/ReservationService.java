package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Reservation;
import kr.co.joy.eatgo.domain.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    public Reservation addReservation(Long restaurantId, Long userId, String name,
                                      String date, String time, Integer partySize) {

        Reservation reservation = Reservation.builder()
                .restaurantId(restaurantId)
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .partySize(partySize)
                .build();

        return reservationRepository.save(reservation);
    }
}
