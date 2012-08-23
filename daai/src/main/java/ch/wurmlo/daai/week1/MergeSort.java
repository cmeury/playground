package ch.wurmlo.daaii.week1;

import ch.wurmlo.daaii.util.TimedResult;

import com.google.common.base.Preconditions;


public class MergeSort implements Sorter {

	public TimedResult<long[]> sort(long[] unsortedArray) {
		Preconditions.checkArgument(unsortedArray.length > 0);
		long[] sortedArray = unsortedArray.clone();
		TimedResult<long[]> result = new TimedResult<long[]>();
		result.storeResult(mergeSort(sortedArray));
		return result;
	}
	
	private long[] mergeSort(long[] unsortedArray) {
		if(unsortedArray.length == 1) {
			return unsortedArray;
		} else {
			long[] firstHalf = mergeSort(ArraySplitter.firstHalf(unsortedArray));
			long[] secondHalf = mergeSort(ArraySplitter.secondHalf(unsortedArray));
			return merge(firstHalf, secondHalf);
		}
	}
	
	private long[] merge(long[] a, long[] b) {
		int length = a.length + b.length;
		long[] result = new long[length];
		
		int i = 0;
		int j = 0;
		for(int k = 0; k < length; k++) {
			// if have used up all values in the first array, fill with 
			// a value from b and directly continue
			if(i >= a.length) {
				for(int z = k; z < length; z++) {
					result[z] = b[j];
					j++;
				}
				break;
			}
			// similarly with the second array
			if(j >= b.length) {
				for(int z = k; z < length; z++) {
					result[k] = a[i];
					i++;
				}
				break;
			}

			// the actual comparison, central step
			if(a[i] < b[j]) {
				result[k] = a[i];
				i++;
				
			} else {
				result[k] = b[j];
				j++;
			}
		}
		return result;
	}
	
}
