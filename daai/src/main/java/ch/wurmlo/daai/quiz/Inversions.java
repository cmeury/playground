package ch.wurmlo.daaii.quiz;


class Inversions {

	public static void main(String args[]) // entry point from OS
	{
		int[] integers = ReadIntegerArrayFile.readIntegersFromFile();
		System.out.println(countInversions(integers) + " inversions.");

	}

	public static long countInversions(int nums[])
	/*
	 * This function will count the number of inversions in an array of numbers.
	 * (Recall that an inversion is a pair of numbers that appear out of
	 * numerical order in the list.
	 * 
	 * We use a modified version of the MergeSort algorithm to do this, so it's
	 * a recursive function. We split the list into two (almost) equal parts,
	 * recursively count the number of inversions in each part, and then count
	 * inversions caused by one element from each part of the list.
	 * 
	 * The merging is done is a separate procedure given below, in order to
	 * simplify the presentation of the algorithm here.
	 * 
	 * Note: I am assuming that the integers are distinct, but they need *not*
	 * be integers { 1, 2, ..., n} for some n.
	 */
	{
		int mid = nums.length / 2, k;
		long countLeft, countRight, countMerge;

		/* If the list is small, there's nothing to do. */
		if (nums.length <= 1)
			return 0;

		/*
		 * Otherwise, we create new arrays and split the list into two (almost)
		 * equal parts.
		 */
		int left[] = new int[mid];
		int right[] = new int[nums.length - mid];

		for (k = 0; k < mid; k++)
			left[k] = nums[k];
		for (k = 0; k < nums.length - mid; k++)
			right[k] = nums[mid + k];

		/*
		 * Recursively count the inversions in each part.
		 */
		countLeft = countInversions(left);
		countRight = countInversions(right);

		/*
		 * Now merge the two sublists together, and count the inversions caused
		 * by pairs of elements, one from each half of the original list.
		 */
		int result[] = new int[nums.length];
		countMerge = mergeAndCount(left, right, result);

		/*
		 * Finally, put the resulting list back into the original one. This is
		 * necessary for the recursive calls to work correctly.
		 */
		for (k = 0; k < nums.length; k++)
			nums[k] = result[k];

		/*
		 * Return the sum of the values computed to get the total number of
		 * inversions for the list.
		 */
		return (countLeft + countRight + countMerge);

	} /* end of "countInversions" procedure */

	public static long mergeAndCount(int left[], int right[], int result[])
	/*
	 * This procudure will merge the two lists, and count the number of
	 * inversions caused by the elements in the "right" list that are less than
	 * elements in the "left" list.
	 */
	{
		int a = 0, b = 0, i, k = 0;
		long count = 0;
		while ((a < left.length) && (b < right.length)) {
			if (left[a] <= right[b])
				result[k] = left[a++];
			else /* You have found (a number of) inversions here. */
			{
				result[k] = right[b++];
				count += left.length - a;
			}
			k++;
		}

		if (a == left.length)
			for (i = b; i < right.length; i++)
				result[k++] = right[i];
		else
			for (i = a; i < left.length; i++)
				result[k++] = left[i];

		return count;
	}

} /* end of "Inversions" program */