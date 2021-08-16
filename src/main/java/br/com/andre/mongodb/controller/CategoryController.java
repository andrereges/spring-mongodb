package br.com.andre.mongodb.controller;

import br.com.andre.mongodb.model.Category;
import br.com.andre.mongodb.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity<Category> create(@RequestBody Category category, HttpServletRequest httpRequest) {
        return ResponseEntity
                .created(URI.create(httpRequest.getRequestURI()))
                .body(categoryService.create(category));
    }

    @GetMapping("/{id}")
    ResponseEntity<Category> get(@PathVariable String id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PutMapping("/{id}")
    ResponseEntity<Category> update(@PathVariable String id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.update(id, category));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable String id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

}
