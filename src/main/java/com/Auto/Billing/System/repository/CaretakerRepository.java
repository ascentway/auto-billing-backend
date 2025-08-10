package com.Auto.Billing.System.repository;


import com.Auto.Billing.System.entity.Caretaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaretakerRepository extends JpaRepository<Caretaker, Long> {
    public Caretaker findById(long cid);
}
