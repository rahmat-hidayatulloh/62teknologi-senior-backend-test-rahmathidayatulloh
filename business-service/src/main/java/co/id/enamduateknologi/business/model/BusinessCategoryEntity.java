package co.id.enamduateknologi.business.model;

import java.util.Set;
import co.id.enamduateknologi.business.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "business_category")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessCategoryEntity extends BaseEntity {

  @Id
  @Column(name = "category_id")
  private Long categoryId;

  @OneToMany(mappedBy = "category")
  private Set<BusinessCategoryEmbeddedEntity> embeddedId;

  private String alias;
  private String title;

}
