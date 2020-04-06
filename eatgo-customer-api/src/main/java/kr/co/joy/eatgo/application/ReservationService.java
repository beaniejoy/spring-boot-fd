package kr.co.joy.eatgo.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReservationService {

    public void addReservation(Long restaurantId, Long userId, String name,
                               String date, String time, Integer partySize) {
    }
}
