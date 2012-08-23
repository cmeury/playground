package ch.wurmlo.daaii;

public class Partitioner {

	/**
	 * Partitions array a (sub-array l to r) around the given pivot p.
	 * @param a
	 * @param l
	 * @param r
	 * @param p
	 * @return new index of pivot
	 */
	public static int partitionAroundPivot(int[] a, int l, int r, int p) {
		if(a.length <= 1) {
			return 0;
		}
		swap(a, p, l);
		int i = l + 1;
		for(int j = l+1; j <= r; j++) {
			if(a[j] < a[l]) {
				swap(a, j, i);
				i++;
			}
		}
		swap(a, l, i-1);
		return i-1;
	}

	public static void swap(int []a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
}
