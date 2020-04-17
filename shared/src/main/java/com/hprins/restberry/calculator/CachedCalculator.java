package com.hprins.restberry.calculator;

import lombok.Getter;

import java.util.Collection;
import java.util.List;

public abstract class CachedCalculator<T> {
  @Getter
  Collection<T> cache;

  public abstract boolean isMatch(T item);

  public abstract List<T> getAllUpToIncluding(T maximum);
}
