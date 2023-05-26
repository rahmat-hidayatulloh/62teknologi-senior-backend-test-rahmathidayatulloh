package co.id.enamduateknologi.business.payload.response;

import co.id.enamduateknologi.business.common.base.BaseResponse;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class PutBusinessResponse extends BaseResponse {

  /**
   * 
   */
  private static final long serialVersionUID = -176092179613917629L;

}
