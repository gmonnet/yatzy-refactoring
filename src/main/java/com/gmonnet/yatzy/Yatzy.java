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
        return scoresOccurences(2);
    }

    public int twoPair() {
        List<Integer> occurences = findHighestOccurences(2).toList();
        if (occurences.size() >= 2) {
            return 2 * (occurences.get(0) + occurences.get(1));
        }
        return 0;
    }

    public int threeOfAKind() {
        return scoresOccurences(3);
    }

    public int fourOfAKind() {
        return scoresOccurences(4);
    }

    public int smallStraight() {
        if (isStraightStartingWith(1)) {
            return 15;
        }
        return 0;
    }

    public int largeStraight() {
        if (isStraightStartingWith(2)) {
            return 20;
        }
        return 0;
    }

    public int fullHouse() {
        List<Integer> triples = findHighestOccurences(3)
            .toList();
        List<Integer> pairs = findHighestOccurences(2)
            .filter(integer -> !triples.contains(integer))
            .toList();

        if (!triples.isEmpty() && !pairs.isEmpty()) {
            return 3 * triples.get(0) + 2 * pairs.get(0);
        }
        return 0;
    }

    private int sumSames(Integer value) {
        return Arrays.stream(dice).filter(value::equals).sum();
    }

    private Stream<Integer> findHighestOccurences(int nbOccurence) {
        return Stream.of(6, 5, 4, 3, 2, 1)
            .filter(value -> Arrays.stream(dice).filter(die -> die == value).count() >= nbOccurence);
    }

    private int scoresOccurences(int nbOccurence) {
        return findHighestOccurences(nbOccurence)
            .findFirst()
            .map(die -> die * nbOccurence)
            .orElse(0);
    }

    private boolean isStraightStartingWith(int starting) {
        int[] sortedUniqueDice = Arrays.stream(dice).sorted().distinct().toArray();
        return sortedUniqueDice.length == 5 && sortedUniqueDice[0] == starting;
    }
}



