package com.example.product.repository;

import com.example.product.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<ProductEntity, String> {}
