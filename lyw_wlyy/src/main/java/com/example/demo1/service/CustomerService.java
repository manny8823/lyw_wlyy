package com.example.demo1.service;

import com.example.demo1.Dao.CustomerDao;
import com.example.demo1.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {
    @Autowired
    CustomerDao customerDao;
    /*查找全部*/
    public List<Customer> getCustomer(){
        return customerDao.findAll();
    }

    /*删除 返回类型用来记录日志*/
    public void deleteCustomerById(String id){
        customerDao.deleteById(id);
    }

    /*新增 用来记录日志*/
    public void addCustomer(Customer customer){
        customerDao.save(customer);
    }

    /*查找某个*/
    public List<Customer> getCustomerById(String id){
        return customerDao.findAllById(id);
    }
    //获取某个
    public Customer AlterGetById(String id){
        return customerDao.findCustomerById(id);
    }

   /* public Customer update(Customer customer){
        Customer customer1=customerDao.findCustomerById(customer.getIdCustomer());
        System.out.println("空空空");
        customer1.setNameCustomer(customer1.getNameCustomer());
        customer1.setSex(customer1.getSexCustomer());
        customer1.setAddress(customer1.getAddress());
        customer1.setPhone(customer1.getPhone());
        return customerDao.save(customer1);
    }*/
    /*修改、更新*/
}
