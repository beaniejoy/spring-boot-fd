package kr.co.joy.eatgo.application;

import kr.co.joy.eatgo.domain.Category;
import kr.co.joy.eatgo.domain.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTests {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
//        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void getCategories() {
        List<Category> mockCategories = new ArrayList<>();
        mockCategories.add(Category.builder().name("Korean Food").build());

        given(categoryRepository.findAll()).willReturn(mockCategories);

        List<Category> categories = categoryService.getCategories();
        Category category = categories.get(0);
        assertEquals(category.getName(), "Korean Food");
    }
}