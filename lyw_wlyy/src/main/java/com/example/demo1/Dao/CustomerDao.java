package com.example.demo1.Dao;

import com.example.demo1.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

public interface CustomerDao extends
            JpaRepository<Customer, Integer>,
            JpaSpecificationExecutor<Customer>,
            Serializable {
    List<Customer> findAllById(String id);
    void deleteById(String id);
    //List<Customer> cusList();


    //获取某个信息
    Customer findCustomerById(String id);


}

