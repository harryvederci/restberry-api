package com.hprins.restberry.service;

import com.hprins.restberry.calculator.PrimeNumberCalculator;
import com.hprins.restberry.dto.PrimeNumbersDto;
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
public class PrimeNumberServiceTest {

  @Mock
  PrimeNumberCalculator primeNumberCalculatorMock;

  PrimeNumberService primeNumberService;

  @Before
  public void setup() {
    this.primeNumberService = new PrimeNumberService(primeNumberCalculatorMock);
  }

  @Test
  public void getPrimeNumbersUpToIncludingShouldDelegateToPrimeNumberCalculator() {
    this.primeNumberService.getPrimeNumbersUpToIncluding(10);

    verify(primeNumberCalculatorMock, times(1)).getAllUpToIncluding(10);
  }

  @Test
  public void getPrimeNumbersUpToIncludingShouldMapResponseFromCalculatorToDto() {
    List<Integer> fakePrimes = Arrays.asList(-9000, 0, 4);
    when(primeNumberCalculatorMock.getAllUpToIncluding(10)).thenReturn(fakePrimes);

    PrimeNumbersDto expectedResult = new PrimeNumbersDto(10, fakePrimes);

    assertEquals(expectedResult, primeNumberService.getPrimeNumbersUpToIncluding(10));
  }

  @Test
  public void checkIfPrimeNumberShouldDelegateToPrimeNumberCalculator() {
    this.primeNumberService.checkIfPrimeNumber(10);

    verify(primeNumberCalculatorMock, times(1)).isMatch(10);
  }
}
