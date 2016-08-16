package md.convertit.products.util;

import java.util.Date;
import java.util.GregorianCalendar;

public class RandomDate {

	public static Date getRandomDate() {

		GregorianCalendar gc = new GregorianCalendar();

		int year = randBetween(2015, 2016);

		gc.set(gc.YEAR, year);

		int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

		gc.set(gc.DAY_OF_YEAR, dayOfYear);

		
		return gc.getTime();
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}
