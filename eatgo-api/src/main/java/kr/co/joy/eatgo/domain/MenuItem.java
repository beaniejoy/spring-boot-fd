package kr.co.joy.eatgo.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Entity
public class MenuItem {
    @Id
    @GeneratedValue
    private Long id;

    private Long restaurantId;

    @NonNull private String name;

    public String getName() {
        return name;
    }
}
