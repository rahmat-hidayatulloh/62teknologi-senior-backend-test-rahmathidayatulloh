package co.id.enamduateknologi.business.config;

import java.sql.Timestamp;
import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import co.id.enamduateknologi.business.model.BusinessCategoryEntity;
import co.id.enamduateknologi.business.repo.BusinessCategoryRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

  private final BusinessCategoryRepository businessCategoryRepository;

  public void run(ApplicationArguments args) {

    var categories = Arrays.asList(new BusinessCategoryEntity("pizza", "Pizza"),
        new BusinessCategoryEntity("food", "Food"));

    for (BusinessCategoryEntity category : categories) {
      if (!businessCategoryRepository.existsByTitle(category.getTitle())) {
        category.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        businessCategoryRepository.save(category);
      }
    }
  }
}
