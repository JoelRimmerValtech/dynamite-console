package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;
import com.softwire.dynamite.game.Round;
import sun.security.util.Length;

import java.util.List;

public class CleverBot implements Bot {

    @Override
    public Move makeMove(Gamestate gamestate) {
        List<Round> listOfRounds = gamestate.getRounds();

        if (listOfRounds.size() == 0) {
            return Move.D;
        }

        Round lastRound = listOfRounds.get(listOfRounds.size()-1);

        if (lastRound.getP2() == Move.R) {
            return Move.P;
        }
        if (lastRound.getP2() == Move.P) {
            return Move.S;
        }
        if (lastRound.getP2() == Move.S) {
            return Move.R;
        }
        if (lastRound.getP2() == Move.D) {
            return Move.W;
        }
        if (lastRound.getP2() == Move.W) {
        }
        return Move.R;
    }
}


