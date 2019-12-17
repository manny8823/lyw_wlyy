package com.example.demo1.Dao;

import com.example.demo1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IndexDao extends
        JpaRepository<Customer, String>,
        JpaSpecificationExecutor<Customer>,
        Serializable {
    @Query(value = "select id, address from customer ",nativeQuery = true)
    public List<Customer> findAll();
}
