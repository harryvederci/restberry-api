package com.hprins.restberry.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciCalculator extends CachedCalculator<Integer> {
  public FibonacciCalculator() {
    this.cache = new ArrayList<>();
    this.cache.addAll(FIRST_FIBONACCI_NUMBERS);
  }

  private static final List<Integer> FIRST_FIBONACCI_NUMBERS = Arrays.asList(0, 1, 1);

  /**
   * Checks if a given number is a fibonacci number
   * @param number the number to check
   * @return whether or not the input number is a fibonacci number
   */
  @Override
  public boolean isMatch(Integer number) {
    if (number <= Collections.max(cache)) {
      return cache.contains(number);
    } else {
      return getAllUpToIncluding(number).contains(number);
    }
  }

  /**
   * Get a list of fibonacci numbers
   * @param maximumCandidate the maximum number to include in the result, if it is a fibonacci number
   * @return a list of fibonacci numbers in the range from 0 up to (including) the value that the method was called with.
   */
  @Override
  public List<Integer> getAllUpToIncluding(Integer maximumCandidate) {
    if (maximumCandidate <= getMaxInCache()) {
      return this.cache
        .stream()
        .filter(number -> number <= maximumCandidate)
        .collect(Collectors.toList());
    }

    while(getMaxInCache() <= maximumCandidate) {
      List<Integer> highestTwoNumbersInCache = getHighestTwoNumbersInCache();
      int numberToAdd = highestTwoNumbersInCache.get(0) + highestTwoNumbersInCache.get(1);

      this.cache.add(numberToAdd);
    }

    return this.cache
      .stream()
      .filter(number -> number <= maximumCandidate)
      .collect(Collectors.toList());
  }

  /**
   * Returns the two cached numbers with the highest values
   * @return two integers: the highest and second highest cached numbers
   */
  private List<Integer> getHighestTwoNumbersInCache() {
    List<Integer> result = new ArrayList<>(this.cache);
    result.sort(Comparator.reverseOrder());

    return result.subList(0, 2);
  }

  /**
   * Returns the highest cached value
   * @return the highest int contained in the cache
   */
  private int getMaxInCache() {
    return Collections.max(this.cache);
  }
}
