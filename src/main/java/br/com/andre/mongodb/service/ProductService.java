package br.com.andre.mongodb.service;

import br.com.andre.mongodb.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ProductService {

    List<Product> getAll();

    Product findById(String id);

    Product create(Product product);

    Product update(String id, Product product);

    void delete(String id);

    List<Product> getByName(String name);

    List<Product> getProductsByRangePrice(BigDecimal from, BigDecimal to);
}
