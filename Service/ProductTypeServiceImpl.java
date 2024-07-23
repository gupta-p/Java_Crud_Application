package com.example.productApplication.Service;

import com.example.productApplication.Models.Product;
import com.example.productApplication.Models.ProductType;
import com.example.productApplication.Repository.ProductTypeRepository;
import com.example.productApplication.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;
    @Override
    public ProductType addProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public List<ProductType> getAllProductType() {
        return productTypeRepository.findAll();
    }

    @Override
    public Optional<ProductType> getProductTypeById(String id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public ProductType updateProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }
}
