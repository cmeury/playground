package eu.meury.subsets.shared;

/**
 * ListVerifier validates that the user entered list is valid.
 * 
 */
public class ListVerifier {

	public static final String ERROR_TEXT = "Input must be a comma separated list of single characters.";
	/**
	 * Verifies that the specified string consists of single characters 
	 * delimited by commas. A single character is also valid.
	 * 
	 * @param list the list to validate, expected to not contain any spaces at all
	 * @return true if valid, false if invalid
	 */
	public static boolean isInputSetValid(String list) {
		if (list == null) {
			return false;
		}
		
		String[] parts = list.split(",");

		// only a comma
		if(parts.length == 0) {
			return false;
		}
		
		// check that the individual parts are of length 1
		for(String p : parts) {
			if(p.length() != 1) {
				return false;
			}
		}
		
		// survived all checks
		return true;
	}
}
