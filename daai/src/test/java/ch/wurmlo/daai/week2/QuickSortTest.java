package ch.wurmlo.daaii;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.google.common.collect.Lists;

public class QuickSortTest {

	@Test
	public void shouldSortArray1() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int a[] = new int[]{9, 8, 7, 6};
		
		// when
		sorter.sort(a, 0, a.length-1);
		
		// then
		assertArrayEquals(new int[]{6, 7, 8, 9}, a);
	}

	@Test
	public void shouldSortArray2() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int a[] = new int[]{9, 10, 11, 20, 8, 7, 6};
		
		// when
		sorter.sort(a, 0, a.length-1);
		
		// then
		assertArrayEquals(new int[]{6, 7, 8, 9, 10, 11, 20}, a);
	}
	
	@Test
	public void shouldSortArray3() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int a[] = new int[]{4,2,9,7,6,10,1,5,3};
		
		// when
		sorter.sort(a, 0, a.length-1);
		
		// then
		assertArrayEquals(new int[]{1,2,3,4,5,6,7,9,10}, a);
	}
	
	@Test
	public void shouldSortArray4() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int a[] = new int[]{8,2,7,9,10,1,4,6,5};
		
		// when
		sorter.sort(a, 0, a.length-1);
		
		// then
		assertArrayEquals(new int[]{1,2,4,5,6,7,8,9,10}, a);
	}
	
	@Test
	public void shouldSortArray5() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int a[] = new int[]{6,1,4,8,2};
		
		// when
		sorter.sort(a, 0, a.length-1);
		
		// then
		assertArrayEquals(new int[]{1,2,4,6,8}, a);
	}
	
	@Test
	public void shouldSortArray6() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int a[] = new int[]{3,1,2};
		
		// when
		sorter.sort(a, 0, a.length-1);
		
		// then
		assertArrayEquals(new int[]{1,2,3}, a);
	}
	
	@Test
	public void shouldSortAlreadySortedArray1() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int max = 6958;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		int[] clone = Arrays.copyOf(array, array.length);

		// when
		sorter.sort(array, 0, array.length-1);
		
		// then
		assertArrayEquals(clone, array);
	}
	
	@Test
	public void shouldSortAlreadySortedArray2() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int max = 10000;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		int[] clone = array.clone();

		// when
		sorter.sort(array, 0, array.length-1);
		
		// then
		assertArrayEquals(clone, array);
	}

	@Test
	public void shouldSortReverseArray() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int max = 6958;
		int[] array = new int[max];
		int j = max - 1;
		for (int i = 0; i < array.length; i++) {
			array[i] = j;
			j--;
		}
		int[] clone = Arrays.copyOf(array, array.length);

		// when
		sorter.sort(array, 0, array.length-1);
		
		// then
		Arrays.sort(clone);
		assertArrayEquals(clone, array);
	}
	
	@Test
	public void shouldSortRandomArrays() {
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		
		int ITERATIONS = 10;
		int SIZE = 10000;
		for(int i = 0; i < ITERATIONS; i++) {
			// given
			int length = random.nextInt(SIZE) + 1;
			int[] array = new int[length];
			List<Integer> alreadyInArray = Lists.newArrayListWithCapacity(length);
			for(int c = 0; c < array.length; c++) {
				int nextInt;
				do {
					nextInt = random.nextInt(SIZE) + 1;
				} while(alreadyInArray.contains(nextInt));
				alreadyInArray.add(nextInt);
				array[c] = nextInt;
			}
			QuickSort sorter = new QuickSort(new FirstElementChooser());
			
			// when
			sorter.sort(array, 0, array.length-1);
			
			// then
			int[] clone = Arrays.copyOf(array, array.length);
			Arrays.sort(clone);
			assertArrayEquals(clone, array);
		}
	}
	
	@Test
	public void shouldSortRandomArraysWithMedian() {
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		
		int ITERATIONS = 10;
		int SIZE = 10000;
		for(int i = 0; i < ITERATIONS; i++) {
			// given
			int length = random.nextInt(SIZE) + 1;
			int[] array = new int[length];
			List<Integer> alreadyInArray = Lists.newArrayListWithCapacity(length);
			for(int c = 0; c < array.length; c++) {
				int nextInt;
				do {
					nextInt = random.nextInt(SIZE) + 1;
				} while(alreadyInArray.contains(nextInt));
				alreadyInArray.add(nextInt);
				array[c] = nextInt;
			}
			QuickSort sorter = new QuickSort(new MedianPivotChooser());
			
			// when
			sorter.sort(array, 0, array.length-1);
			
			// then
			int[] clone = Arrays.copyOf(array, array.length);
			Arrays.sort(clone);
			assertArrayEquals(clone, array);
		}
	}
}
