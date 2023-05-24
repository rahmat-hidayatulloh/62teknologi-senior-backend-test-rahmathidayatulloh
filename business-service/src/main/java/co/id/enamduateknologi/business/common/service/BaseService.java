package co.id.enamduateknologi.business.common.service;

import co.id.enamduateknologi.business.common.base.BaseRequest;
import co.id.enamduateknologi.business.common.base.BaseResponse;

public interface BaseService<T extends BaseRequest, V extends BaseResponse> {

  V execute(T input);
}
