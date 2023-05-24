package co.id.enamduateknologi.business.payload.dto;

import java.sql.Time;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusinessDto {
  
  private String alias;
  private List<CategoryDto> categories;
  private CoordinatesDto coordinates;
  private String displayPhone;
  private Double distance;
  private String id;
  private String imageUrl;
  private Time openAt;
  private Time closedAt;
  private LocationDto location;
  private String name;
  private String phone;
  private String price;
  private Double rating;
  private Long reviewCount;
  private TransactionsDto transactions;
  private String url;
  
  
}
