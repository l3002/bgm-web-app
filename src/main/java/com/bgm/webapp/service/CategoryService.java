package com.bgm.webapp.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.bgm.webapp.data.category.Category;
import com.bgm.webapp.data.category.CategoryRepository;
import com.bgm.webapp.data.product.Product;

import lombok.AllArgsConstructor;

/**
 * CategoryService
 */
@Service
@AllArgsConstructor
public class CategoryService {

  private CategoryRepository categoryRepository;

  public Category findCategoryByName(String categoryName) {

    Optional<Category> category = categoryRepository.findByCategoryName(categoryName);

    return category.orElseThrow();
  }

  public Category uploadCategory(Category category) {

    return categoryRepository.save(category);

  }

  public Category updateCategoryName(String categoryName, String newCategoryName) {

    Category updatedCategory = categoryRepository.findByCategoryName(categoryName).orElseThrow();
    updatedCategory.setCategoryName(newCategoryName);
    updatedCategory.setImgDirPath(); // TODO: update image directory path after updating category name

    return categoryRepository.save(updatedCategory);

  }

  public Category updatedCategoryDescription(String categoryName, String description) {

    Category updatedCategory = categoryRepository.findByCategoryName(categoryName).orElseThrow();
    updatedCategory.setCategoryDescription(description);

    return categoryRepository.save(updatedCategory);

  }

  public Set<Product> getAllProductsInCategory(String categoryName) {

    Optional<Category> category = categoryRepository.findCategoryByName(categoryName).orElseThrow();

    return category.getProducts();

  }

}
