package com.stoyan.archery;

/**
 * Created by Stoyan Gaydarov on 7/31/13.
 */
public enum Score {
    Miss(0, "0"),
    One(1, "1"),
    Two(2, "2"),
    Three(3, "3"),
    Four(4, "4"),
    Five(5, "5"),
    Six(6, "6"),
    Seven(7, "7"),
    Eight(8, "8"),
    Nine(9, "9"),
    Ten(10, "10"),
    X(10, "X");

    public final int points;
    public final String display;

    Score(int score, String display) {
        this.points = score;
        this.display = display;
    }
}
