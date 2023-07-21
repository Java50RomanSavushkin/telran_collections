package telran.recursion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.recursion.LinearRecursion.displayArray;
import static telran.recursion.LinearRecursion.displayReversedArray;
import static telran.recursion.LinearRecursion.factorial;
import static telran.recursion.LinearRecursion.function;
import static telran.recursion.LinearRecursion.isSubstring;
import static telran.recursion.LinearRecursion.pow;
import static telran.recursion.LinearRecursion.reverseArray;
import static telran.recursion.LinearRecursion.square;
import static telran.recursion.LinearRecursion.sumArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinearRecursionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void functionTest() {
		function(3);
		function(30);
	}

	@Test
	void factorialTest() {
		assertThrowsExactly(IllegalArgumentException.class, () -> factorial(-6));
		assertEquals(6, factorial(3));
		assertEquals(24, factorial(4));
	}

	@Test
	void powTest() {
		assertThrowsExactly(IllegalArgumentException.class, () -> pow(10, -3));
		assertEquals(-1000, pow(-10, 3));
		assertEquals(100, pow(-10, 2));
		assertEquals(1000, pow(10, 3));
	}

	@Test
	void displayArrayTest() {
		System.out.println("\nDiaplaying range [1-5]");
		int ar[] = { 1, 2, 3, 4, 5 };
		displayArray(ar);
	}

	@Test
	void displayArrayReverseTest() {
		System.out.println("\nDiaplaying reversed range [1-5]");
		int ar[] = { 1, 2, 3, 4, 5 };
		displayReversedArray(ar);
	}

	@Test
	void sumArrayTest() {
		int ar[] = { 1, 2, 3, 4, 5 };
		assertEquals(15, sumArray(ar));
	}

	@Test
	void reverseArrayTest() {
		int ar[] = { 1, 2, 3, 4, 5 };
		int expected[] = { 5, 4, 3, 2, 1 };
		reverseArray(ar);
		assertArrayEquals(expected, ar);
	}

	@Test
	void squareTest() {
		assertEquals(100, square(10));
		assertEquals(100, square(-10));
	}

	@Test
	void isSubstringTest() {
		String str = "blobloblobloblokbloblo.";
		assertTrue(isSubstring(str, "blok"));
		assertTrue(isSubstring(str, "kblob"));
		assertTrue(isSubstring(str, "oblo."));
		assertFalse(isSubstring(str, "blod"));
		assertFalse(isSubstring(str, "bok"));
		assertFalse(isSubstring(str, "loko"));
	}

}
