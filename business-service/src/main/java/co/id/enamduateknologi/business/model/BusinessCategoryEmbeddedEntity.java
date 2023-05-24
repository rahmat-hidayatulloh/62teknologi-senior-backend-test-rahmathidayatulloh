package co.id.enamduateknologi.business.model;

import co.id.enamduateknologi.business.model.embedded.BusinessCategoryEmbedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "business_category_embedded")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BusinessCategoryEmbeddedEntity {

  @EmbeddedId
  private BusinessCategoryEmbedded id;

  @ManyToOne
  @MapsId("businessId")
  @JoinColumn(name = "business_id")
  private BusinessEntity business;

  @ManyToOne
  @MapsId("categoryId")
  @JoinColumn(name = "category_id")
  private BusinessCategoryEntity category;

}
