package com.unknownbrain.msscbrewery.web.mappers;

import com.unknownbrain.msscbrewery.domain.Beer;
import com.unknownbrain.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
