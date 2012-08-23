package ch.wurmlo.daaii.week1;

import static org.junit.Assert.*;

import org.junit.Test;


public class ArraySplitterTest {

	@Test
	public void testEvenArrayLength() {
		// given
		long[] array = new long[]{1,2,3,4};
		
		// when
		long[] firstHalf = ArraySplitter.firstHalf(array);
		long[] secondHalf = ArraySplitter.secondHalf(array);
		
		// then
		assertArrayEquals(new long[]{1,2}, firstHalf);
		assertArrayEquals(new long[]{3,4}, secondHalf);
	}

	@Test
	public void testOddArrayLength() {
		// given
		long[] array = new long[]{1,2,3,4,5};
		
		// when
		long[] firstHalf = ArraySplitter.firstHalf(array);
		long[] secondHalf = ArraySplitter.secondHalf(array);
		
		// then
		assertArrayEquals(new long[]{1,2}, firstHalf);
		assertArrayEquals(new long[]{3,4,5}, secondHalf);
	}
	
	@Test
	public void testTwoElements() {
		// given
		long[] array = new long[]{1,2};
		
		// when
		long[] firstHalf = ArraySplitter.firstHalf(array);
		long[] secondHalf = ArraySplitter.secondHalf(array);
		
		// then
		assertArrayEquals(new long[]{1}, firstHalf);
		assertArrayEquals(new long[]{2}, secondHalf);
	}
	
	@Test
	public void testOneElement() {
		// given
		long[] array = new long[]{1};
		
		// when
		long[] firstHalf = ArraySplitter.firstHalf(array);
		long[] secondHalf = ArraySplitter.secondHalf(array);
		
		// then
		assertArrayEquals(new long[]{}, firstHalf);
		assertArrayEquals(new long[]{1}, secondHalf);
	}
	
	@Test
	public void testNoElement() {
		// given
		long[] array = new long[]{};
		
		// when
		long[] firstHalf = ArraySplitter.firstHalf(array);
		long[] secondHalf = ArraySplitter.secondHalf(array);
		
		// then
		assertEquals(0, firstHalf.length);
		assertEquals(0, secondHalf.length);
	}
}
