package com.stoyan.archery;

import java.util.Comparator;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class ScoreComparator implements Comparator<Score> {

    @Override
    public int compare(Score lhs, Score rhs) {
        int diff = rhs.points - lhs.points;
        return diff != 0 ? diff : rhs.ordinal() - lhs.ordinal();
    }
}
