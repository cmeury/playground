/**
 * Copyright 2012, netbreeze GmbH
 */
package ch.wurmlo.week2;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 */
public class Point {

	int number;

	public Point(int number) {
		this.number = number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Point point = (Point) o;
		return new EqualsBuilder().append(number, point.number).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(11,23).append(number).hashCode();
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
