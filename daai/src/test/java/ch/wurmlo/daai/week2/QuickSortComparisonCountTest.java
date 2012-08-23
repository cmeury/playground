package ch.wurmlo.daaii;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class QuickSortComparisonCountTest {

	@Test
	public void shouldReturnCorrectCountLow() {
		// given
		QuickSort sorter = new QuickSort(new FirstElementChooser());
		int[] array = ReadIntegerArrayFileForTest.readIntegersFromFile("array0.txt");
		
		// when
		int count = sorter.sort(array, 0, array.length-1);
		
		// then
		assertEquals(64, count);
	}
	
	@Test
	public void shouldReturnCorrectCountHigh() {
		// given
		QuickSort sorter = new QuickSort(new LastElementChooser());
		int[] array = ReadIntegerArrayFileForTest.readIntegersFromFile("array0.txt");
		
		// when
		int count = sorter.sort(array, 0, array.length-1);
		
		// then
		assertEquals(60, count);
	}
	
	@Test
	public void shouldReturnCorrectCountMedian() {
		// given
		QuickSort sorter = new QuickSort(new MedianPivotChooser());
		int[] array = ReadIntegerArrayFileForTest.readIntegersFromFile("array0.txt");
		
		// when
		int count = sorter.sort(array, 0, array.length-1);
		
		// then
		assertEquals(55, count);
	}
}
