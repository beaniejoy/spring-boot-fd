package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Category;
import kr.co.joy.eatgo.domain.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }

}
