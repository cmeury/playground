package ch.wurmlo.daai.week1;

import java.util.Arrays;

import ch.wurmlo.daai.util.TimedResult;

public class BuiltinSort implements Sorter {

	public TimedResult<long[]> sort(long[] unsortedArray) {
		TimedResult<long[]> result = new TimedResult<long[]>();
		Arrays.sort(unsortedArray);
		result.storeResult(unsortedArray);
		return result;
	}

}
