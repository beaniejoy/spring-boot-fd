package kr.co.joy.eatgo.domain;

import org.junit.jupiter.api.Test;

class RegionTests {

    @Test
    public void creation() {
        Region region = Region.builder().name("서울").build();

        assertEquals(region.getName(), "서울");
    }
}