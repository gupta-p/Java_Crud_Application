package com.example.productApplication.Controller;

import com.example.productApplication.Models.Product;
import com.example.productApplication.Models.ProductType;
import com.example.productApplication.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productType")
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @PostMapping("/addProductType")
    public ResponseEntity<Object> addProductType(@RequestBody ProductType productType) {
        try {
            return new ResponseEntity<>(productTypeService.addProductType(productType), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllProductType")
    public ResponseEntity<Object> getProductType() {
        try {
            return new ResponseEntity<>(productTypeService.getAllProductType(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getProductTypeById")
    public ResponseEntity<Object> getProductById(@RequestParam String id) {
        try {
            return new ResponseEntity<>(productTypeService.getProductTypeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/updateProductType")
    public ResponseEntity<Object> updateProductType(@RequestBody ProductType productType) {
        try {
            return new ResponseEntity<>(productTypeService.updateProductType(productType), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
