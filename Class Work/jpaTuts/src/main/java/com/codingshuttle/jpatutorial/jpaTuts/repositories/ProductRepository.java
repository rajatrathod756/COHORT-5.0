package com.codingshuttle.jpatutorial.jpaTuts.repositories;

import com.codingshuttle.jpatutorial.jpaTuts.entites.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
