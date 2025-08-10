package com.Auto.Billing.System.repository;

import com.Auto.Billing.System.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    public Building findById(long bid);
}
