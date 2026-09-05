package com.foodretail.controller;

import com.foodretail.entity.Product;
import com.foodretail.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String productsPage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping("/api/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/api/products")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/api/products/{id}")
    @ResponseBody
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {

        product.setId(id);
        return productService.saveProduct(product);
    }

    @DeleteMapping("/api/products/{id}")
    @ResponseBody
    public String deleteProduct(@PathVariable int id) {

        productService.deleteProduct(id);

        return "Product deleted successfully!";
    }
}