package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;

import java.util.Random;

public class EagerBot implements Bot {

    int sticksOfDynamiteRemaining = 100;

    @Override
    public Move makeMove(Gamestate gamestate) {

        if (sticksOfDynamiteRemaining > 0) {
            sticksOfDynamiteRemaining = sticksOfDynamiteRemaining-1;
            return Move.D;
        }

        Random rand = new Random();
        int move = rand.nextInt(4);
        move += 1;

        int R = 1;
        int P = 2;
        int S = 3;
        int W = 4;

        if (move == 1) {
            return Move.R;
        }
        if (move == 2) {
            return Move.P;
        }
        if (move == 3) {
            return Move.S;
        }
        if (move == 4) {
        }
        return Move.W;
    }
}