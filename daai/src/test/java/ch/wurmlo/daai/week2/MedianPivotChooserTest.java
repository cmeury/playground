package ch.wurmlo.daaii;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedianPivotChooserTest {

	@Test
	public void shouldPickMiddleElement1() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		
		// when
		int result = chooser.getMiddleElement(0, 1);
		
		// then
		assertEquals(0, result);
	}
	
	@Test
	public void shouldPickMiddleElement2() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		
		// when
		int result = chooser.getMiddleElement(0, 2);
		
		// then
		assertEquals(1, result);
	}
	
	@Test
	public void shouldPickMiddleElement3() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		
		// when
		int result = chooser.getMiddleElement(0, 3);
		
		// then
		assertEquals(1, result);
	}
	
	@Test
	public void shouldPickMiddleElement4() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		
		// when
		int result = chooser.getMiddleElement(0, 4);
		
		// then
		assertEquals(2, result);
	}
	
	@Test
	public void shouldReturnMedianIndex1() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		int a[] = new int[]{1,2,3};
		
		// when
		int result = chooser.getMedianIndex(a, 0, 2, 1);
		
		// then
		assertEquals(1, result);
	}
	
	@Test
	public void shouldReturnMedianIndex2() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		int a[] = new int[]{80,20,50};
		
		// when
		int result = chooser.getMedianIndex(a, 0, 2, 1);
		
		// then
		assertEquals(2, result);
	}
	
	@Test
	public void shouldReturnMedianIndex3() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		int a[] = new int[]{1000,3,2};
		
		// when
		int result = chooser.getMedianIndex(a, 0, 2, 1);
		
		// then
		assertEquals(1, result);
	}
	
	@Test
	public void shouldReturnMedianIndex4() {
		// given
		MedianPivotChooser chooser = new MedianPivotChooser();
		int a[] = new int[]{90,91,75};
		
		// when
		int result = chooser.getMedianIndex(a, 0, 2, 1);
		
		// then
		assertEquals(0, result);
	}
}
