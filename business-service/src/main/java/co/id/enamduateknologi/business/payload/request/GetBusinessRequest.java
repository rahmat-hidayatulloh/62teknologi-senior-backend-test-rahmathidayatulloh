package co.id.enamduateknologi.business.payload.request;

import java.sql.Time;
import java.util.List;
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

  private List<String> categories;

  private Double latitude;

  private Double longitude;

  private int limit;

  private String sortBy;

  private Time openedAt;

  private Time closedAt;

}
