package com.foodretail.service;

import com.foodretail.entity.Product;
import com.foodretail.repository.ProductRepository;
import com.foodretail.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    public ProductService(
            ProductRepository productRepository,
            OrderItemRepository orderItemRepository) {

        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(int id) {

        orderItemRepository.deleteByProductId(id);

        productRepository.deleteById(id);
    }
}