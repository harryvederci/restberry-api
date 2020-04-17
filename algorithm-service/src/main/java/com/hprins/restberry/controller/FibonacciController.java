package com.hprins.restberry.controller;

import com.hprins.restberry.calculator.FibonacciCalculator;
import com.hprins.restberry.dto.FibonacciDto;
import com.hprins.restberry.service.FibonacciService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/fibonacci", produces = MediaType.APPLICATION_JSON_VALUE)
public class FibonacciController {
  private final FibonacciService fibonacciService = new FibonacciService(new FibonacciCalculator());

  @GetMapping(value = "/{maximumCandidate}")
  public ResponseEntity<FibonacciDto> getFibonacciNumbers(@PathVariable int maximumCandidate) {
    return ResponseEntity.ok(this.fibonacciService.getFibonacciNumbersUpToIncluding(maximumCandidate));
  }

  @GetMapping(value = "/is-fib/{number}")
  public ResponseEntity<Boolean> checkIfPrime(@PathVariable int number) {
    return ResponseEntity.ok(this.fibonacciService.checkIfFibonacciNumber(number));
  }
}
