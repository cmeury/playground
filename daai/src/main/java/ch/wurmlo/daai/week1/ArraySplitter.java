package ch.wurmlo.daaii.week1;

public class ArraySplitter {

	public static long[] secondHalf(long[] unsortedArray) {
		int origLen = unsortedArray.length;
		
		// if the length is odd, we need to add one because dividing by two
		// rounds by cutting of the decimals
		long[] half = new long[origLen % 2 == 0 ? origLen / 2 : origLen / 2 + 1 ];
	
		for(int c = 0; c < half.length; c++) {
			half[c] = unsortedArray[(origLen / 2) + c];
		}
		return half;
	}

	public static long[] firstHalf(long[] unsortedArray) {
		long[] half = new long[unsortedArray.length / 2];
		for(int c = 0; c < half.length; c++) {
			half[c] = unsortedArray[c];
		}
		return half;
	}
	
}
