package com.hprins.restberry.service;

import com.hprins.restberry.calculator.FibonacciCalculator;
import com.hprins.restberry.dto.FibonacciDto;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FibonacciService {
  private FibonacciCalculator fibonacciCalculator;

  public FibonacciDto getFibonacciNumbersUpToIncluding(int maximumCandidate) {
    List<Integer> primeNumbers = this.fibonacciCalculator.getAllUpToIncluding(maximumCandidate);

    return new FibonacciDto(maximumCandidate, primeNumbers);
  }

  public boolean checkIfFibonacciNumber(int number) {
    return this.fibonacciCalculator.isMatch(number);
  }
}
