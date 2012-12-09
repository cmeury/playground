package ch.wurmlo.week1.schedule;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(3,117).append(weight).append(length).toHashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Job rhs = (Job) o;
		return new EqualsBuilder().append(weight, rhs.weight).append(length, rhs.length).isEquals();
	}

	@Override
	public String toString() {
		return "Job[weight="+weight+",length="+length+"]";
	}
}
