package com.stoyan.archery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class Round {

    private final Score[] scores;

    public Round(Score[] scores) {
        this.scores = scores;
        Arrays.sort(this.scores, new ScoreComparator());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (Score score : scores) {
            builder.append(score.display);
            builder.append(" ");
            count += score.points;
        }

        builder.append("=> ");
        builder.append(count);

        return builder.toString();
    }

    public static List<Round> toRound(List<Score[]> scores) {
        if (scores == null || scores.size() == 0) {
            return Collections.emptyList();
        }

        ArrayList<Round> rounds = new ArrayList<Round>(scores.size());
        for(Score[] round : scores) {
            rounds.add(new Round(round));
        }
        return rounds;
    }
}
