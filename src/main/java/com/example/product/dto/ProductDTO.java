package com.example.product.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    @NotNull(message = "id cannot be null")
    private String id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Size(max = 100)
    private String description;

    @Min(value = 0, message = "Price must be positive")
    private double costPrice;

    @Min(value = 0, message = "Stock must be non-negative")
    private int stock;
    @NotEmpty(message = "category cannot be empty")
    private String category;
    @Min(value = 0, message = "Price must be non-negative")
    private double sellingPrice;
    @Min(value = 0, message = "Price must be non-negative")
    private int stockSold;
    @NotNull(message = "date  cannot be empty")
    private Date manDate;
    private Date expiryDate;
    @NotEmpty(message = "sName cannot be empty")
    private  String supplierName;
    @NotEmpty(message = "place cannot be empty")
    private String manPlace;
    @Min(value = 0, message = "Stock must be non-negative")
    private double weight;
    @Min(value = 1, message = "The value must be at least 1")
    @Max(value = 10, message = "The value must be no more than 10")
    private int rating ;



}
