package ar.com.tinello.katas.circularprimes;

public class CircularPrimes {

	private static final int ZERO_REST = 0;
	private static final int DIVISIBLE_BY_ONE_AND_ITSELF = 2;

	/**
	 * Algoritmo de Eratóstenes
	 * Fórmula de Fermat
	 * Leonhard Euler
	 * Mersenne
	 * Édouard Lucas
	 */
	public boolean isPrime(int number) {
		if (number == 1) return false;
		if (number == 2) return true;
		if (number % 2 == 0) return false;

		int mitad = (number / 2) + 1;
		for (int x = 3; x < mitad; x=x+2) {
			if ((number % x) == ZERO_REST) {
				return false;
			}
		}
		return true;
	}

	public int circularNumber(int number) {
		int exponent = ("" + number).length() - 1;
		int pow = (int) Math.pow(10, exponent);
		int firtDigit = number / pow;
		int restDigit = number % pow;
		return (restDigit * 10) + firtDigit;
	}

	public boolean isCircularPrimes(int number) {
		if (isPrime(number)) {
			return isCircularPrime(number);
		}
		return false;
	}

	private boolean isCircularPrime(int number) {
		int circular = number;
		boolean isCircularPrimes = true;
		for (int j = 0; j < String.valueOf(number).length() - 1; j++) {
			circular = circularNumber(circular);

			if (!isEqualsSizeNumberAndCircular(number, circular) || !isPrime(circular)) {
				isCircularPrimes = false;
				break;
			}
		}
		return isCircularPrimes;
	}

	private boolean isEqualsSizeNumberAndCircular(int number, int circular) {
		return String.valueOf(circular).length() == String.valueOf(number).length();
	}

	public int countCircularPrimesBelow(int max) {
		int count = 0;
		for (int i = 1; i <= max; i++) {
			if (isCircularPrimes(i))
				count++;
		}
		return count;
	}
}
