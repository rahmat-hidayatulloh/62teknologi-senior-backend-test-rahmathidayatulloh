package co.id.enamduateknologi.business.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import co.id.enamduateknologi.business.common.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DeleteBusinessRequest extends BaseRequest {

  /**
   * 
   */
  private static final long serialVersionUID = -583666083012991828L;

  @JsonProperty("business_id")
  private String businessId;

}
