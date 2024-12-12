package com.mohitsabhadiya123.InventoryManagementSystem.Repository;

import com.mohitsabhadiya123.InventoryManagementSystem.Model_Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
}
