package co.id.enamduateknologi.business.services;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import co.id.enamduateknologi.business.common.service.BaseService;
import co.id.enamduateknologi.business.model.BusinessEntity;
import co.id.enamduateknologi.business.model.BusinessLocationEntity;
import co.id.enamduateknologi.business.payload.dto.BusinessDto;
import co.id.enamduateknologi.business.payload.dto.CategoryDto;
import co.id.enamduateknologi.business.payload.dto.CoordinatesDto;
import co.id.enamduateknologi.business.payload.dto.LocationDto;
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

    List<BusinessEntity> businesses = businessRepository.searchBusiness(input.getCategories(),
        input.getLatitude(), input.getLongitude(), input.getLimit(), input.getSortBy(),
        input.getOpenedAt(), input.getClosedAt());

    log.debug("List elements: {}", businesses);


    return mapToBusinessResponse(businesses);
  }

  private GetBusinessResponse mapToBusinessResponse(List<BusinessEntity> businesses) {
    // TODO Auto-generated method stub
    return GetBusinessResponse.builder().businesses(mapBusinessList(businesses))
        .total(businesses.size()).build();
  }

  private List<BusinessDto> mapBusinessList(List<BusinessEntity> businesses) {

    List<BusinessDto> businessDtoList = new ArrayList<>();
    for (BusinessEntity business : businesses) {

      BusinessLocationEntity location = mapLocation(business.getBusinessId());
      
      businessDtoList.add(BusinessDto.builder().alias(business.getAlias())
          .categories(mapCategoryList(business.getBusinessId()))
          .coordinates(new CoordinatesDto(
              location.getLatitude(),
              location.getLongitude()))
          .displayPhone(null)
          .distance(business.getDistance())
          .imageUrl(business.getImageUrl())
          .openAt(business.getOpenAt())
          .closedAt(business.getClosedAt())
          .location(mapLocationDto(location))
          .build());
    }

    return null;
  }


  private LocationDto mapLocationDto(BusinessLocationEntity location) {
    // TODO Auto-generated method stub
    return null;
  }

  private BusinessLocationEntity mapLocation(String businessId) {
    // TODO Auto-generated method stub
    return null;
  }

  private List<CategoryDto> mapCategoryList(String businessId) {
    // TODO Auto-generated method stub
    return null;
  }
}
