package co.id.enamduateknologi.business.services;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import co.id.enamduateknologi.business.common.service.BaseService;
import co.id.enamduateknologi.business.model.BusinessCategoryEntity;
import co.id.enamduateknologi.business.model.BusinessCategoryRelationshipEntity;
import co.id.enamduateknologi.business.model.BusinessEntity;
import co.id.enamduateknologi.business.model.BusinessLocationEntity;
import co.id.enamduateknologi.business.payload.dto.BusinessDto;
import co.id.enamduateknologi.business.payload.dto.CategoryDto;
import co.id.enamduateknologi.business.payload.dto.CoordinatesDto;
import co.id.enamduateknologi.business.payload.dto.LocationDto;
import co.id.enamduateknologi.business.payload.request.PutBusinessRequest;
import co.id.enamduateknologi.business.payload.response.PutBusinessResponse;
import co.id.enamduateknologi.business.repo.BusinessCategoryRelationshipRepository;
import co.id.enamduateknologi.business.repo.BusinessCategoryRepository;
import co.id.enamduateknologi.business.repo.BusinessRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PutBusinessService implements BaseService<PutBusinessRequest, PutBusinessResponse> {

  private final BusinessCategoryRepository businessCategoryRepository;
  private final BusinessRepository businessRepository;
  private final BusinessCategoryRelationshipRepository businessCategoryRelationshipRepository;


  @Override
  public PutBusinessResponse execute(PutBusinessRequest input) {

    BusinessEntity business = businessRepository.findById(input.getBusinessId()).get();
   
    mapBusinessData(business,input.getBusiness());

    return PutBusinessResponse.builder().build();
  }

  private BusinessEntity mapBusinessData(BusinessEntity business, BusinessDto businessDto) {

    business = storeBusinessData(business, businessDto);
    business.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

    if (checkingCategory(businessDto.getCategories())) {
      storeCategoryRelationship(business, businessDto.getCategories());
    }
    return business;
  }

  private BusinessEntity storeBusinessData(BusinessEntity business, BusinessDto businessDto) {
    
    business.setAlias(businessDto.getAlias());
    business.setDistance(businessDto.getDistance());
    business.setImageUrl(businessDto.getImageUrl());
    business.setLocation(businessLocationPlace(businessDto.getLocation(), businessDto.getCoordinates()));
    business.setName(businessDto.getName());
    business.setPhone(businessDto.getPhone());
    business.setPrice(businessDto.getPrice());
    business.setRating(businessDto.getRating());
    business.setReviewCount(businessDto.getReviewCount());
    
    return businessRepository.save(business);
  }



  private List<BusinessLocationEntity> businessLocationPlace(LocationDto location,
      CoordinatesDto coordinatesDto) {
    // TODO Auto-generated method stub
    return Arrays.asList(BusinessLocationEntity.builder().address1(location.getAddress1())
        .address2(location.getAddress2()).address3(location.getAddress3()).city(location.getCity())
        .country(location.getCountry()).state(location.getState()).zipCode(location.getZipCode())
        .latitude(coordinatesDto.getLatitude()).longitude(coordinatesDto.getLongitude()).build());
  }

  private boolean checkingCategory(List<CategoryDto> categories) {

    for (CategoryDto category : categories) {
      return businessCategoryRepository.existsByTitle(category.getTitle());
    }
    return true;
  }

  private void storeCategoryRelationship(BusinessEntity business, List<CategoryDto> categories) {

    for (CategoryDto categoryDto : categories) {

      Optional<BusinessCategoryEntity> categoryEntity =
          businessCategoryRepository.findByTitle(categoryDto.getTitle());

      if (!ObjectUtils.isEmpty(categoryEntity)) {
        businessCategoryRelationshipRepository
            .save(new BusinessCategoryRelationshipEntity(business, categoryEntity.get()));
      }
    }
  }

}
