package com.hprins.restberry.calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PrimeNumberCalculator extends CachedCalculator<Integer> {
  public PrimeNumberCalculator() {
    this.cache = new HashSet<>();
    this.cache.add(FIRST_PRIME_NUMBER);
  }

  private static final int FIRST_PRIME_NUMBER = 2;

  private int calculateIfGTE = FIRST_PRIME_NUMBER;

  /**
   * Checks if a given number is a prime number
   * @param number the number to check
   * @return whether or not the input number is a prime number
   */
  @Override
  public boolean isMatch(Integer number) {
    if (number <= Collections.max(cache)) {
      return cache.contains(number);
    } else {
      return isPrime(number);
    }
  }

  /**
   * Get a list of prime numbers, given a maximum number to calculate
   * @param maximumNumberToCalculate the maximum number to include in the result, if it is a prime number
   * @return a list of prime numbers in the range from 0 up to (including) the value that the method was called with.
   */
  @Override
  public List<Integer> getAllUpToIncluding(Integer maximumNumberToCalculate) {
    if (maximumNumberToCalculate <= this.calculateIfGTE) {
      return this.cache
        .stream()
        .filter(number -> number <= maximumNumberToCalculate)
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());
    }

    List<Integer> primeNumbers = new ArrayList<>();

    for (int index = this.calculateIfGTE; index <= maximumNumberToCalculate; index++) {
      if (isPrime(index)) {
        primeNumbers.add(index);
      }
    }

    this.cache.addAll(primeNumbers);
    this.calculateIfGTE = maximumNumberToCalculate;

    List<Integer> result = new ArrayList<>(this.cache);
    result.sort(Comparator.naturalOrder());

    return result;
  }

  /**
   * Checks if a given number is a prime number
   * @param number the number that may or may not be a prime number
   * @return true if the number is a prime number, false if it is not
   */
  private static boolean isPrime(int number) {
    for (int index = FIRST_PRIME_NUMBER; index <= Math.sqrt(number); index++) {
      if (number % index == 0) {
        return false;
      }
    }

    return true;
  }
}
