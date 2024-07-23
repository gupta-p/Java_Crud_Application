package com.example.productApplication.Models;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@QueryEntity
@Document(collection = "products")
public class Product {
    @Id
    private String productId;
    private String name;
    private double price;
    private Number designYear;
    private LocalDate expiryDate;
    private boolean isDeleted;
    @DocumentReference
    private ProductType productType;
    private String status;
}
