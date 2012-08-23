package ch.wurmlo.daaii;

import java.util.Arrays;

public class MedianPivotChooser implements PivotChooser {

	public int choosePivot(int[] a, int k, int l) {
		int middleIdx = getMiddleElement(k, l);
		int medianIdx = getMedianIndex(a, k, middleIdx, l); 
		return medianIdx;
	}

	int getMedianIndex(int[] array, int a, int b, int c) {
		int[] values = new int[]{array[a], array[b], array[c]};
		Arrays.sort(values);
		if(values[1] == array[a]) { 
			return a;
		}
		if(values[1] == array[b]) {
			return b;
		}
		if(values[1] == array[c]) {
			return c;
		}
		throw new RuntimeException("Could not determine median!? " + a + ", " + b + ", " + c);
	}

	int getMiddleElement(int k, int l) {
		int length = l - k + 1;
		if(length % 2 == 0) {
			return k + (length / 2) - 1;
		} else {
			return k + (length / 2);
		}
	}

}
