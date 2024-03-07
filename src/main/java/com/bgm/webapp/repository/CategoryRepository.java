package com.bgm.webapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bgm.webapp.data.category.Category;

/**
 * CategoryRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  public Optional<Category> findByCategoryName(String categoryName);

}
