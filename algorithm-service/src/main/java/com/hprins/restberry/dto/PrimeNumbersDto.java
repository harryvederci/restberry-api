package com.hprins.restberry.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class PrimeNumbersDto {

  @JsonProperty("Initial")
  private final int inputParameter;

  @JsonProperty("Primes")
  private final List<Integer> result;
}
