package com.Auto.Billing.System.repository;

import com.Auto.Billing.System.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Tenant findById(long tid);
}
