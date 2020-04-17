package com.hprins.restberry.controller;

import com.hprins.restberry.calculator.PrimeNumberCalculator;
import com.hprins.restberry.dto.PrimeNumbersDto;
import com.hprins.restberry.service.PrimeNumberService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/primes", produces = MediaType.APPLICATION_JSON_VALUE)
public class PrimeNumberController {
  private final PrimeNumberService primeNumberService = new PrimeNumberService(new PrimeNumberCalculator());

  @GetMapping(value = "/{maxNumberToCalculate}")
  public ResponseEntity<PrimeNumbersDto> getPrimeNumbers(@PathVariable int maxNumberToCalculate) {
    return ResponseEntity.ok(this.primeNumberService.getPrimeNumbersUpToIncluding(maxNumberToCalculate));
  }

  @GetMapping(value = "/is-prime/{number}")
  public ResponseEntity<Boolean> checkIfPrime(@PathVariable int number) {
    return ResponseEntity.ok(this.primeNumberService.checkIfPrimeNumber(number));
  }
}
