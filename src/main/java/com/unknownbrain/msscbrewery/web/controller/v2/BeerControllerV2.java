package com.unknownbrain.msscbrewery.web.controller.v2;

import com.unknownbrain.msscbrewery.services.v2.BeerServiceV2;
import com.unknownbrain.msscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }

    @GetMapping("/{beerId}")
    @ResponseStatus(HttpStatus.OK)
    public BeerDtoV2 getBeerById(@PathVariable UUID beerId) {
        return beerServiceV2.getBeerById(beerId); //TODO
    }

    @PostMapping
    public ResponseEntity<Void> saveNewBeer(@Valid @RequestBody BeerDtoV2 beerDtoV2) {
        BeerDtoV2 savedBeerDto = beerServiceV2.saveNewBeer(beerDtoV2);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v2/beer/" + savedBeerDto.getId().toString());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeerById(@PathVariable UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtoV2) {
        beerServiceV2.updateBeer(beerId, beerDtoV2);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerServiceV2.deleteById(beerId);
    }

}
