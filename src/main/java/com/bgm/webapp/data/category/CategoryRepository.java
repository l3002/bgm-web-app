package com.bgm.webapp.data.category;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoryRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  public Optional<Category> findByCategoryName(String categoryName);

}
