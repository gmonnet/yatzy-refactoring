package yatzy.refactoring.kata;

import java.util.Arrays;

public class Yatzy {

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = d5;
    }

    public int chance() {
        return Arrays.stream(dice).sum();
    }

    public int yatzy() {
        if (Arrays.stream(dice).allMatch(value -> dice[0] == value)) {
            return 50;
        } else {
            return 0;
        }
    }

    public int ones() {
        return sumSames(1);
    }

    public int twos() {
        return sumSames(2);
    }

    public int threes() {
        return sumSames(3);
    }

    public int fours() {
        return sumSames(4);
    }

    public int fives() {
        return sumSames(5);
    }

    public int sixes() {
        return sumSames(6);
    }

    public int scorePair() {
        int[] tallies = talliesSides();
        for (int i = tallies.length - 1; i >= 0; i--) {
            if (tallies[i] >= 2) {
                return 2 * (i + 1);
            }
        }
        return 0;
    }

    public int twoPair() {
        int[] tallies = talliesSides();
        int n = 0;
        int score = 0;
        for (int i = tallies.length - 1; i >= 0; i--) {
            if (tallies[i] >= 2) {
                n++;
                score += (i + 1);
            }
        }
        if (n == 2) {
            return score * 2;
        }
        return 0;
    }

    public int fourOfAKind() {
        int[] tallies = talliesSides();
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public int threeOfAKind() {
        int[] tallies = talliesSides();
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public int smallStraight() {
        int[] tallies = talliesSides();
        if (tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        int[] tallies = talliesSides();
        if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        boolean hasPair = false;
        int pairAt = 0;
        boolean hasTriple = false;
        int tripleAt = 0;

        int[] tallies = talliesSides();

        for (int i = 0; i < tallies.length; i++) {
            if (tallies[i] == 2) {
                hasPair = true;
                pairAt = i + 1;
            }
            if (tallies[i] == 3) {
                hasTriple = true;
                tripleAt = i + 1;
            }
        }

        if (hasPair && hasTriple) {
            return pairAt * 2 + tripleAt * 3;
        } else {
            return 0;
        }
    }

    private int sumSames(Integer value) {
        return Arrays.stream(dice).filter(value::equals).sum();
    }

    private int[] talliesSides() {
        int[] tallies = new int[6];
        for (int die : dice) {
            tallies[die - 1]++;
        }
        return tallies;
    }
}



