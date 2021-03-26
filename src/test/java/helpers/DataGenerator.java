package helpers;

import java.util.Date;

public class DataGenerator {
	public static String createRandomString() {
		return String.valueOf(System.currentTimeMillis()).
				replaceAll("1", "a").
				replaceAll("2", "c").
				replaceAll("3", "f").
				replaceAll("4", "y").
				replaceAll("5", "q").
				replaceAll("6", "s").
				replaceAll("7", "o").
				replaceAll("8", "i").
				replaceAll("9", "l");
	}

}
