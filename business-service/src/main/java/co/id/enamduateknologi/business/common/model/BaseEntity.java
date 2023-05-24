package co.id.enamduateknologi.business.common.model;

import java.sql.Timestamp;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {

  private Timestamp createdAt;

  private Timestamp updatedAt;

}
