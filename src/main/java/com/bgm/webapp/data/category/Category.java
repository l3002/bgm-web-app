package com.bgm.webapp.data.category;

import java.util.Set;

import com.bgm.webapp.data.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Category
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long categoryID;
  private String categoryName;
  private String description;
  public static final String DEFAULT_IMG_DIR_PATH = ""; // TODO: create default directory path for all the categories
  private String imageDirPath;
  @OneToMany
  private Set<Product> products;
  private Integer numberOfProducts;
}
