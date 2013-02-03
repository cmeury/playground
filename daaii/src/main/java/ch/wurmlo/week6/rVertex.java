package ch.wurmlo.week6;

public class rVertex implements Comparable {

	private Integer id;
	private Boolean explored = false;

	public rVertex(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean isExplored() {
		return explored;
	}

	public void setExplored(Boolean explored) {
		this.explored = explored;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		rVertex vertex = (rVertex) o;

		if (id != null ? !id.equals(vertex.id) : vertex.id != null) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public int compareTo(Object o) {
		rVertex other = (rVertex) o;
		return other.id.compareTo(this.id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	@Override
	public rVertex clone() {
		return new rVertex(id);
	}
}
