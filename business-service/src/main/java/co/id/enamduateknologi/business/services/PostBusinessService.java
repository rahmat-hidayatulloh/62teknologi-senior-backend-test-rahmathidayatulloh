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
import co.id.enamduateknologi.business.payload.request.PostBusinessRequest;
import co.id.enamduateknologi.business.payload.response.PostBusinessResponse;
import co.id.enamduateknologi.business.repo.BusinessCategoryRelationshipRepository;
import co.id.enamduateknologi.business.repo.BusinessCategoryRepository;
import co.id.enamduateknologi.business.repo.BusinessRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostBusinessService implements BaseService<PostBusinessRequest, PostBusinessResponse> {

  private final BusinessCategoryRepository businessCategoryRepository;
  private final BusinessRepository businessRepository;
  private final BusinessCategoryRelationshipRepository businessCategoryRelationshipRepository;

  @Override
  public PostBusinessResponse execute(PostBusinessRequest input) {

    
    BusinessEntity business =  mapBusinessData(input.getBusiness());
    

    return new PostBusinessResponse();
  }

  private BusinessEntity mapBusinessData(BusinessDto businessDto) {

    BusinessEntity business = storeBusinessData(businessDto);
    business.setCreatedAt(new Timestamp(System.currentTimeMillis()));

    if (checkingCategory(businessDto.getCategories())) {

      storeCategoryRelationship(business, businessDto.getCategories());
    }

    return business;
  }

  private BusinessEntity storeBusinessData(BusinessDto businessDto) {

    return businessRepository.save(BusinessEntity.builder()
        .alias(businessDto.getAlias())
        .distance(businessDto.getDistance())
        .imageUrl(businessDto.getImageUrl())
        .location(businessLocationPlace(businessDto.getLocation(),businessDto.getCoordinates()))
        .name(businessDto.getName())
        .phone(businessDto.getPhone())
        .price(businessDto.getPrice())
        .rating(businessDto.getRating())
        .reviewCount(businessDto.getReviewCount())
        .build()
        );
  }

 

  private List<BusinessLocationEntity> businessLocationPlace(LocationDto location, CoordinatesDto coordinatesDto) {
    // TODO Auto-generated method stub
    return Arrays.asList(BusinessLocationEntity.builder()
        .address1(location.getAddress1())
        .address2(location.getAddress2())
        .address3(location.getAddress3())
        .city(location.getCity())
        .country(location.getCountry())
        .state(location.getState())
        .zipCode(location.getZipCode())
        .latitude(coordinatesDto.getLatitude())
        .longitude(coordinatesDto.getLongitude())
        .build()
        );
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
