package com.hprins.restberry.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PrimeNumberCalculatorTest {

  PrimeNumberCalculator primeNumberCalculator;

  @Before
  public void setup() {
    this.primeNumberCalculator = new PrimeNumberCalculator();
  }

  @Test
  public void getAllUpToIncludingShouldGiveCorrectAnswerWithSmallInputNumber() {
    List<Integer> expectedResult = Arrays.asList(2, 3, 5, 7);

    List<Integer> result = this.primeNumberCalculator.getAllUpToIncluding(10);

    assertEquals(expectedResult, result);
  }

  @Test
  public void getAllUpToIncludingShouldGiveCorrectAnswerWithMediumInputNumber() {
    List<Integer> result = this.primeNumberCalculator.getAllUpToIncluding(11_027);

    assertEquals(1337, result.size());
  }

  @Test
  public void getAllUpToIncludingShouldUseCacheIfPreviouslyCalculated() {
    // TODO
  }
}
