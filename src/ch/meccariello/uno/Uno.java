package ch.meccariello.uno;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Uno {

	public static void main(String[] args) {
		System.out.println(new BigDecimal("1324641819451828974499891837121832599810209360673358065686551152497461815091591578895743130235002378688844343005686404521144382704205360039762937774080000000000000000000000000").divide(new BigDecimal((3600 * 24 * 365) + "").setScale(0, RoundingMode.HALF_UP)));
	}
	
}
