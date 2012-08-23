package eu.meury.subsets.shared;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GenerateSubsetsTest {
	private List<String> list;
	
	@Before
	public void setUp() {
		list = new ArrayList<String>();
	}
	
	@After
	public void tearDown() {
		list.clear();
	}
	
	@Test
	public void testGetSubsets1() {
		list.add("A");
		assertTrue(GenerateSubsets.getSubsets(list).toString().equals("[A]"));
	}

	@Test
	public void testGetSubsets2() {
		list.add("A");
		list.add("B");
		assertTrue(GenerateSubsets.getSubsets(list).toString().equals("[A, B, AB]"));
	}

	@Test
	public void testGetSubsets3() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertTrue(GenerateSubsets.getSubsets(list).toString().equals("[A, B, C, BC, AB, AC, ABC]"));
	}

	@Test
	public void testGetSubsets4() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		assertTrue(GenerateSubsets.getSubsets(list).toString().equals("[A, B, C, D, CD, BC, BD, BCD, AB, AC, AD, ACD, ABC, ABD, ABCD]"));
	}

	@Test
	public void testGetSubsets5() {
		list.add("A");
		list.add("X");
		list.add("D");
		assertTrue(GenerateSubsets.getSubsets(list).toString().equals("[A, X, D, XD, AX, AD, AXD]"));
	}

}
