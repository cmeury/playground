package ch.wurmlo.daai.week2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartitionerTest {

	@Test
	public void shouldNotFailOnEmptyArrayOne() {
		// given
		int a[] = new int[]{};
		
		// when
		Partitioner.partitionAroundPivot(a, 0, a.length-1, 0);
		
		// then
		// no exception
	}

	@Test
	public void shouldNotChangeArrayOnSizeOne() {
		// given
		int a[] = new int[]{5};
		
		// when
		Partitioner.partitionAroundPivot(a, 0, a.length-1, 0);
		
		// then
		assertEquals(1, a.length);
		assertEquals(5, a[0]);
	}
	
	@Test
	public void shouldReverseOnTwo() {
		// given
		int a[] = new int[]{6,2};
		
		// when
		Partitioner.partitionAroundPivot(a, 0, a.length-1, 0);
		
		// then
		assertArrayEquals(new int[]{2,6}, a);
	}

	@Test
	public void shouldKeepOnTwo() {
		// given
		int a[] = new int[]{1,2};
		
		// when
		Partitioner.partitionAroundPivot(a, 0, a.length-1, 0);
		
		// then
		assertArrayEquals(new int[]{1,2}, a);
	}
	
	@Test
	public void shouldPivotOnSimpleCase() {
		// given
		int a[] = new int[]{5,2,9};
		
		// when
		Partitioner.partitionAroundPivot(a, 0, a.length-1, 0);
		
		// then
		assertArrayEquals(new int[]{2,5,9}, a);
	}

	@Test
	public void shouldPivotOnSimpleCase2() {
		// given
		int a[] = new int[]{5,9,2};
		
		// when
		Partitioner.partitionAroundPivot(a, 0, a.length-1, 0);
		
		// then
		assertArrayEquals(new int[]{2,5,9}, a);
	}

	
}
