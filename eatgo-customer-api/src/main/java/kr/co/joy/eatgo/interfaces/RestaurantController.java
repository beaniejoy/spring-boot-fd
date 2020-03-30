package kr.co.joy.eatgo.interfaces;

import kr.co.joy.eatgo.application.RestaurantService;
import kr.co.joy.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list(@RequestParam("region") String region) {
        List<Restaurant> restaurants = restaurantService.getRestaurants(region, );
        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        // 레스토랑의 기본정보 + 메뉴정보
        Restaurant restaurant = restaurantService.getRestaurant(id);
        return restaurant;
    }
}
