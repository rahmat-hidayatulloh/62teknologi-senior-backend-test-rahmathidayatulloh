package co.id.enamduateknologi.business.payload.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

  private String alias;
  private String title;

}
