package com.demo.market.domain.repository;

import com.demo.market.domain.ProductDomain;

import java.util.List;
import java.util.Optional;

public interface ProductDomainRepository {

    List<ProductDomain> getAll();
    Optional<List<ProductDomain>> getByCategory(int categoryId);
    Optional<List<ProductDomain>> getScarseProducts(int quantity);
    Optional<ProductDomain> getProduct(int productId);
    ProductDomain save(ProductDomain product);
    void delete(int productId);
}
