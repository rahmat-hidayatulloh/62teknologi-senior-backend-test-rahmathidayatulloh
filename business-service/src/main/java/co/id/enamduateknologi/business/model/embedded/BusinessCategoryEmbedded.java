package co.id.enamduateknologi.business.model.embedded;

import co.id.enamduateknologi.business.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
public class BusinessCategoryEmbedded extends BaseEntity {

  @Column(name = "business_id")
  private Long businessId;

  @Column(name = "category_id")
  private Long categoryId;

}
