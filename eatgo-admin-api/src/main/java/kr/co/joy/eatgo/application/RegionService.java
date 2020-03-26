package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Region;
import kr.co.joy.eatgo.domain.RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegionService {

    private RegionRepository regionRepository;

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();

        return regions;
    }
}
