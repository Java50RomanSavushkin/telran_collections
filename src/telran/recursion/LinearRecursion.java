package telran.recursion;

public class LinearRecursion {
	public static void function(int a) {
		if (a > 3) {
			function(a - 1);
		}
	}

	public static long factorial(int n) {
		long res = 1;
		if (n < 0) {
			throw new IllegalArgumentException("factorial exists only for positive numbers and 0");
		}
		if (n > 0) {
			res = n * factorial(n - 1);
		}
		return res;
	}

	public static long pow(int a, int b) {
		long res = 1;
		if (b < 0) {
			throw new IllegalArgumentException("degree cannot be a negative");
		}
		if (b > 0) {
			// res = a * pow(a, b - 1);
			res = multiply(a, pow(a, b - 1));
		}
		return res;
	}

	public static int multiply(int a, long b) {
		if (a == 0 || b == 0) {
			return 0;
		}
		boolean negativeResult = false;
		if (a < 0 && b < 0) {
			a = -a;
			b = -b;
		} else if (a < 0) {
			a = -a;
			negativeResult = true;
		} else if (b < 0) {
			b = -b;
			negativeResult = true;
		}
		int result = a + multiply(a, b - 1);
		if (negativeResult) {
			result = -result;
		}
		return result;
	}

	public static void displayArray(int[] ar) {
		displayArray(0, ar, false);
	}

	private static void displayArray(int index, int[] ar, boolean isReverse) {
		if (index < ar.length) {
			if (isReverse) {
				displayArray(index + 1, ar, isReverse);
				System.out.print(ar[index] + " ");
			} else {
				System.out.print(ar[index] + " ");
				displayArray(index + 1, ar, isReverse);
			}
		}
	}

	public static void displayReversedArray(int[] ar) {
		displayArray(0, ar, true);
	}

	public static long sumArray(int[] array) {
		return sumArray(0, array);
	}

	private static long sumArray(int index, int[] array) {
		long res = 0;
		if (index < array.length) {
			res = array[index] + sumArray(index + 1, array);
		}
		return res;
	}

	public static void reverseArray(int[] array) {
		reverseArray(0, array, array.length - 1);
	}

	private static void reverseArray(int left, int[] array, int right) {
		if (left < right) {
			int tmp = array[left];
			array[left] = array[right];
			array[right] = tmp;
			reverseArray(left + 1, array, right - 1);
		}

	}

	public static int square(int x) {
		if (x == 0) {
			return 0;
		} else if (x < 0) {
			x = -x;
		}
		return x + square(x - 1) + x - 1;
	}

	public static boolean isSubstring(String string, String substr) {
		return isSubstring(string, substr, 0, 0);
	}

	private static boolean isSubstring(String string, String substr, int strIndex, int substrIndex) {
		int strLength = string.length();
		int substrLength = substr.length();
		if (substrIndex == substrLength) {
			return true;
		}
		if (strIndex == strLength) {
			return false;
		}
		char stringChar = string.charAt(strIndex);
		char substrChar = substr.charAt(substrIndex);
		if (stringChar == substrChar) {
			return isSubstring(string, substr, strIndex + 1, substrIndex + 1);
		} else {
			return isSubstring(string, substr, strIndex + 1, 0);
		}
	}

}