package com.hprins.restberry.controller;

import com.hprins.restberry.dto.PrimeNumbersDto;
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
public class PrimeNumberControllerIntegrationTest {

  private static final String PRIMES_ENDPOINT = "/primes";
  private static final String CHECK_IF_PRIME_ENDPOINT = PRIMES_ENDPOINT + "/is-prime";

  @Autowired
  private TestRestTemplate template;

  @Test
  public void getPrimesShouldReturnDtoWithCorrectContentForLowInputValue() {
    final int input = 10;
    final String url = PRIMES_ENDPOINT + "/" + input;
    final List<Integer> expectedResult = Arrays.asList(2, 3, 5, 7);

    final ResponseEntity<PrimeNumbersDto> entity = template.getForEntity(url, PrimeNumbersDto.class);

    final PrimeNumbersDto primeNumbersDto = entity.getBody();

    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertNotNull(primeNumbersDto);
    assertEquals(input, primeNumbersDto.getInputParameter());
    assertEquals(expectedResult, primeNumbersDto.getResult());
  }

  @Test
  public void checkIfPrimeShouldReturnTrueIfInputNumberIsPrime() {
    final int input = 7;
    final String url = CHECK_IF_PRIME_ENDPOINT + "/" + input;

    final ResponseEntity<Boolean> entity = template.getForEntity(url, Boolean.class);

    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(true, entity.getBody());
  }

  @Test
  public void checkIfPrimeShouldReturnFalseIfInputNumberIsNotPrime() {
    final int input = 10;
    final String url = CHECK_IF_PRIME_ENDPOINT + "/" + input;

    final ResponseEntity<Boolean> entity = template.getForEntity(url, Boolean.class);

    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(false, entity.getBody());
  }
}
