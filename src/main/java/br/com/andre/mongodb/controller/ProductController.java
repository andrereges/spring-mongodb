package br.com.andre.mongodb.controller;

import br.com.andre.mongodb.model.Product;
import br.com.andre.mongodb.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/name")
    ResponseEntity<List<Product>> getByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(productService.getByName(name));
    }

    @GetMapping("/price-range")
    ResponseEntity<List<Product>> getByPriceRange(
            @RequestParam("from") BigDecimal from,
            @RequestParam("to") BigDecimal to) {
        return ResponseEntity.ok(productService.getProductsByRangePrice(from, to));
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<Product> create(@RequestBody Product product, HttpServletRequest httpRequest) {
        return ResponseEntity
                .created(URI.create(httpRequest.getRequestURI()))
                .body(productService.create(product));
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> get(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

}
