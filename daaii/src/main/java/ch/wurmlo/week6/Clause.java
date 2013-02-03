package ch.wurmlo.week6;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Clause {

    private final float first;
    private final float second;

    public Clause(float first, float second) {
        this.first = first;
        this.second = second;
    }

    public float getFirst() {
        return first;
    }

    public float getSecond() {
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
