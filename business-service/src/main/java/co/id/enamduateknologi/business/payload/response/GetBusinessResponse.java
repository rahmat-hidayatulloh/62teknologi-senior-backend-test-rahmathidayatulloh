package co.id.enamduateknologi.business.payload.response;

import java.util.List;
import co.id.enamduateknologi.business.common.base.BaseResponse;
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
public class GetBusinessResponse extends BaseResponse {

  /**
   * 
   */
  private static final long serialVersionUID = -4717559497761746633L;

  private List<BusinessDto> businesses;

  private int total;
}
