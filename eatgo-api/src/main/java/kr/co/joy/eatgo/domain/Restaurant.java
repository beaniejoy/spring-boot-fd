package kr.co.joy.eatgo.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<>();

    public Restaurant() {

    }

    public Restaurant(@NonNull String name, @NonNull String address) {
        this.name = name;
        this.address = address;
    }

    public Restaurant(Long id, @NonNull String name, @NonNull String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getInformation() {
        return name + " in " + address;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        for (MenuItem menuItem : menuItems) {
            addMenuItem(menuItem);
        }
    }
}
