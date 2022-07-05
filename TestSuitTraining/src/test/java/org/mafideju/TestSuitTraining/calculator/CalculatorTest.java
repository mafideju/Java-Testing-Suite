package org.mafideju.TestSuitTraining.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

  Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void integerSum() {
    int expected = 5;
    int unexpected = 6;
    int actual = calculator.integerSum(3, 2);

    assertEquals(expected, actual);
    assertNotEquals(unexpected, actual);
    assertNotNull(actual);
  }

  @Test
  void integerSubtraction() {
    int expected = 5;
    int actual = calculator.integerSubtraction(10, 5);
    assertEquals(expected, actual);
  }

  @Test
  void integerMultiplication() {
    int calc = calculator.integerMultiplication(10, 5);
    assertEquals(50, calc);
  }

  @Test
  void integerDivision() {
    int calc = calculator.integerDivision(4, 2);
    assertEquals(2, calc);
  }

  @Test
  void doubleSum() {
    double calc = calculator.doubleSum(3.2, 2.5);
    assertEquals(5.7, calc);
  }

  @Test
  void throwExceptionWhenDividesByZero() {
    AtomicInteger divisionByZero = new AtomicInteger();

    assertThrows(ArithmeticException.class, () -> {
      divisionByZero.set(calculator.integerDivision(5, 0));
    });

    assertEquals(divisionByZero.get(), 0);
  }
}
