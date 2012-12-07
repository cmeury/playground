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

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
