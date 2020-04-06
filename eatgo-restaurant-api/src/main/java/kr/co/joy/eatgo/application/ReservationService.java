package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Reservation;
import kr.co.joy.eatgo.domain.ReservationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService {

    private ReservationRepository reservationRepository;

    public List<Reservation> getReservations(Long restaurantId) {
        return reservationRepository.findAllByRestaurantId(restaurantId);
    }
}
