package co.id.enamduateknologi.business.repo;

import java.sql.Time;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import co.id.enamduateknologi.business.model.BusinessEntity;

@Repository
public interface BusinessRepository extends JpaRepository<BusinessEntity, String> {

  
  @Query(value = "SELECT DISTINCT b.* FROM business b " +
      "JOIN business_location l ON b.id = l.business_id " +
      "JOIN business_category bc ON b.id = bc.business_id " +
      "JOIN category c ON bc.category_id = c.id " +
      "WHERE " +
      "(:categories IS NULL OR c.name IN :categories) AND " +
      "(:latitude IS NULL OR l.latitude = :latitude) AND " +
      "(:longitude IS NULL OR l.longitude = :longitude) AND " +
      "(:openedAt IS NULL OR b.opened_at >= :openedAt) AND " +
      "(:closedAt IS NULL OR b.closed_at <= :closedAt) " +
      "ORDER BY " +
      "CASE WHEN :sortBy = 'name' THEN b.name END ASC, " +
      "CASE WHEN :sortBy = 'latitude' THEN l.latitude END ASC, " +
      "CASE WHEN :sortBy = 'longitude' THEN l.longitude END ASC " +
      "LIMIT :limit",
      nativeQuery = true)
  List<BusinessEntity> searchBusiness(
      @Param("categories") List<String> categories, 
      @Param("latitude") Double latitude, 
      @Param("longitude") Double longitude, 
      @Param("limit") int limit,
      @Param("sortBy") String sortBy,
      @Param("openedAt") Time openedAt,
      @Param("closedAt") Time closedAt
      );

}
