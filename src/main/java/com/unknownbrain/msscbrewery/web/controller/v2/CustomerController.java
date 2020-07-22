package com.unknownbrain.msscbrewery.web.controller.v2;

import com.unknownbrain.msscbrewery.services.v2.CustomerServiceV2;
import com.unknownbrain.msscbrewery.web.model.v2.CustomerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v2/customer")
@RestController
public class CustomerController {

    private final CustomerServiceV2 customerServiceV2;

    public CustomerController(CustomerServiceV2 customerServiceV2) {
        this.customerServiceV2 = customerServiceV2;
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDtoV2 getCustomer(@PathVariable UUID customerId) {

        return customerServiceV2.getCustomerById(customerId);
    }

    @PostMapping
    public ResponseEntity<Void> handlePost(CustomerDtoV2 customerDtoV2) {
        CustomerDtoV2 savedDto = customerServiceV2.saveNewCustomer(customerDtoV2);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/customer/" + savedDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("customerId") UUID customerId, CustomerDtoV2 customerDtoV2) {
        customerServiceV2.updateCustomer(customerId, customerDtoV2);
    }

    @DeleteMapping("/{customerId}")
    public void deleteById(@PathVariable("customerId") UUID customerId) {
        customerServiceV2.deleteById(customerId);
    }
}
