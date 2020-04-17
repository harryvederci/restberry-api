package com.hprins.restberry.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FibonacciCalculatorTest {

  FibonacciCalculator fibonacciCalculator;

  @Before
  public void setup() {
    this.fibonacciCalculator = new FibonacciCalculator();
  }

  @Test
  public void getAllUpToIncludingShouldGiveCorrectAnswerWithSmallInputNumber() {
    List<Integer> expectedResult = Arrays.asList(0, 1, 1, 2, 3, 5, 8);

    List<Integer> result = this.fibonacciCalculator.getAllUpToIncluding(10);

    assertEquals(expectedResult, result);
  }

  @Test
  public void getAllUpToIncludingShouldGiveCorrectAnswerWithSlightlyLargerInputNumber() {
    List<Integer> expectedResult = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584);

    List<Integer> result = this.fibonacciCalculator.getAllUpToIncluding(3000);

    assertEquals(expectedResult, result);
  }

  @Test
  public void getAllUpToIncludingShouldUseCacheIfPreviouslyCalculated() {
    // TODO
  }
}
