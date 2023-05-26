package co.id.enamduateknologi.business.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.id.enamduateknologi.business.model.BusinessEntity;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessEntity, String> {

}
