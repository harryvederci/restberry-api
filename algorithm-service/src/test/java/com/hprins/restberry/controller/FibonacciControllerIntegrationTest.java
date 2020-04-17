package com.hprins.restberry.controller;

import com.hprins.restberry.dto.FibonacciDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FibonacciControllerIntegrationTest {

  private static final String FIBONACCI_ENDPOINT = "/fibonacci";
  private static final String CHECK_IF_FIBONACCI_ENDPOINT = FIBONACCI_ENDPOINT + "/is-fib";

  @Autowired
  private TestRestTemplate template;

  @Test
  public void getPrimesShouldReturnDtoWithCorrectContentForLowInputValue() {
    final int input = 10;
    final String url = FIBONACCI_ENDPOINT + "/" + input;
    final List<Integer> expectedResult = Arrays.asList(0, 1, 1, 2, 3, 5, 8);

    final ResponseEntity<FibonacciDto> entity = template.getForEntity(url, FibonacciDto.class);

    final FibonacciDto fibonacciDto = entity.getBody();

    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertNotNull(fibonacciDto);
    assertEquals(input, fibonacciDto.getInputParameter());
    assertEquals(expectedResult, fibonacciDto.getResult());
  }

  @Test
  public void checkIfFibonacciShouldReturnTrueIfInputIsFibonacciNumber() {
    final int input = 8;
    final String url = CHECK_IF_FIBONACCI_ENDPOINT + "/" + input;

    final ResponseEntity<Boolean> entity = template.getForEntity(url, Boolean.class);

    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(true, entity.getBody());
  }

  @Test
  public void checkIfFibonacciShouldReturnFalseIfInputNumberIsNotAFibonacciNumber() {
    final int input = 10;
    final String url = CHECK_IF_FIBONACCI_ENDPOINT + "/" + input;

    final ResponseEntity<Boolean> entity = template.getForEntity(url, Boolean.class);

    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(false, entity.getBody());
  }
}
