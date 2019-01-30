package ch.meccariello.picalc;

import java.lang.management.ManagementFactory;
import java.util.stream.IntStream;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;
import org.apfloat.Apint;
import org.apfloat.ApintMath;

public class PiCalc {

	static Apfloat sum = new Apfloat(0);
	static int digits = 25; // Maximum 199 (for some reason I can't figure out)
	
	public static void main(String[] args) {

		long uptime = ManagementFactory.getRuntimeMXBean().getUptime();
		IntStream.range(0, digits).forEach(k -> sum = sum.add(ApintMath.factorial(6 * k).multiply(ApintMath.pow(new Apint(-1), k)).multiply(new Apfloat(545140134).multiply(new Apfloat(k)).add(new Apfloat(13591409))).divide(ApintMath.factorial(3 * k).multiply(ApfloatMath.pow(ApintMath.factorial(k), 3)).multiply(ApfloatMath.pow(new Apfloat(640320), (3 * k))).precision(digits))));
		System.out.println(ApfloatMath.pow(sum.multiply(ApfloatMath.sqrt(new Apfloat(10005, digits + 1)).divide(new Apfloat(42709344 * ((digits - 10) >= 0 ? Long.valueOf(Integer.parseInt("1" + String.valueOf(digits).substring(1, String.valueOf(digits).length())) - Integer.parseInt(String.valueOf(digits).substring(1, String.valueOf(digits).length()))) : 1)))), -1) + "\nIt took " + ((ManagementFactory.getRuntimeMXBean().getUptime() - uptime) / 1000.0) + " seconds to calculate " + digits + " digits with an accuracy of " + digits + ".");

	}

}
