package ch.wurmlo.daai.tictactoe;

import static ch.wurmlo.daai.tictactoe.Spot.A;
import static ch.wurmlo.daai.tictactoe.Spot.B;
import static ch.wurmlo.daai.tictactoe.Spot.NONE;

import java.util.List;

public class Main {

	public static void main(String[] args) {
//		PlayState state = new PlayState(A, B, A, B, A, B, A, NONE, NONE, Spot.A);
		PlayState state = new PlayState();

		List<PlayState> nextStates = Next.possibilities(state);
		for (int i = 0; i < 100; i++) {
			new View(nextStates.get(i)).render(System.out);
			System.out.println();
		}
//		for (PlayState nextState : nextStates) {
//			new View(nextState).render(System.out);
//			System.out.println();
//		}





	}
}
