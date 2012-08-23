package ch.wurmlo.daaii;

import java.util.Arrays;

public class QuickSortMain {

		public static void main(String[] args) {
			int[] integers = ReadIntegerArrayFile.readIntegersFromFile("QuickSort.txt", 10000);
			
			QuickSort sort = new QuickSort(new FirstElementChooser());
			int count = sort.sort(Arrays.copyOf(integers, integers.length), 0, integers.length - 1);
			System.out.println("Low: " + count);

			sort = new QuickSort(new LastElementChooser());
			count = sort.sort(Arrays.copyOf(integers, integers.length), 0, integers.length - 1);
			System.out.println("High: " + count);

			sort = new QuickSort(new MedianPivotChooser());
			count = sort.sort(Arrays.copyOf(integers, integers.length), 0, integers.length - 1);
			System.out.println("Median: " + count);
			
			sort = new QuickSort(new RandomPivotChooser());
			count = sort.sort(Arrays.copyOf(integers, integers.length), 0, integers.length - 1);
			System.out.println("Random: " + count);

		}
}
