package ch.wurmlo.week1.schedule;

public class Job {

	private int weight;
	private int length;

	public Job(int weight, int length) {
		this.weight = weight;
		this.length = length;
	}

	public int getWeight() {
		return weight;
	}

	public int getLength() {
		return length;
	}

}
