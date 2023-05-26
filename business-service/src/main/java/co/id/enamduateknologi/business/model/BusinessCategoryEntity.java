package co.id.enamduateknologi.business.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;
import co.id.enamduateknologi.business.common.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID")
  @UuidGenerator
  @Column(name = "category_id")
  private String categoryId;

  // @OneToMany(mappedBy = "category")
  // private Set<BusinessCategoryRelationshipEntity> embeddedId;

  private String alias;
  private String title;

  public BusinessCategoryEntity(String alias, String title) {
    this.alias = alias;
    this.title = title;
  }

}
