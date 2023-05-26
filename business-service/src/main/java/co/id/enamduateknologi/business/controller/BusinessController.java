package co.id.enamduateknologi.business.controller;

import java.sql.Time;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.id.enamduateknologi.business.payload.request.DeleteBusinessRequest;
import co.id.enamduateknologi.business.payload.request.GetBusinessRequest;
import co.id.enamduateknologi.business.payload.request.PostBusinessRequest;
import co.id.enamduateknologi.business.payload.request.PutBusinessRequest;
import co.id.enamduateknologi.business.payload.response.DeleteBusinessResponse;
import co.id.enamduateknologi.business.payload.response.GetBusinessResponse;
import co.id.enamduateknologi.business.payload.response.PostBusinessResponse;
import co.id.enamduateknologi.business.payload.response.PutBusinessResponse;
import co.id.enamduateknologi.business.services.DeleteBusinessService;
import co.id.enamduateknologi.business.services.GetBusinessService;
import co.id.enamduateknologi.business.services.PostBusinessService;
import co.id.enamduateknologi.business.services.PutBusinessService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/business")
@RequiredArgsConstructor
public class BusinessController {

  private final PostBusinessService postBusinessService;

  private final PutBusinessService putBusinessService;

  private final DeleteBusinessService deleteBusinessService;

  private final GetBusinessService getBusinessService;


  @PostMapping
  public PostBusinessResponse postBusiness(@RequestBody PostBusinessRequest request) {

    return postBusinessService.execute(request);
  }

  @PutMapping
  public PutBusinessResponse putBusiness(@RequestBody PutBusinessRequest request) {

    return putBusinessService.execute(request);
  }

  @DeleteMapping
  public DeleteBusinessResponse deleteBusiness(@RequestBody DeleteBusinessRequest request) {

    return deleteBusinessService.execute(request);
  }

  @GetMapping("/search")
  public GetBusinessResponse getBusinessSearch(
      @RequestParam(name = "categories", required = false) List<String> categories,
      @RequestParam(name = "latitude", required = false) Double latitude,
      @RequestParam(name = "longitude", required = false) Double longitude,
      @RequestParam(name = "limit", required = false) Integer limit,
      @RequestParam(name = "sortBy", required = false) String sortBy,
      @RequestParam(name = "opened_at", required = false) Time openedAt,
      @RequestParam(name = "closed_at", required = false) Time closedAt ) {

    return getBusinessService.execute(GetBusinessRequest.builder()
        .categories(categories)
        .latitude(latitude)
        .longitude(longitude)
        .limit(limit)
        .sortBy(sortBy)
        .openedAt(openedAt)
        .closedAt(closedAt)
        .build()
        );
  }


}
