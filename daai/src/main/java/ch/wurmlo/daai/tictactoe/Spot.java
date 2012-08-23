package ch.wurmlo.daai.tictactoe;

public enum Spot {

	A("O"),
	B("X"),
	NONE("-");

	final private String displayName;

	private Spot(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}

	public Spot reverse() {
		if(this == A) {
			return B;
		} if(this == B) {
			return A;
		} else {
			throw new RuntimeException("trying to reverse NONE");
		}
	}
}
