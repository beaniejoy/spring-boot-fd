package kr.co.joy.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTests {

    @Test
    public void creation() {
        Category category = Category.builder().name("Korean Food").build();

        assertEquals(category.getName(), "Korean Food");
    }
}