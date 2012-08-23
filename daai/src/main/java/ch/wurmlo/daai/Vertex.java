package ch.wurmlo.daai;

public class Vertex implements Comparable{

	private Integer id;
	private Boolean explored = false;

	public Vertex(Integer id) {
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

		Vertex vertex = (Vertex) o;

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
		Vertex other = (Vertex) o;
		return this.id.compareTo(other.id);
	}

	@Override
	public String toString() {
		return String.valueOf(id);
	}

	@Override
	public Vertex clone() {
		return new Vertex(id);
	}
}
