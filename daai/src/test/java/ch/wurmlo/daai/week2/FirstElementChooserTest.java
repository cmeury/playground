package ch.wurmlo.daaii;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FirstElementChooserTest {

	private PivotChooser chooser;
	
	@Before
	public void setUp() {
		chooser = new FirstElementChooser();
	}
	
	@Test
	public void shouldReturnZeroOnEmptyArray() {
		// given
		int a[] = new int[0];
		
		// when
		int pivot = chooser.choosePivot(a, 0, a.length);
		
		// then
		assertEquals(0, pivot);
	}

	
	@Test
	public void shouldReturnZeroOnSingleElementArray() {
		// given
		int a[] = new int[]{5};
		
		// when
		int pivot = chooser.choosePivot(a, 0, a.length);
		
		// then
		assertEquals(0, pivot);
	}

	
	@Test
	public void shouldReturnFirstElementIndex() {
		// given
		int a[] = new int[]{1,2,3,4,5,6,7};
		
		// when
		int pivot = chooser.choosePivot(a, 0, a.length);
		
		// then
		assertEquals(0, pivot);
	}

}
