package co.id.enamduateknologi.business.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.id.enamduateknologi.business.model.BusinessCategoryRelationshipEntity;
import co.id.enamduateknologi.business.model.BusinessEntity;
import co.id.enamduateknologi.business.model.embedded.BusinessCategoryEmbedded;

@Repository
public interface BusinessCategoryRelationshipRepository
    extends JpaRepository<BusinessCategoryRelationshipEntity, BusinessCategoryEmbedded> {

  List<BusinessCategoryRelationshipEntity> findAllByBusiness(BusinessEntity business);

}
