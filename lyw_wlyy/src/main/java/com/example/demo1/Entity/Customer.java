package com.example.demo1.Entity;

import com.example.demo1.Dao.CustomerDao;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer1")
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idcustomer")
    private String id;
    //@Column(name="namecustomer")
    private String name;
    //@Column(name="sexcustomer")
    private String sex;
   //@Column(name = "address")
    private String address;
    //@Column(name="phone")
    private String phone;

    public Customer(){}
    public String  getIdCustomer(){return id;}
    public String getNameCustomer(){return name;}
    public String getSexCustomer(){return sex;}
    public String getAddress(){return address;}
    public String getPhone(){return phone;}

    public void setNameCustomer(String name){this.name = name;}

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
