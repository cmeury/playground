package ch.wurmlo.daaii;

public class LastElementChooser implements PivotChooser {

	public int choosePivot(int[] a, int k, int l) {
		return l;
	}

}
