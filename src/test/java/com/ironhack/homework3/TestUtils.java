package com.ironhack.homework3;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

public class TestUtils {

  public static <T> void resetIdCounter(Class<T> clazz) throws NoSuchFieldException, IllegalAccessException {
    Field field = clazz.getDeclaredField("idCounter");
    field.setAccessible(true);
    field.set(field, new AtomicInteger(0));
  }
}
