package com.gmonnet.yatzy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
        return findHighestOccurences(2)
            .findFirst()
            .map(die -> die * 2)
            .orElse(0);
    }

    public int twoPair() {
        List<Integer> occurences = findHighestOccurences(2).toList();
        if (occurences.size() >= 2) {
            return 2 * (occurences.get(0) + occurences.get(1));
        }
        return 0;
    }

    public int threeOfAKind() {
        return findHighestOccurences(3)
            .findFirst()
            .map(die -> die * 3)
            .orElse(0);
    }

    public int fourOfAKind() {
        return findHighestOccurences(4)
            .findFirst()
            .map(die -> die * 4)
            .orElse(0);
    }

    public int smallStraight() {
        int[] sortedUniqueDice = Arrays.stream(dice).sorted().distinct().toArray();
        if (sortedUniqueDice.length == 5 && sortedUniqueDice[0] == 1) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        int[] sortedUniqueDice = Arrays.stream(dice).sorted().distinct().toArray();
        if (sortedUniqueDice.length == 5 && sortedUniqueDice[0] == 2) {
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

    private Stream<Integer> findHighestOccurences(int nbOccurence) {
        return Stream.of(6, 5, 4, 3, 2, 1)
            .filter(value -> Arrays.stream(dice).filter(die -> die == value).count() >= nbOccurence);
    }
}



