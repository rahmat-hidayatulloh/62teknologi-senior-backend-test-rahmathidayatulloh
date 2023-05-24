package co.id.enamduateknologi.business.common.base;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseRequest implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = -6083326463024228459L;

}
