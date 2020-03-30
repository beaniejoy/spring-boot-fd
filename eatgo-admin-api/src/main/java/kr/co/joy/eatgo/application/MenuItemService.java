package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.MenuItem;
import kr.co.joy.eatgo.domain.MenuItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuItemService {

    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getMenuItems(Long restaurantId) {
        return menuItemRepository.findAllByRestaurantId(restaurantId);
    }

    public void bulkUpdate(Long restaurantId, List<MenuItem> menuItems) {
        // bulk update
        for (MenuItem menuItem : menuItems) {
            update(restaurantId, menuItem);
        }
    }

    // insert, update, delete functions all included
    private void update(Long restaurantId, MenuItem menuItem) {
        if (menuItem.isDestroy()) {
            // delete
            menuItemRepository.deleteById(menuItem.getId());
            return;
        }
        menuItem.setRestaurantId(restaurantId);
        menuItemRepository.save(menuItem);
    }
}
