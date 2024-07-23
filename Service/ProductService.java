package com.example.productApplication.Service;

import com.example.productApplication.DTO.GroupedProductDTO;
import com.example.productApplication.DTO.SearchProductDTO;
import com.example.productApplication.Models.Product;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product addProduct(Product product);

    public List<Product> getAllProduct();

    public Optional<Product> getProductById(String productId);

    public Product updateProduct(Product product);

    public String deleteProductById(String productId);
    public List<GroupedProductDTO> groupProductsByType();
    public List<Product> searchProduct(SearchProductDTO searchProductDTO) throws ParseException;

}
