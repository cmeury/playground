package eu.meury.subsets.shared;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides a static method to generate subsets
 *
 */
public class GenerateSubsets {
	
	/**
	 * This is a recursive function which calculates all the subsets of the given
	 * list.
	 * 
	 * @param list a list of strings
	 * @return all subsets of the given list
	 */
	static public List<String> getSubsets(List<String> list) {
		// anchor; if we're down to one element, return it
		if(list.size() == 0) {
			return list;
		}
		
		List<String> subsets = new ArrayList<String>();

		// remove the first entry of the list and add it as a result
		String first = null;
		if(list.size() >= 1) {
			first = list.remove(0);
		}
		subsets.add(first);
		
		// recursive call to get the remaining subsets
		List<String> nextSubsets = getSubsets(list);
		subsets.addAll(nextSubsets);

		// additionally to the remaining subsets, also add them with the first element preceding
		for(String s : nextSubsets) {
			subsets.add(first + s);
		}
		
		return subsets;
	}
}
