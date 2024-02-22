package com.bgm.webapp.data.category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long categoryID;
  private String categoryName;
  private String description;
  private static final String DEFAULT_IMG_DIR_PATH = ""; // TODO: create default directory path for all the categories
  private Integer numberOfItem;
  private String imageDirPath;
}
