package com.example.productApplication.Repository;

import com.example.productApplication.Models.Product;
import com.example.productApplication.Models.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductTypeRepository extends MongoRepository<ProductType , String> {

    List<ProductType> findByIsDeletedFalse();

}
