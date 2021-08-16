package br.com.andre.mongodb.repository;

import br.com.andre.mongodb.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{ $and: [ { 'price': { $gte: ?0 } }, { 'price': { $lte: ?1 } } ] }")
    List<Product> getProductsByRangePrice(BigDecimal from, BigDecimal to);

    List<Product> findByName(String name);
}
