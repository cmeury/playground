package ch.wurmlo.week6;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Clause {

    private final int first;
    private final int second;

    public Clause(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Clause [first=" + this.first + ",second=" + this.second + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clause clause = (Clause) o;
        return new EqualsBuilder().append(first, clause.first).append(second, clause.second).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(11,31).append(first).append(second).toHashCode();
    }

}
