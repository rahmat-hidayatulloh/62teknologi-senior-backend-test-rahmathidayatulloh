package co.id.enamduateknologi.business.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.id.enamduateknologi.business.model.BusinessCategoryEntity;

@Repository
public interface BusinessCategoryRepository extends JpaRepository<BusinessCategoryEntity, String> {

  boolean existsByTitle(String title);
  
  Optional<BusinessCategoryEntity> findByTitle(String title);
}
