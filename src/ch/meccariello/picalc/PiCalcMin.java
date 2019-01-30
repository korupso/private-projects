package ch.meccariello.picalc;

import java.math.*;
import java.util.stream.IntStream;

public class PiCalcMin {

	static BigDecimal sum = new BigDecimal(0);
	static BigDecimal nfac = new BigDecimal(1);

	public static void main(String[] args) {
		IntStream.range(0, nfac.intValue()).forEach(i -> nfac.multiply(nfac.subtract(new BigDecimal(i))));
		IntStream.range(0, 100).forEach(n -> sum.add(new BigDecimal(720).multiply(new BigDecimal(-1).pow(n)).multiply(new BigDecimal(545140134).multiply(new BigDecimal(n)).add(new BigDecimal(13591409))).divide(new BigDecimal(6).multiply(nfac.pow(3)).multiply(new BigDecimal(640320).pow(3 * n)), RoundingMode.HALF_UP)));
		System.out.println(sum.multiply(new BigDecimal(10005).sqrt(new MathContext(100)).divide(new BigDecimal(4270934400L), RoundingMode.HALF_UP).divide(new BigDecimal(10005).sqrt(new MathContext(100)).divide(new BigDecimal(4270934400L), RoundingMode.HALF_UP),RoundingMode.HALF_UP)));
	}

}