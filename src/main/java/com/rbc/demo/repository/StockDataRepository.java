package com.rbc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rbc.demo.model.StockDataEntity;

@Repository
public interface StockDataRepository extends JpaRepository<StockDataEntity, Long> {
}
