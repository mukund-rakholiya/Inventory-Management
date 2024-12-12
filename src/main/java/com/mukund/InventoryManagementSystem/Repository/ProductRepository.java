package com.mohitsabhadiya123.InventoryManagementSystem.Repository;

import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
