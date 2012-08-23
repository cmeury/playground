package ch.wurmlo.daai.tictactoe;


import static ch.wurmlo.daai.tictactoe.Spot.NONE;
import static com.google.common.collect.Lists.*;

import java.util.List;
import com.google.common.collect.Lists;

public class PlayState {

	private final List<Spot> spots;
	private final Spot nextPlayer;

	public PlayState(Spot i, Spot i1, Spot i2, Spot i3, Spot i4, Spot i5, Spot i6, Spot i7, Spot i8, Spot nextPlayer) {
		this(newArrayList(i, i1, i2, i3, i4, i5, i6, i7, i8), nextPlayer);
	}

	public PlayState() {
		this(NONE, NONE, NONE, NONE, NONE, NONE, NONE, NONE, NONE, Spot.A);
	}

	public PlayState(List<Spot> spots, Spot nextPlayer) {
		int size = spots.size();
		if (size != 9) {
			throw new StateError("All spots need to be filled to instantiate a state");
		}
		this.spots = Lists.newArrayList(spots);
		this.nextPlayer = nextPlayer;
	}

	public Spot getNextPlayer() {
		return nextPlayer;
	}

	public Spot getSpot(int n) {
		if(n < 0 || n > 8) {
			throw new StateError("Cannot retrieve spots outside of the board");
		}
		return spots.get(n);
	}

	public void set(int index, Spot spot) {
		if(index < 0 || index > 8) {
			throw new StateError("Cannot set spot outside of the board");
		}
		spots.set(index, spot);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		PlayState playState = (PlayState) o;

		if (!spots.equals(playState.spots)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return spots.hashCode();
	}

	public PlayState copy() {
		return new PlayState(spots, nextPlayer);
	}

	public PlayState copy(Spot nextPlayer) {
		return new PlayState(spots, nextPlayer);
	}

	public Spot winner() {
		// rows
		if(spotsEqual(0, 1, 2)) {
			return getSpot(0);
		}
		if(spotsEqual(3, 4, 5)) {
			return getSpot(3);
		}
		if(spotsEqual(6, 7, 8)) {
			return getSpot(6);
		}

		// columns
		if(spotsEqual(0, 3, 6)) {
			return getSpot(0);
		}
		if(spotsEqual(1, 4, 7)) {
			return getSpot(1);
		}
		if(spotsEqual(2, 5, 8)) {
			return getSpot(2);
		}

		// diagonals
		if(spotsEqual(0, 4, 8)) {
			return getSpot(0);
		}
		if(spotsEqual(2, 4, 6)) {
			return getSpot(2);
		}
		return Spot.NONE;
	}

	private boolean spotsEqual(int a, int b, int c) {
		return (getSpot(a) == getSpot(b)) && getSpot(b) == getSpot(c);
	}
}
