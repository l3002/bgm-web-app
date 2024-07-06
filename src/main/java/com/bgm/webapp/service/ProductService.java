package com.bgm.webapp.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bgm.webapp.data.product.Product;
import com.bgm.webapp.repository.ProductRepository;

import lombok.AllArgsConstructor;

/**
 * ProductService
 */
@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public ResponseEntity<?> getProductByID(Long productID) {

    Optional<Product> product = productRepository.findById(productID);

    return product.map(response -> ResponseEntity.ok().body(response))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  public ResponseEntity<Product> saveProduct(Product product) throws URISyntaxException {

    Product newProduct = productRepository.save(product);

    return ResponseEntity.created(new URI("/product/" + newProduct.getProductID())).body(newProduct);
  }

  public ResponseEntity<Product> updateProduct(Product product) {

    Product updatedProduct = productRepository.save(product);

    return ResponseEntity.ok().body(updatedProduct);

  }

  public ResponseEntity<?> deleteProduct(Long ProductID) {

    productRepository.deleteById(ProductID);

    return ResponseEntity.ok().build();
  }
}
