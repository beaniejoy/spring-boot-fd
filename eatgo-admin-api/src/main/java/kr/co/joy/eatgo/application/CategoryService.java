package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Category;
import kr.co.joy.eatgo.domain.CategoryRepository;
import kr.co.joy.eatgo.domain.Region;
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

    public Category addCategory(String name) {
        Category category = Category.builder().name(name).build();
        return categoryRepository.save(category);
    }
}
