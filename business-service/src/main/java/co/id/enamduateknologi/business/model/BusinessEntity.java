package co.id.enamduateknologi.business.model;

import java.sql.Time;
import java.util.List;
import java.util.Set;
import co.id.enamduateknologi.business.common.model.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "business")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessEntity extends BaseEntity {

  @Id
  @Column(name = "business_id")
  private Long businessId;

  @OneToMany(mappedBy = "business")
  private Set<BusinessCategoryEmbeddedEntity> embeddedId;

  private String name;

  private String alias;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "businessEntity")
  private List<BusinessLocationEntity> location;

  private Double distance;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "open_at")
  private Time openAt;

  @Column(name = "closed_at")
  private Time closedAt;

  private String phone;

  private Double rating;

  @Column(name = "review_count")
  private Long reviewCount;

  private String url;

}
