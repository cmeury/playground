package ch.wurmlo.daai.week1;

import java.util.Arrays;
import java.util.Random;

import ch.wurmlo.daai.util.TimedResult;

public class Main {
	
	private static final int DATA_SIZE = 50000;

	public static void main(String[] args) {
		int dataSize = DATA_SIZE;
		long[] randomData = generateRandomData(dataSize);
		
		
		sortAndDisplayDuration(new BuiltinSort(), Arrays.copyOf(randomData, randomData.length));
		sortAndDisplayDuration(new MergeSort(), Arrays.copyOf(randomData, randomData.length));
		sortAndDisplayDuration(new BubbleSort(), Arrays.copyOf(randomData, randomData.length));
	}

	public static void sortAndDisplayDuration(Sorter sorter, long[] randomData) {
		TimedResult<long[]> sort = sorter.sort(Arrays.copyOf(randomData, randomData.length));
		System.out.println(sorter.getClass().getSimpleName() +  " - duration: " + sort.getDuration() + " ms");
	}
	
	private static long[] generateRandomData(int amount) {
		Random random = new Random();
		long[] numbers = new long[amount];
		for(int l = 0; l < amount; l++) {
			numbers[l] = random.nextLong();
		}
		return numbers;
	}
	
}
