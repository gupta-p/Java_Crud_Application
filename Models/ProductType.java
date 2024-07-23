package com.example.productApplication.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;
@Data
@Document(collection = "productType")
public class ProductType {
    @Id
    private String id;
    private String productTypename;
    private boolean isDeleted;
}
