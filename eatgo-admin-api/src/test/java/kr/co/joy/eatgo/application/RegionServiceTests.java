package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Region;
import kr.co.joy.eatgo.domain.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class RegionServiceTests {

    private RegionService regionService;

    @Mock
    private RegionRepository regionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        regionService = new RegionService(regionRepository);
    }

    @Test
    public void getRegions() {
        List<Region> mockRegions = new ArrayList<>();
        mockRegions.add(Region.builder().name("Seoul").build());

        given(regionRepository.findAll()).willReturn(mockRegions);

        List<Region> regions = regionService.getRegions();
        Region region = regions.get(0);
        assertEquals(region.getName(), "Seoul");
    }

    @Test
    public void addRegion() {
        given(regionRepository.save(any())).will(invocation -> {
            Region region = invocation.getArgument(0);
            region.setId(1004L);
            return region;
        });

        Region region = regionService.addRegion("Seoul");
        verify(regionRepository).save(any());
        assertEquals(region.getName(), "Seoul");

    }
}