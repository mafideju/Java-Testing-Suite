package org.mafideju.TestSuitTraining.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

  Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  void integerSum() {
    int calc = calculator.integerSum(3, 2);

    assertEquals(5, calc);
  }

  @Test
  void integerSubtraction() {
    int calc = calculator.integerSubtraction(10, 5);

    assertEquals(5, calc);
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
}
