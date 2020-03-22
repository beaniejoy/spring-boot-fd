package kr.co.joy.eatgo.interfaces;

import kr.co.joy.eatgo.application.MenuItemService;
import kr.co.joy.eatgo.domain.MenuItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MenuItemController.class)
class MenuItemControllerTests {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private MenuItemService menuItemService;

    @Test
    public void list() throws Exception {
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(MenuItem.builder()
                .restaurantId(1004L)
                .name("Kimchi")
                .build());

        given(menuItemService.getMenuItems(1004L)).willReturn(menuItems);

        mvc.perform(get("/restaurants/1004/menuitems"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"restaurantId\":1004")))
                .andExpect(content().string(
                        containsString("\"name\":\"Kimchi\"")));
    }

    @Test
    public void bulkUpdate() throws Exception {
        mvc.perform(
                patch("/restaurants/1/menuitems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[]")
        )
                .andExpect(status().isOk());

        verify(menuItemService).bulkUpdate(eq(1L), any());
    }
}