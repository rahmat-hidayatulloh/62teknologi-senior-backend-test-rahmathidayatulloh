package co.id.enamduateknologi.business.common.base;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -3780265699308396368L;

}
