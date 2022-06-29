package org.mafideju.ISBNValidator.validators;

import org.junit.jupiter.api.Test;
import org.mafideju.ISBNValidator.validators.ValidateISBN;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IsbnValidatorApplicationTests {

	@Test
	void checkValidISBNFor10Digits() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("1614277060");

		assertNotNull(result);
		assertTrue(result);
	}

	@Test
	void checkValidISBNFor13Digits() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853267338");

		assertNotNull(result);
		assertTrue(result);
	}

	@Test
	void checkInvalid10DigitsISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("0226359949");

		assertNotNull(result);
		assertFalse(result);
	}

	@Test
	void checkInvalid13DigitsISBN() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("9781853267336");

		assertNotNull(result);
		assertFalse(result);
	}

	@Test
	void checkValidISBNWithX() {
		ValidateISBN validator = new ValidateISBN();
		boolean result = validator.checkISBN("012000030X");

		assertNotNull(result);
		assertTrue(result);
	}

	@Test
	void checkISBNLength() {
		ValidateISBN validator = new ValidateISBN();

		assertThrows(NumberFormatException.class, () -> {
			validator.checkISBN("123456789");
		});
	}

	@Test
	void checkIfIsNumberISBN() {
		ValidateISBN validator = new ValidateISBN();

		Exception exception = assertThrows(NumberFormatException.class, () -> {
			validator.checkISBN("helloworld");
		});
	}
}
