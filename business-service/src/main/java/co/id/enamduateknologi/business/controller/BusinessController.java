package co.id.enamduateknologi.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.id.enamduateknologi.business.model.request.DeleteBusinessRequest;
import co.id.enamduateknologi.business.model.request.GetBusinessRequest;
import co.id.enamduateknologi.business.model.request.PostBusinessRequest;
import co.id.enamduateknologi.business.model.request.PutBusinessRequest;
import co.id.enamduateknologi.business.model.response.DeleteBusinessResponse;
import co.id.enamduateknologi.business.model.response.GetBusinessResponse;
import co.id.enamduateknologi.business.model.response.PostBusinessResponse;
import co.id.enamduateknologi.business.model.response.PutBusinessResponse;
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


  public PostBusinessResponse postBusiness(@RequestBody PostBusinessRequest request) {

    return postBusinessService.execute(request);
  }

  public PutBusinessResponse putBusiness(PutBusinessRequest request) {

    return putBusinessService.execute(request);
  }

  public DeleteBusinessResponse deleteBusiness(DeleteBusinessRequest request) {

    return deleteBusinessService.execute(request);
  }

  @GetMapping("/search")
  public GetBusinessResponse getBusinessSearch(GetBusinessRequest request) {
    
    return getBusinessService.execute(request);
  }


}
