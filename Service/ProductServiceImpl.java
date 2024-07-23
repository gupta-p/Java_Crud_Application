package com.example.productApplication.Service;

import com.example.productApplication.DTO.GroupedProductDTO;
import com.example.productApplication.DTO.SearchProductDTO;
import com.example.productApplication.Models.Product;
import com.example.productApplication.Models.ProductType;
import com.example.productApplication.Models.QProduct;
import com.example.productApplication.Repository.ProductRepository;
import com.example.productApplication.Repository.ProductTypeRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public Product addProduct(Product product) {
        Optional<ProductType> productType = productTypeRepository.findById(product.getProductType().getId());
        if (productType != null) {
            product.setProductType(productType.get());
        }
        product.setStatus("PENDING");
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findByIsDeletedFalse();
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public String deleteProductById(String productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setDeleted(true);
            productRepository.save(existingProduct);
        }
        return "Product deleted successfully";
    }
    @Override
    public List<GroupedProductDTO> groupProductsByType() {
        List<ProductType> ProductTypes = productTypeRepository.findByIsDeletedFalse();
        List<GroupedProductDTO> filteredGroupingList = new ArrayList<>();
        for (ProductType pType : ProductTypes) {
            GroupedProductDTO groupProductType = new GroupedProductDTO();
            List<Product> products = productRepository.findByIsDeletedFalse();
            double totalPrice = 0;
            for (Product product : products) {
                totalPrice = totalPrice + product.getPrice();
            }
            groupProductType.setProductType(pType.getProductTypename());
            groupProductType.setProductList(products);
            groupProductType.setTotalPrice(totalPrice);
            filteredGroupingList.add(groupProductType);
        }
        return filteredGroupingList;
    }

    @Override
    public List<Product> searchProduct(SearchProductDTO searchProductDTO) throws ParseException {
        QProduct qProduct = new QProduct("Product");
        BooleanBuilder productBooleanBuilder = new BooleanBuilder();
        List<Product> productList;
        if (searchProductDTO.getSearchDate() != null) {
            LocalDate searchDate = searchProductDTO.getSearchDate();
            productBooleanBuilder.and(qProduct.expiryDate.before(searchDate));
            log.info("  " + productBooleanBuilder.getValue() + "    ");
        }
        Predicate predicates = productBooleanBuilder.getValue();
        productList = (List<Product>) productRepository.findAll(predicates);
        return productList;

    }
}
