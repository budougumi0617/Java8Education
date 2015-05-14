/**
 * @file
 * @par File Name:
 * Ex04.java
 * @author budougumi0617
 * @date Created on 2015/05/14
 */
package main.java.ch8.ex04;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author budougumi0617
 * @note no comment
 */
public class Ex04 {
	public static final BigDecimal m = new BigDecimal("25214903917",
			MathContext.UNLIMITED);
	public static final BigDecimal alpha = new BigDecimal("11", MathContext.UNLIMITED);
	public static final BigDecimal N = new BigDecimal("2", MathContext.UNLIMITED).pow(48);
	public static final BigDecimal ny = new BigDecimal("246154705703781",
			MathContext.UNLIMITED);

	public static BigDecimal next(BigDecimal s) {
		BigDecimal result = s.multiply(m, MathContext.UNLIMITED);
		BigDecimal temp = alpha.remainder(N, MathContext.UNLIMITED);
		return result.add(temp, MathContext.UNLIMITED);
	}

	public static BigDecimal prev(BigDecimal s) {
		BigDecimal result = s.subtract(alpha, MathContext.UNLIMITED);
		result = result.multiply(ny, MathContext.UNLIMITED);
		return result.remainder(N, MathContext.UNLIMITED);
	}

	public static void main(String[] args) {
		System.out.println("next(0) = " + Ex04.next(BigDecimal.ZERO));
		Random generator = new Random(164311266871034L);
		System.out.println("Random(164311266871034L).nextDouble() = "
				+ generator.nextDouble());
		System.out.println("Random(164311266871034L).nextDouble() = "
				+ generator.nextDouble());

		// System.out.println("prev(prev(prev(0)))^m = "
		// +
		// prev(prev(prev(BigDecimal.ZERO))).xor(m));
		// System.out.println("0 = "
		// +
		// prev(prev(prev(BigDecimal.ZERO))).xor(m).subtract(
		// new BigDecimal("164311266871034")));
		Optional<BigDecimal> result = Stream.iterate(BigDecimal.ZERO, f -> prev(f))
				.limit(1_000_000L).min((i, j) -> i.compareTo(j));
		generator = new Random(result.get().toBigInteger().xor(m.toBigInteger())
				.longValue());
		long l = 0;
		// for (long i = 0; i <= 376060; i++) {
		// System.out.println(" i = " + i +
		// " generator.nextDouble() :"
		// + generator.nextDouble());
		// }
		BigDecimal results = BigDecimal.ZERO;
		for (long i = 0; i <= 2; i++) {
			results = prev(results);
		}
		generator = new Random(results.toBigInteger().xor(m.toBigIntegerExact())
				.longValue());
		for (long i = 0; i < 2; i++) {
			System.out.println(" i = " + i + " generator.nextDouble() :"
					+ generator.nextDouble());
		}
		System.out.println("result = " + result.orElse(BigDecimal.TEN).toString()
				+ " count : " + l);

	}
}
