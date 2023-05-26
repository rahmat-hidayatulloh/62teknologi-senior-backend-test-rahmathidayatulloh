package co.id.enamduateknologi.business.payload.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoordinatesDto {

  private Double latitude;
  private Double longitude;
}
