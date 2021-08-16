package br.com.andre.mongodb.service.impl;

import br.com.andre.mongodb.model.Category;
import br.com.andre.mongodb.repository.CategoryRepository;
import br.com.andre.mongodb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with id " + id));
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(String id, Category category) {
        Category entity = findById(id);
        entity.setName(category.getName());

        return categoryRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        Category category = findById(id);
        categoryRepository.delete(category);
    }
}
