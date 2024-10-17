package com.example.product.controller;

import com.example.product.dto.ProductDTO;
import com.example.product.model.ProductEntity;
import com.example.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }

    // Get a single product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable String id) {
        ProductEntity product = productService.getAProduct(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    // Add a new product
    @PostMapping
    public ResponseEntity<ProductEntity> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductEntity createdProduct = productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Get all products grouped by supplier name
    @GetMapping("/suppliers")
    public ResponseEntity<Map<String, List<String>>> getProductsBySupplier() {
        Map<String, List<String>> productsBySupplier = productService.getProductOfAllSuppliers();
        return ResponseEntity.ok(productsBySupplier);
    }

    @GetMapping("/category")
    public ResponseEntity<Map<String, List<String>>> findAllProductUnderEachCategory(){
        Map<String, List<String>> productsByCategory =productService.findAllProductUnderEachCategory();
        return ResponseEntity.ok(productsByCategory);
    }
    @GetMapping("/expired")
    public ResponseEntity<List<String>> findExpiredProductNames(){
        List<String> expiredProducts =productService.findExpiredProductNames();
        return ResponseEntity.ok(expiredProducts);
    }

    @GetMapping("/bestseller")
    public ResponseEntity<Map<String, String>> findBestSellingProductsByCategory(){
        Map<String, String> bestSeller =productService.findBestSellingProductsByCategory();
        return ResponseEntity.ok(bestSeller);
    }
    @GetMapping("/profit")
    public ResponseEntity<Map<String, Double>> calculateProfitForProducts(){
        Map<String, Double> profit =productService.calculateProfitForProducts();
        return ResponseEntity.ok(profit);
    }
    @GetMapping("/availablestock")
    public ResponseEntity<Map<String, Integer>> calculateRemainingStock(){
        Map<String, Integer> profit =productService.calculateRemainingStock();
        return ResponseEntity.ok(profit);
    }




}

