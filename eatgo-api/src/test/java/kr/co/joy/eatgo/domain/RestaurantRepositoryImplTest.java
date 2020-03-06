package kr.co.joy.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryImplTest {
    @Test
    public void save() {
        RestaurantRepository repository = new RestaurantRepositoryImpl();

        int oldCount = repository.findAll().size();

        Restaurant restaurant = new Restaurant("BeRyong","Busan");
        repository.save(restaurant);

        assertEquals(restaurant.getId(), 1234);
        int newCount = repository.findAll().size();

        assertEquals(newCount - oldCount, 1);
    }
}