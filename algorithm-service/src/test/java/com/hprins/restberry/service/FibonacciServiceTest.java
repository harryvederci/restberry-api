package com.hprins.restberry.service;

import com.hprins.restberry.calculator.FibonacciCalculator;
import com.hprins.restberry.dto.FibonacciDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FibonacciServiceTest {

  @Mock
  FibonacciCalculator fibonacciCalculatorMock;

  FibonacciService fibonacciService;

  @Before
  public void setup() {
    this.fibonacciService = new FibonacciService(fibonacciCalculatorMock);
  }

  @Test
  public void getFibonacciNumbersUpToIncludingShouldDelegateToFibonacciCalculator() {
    this.fibonacciService.getFibonacciNumbersUpToIncluding(10);

    verify(fibonacciCalculatorMock, times(1)).getAllUpToIncluding(10);
  }

  @Test
  public void getFibonacciNumbersUpToIncludingShouldMapResponseFromCalculatorToDto() {
    List<Integer> fakeFibonacciNumbers = Arrays.asList(-9000, 20, 25);
    when(fibonacciCalculatorMock.getAllUpToIncluding(10)).thenReturn(fakeFibonacciNumbers);

    FibonacciDto expectedResult = new FibonacciDto(10, fakeFibonacciNumbers);

    assertEquals(expectedResult, fibonacciService.getFibonacciNumbersUpToIncluding(10));
  }

  @Test
  public void checkIfFibonacciNumberShouldDelegateToFibonacciCalculator() {
    this.fibonacciService.checkIfFibonacciNumber(10);

    verify(fibonacciCalculatorMock, times(1)).isMatch(10);
  }
}
