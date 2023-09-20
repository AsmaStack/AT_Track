package com.amdocs.SpringBootCustomer.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.amdocs.SpringBootCustomer.model.Customers;

@Repository
public interface CustomerRepo extends JpaRepository<Customers, Long> {
}

