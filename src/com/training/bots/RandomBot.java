package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;

import java.util.Random;

public class RandomBot implements Bot {

    @Override
    public Move makeMove(Gamestate gamestate) {



        Random rand = new Random();
        int move = rand.nextInt(3);
        move += 1;

        int R = 1;
        int P = 2;
        int S = 3;

        if (move ==1) {
            return Move.R;
        }
        if (move ==2) {
            return Move.P;
        }
        if (move == 3) {
        }
        return Move.S;
    }
}

