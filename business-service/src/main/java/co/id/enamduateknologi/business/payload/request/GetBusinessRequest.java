package co.id.enamduateknologi.business.payload.request;

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
public class GetBusinessRequest extends BaseRequest {

  /**
   * 
   */
  private static final long serialVersionUID = 8410393612180096882L;

  private String location;
  private String latitude;
  private String longitude;
  private String openAt;
  private String closedAt;

}
