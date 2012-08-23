package ch.wurmlo.daaii.quiz;

public class ArraySplitter {

	public static int[] secondHalf(int[] unsortedArray) {
		int origLen = unsortedArray.length;
		
		// if the length is odd, we need to add one because dividing by two
		// rounds by cutting of the decimals
		int[] half = new int[origLen % 2 == 0 ? origLen / 2 : origLen / 2 + 1 ];
	
		for(int c = 0; c < half.length; c++) {
			half[c] = unsortedArray[(origLen / 2) + c];
		}
		return half;
	}

	public static int[] firstHalf(int[] unsortedArray) {
		int[] half = new int[unsortedArray.length / 2];
		for(int c = 0; c < half.length; c++) {
			half[c] = unsortedArray[c];
		}
		return half;
	}

}
