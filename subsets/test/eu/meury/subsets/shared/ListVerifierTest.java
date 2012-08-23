package eu.meury.subsets.shared;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ListVerifierTest {

	@Test
	public void testIsInputSetValid() {
		assertTrue(ListVerifier.isInputSetValid("A"));
		assertTrue(ListVerifier.isInputSetValid("A,B"));
		assertTrue(ListVerifier.isInputSetValid("A,B,C"));
		assertTrue(ListVerifier.isInputSetValid("1,2,3"));
		assertTrue(ListVerifier.isInputSetValid("%,&,/"));
		assertFalse(ListVerifier.isInputSetValid(" A"));
		assertFalse(ListVerifier.isInputSetValid("A, B"));
		assertFalse(ListVerifier.isInputSetValid(","));
		assertFalse(ListVerifier.isInputSetValid(",,"));
		assertFalse(ListVerifier.isInputSetValid("AB,CA"));
		assertFalse(ListVerifier.isInputSetValid("3443,3443"));
		assertFalse(ListVerifier.isInputSetValid("2323,"));
		assertFalse(ListVerifier.isInputSetValid(",2323,"));
		assertFalse(ListVerifier.isInputSetValid(",2323"));
		assertFalse(ListVerifier.isInputSetValid(",A"));
		assertFalse(ListVerifier.isInputSetValid(",,A"));
		assertTrue(ListVerifier.isInputSetValid("A,,"));  // TODO: Should also fail, see how split() works in detail
		assertFalse(ListVerifier.isInputSetValid(",A,.,,"));
		assertFalse(ListVerifier.isInputSetValid(", ,"));
		assertFalse(ListVerifier.isInputSetValid("A ,A,B,C"));
		
		
	}

}
