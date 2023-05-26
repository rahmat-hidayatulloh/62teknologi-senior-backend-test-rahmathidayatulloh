package co.id.enamduateknologi.business.payload.dto;

import java.sql.Time;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusinessDto {

  private String alias;

  private List<CategoryDto> categories;

  private CoordinatesDto coordinates;

  @JsonProperty("display_phone")
  private String displayPhone;

  private Double distance;

  private String imageUrl;

  @JsonProperty("open_at")
  private Time openAt;

  @JsonProperty("closed_at")
  private Time closedAt;

  private LocationDto location;

  private String name;

  private String phone;

  private String price;

  private Double rating;

  @JsonProperty("review_count")
  private Long reviewCount;

  private List<TransactionsDto> transactions;

  private String url;


}
