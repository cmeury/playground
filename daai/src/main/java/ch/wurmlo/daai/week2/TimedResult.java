package ch.wurmlo.daai.week2;

import java.util.Date;

/**
 * Used for storing the duration of a calculation alongside its result.
 */
public class TimedResult<T> {

	long start;
	long duration;
	T result;

	/**
	 * Constructs a new {@link TimedResult} and start the time-keeping.
	 */
	public TimedResult() {
		super();
		this.start = new Date().getTime();
	}
	
	/**
	 * Can only be called after {@link TimedResult#storeResult(Object)}
	 * has been called.
	 * @return duration in milliseconds
	 */
	public long getDuration() {
		return duration;
	}
	
	/**
	 * Stores the result and stops the time-keeping.
	 * @param result object representing the result
	 */
	public void storeResult(T result) {
		this.result = result;
		long end = new Date().getTime();
		this.duration = end - this.start;
	}
	
	/**
	 * Returns the result object.
	 * @return the result
	 */
	public T getResult() {
		return result;
	}
	
	
}
