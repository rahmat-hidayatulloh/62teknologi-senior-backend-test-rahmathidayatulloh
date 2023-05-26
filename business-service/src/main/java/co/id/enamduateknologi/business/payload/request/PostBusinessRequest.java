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
public class PostBusinessRequest extends BaseRequest {

  /**
   * 
   */
  private static final long serialVersionUID = 6503366541765189720L;

  private BusinessDto business;
}
