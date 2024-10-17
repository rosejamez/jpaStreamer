package com.example.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private double costPrice;
    private double sellingPrice;
    private int stock ;
    private int stockSold;
    private Date manDate;
    private Date expiryDate;
    private  String supplierName;
    private String manPlace;
    private double weight;
    private int rating ;



}
