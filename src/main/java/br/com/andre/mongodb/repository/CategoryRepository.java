package br.com.andre.mongodb.repository;

import br.com.andre.mongodb.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
