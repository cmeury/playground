package ch.wurmlo.daaii.quiz;

public class ArrayInversionCounter implements Counter {

	public ArrayAndCount sortAndCountArray(int[] A) {
		if (A.length == 1) {
			ArrayAndCount arCount = new ArrayAndCount(A, 0);
			return arCount;
		} else {
			int[] left = ArraySplitter.firstHalf(A);
			int[] right = ArraySplitter.secondHalf(A);
			
			ArrayAndCount leftResult = sortAndCountArray(left);
			ArrayAndCount rightResult = sortAndCountArray(right);
			ArrayAndCount splitResult = mergeAndCountSplitInv(leftResult.getArray(),
					rightResult.getArray());
			
			long result = leftResult.getCount() + rightResult.getCount()
					+ splitResult.getCount();
			ArrayAndCount arCount = new ArrayAndCount(splitResult.getArray(), result);
			return arCount;
		}
	}

	private ArrayAndCount mergeAndCountSplitInv(int[] B, int[] C) {
		int length = B.length + C.length;
		int[] result = new int[length];
		long count = 0;
		int i = 0;
		int j = 0;
		for (int k = 0; k < length; k++) {
			// if have used up all values in the first array, fill with
			// a value from C and directly continue
			if (i >= B.length) {
				for (int z = k; z < length; z++) {
					result[z] = C[j];
					j++;
				}
				break;
			}
			// similarly with the second array
			if (j >= C.length) {
				for (int z = k; z < length; z++) {
					result[z] = B[i];
					i++;
				}
				break;
			}

			// the actual comparison, central step
			if (B[i] < C[j]) {
				result[k] = B[i];
				i++;
			} else {
				result[k] = C[j];
				j++;
				// inversions = numbers left in 1st array
				count += B.length - i;
			}
		}
		ArrayAndCount arCount = new ArrayAndCount(result, count);
		return arCount;
	}
}
