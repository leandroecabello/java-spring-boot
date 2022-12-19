package com.demo.market.domain.service;

import com.demo.market.domain.ProductDomain;
import com.demo.market.domain.repository.ProductDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductDomainRepository productDomainRepository;

    public List<ProductDomain> getAll(){
        return productDomainRepository.getAll();
    }

    public Optional<ProductDomain> getProduct(int productId) {
        return productDomainRepository.getProduct(productId);
    }

    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        return productDomainRepository.getByCategory(categoryId);
    }

    public ProductDomain save(ProductDomain product) {
        return productDomainRepository.save(product);
    }

    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productDomainRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
