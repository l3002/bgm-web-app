package com.bgm.webapp.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bgm.webapp.data.product.Product;
import com.bgm.webapp.service.ProductService;

import lombok.AllArgsConstructor;

/**
 * ProductController
 */
@RestController
@AllArgsConstructor
public class ProductController {

  private ProductService productService;

  @GetMapping("/products")
  public List<Product> getProducts() {
    return productService.getAllProducts();
  }

  @PostMapping("/product/new")
  public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product product) throws URISyntaxException {

    return productService.saveProduct(product);
  }

  @GetMapping("/product/{id}")
  public ResponseEntity<?> getProductById(@PathVariable Long id) {
    return productService.getProductByID(id);
  }

  @PutMapping("/product/{id}")
  public ResponseEntity<Product> updateProduct(@Validated @RequestBody Product product) {
    return productService.updateProduct(product);
  }

  @DeleteMapping("/product/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id) {

    return productService.deleteProduct(id);
  }

}
