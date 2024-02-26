package com.bgm.webapp.data.product;

import java.util.Map;

import com.bgm.webapp.data.category.Category;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
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

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productID;
  private String productName;
  private String description;
  @ElementCollection
  @CollectionTable(name = "property-value-mapping", joinColumns = { @JoinColumn(name = "id") })
  @MapKeyColumn(name = "property")
  @Column(name = "value")
  private Map<String, String> details;
  @ManyToOne
  private Category category;

}
