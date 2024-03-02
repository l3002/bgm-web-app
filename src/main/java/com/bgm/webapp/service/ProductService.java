package com.bgm.webapp.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bgm.webapp.data.product.Product;
import com.bgm.webapp.data.product.ProductRepository;

import lombok.AllArgsConstructor;

/**
 * ProductService
 */
@Service
@AllArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public Product findProductWithName(String productName) {

    Optional<Product> product = productRepository.findByProductName(productName);

    return product.orElseThrow();
  }

  public Product uploadProduct(Product product) {

    return productRepository.save(product);

  }

  public Product updateProductName(String productName, String newProductName) {

    Product updatedProduct = productRepository.findByProductName(productName).orElseThrow();

    updatedProduct.setProductName(newProductName);

    return productRepository.save(updatedProduct);

  }

  public Product updateProductDescription(String productName, String newDescription) {

    Product updatedProduct = productRepository.findByProductName(productName).orElsethrow();

    updatedProduct.setDescription(newDescription);

    return productRepository.save(updatedProduct);
  }

  public Product updateProductDetails(String productName, Map<String, String> newDetails) {

    Product updatedProduct = productRepository.findByProductName(productName).orElseThrow();

    updatedProduct.setDetails(newDetails);

    return productRepository.save(updatedProduct);

  }

  public Product addNewPropertyToDetail(String productName, String property, String value) {

    Product updatedProduct = productRepository.findByProductName(productName).orElseThrow();

    Map<String, String> newDetails = new HashMap<String, String>();

    newDetails.putAll(updatedProduct.getDetails());

    newDetails.put(property, value);

    updatedProduct.setDetails(newDetails);

    return updatedProduct;
  }

  // TODO Add Implementation for below method.
  public Product updatePropertyInDetails(String productName, String property, String value) {
    return null;
  }

}
