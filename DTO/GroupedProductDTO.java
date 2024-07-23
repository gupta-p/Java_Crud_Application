package com.example.productApplication.DTO;

import com.example.productApplication.Models.Product;
import lombok.Data;

import java.util.List;
@Data
public class GroupedProductDTO {
    private String productType;
    private List<Product> productList;
    private double totalPrice;
}
