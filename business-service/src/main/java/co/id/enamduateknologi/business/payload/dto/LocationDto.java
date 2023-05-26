package co.id.enamduateknologi.business.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocationDto {

  private String address1;
  
  private String address2;
  
  private String address3;
  
  private String city;
  
  private String country;
  
  @JsonProperty("display_address")
  private String[] displayAddress;
  
  private String state;
  
  private String zipCode;
}
