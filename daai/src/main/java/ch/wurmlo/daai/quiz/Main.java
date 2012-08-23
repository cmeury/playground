package ch.wurmlo.daaii.quiz;

import ch.wurmlo.daaii.util.TimedResult;

public class Main {

	public static void main(String[] args) {
		
		int[] integers = ReadIntegerArrayFile.readIntegersFromFile();

		TimedResult<ArrayAndCount> timedResult = new TimedResult<ArrayAndCount>();
		ArrayInversionCounter counter = new ArrayInversionCounter();
		timedResult.storeResult(counter.sortAndCountArray(integers.clone()));
		System.out.println("ArrayInversionCounter: " + timedResult.getResult().getCount());
		System.out.println("took " + timedResult.getDuration() + " ms");
		
		TimedResult<ArrayAndCount> timedResult2 = new TimedResult<ArrayAndCount>();
		BruteForceCounter counter2 = new BruteForceCounter();
		timedResult2.storeResult(counter2.sortAndCountArray(integers.clone()));
		System.out.println("BruteForceCounter: " + timedResult2.getResult().getCount());
		System.out.println("took " + timedResult2.getDuration() + " ms");

	}

}