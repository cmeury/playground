package ch.wurmlo.daai.week2;


public class QuickSort {

	private PivotChooser pivotChooser;
	
	public QuickSort(PivotChooser pivotChooser) {
		this.pivotChooser = pivotChooser;
	}
	
	public int sort(int[] array, int left, int right) {
		int n = right - left + 1;
		if(n <= 1) {
			return 0;
		}
		int pivot = pivotChooser.choosePivot(array, left, right);
		int newPivot = Partitioner.partitionAroundPivot(array, left, right, pivot);
		int comparisons = 0;
		if(newPivot > left) {
			comparisons += sort(array, left, newPivot-1);
		}
		if(newPivot < right) {
			comparisons += sort(array, newPivot+1, right);
		}
		comparisons += n - 1;
		return comparisons;
	}

}
