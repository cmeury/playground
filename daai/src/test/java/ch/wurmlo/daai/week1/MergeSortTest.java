package ch.wurmlo.daai.week1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ch.wurmlo.daai.util.TimedResult;

public class MergeSortTest {

	Sorter sort;
	
	@Before
	public void setUp() {
		sort = new MergeSort();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoItem() {
		// given
		long[] unsorted = new long[]{};
		
		// when
		sort.sort(unsorted);
	}

	@Test
	public void testOneItem() {
		// given
		long[] unsorted = new long[]{5};
		
		// when
		TimedResult<long[]> sort2 = sort.sort(unsorted);
		
		// then
		assertEquals(1, sort2.getResult().length);
		assertEquals(5, sort2.getResult()[0]);
	}
	
	@Test
	
	public void testTwoItems() {
		// given
		long[] unsorted = new long[]{2,1};
		
		// when
		TimedResult<long[]> sort2 = sort.sort(unsorted);
		
		// then
		assertEquals(2, sort2.getResult().length);
		assertEquals(1, sort2.getResult()[0]);
		assertEquals(2, sort2.getResult()[1]);
	}
	@Test
	public void testAlreadyOrdered() {
		// given
		long[] unsorted = new long[]{1,4,6};
		
		// when
		TimedResult<long[]> sort2 = sort.sort(unsorted);
		
		// then
		assertEquals(3, sort2.getResult().length);
		assertEquals(1, sort2.getResult()[0]);
		assertEquals(4, sort2.getResult()[1]);
		assertEquals(6, sort2.getResult()[2]);
	}
	
	@Test
	public void testSorting() {
		// given
		long[] unsorted = new long[]{1,800,10,50,2};
		
		// when
		TimedResult<long[]> sort2 = sort.sort(unsorted);
		
		// then
		assertEquals(5, sort2.getResult().length);
		assertEquals(1, sort2.getResult()[0]);
		assertEquals(2, sort2.getResult()[1]);
		assertEquals(10, sort2.getResult()[2]);
		assertEquals(50, sort2.getResult()[3]);
		assertEquals(800, sort2.getResult()[4]);
	}
}
