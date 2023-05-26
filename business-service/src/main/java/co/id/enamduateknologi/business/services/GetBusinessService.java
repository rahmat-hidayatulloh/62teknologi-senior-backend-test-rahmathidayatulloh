package co.id.enamduateknologi.business.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import co.id.enamduateknologi.business.common.service.BaseService;
import co.id.enamduateknologi.business.model.BusinessEntity;
import co.id.enamduateknologi.business.payload.request.GetBusinessRequest;
import co.id.enamduateknologi.business.payload.response.GetBusinessResponse;
import co.id.enamduateknologi.business.repo.BusinessRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class GetBusinessService implements BaseService<GetBusinessRequest, GetBusinessResponse> {

  private static final Logger log = LoggerFactory.getLogger(GetBusinessService.class);
 
  private final BusinessRepository businessRepository;

  @Override
  public GetBusinessResponse execute(GetBusinessRequest input) {

    List<BusinessEntity> businesses = businessRepository.searchBusiness(
        input.getCategories(), 
        input.getLatitude(),
        input.getLongitude(),
        input.getLimit(),
        input.getSortBy(),
        input.getOpenedAt(),
        input.getClosedAt()
        );
    
    log.debug("List elements: {}", businesses);
    return null;
  }
}
