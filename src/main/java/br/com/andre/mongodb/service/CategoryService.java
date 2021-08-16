package br.com.andre.mongodb.service;

import br.com.andre.mongodb.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getAll();

    Category findById(String id);

    Category create(Category category);

    Category update(String id, Category category);

    void delete(String id);
}
