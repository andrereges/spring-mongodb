package br.com.andre.mongodb.service.impl;

import br.com.andre.mongodb.model.Product;
import br.com.andre.mongodb.repository.ProductRepository;
import br.com.andre.mongodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryServiceImpl categoryServiceImpl;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id " + id));
    }

    @Override
    public Product create(Product product) {
        if (product.getCategory() == null)
            throw new IllegalArgumentException("Category is required");

        return productRepository.save(product);
    }

    @Override
    public Product update(String id, Product product) {
        Product entity = findById(id);
        entity.setName(product.getName());
        entity.setQuantity(product.getQuantity());
        entity.setPrice(product.getPrice());

        if (product.getCategory() != null)
            entity.setCategory(categoryServiceImpl.findById(product.getCategory().getId()));

        return productRepository.save(entity);
    }

    @Override
    public void delete(String id) {
        productRepository.delete(findById(id));
    }

    @Override
    public List<Product> getByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByRangePrice(BigDecimal from, BigDecimal to) {
        return productRepository.getProductsByRangePrice(from, to);
    }
}
