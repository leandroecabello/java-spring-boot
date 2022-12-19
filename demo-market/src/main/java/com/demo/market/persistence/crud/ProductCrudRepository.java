package com.demo.market.persistence.crud;

import com.demo.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

    // 1
    //List<Product> findByCategoryId(int categoryId);

    //2
    /*@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true);
    List<Product> findByCategoryId(int categoryId);*/

    // 3
    List<Product> findByCategoryIdOrderByNameAsc(int categoryId);

    Optional<List<Product>> findByStockQuantityLessThanAndState(int stockQuantity, boolean state);
}
