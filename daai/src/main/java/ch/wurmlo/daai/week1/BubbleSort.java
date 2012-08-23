package ch.wurmlo.daaii.week1;

import ch.wurmlo.daaii.util.TimedResult;


public class BubbleSort implements Sorter {

	public TimedResult<long[]> sort(long[] unsortedArray) {
		long[] sorted = unsortedArray.clone();
		TimedResult<long[]> result = new TimedResult<long[]>();
		boolean swapped;
		do {
			swapped = false;
			for(int i = 1; i < sorted.length; i++) {
				if(sorted[i-1] > sorted[i]) {
					swap(sorted, i-1, i);
					swapped = true;
				}
			}
			
		} while (swapped == true);
		result.storeResult(sorted);
		return result;
	}

	private void swap(long[] array, int l, int m) {
		long tmp = array[l];
		array[l] = array[m];
		array[m] = tmp;
	}

}
