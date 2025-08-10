package com.Auto.Billing.System.repository;

import com.Auto.Billing.System.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    Owner findById(int oid);
}
