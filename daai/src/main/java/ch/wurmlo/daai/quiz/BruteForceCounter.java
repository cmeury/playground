package ch.wurmlo.daai.quiz;

public class BruteForceCounter implements Counter {

	@Override
	public ArrayAndCount sortAndCountArray(int[] A) {
		long count = 0;
		for(int i = 0; i < A.length; i++) {
			for(int j = i + 1; j < A.length; j++) {
				if(A[j] < A[i]) {
					count += 1;
				}
			}
		}
		return new ArrayAndCount(A, count);
	}

}
