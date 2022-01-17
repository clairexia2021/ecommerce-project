package com.clairex.ecommerce.dao;

import com.clairex.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("http://localhost:4200") // origin is protocol + hostname + port
public interface ProductRepository extends JpaRepository<Product, Long> {

    // query method: select * from product where category_id = ?
    // REST automatically exposes endpoint: http://localhost:8080/api/products/search/findByCategoryId?id=1
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // select * from product p where p.name like concat('%', :name, '%')
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
