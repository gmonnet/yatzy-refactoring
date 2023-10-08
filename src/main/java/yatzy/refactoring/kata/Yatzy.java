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
        int total = 0;
        total += dice[0];
        total += dice[1];
        total += dice[2];
        total += dice[3];
        total += dice[4];
        return total;
    }

    public int yatzy() {
        int[] counts = new int[6];
        for (int die : dice) {
            counts[die - 1]++;
        }
        for (int i = 0; i != 6; i++) {
            if (counts[i] == 5) {
                return 50;
            }
        }
        return 0;
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
        int[] counts = new int[6];
        counts[dice[0] - 1]++;
        counts[dice[1] - 1]++;
        counts[dice[2] - 1]++;
        counts[dice[3] - 1]++;
        counts[dice[4] - 1]++;
        for (int i = 0; i != 6; i++) {
            if (counts[6 - i - 1] >= 2) {
                return (6 - i) * 2;
            }
        }
        return 0;
    }

    public int twoPair() {
        int[] counts = new int[6];
        counts[dice[0] - 1]++;
        counts[dice[1] - 1]++;
        counts[dice[2] - 1]++;
        counts[dice[3] - 1]++;
        counts[dice[4] - 1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1) {
            if (counts[6 - i - 1] >= 2) {
                n++;
                score += (6 - i);
            }
        }
        if (n == 2) {
            return score * 2;
        }
        return 0;
    }

    public int fourOfAKind() {
        int[] tallies = new int[6];
        tallies[dice[0] - 1]++;
        tallies[dice[1] - 1]++;
        tallies[dice[2] - 1]++;
        tallies[dice[3] - 1]++;
        tallies[dice[4] - 1]++;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }
        return 0;
    }

    public int threeOfAKind() {
        int[] tallies = new int[6];
        tallies[dice[0] - 1]++;
        tallies[dice[1] - 1]++;
        tallies[dice[2] - 1]++;
        tallies[dice[3] - 1]++;
        tallies[dice[4] - 1]++;
        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 3) {
                return (i + 1) * 3;
            }
        }
        return 0;
    }

    public int smallStraight() {
        int[] tallies = new int[6];
        tallies[dice[0] - 1]++;
        tallies[dice[1] - 1]++;
        tallies[dice[2] - 1]++;
        tallies[dice[3] - 1]++;
        tallies[dice[4] - 1]++;
        if (tallies[0] == 1 && tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        int[] tallies = new int[6];
        tallies[dice[0] - 1]++;
        tallies[dice[1] - 1]++;
        tallies[dice[2] - 1]++;
        tallies[dice[3] - 1]++;
        tallies[dice[4] - 1]++;
        if (tallies[1] == 1 && tallies[2] == 1 && tallies[3] == 1 && tallies[4] == 1 && tallies[5] == 1) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;


        int[] tallies = new int[6];
        tallies[dice[0] - 1]++;
        tallies[dice[1] - 1]++;
        tallies[dice[2] - 1]++;
        tallies[dice[3] - 1]++;
        tallies[dice[4] - 1]++;

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i + 1;
            }
        }

        for (i = 0; i != 6; i += 1) {
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i + 1;
            }
        }

        if (_2 && _3) {
            return _2_at * 2 + _3_at * 3;
        } else {
            return 0;
        }
    }

    private int sumSames(Integer value) {
        return Arrays.stream(dice).filter(value::equals).sum();
    }
}



