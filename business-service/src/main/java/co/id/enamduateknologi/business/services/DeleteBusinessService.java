package co.id.enamduateknologi.business.services;

import java.util.List;
import org.springframework.stereotype.Service;
import co.id.enamduateknologi.business.common.service.BaseService;
import co.id.enamduateknologi.business.model.BusinessCategoryRelationshipEntity;
import co.id.enamduateknologi.business.model.BusinessEntity;
import co.id.enamduateknologi.business.payload.request.DeleteBusinessRequest;
import co.id.enamduateknologi.business.payload.response.DeleteBusinessResponse;
import co.id.enamduateknologi.business.repo.BusinessCategoryRelationshipRepository;
import co.id.enamduateknologi.business.repo.BusinessRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteBusinessService
    implements BaseService<DeleteBusinessRequest, DeleteBusinessResponse> {

  private final BusinessRepository businessRepository;
  private final BusinessCategoryRelationshipRepository businessCategoryRelationshipRepository;

  @Override
  public DeleteBusinessResponse execute(DeleteBusinessRequest input) {

    BusinessEntity business = businessRepository.findById(input.getBusinessId()).get();
    removeCompositeKey(business);
    businessRepository.delete(business);

    return DeleteBusinessResponse.builder().build();
  }

  private void removeCompositeKey(BusinessEntity business) {

    List<BusinessCategoryRelationshipEntity> businessCategoryRelationships =
        businessCategoryRelationshipRepository.findAllByBusiness(business);

    for (BusinessCategoryRelationshipEntity businessCategoryRelationship : businessCategoryRelationships) {
      businessCategoryRelationshipRepository.delete(businessCategoryRelationship);
    }
  }

}
