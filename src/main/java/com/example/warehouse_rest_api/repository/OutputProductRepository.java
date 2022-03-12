package com.example.warehouse_rest_api.repository;

import com.example.warehouse_rest_api.entity.OutProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutputProductRepository extends JpaRepository<OutProduct,Integer> {
}
