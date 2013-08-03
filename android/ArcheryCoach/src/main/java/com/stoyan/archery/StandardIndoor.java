package com.stoyan.archery;

/**
 * Created by stoyan on 8/2/13.
 */
public class StandardIndoor implements TargetStyle {

    @Override
    public int distance() {
        return 18;
    }

    @Override
    public int targetSize() {
        return 0;
    }
}
