package com.hprins.restberry.service;

import com.hprins.restberry.calculator.PrimeNumberCalculator;
import com.hprins.restberry.dto.PrimeNumbersDto;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PrimeNumberService {
  private PrimeNumberCalculator primeNumberCalculator;

  public PrimeNumbersDto getPrimeNumbersUpToIncluding(int maxNumberToCalculate) {
    List<Integer> primeNumbers = this.primeNumberCalculator.getAllUpToIncluding(maxNumberToCalculate);

    return new PrimeNumbersDto(maxNumberToCalculate, primeNumbers);
  }

  public boolean checkIfPrimeNumber(int number) {
    return this.primeNumberCalculator.isMatch(number);
  }
}
