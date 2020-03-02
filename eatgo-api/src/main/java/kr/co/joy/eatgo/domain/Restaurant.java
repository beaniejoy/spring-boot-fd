package kr.co.joy.eatgo.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Restaurant {
    @NonNull private Long id;
    @NonNull private String name;
    @NonNull private String address;
    private List<MenuItem> menuItems = new ArrayList<>();

    public String getInformation() {
        return name + " in " + address;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void setMenuItem(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }
}
