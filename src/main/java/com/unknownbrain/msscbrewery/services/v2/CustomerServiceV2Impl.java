package com.unknownbrain.msscbrewery.services.v2;

import com.unknownbrain.msscbrewery.web.model.v2.CustomerDtoV2;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class CustomerServiceV2Impl implements CustomerServiceV2 {
    @Override
    public CustomerDtoV2 getCustomerById(UUID customerId) {
        return CustomerDtoV2.builder()
                .id(UUID.randomUUID())
                .name("Joe Buck")
                .build();
    }

    @Override
    public CustomerDtoV2 saveNewCustomer(CustomerDtoV2 customerDto) {
        return CustomerDtoV2.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDtoV2 customerDto) {
        log.debug("Updating....");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleting.... ");
    }
}
