package com.bgm.webapp.data.product;

import java.util.Map;

import com.bgm.webapp.data.category.Category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Product
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productID;
  private String productName;
  private String description;
  private Map<String, String> details;
  private Category category;

}
