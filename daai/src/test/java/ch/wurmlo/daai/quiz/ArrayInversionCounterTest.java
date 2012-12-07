package ch.wurmlo.daai.quiz;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class ArrayInversionCounterTest {

	@Test
	public void testStandardCase() {
		// given
		int[] array = new int[]{1,3,5,2,4,6};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();
		
		// then
		assertEquals(3, inversions);
	}
	
	@Test
	public void testStandardCaseOdd() {
		// given
		int[] array = new int[]{1,3,5,2,4,7,6};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();
		
		// then
		assertEquals(4, inversions);
	}

	@Test
	public void testStandardCaseOddSplit() {
		// given
		int[] array = new int[]{6,3,5,2,4,7,1};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();
		
		// then
		assertEquals(13, inversions);
	}
	
	@Test
	public void testSingleCase() {
		// given
		int[] array = new int[]{1};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();
		
		// then
		assertEquals(0, inversions);
	}
	
	@Test
	public void testTupleCase() {
		// given
		int[] array = new int[]{1,3};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();
		
		// then
		assertEquals(0, inversions);
	}

	@Test
	public void testTupleCaseReverse() {
		// given
		int[] array = new int[]{5,1};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();
		
		// then
		assertEquals(1, inversions);
	}
	
	@Test
	public void testCasesInvestigating1() {
		// given
		int[] array = new int[]{1,3,2};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();
		
		// then
		assertEquals(1, inversions);
	}

	@Test
	public void testCasesInvestigating2() {
		// given
		int[] array = new int[]{1,3,5,7,2,4,6,8,9};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		assertEquals(6, inversions);
	}
	
	@Test
	public void testCasesInvestigating3() {
		// given
		int[] array = new int[]{1,3,5,7,9,11,2,4,6,8,10};
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		assertEquals(15, inversions);
	}
	
	@Test
	public void testReverseNChoose2() {
		// given
		int max = 80000;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = max - i;
		}
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		long numbers = max;
		assertEquals((numbers*(numbers-1))/2, inversions);
	}

	@Test
	public void testReverseNChooseSmaller() {
		// given
		int max = 46342;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = max - i;
		}
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		long numbers = max;
		assertEquals((numbers*(numbers-1))/2, inversions);
	}
	
	@Test
	public void testReverseNChooseSmaller2() {
		// given
		int max = 46341;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = max - i;
		}
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		long numbers = max;
		assertEquals((numbers*(numbers-1))/2, inversions);
	}

	@Test
	public void testReverseNChoose2Odd() {
		// given
		int max = 80000;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = max - i;
		}
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		long numbers = max;
		assertEquals((numbers*(numbers-1))/2, inversions);
	}

	@Test
	public void testSortedArrayZero() {
		// given
		int max = 80000;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		assertEquals(0, inversions);
	}

	@Test
	public void testSortedArrayZeroOdd() {
		// given
		int max = 80001;
		int[] array = new int[max];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		ArrayInversionCounter counter = new ArrayInversionCounter();
		
		// when
		long inversions = counter.sortAndCountArray(array).getCount();

		// then
		assertEquals(0, inversions);
	}
	private void print(int[] array, ArrayInversionCounter counter) {
		int[] array2 = counter.sortAndCountArray(array).getArray();
		for (int i : array2) {
			System.out.println(i);
		}
	}
	
}
