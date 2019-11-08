package edu.mum.stockservice.serviceImpl;

import edu.mum.stockservice.model.Category;
import edu.mum.stockservice.repository.CategoryRepository;
import edu.mum.stockservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
