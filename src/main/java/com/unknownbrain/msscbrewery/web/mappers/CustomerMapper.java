package com.unknownbrain.msscbrewery.web.mappers;

import com.unknownbrain.msscbrewery.domain.Customer;
import com.unknownbrain.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto customerToCustomerDto(Customer customer);

    Customer customerDtoToCustomer(CustomerDto customerDto);
}
