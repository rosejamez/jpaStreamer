package com.example.product.service;
import com.example.product.repository.ProductRepository;
import com.example.product.dto.ProductDTO;
import com.example.product.model.ProductEntity;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    final  private JPAStreamer jpaStreamer;

    @Autowired
    public ProductService(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }
    public List<ProductEntity> getAllProduct(){
        return productRepository.findAll();

    }
    public ProductEntity getAProduct(String id){
        Optional<ProductEntity> productEntity=productRepository.findById(id);
        return productEntity.orElse(null);

    }
    public ProductEntity addProduct(ProductDTO productDTO){
        ProductEntity productEntity=ProductEntity.builder()
                                    .id(productDTO.getId())
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .costPrice(productDTO.getCostPrice())
                .sellingPrice(productDTO.getSellingPrice())
                .stock(productDTO.getStock())
                .stockSold(productDTO.getStockSold())
                .manDate(productDTO.getManDate())
                .expiryDate(productDTO.getExpiryDate())
                .supplierName(productDTO.getSupplierName())
                .manPlace(productDTO.getManPlace())
                .weight(productDTO.getWeight())
                .rating(productDTO.getRating())
                .build();
        return productRepository.save(productEntity);

    }
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public Map<String,List<String>> getProductOfAllSuppliers(){
        return jpaStreamer.stream(ProductEntity.class)
                .collect(Collectors.groupingBy(
                        ProductEntity::getSupplierName,
                        Collectors.mapping(ProductEntity::getName, Collectors.toList())
                ));
    }

    public Map<String, List<String>> findAllProductUnderEachCategory(){
        return jpaStreamer.stream(ProductEntity.class)
                .collect(Collectors.groupingBy(
                        ProductEntity::getCategory
                        ,Collectors.mapping(ProductEntity::getName, Collectors.toList())));
    }

    public List<String> findExpiredProductNames() {
        Date now = new Date();
        return jpaStreamer.stream(ProductEntity.class)
                .filter(product -> product.getExpiryDate().before(now)) // Use before for Date
                .map(ProductEntity::getName)
                .collect(Collectors.toList());
    }
    public Map<String, String> findBestSellingProductsByCategory() {
        return jpaStreamer.stream(ProductEntity.class)
                .collect(Collectors.groupingBy(ProductEntity::getCategory))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .max((p1, p2) -> Integer.compare(p1.getStockSold(), p2.getStockSold()))
                                .map(ProductEntity::getName)
                                .orElse(null)
                ));
    }

    public Map<String, Double> calculateProfitForProducts() {
        return jpaStreamer.stream(ProductEntity.class)
                .collect(Collectors.toMap(
                        ProductEntity::getName,
                        product -> (product.getSellingPrice() - product.getCostPrice()) * product.getStockSold()
                ));
    }
    public Map<String, Integer> calculateRemainingStock() {
        return jpaStreamer.stream(ProductEntity.class)
                .collect(Collectors.toMap(
                        ProductEntity::getName,
                        product -> product.getStock() - product.getStockSold()
                ));
    }


}

