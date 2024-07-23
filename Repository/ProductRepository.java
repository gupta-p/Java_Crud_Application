package com.example.productApplication.Repository;

import com.example.productApplication.Models.Product;
import com.example.productApplication.Models.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
public interface ProductRepository extends MongoRepository<Product,String>,QuerydslPredicateExecutor<Product>{
      List<Product> findByIsDeletedFalse();
      List<Product> findByProductType(ProductType id);

}
