package br.com.andre.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class Product {

    @Id
    private String id;
    private String name;
    private Double quantity;
    private BigDecimal price;

    @DBRef
    private Category category;
}
