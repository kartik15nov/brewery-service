package com.unknownbrain.msscbrewery.services.v2;

import com.unknownbrain.msscbrewery.web.model.v2.CustomerDtoV2;

import java.util.UUID;

public interface CustomerServiceV2 {
    CustomerDtoV2 getCustomerById(UUID customerId);

    CustomerDtoV2 saveNewCustomer(CustomerDtoV2 customerDtoV2);

    void updateCustomer(UUID customerId, CustomerDtoV2 customerDtoV2);

    void deleteById(UUID customerId);
}
