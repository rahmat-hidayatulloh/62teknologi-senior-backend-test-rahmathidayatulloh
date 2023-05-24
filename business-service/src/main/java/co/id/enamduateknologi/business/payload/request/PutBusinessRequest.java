package co.id.enamduateknologi.business.payload.request;

import co.id.enamduateknologi.business.common.base.BaseRequest;
import co.id.enamduateknologi.business.payload.dto.BusinessDto;
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
public class PutBusinessRequest extends BaseRequest {

  /**
   * 
   */
  private static final long serialVersionUID = -4014312818930453696L;

  private BusinessDto businesses;
  private String region;
  private int total;
}
