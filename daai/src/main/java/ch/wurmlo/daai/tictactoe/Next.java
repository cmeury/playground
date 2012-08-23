package ch.wurmlo.daai.tictactoe;

import static ch.wurmlo.daai.tictactoe.Spot.*;

import java.util.List;
import com.google.common.collect.Lists;

public class Next {

	public static List<PlayState> possibilities(PlayState state) {
		List<PlayState> playStates = Lists.newArrayList();
		for (int i = 0; i < 9; i++) {
			Spot spot = state.getSpot(i);
			if (spot == NONE) {
				Spot nextPlayer = state.getNextPlayer();
				PlayState newPlayState = state.copy(nextPlayer.reverse());
				newPlayState.set(i, nextPlayer);
				playStates.add(newPlayState);
				playStates.addAll(Next.possibilities(newPlayState));
			}
		}
		return playStates;
	}
}
