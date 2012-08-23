package ch.wurmlo.daai.tictactoe;

import java.io.PrintStream;

public class View {

	final private PlayState state;

	public View(PlayState state) {
		this.state = state;
	}

	public void render(PrintStream stream) {
		stream.println(state.getSpot(0) + " | " + state.getSpot(1) + " | " + state.getSpot(2));
		stream.println("--|---|--");
		stream.println(state.getSpot(3) + " | " + state.getSpot(4) + " | " + state.getSpot(5));
		stream.println("--|---|--");
		stream.println(state.getSpot(6) + " | " + state.getSpot(7) + " | " + state.getSpot(8));
		stream.println();
		stream.println(state.winner());
	}

}
