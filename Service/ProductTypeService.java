package com.example.productApplication.Service;

import com.example.productApplication.Models.Product;
import com.example.productApplication.Models.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {

    public ProductType addProductType(ProductType productType);

    public List<ProductType> getAllProductType();

    public Optional<ProductType> getProductTypeById(String id);

    public ProductType updateProductType( ProductType productType);

}
