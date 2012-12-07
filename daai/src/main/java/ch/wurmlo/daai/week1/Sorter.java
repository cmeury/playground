package ch.wurmlo.daai.week1;

import ch.wurmlo.daai.util.TimedResult;

/**
 * Sorts an array of longs.
 */
public interface Sorter {
	
	/**
	 * Sorts an array of longs. The returned array has the same size
	 * of the input array.
	 * @param unsortedArray unsorted array of longs
	 * @return same numbers, but sorted and a duration
	 * @throws IllegalArgumentException when an empty array is passed
	 */
	TimedResult<long[]> sort(long[] unsortedArray);
}
