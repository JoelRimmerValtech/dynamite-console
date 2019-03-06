package com.training.bots;

import com.softwire.dynamite.bot.Bot;
import com.softwire.dynamite.game.Gamestate;
import com.softwire.dynamite.game.Move;
import com.softwire.dynamite.game.Round;

import java.util.List;
import java.util.Random;

public class ILikeBigBotsAndICanNotLieV2 implements Bot {

    int dynamiteRemaining = 100;
    int opponentDynamite = 100;

    @Override
    public Move makeMove(Gamestate gamestate) {
        List<Round> listOfRounds = gamestate.getRounds();

        // First move of the game
        if (listOfRounds.size() == 0) {
            return Move.R;
        }

        Round lastRound = listOfRounds.get(listOfRounds.size()-1);
        if (lastRound.getP2() == Move.D) {
            opponentDynamite = opponentDynamite-1;
        }

        // Second move of the game
        if (listOfRounds.size() < 4) {
            return getRandomMove();
        }


        Round secondToLastRound = listOfRounds.get(listOfRounds.size()-2);
        Round thirdToLastRound = listOfRounds.get(listOfRounds.size()-3);
        Round fourthToLastRound = listOfRounds.get(listOfRounds.size()-4);

        if (dynamiteRemaining > 0) {

            Random rand = new Random();

            int random = rand.nextInt(2);
            random += 1;

            int random2 = rand.nextInt(2);
            random2 += 1;

            int random3 = rand.nextInt(2);
            random3+= 1;

            if (lastRound.getP2() == lastRound.getP1()) {
                if (random3 == 1) {
                    if (opponentDynamite > 0) {
                        return Move.S;
                    }
                }
            }

            if (random == 1) {

                if (lastRound.getP2() == lastRound.getP1() && secondToLastRound.getP2() == secondToLastRound.getP1() && thirdToLastRound.getP2() == thirdToLastRound.getP1() && fourthToLastRound.getP2() == fourthToLastRound.getP1()) {
                    if (random2 == 1) {
                        return Move.R;
                    } else if (random2 == 2) {
                        dynamiteRemaining = dynamiteRemaining - 1;
                        return Move.D;
                    }
                }

                if (lastRound.getP2() == lastRound.getP1() && secondToLastRound.getP2() == secondToLastRound.getP1() && thirdToLastRound.getP2() == thirdToLastRound.getP1()) {
                    if (random2 == 1) {
                        return Move.R;
                    } else if (random2 == 2) {
                        if (listOfRounds.size()>1250){
                            return Move.S;
                        } else {
                            dynamiteRemaining = dynamiteRemaining - 1;
                            return Move.D;
                        }
                    }
                }

                if (lastRound.getP2() == lastRound.getP1() && secondToLastRound.getP2() == secondToLastRound.getP1()) {
                    if (random2 == 1) {
                        if (opponentDynamite > 0)
                            return Move.W;
                    } else if (random2 == 2) {
                        return Move.S;
                    }
                }
            }
            if (random ==2) {
                if (lastRound.getP2() == lastRound.getP1() && secondToLastRound.getP2() == secondToLastRound.getP1() && thirdToLastRound.getP2() == thirdToLastRound.getP1() && fourthToLastRound.getP2() == fourthToLastRound.getP1()) {
                    if (random2 == 1) {
                        return Move.P;
                    } else if (random2 == 2) {
                        dynamiteRemaining = dynamiteRemaining - 1;
                        return Move.D;
                    }
                }

                if (lastRound.getP2() == lastRound.getP1() && secondToLastRound.getP2() == secondToLastRound.getP1() && thirdToLastRound.getP2() == thirdToLastRound.getP1()) {
                    if (random2 == 1) {
                        return Move.P;
                    } else if (random2 == 2) {
                        if (listOfRounds.size() > 1000) {
                            return Move.S;
                        } else {
                            dynamiteRemaining = dynamiteRemaining - 1;
                            return Move.D;
                        }
                    }
                }

                if (lastRound.getP2() == lastRound.getP1() && secondToLastRound.getP2() == secondToLastRound.getP1()) {
                    if (random2 == 1) {
                        if (opponentDynamite > 0)
                            return Move.W;
                    } else if (random2 == 2) {
                        return Move.S;
                    }
                }
            }
        }
        if (lastRound.getP2() == secondToLastRound.getP2() && lastRound.getP2() == thirdToLastRound.getP2()) {
            if (lastRound.getP2() == Move.R) {
                return Move.P;
            }
        }
        if (lastRound.getP2() == secondToLastRound.getP2() && lastRound.getP2() == thirdToLastRound.getP2()) {
            if (lastRound.getP2() == Move.P) {
                return Move.S;
            }
        }
        if (lastRound.getP2() == secondToLastRound.getP2() && lastRound.getP2() == thirdToLastRound.getP2()) {
            if (lastRound.getP2() == Move.S) {
                return Move.R;
            }
        }

        if (lastRound.getP2() == secondToLastRound.getP2()) {
            if (lastRound.getP2() == Move.R) {
                return Move.R;
            }
        }
        if (lastRound.getP2() == secondToLastRound.getP2()) {
            if (lastRound.getP2() == Move.P) {
                return Move.P;
            }
        }
        if (lastRound.getP2() == secondToLastRound.getP2()) {
            if (lastRound.getP2() == Move.S) {
                return Move.S;
            }
        }


        return getRandomMove();
    }

    private Move getRandomMove() {
        Random rand = new Random();
        int move = rand.nextInt(3);
        move += 1;

        if (move == 1) {
            return Move.R;
        }
        else if (move == 2) {
            return Move.P;
        }
        else {
            return Move.S;
        }
    }
}
