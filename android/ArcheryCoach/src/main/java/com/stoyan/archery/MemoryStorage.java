package com.stoyan.archery;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Stoyan Gaydarov on 8/1/13.
 */
public class MemoryStorage implements Storage {

    private HashMap<TargetStyle, ArrayList<Score[]>> scores;

    public MemoryStorage() {
        scores = new HashMap<TargetStyle, ArrayList<Score[]>>();
    }

    @Override
    public boolean store(TargetStyle style, Score[] arrows) {
        if (style == null || arrows == null || arrows.length == 0) {
            return false;
        }

        ArrayList<Score[]> target = scores.get(style);
        if(target == null) {
            target = new ArrayList<Score[]>();
            scores.put(style, target);
        }

        return target.add(arrows);
    }
}
