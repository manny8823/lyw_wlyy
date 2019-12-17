package com.example.demo1.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name="goods")
public class goods implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="idgoods")
    private String idgoods;
    @Column(name="name")
    private String name;
    @Column(name="size")
    private String size;
    @Column(name="provider")
    private String provider;


    @Column(name="date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String date;
    @Column(name="price")
    private String price;
    @Column(name="sellPrice")
    private String sellPrice;
    @Column(name="totalSum")
    private String totalSum;

    String getIdgoods(){return idgoods;}
    String getName(){return name;}
    String getSize(){return size;}
    String getProvider(){return provider;}
    String getDate(){return date;}
    String getPrice(){return price;}
    String getSellPrice(){return sellPrice;}
    String getTotalSum(){return totalSum;}
}
