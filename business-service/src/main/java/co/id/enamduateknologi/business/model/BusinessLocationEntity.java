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
@Table(name = "business_location")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BusinessLocationEntity extends BaseEntity {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID")
  @UuidGenerator
  @Column(name = "location_id")
  private String locationId;

  private String address1;

  private String address2;

  private String address3;

  private String city;

  private String country;

  private String state;

  private String zipCode;

  private Double latitude;

  private Double longitude;

}
