package com.Auto.Billing.System.repository;

import com.Auto.Billing.System.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    Tenant findById(int tid);
}
