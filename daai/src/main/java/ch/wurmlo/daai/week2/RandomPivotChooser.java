package ch.wurmlo.daaii;

import java.util.Calendar;
import java.util.Random;

public class RandomPivotChooser implements PivotChooser {

	public int choosePivot(int[] a, int k, int l) {
		Random random = new Random(Calendar.getInstance().getTimeInMillis());
		return random.nextInt(l-k) + k;
	}

}
