package ch.wurmlo.daaii.week1;

import ch.wurmlo.daaii.util.TimedResult;

public class Fibonacci {

	public static void main(String[] args) {
		stupidFibonacci(40);
		storingFibonacci(40);
	}
	
	
	private static void storingFibonacci(int n) {
		TimedResult<Long> result = new TimedResult<Long>();
		result.storeResult(storingFibonacciRecursion(n));
		System.out.println("storingFibonacci(" + n + ") = " + result.getResult() + " -> " + result.getDuration() + " ms");
	}
	
	private static long storingFibonacciRecursion(int n) {
		if(n == 0) {
			return 0;
		} 
		long[] fibNumbers = new long[n+1];
		fibNumbers[0] = 0;
		fibNumbers[1] = 1;
		for(int i = 2; i <= n; i++) {
			fibNumbers[i] = fibNumbers[i-1] + fibNumbers[i-2];
		}
		return fibNumbers[n];
	}

	private static void stupidFibonacci(int n) {
		TimedResult<Long> result = new TimedResult<Long>();
		result.storeResult(stupidFibonacciRecursion(n));
		System.out.println("stupidFibonacci(" + n + ") = " + result.getResult() + " -> " + result.getDuration() + " ms");
	}
	
	private static long stupidFibonacciRecursion(int n) {
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return stupidFibonacciRecursion(n-1) + stupidFibonacciRecursion(n-2);
		}
	}

}
