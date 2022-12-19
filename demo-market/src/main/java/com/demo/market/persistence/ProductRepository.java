package com.demo.market.persistence;

import com.demo.market.domain.ProductDomain;
import com.demo.market.domain.repository.ProductDomainRepository;
import com.demo.market.persistence.crud.ProductCrudRepository;
import com.demo.market.persistence.entity.Product;
import com.demo.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
* Resumen de que se intenta hacer:
*
* Al orientar nuestro repositorio a términos del dominio, lo que se quiere conseguir
* es conectar los métodos que tenemos en el repositorio, a el dominio para que así
* funcione en términos del dominio y no de la base que está conectada directamente con la DB
*
* */

// @Component: le indicamos que es un componente de spring.
@Repository // indica que la clase es la encargada de interactuar con la base de datos.
public class ProductRepository implements ProductDomainRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDomain> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<ProductDomain>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }

    @Override
    public Optional<List<ProductDomain>> getScarseProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndState(quantity, true);
        return products.map((prods -> mapper.toProducts(prods)));
    }

    @Override
    public Optional<ProductDomain> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProductDomain(product));
    }

    @Override
    public ProductDomain save(ProductDomain productDomain) {
        Product product = mapper.toProduct(productDomain);
        return mapper.toProductDomain(productCrudRepository.save(product));
    }

    @Override
    public void delete(int productId){
        productCrudRepository.deleteById(productId);
    }
}
