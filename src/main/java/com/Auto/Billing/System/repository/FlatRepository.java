package com.Auto.Billing.System.repository;

import com.Auto.Billing.System.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Integer> {
    Flat findById(int flatId);
}
