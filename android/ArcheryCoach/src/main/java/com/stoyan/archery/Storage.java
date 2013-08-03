package com.stoyan.archery;

/**
 * Created by Stoyan Gaydarov on 7/31/13.
 */
public interface Storage {

    public boolean store(TargetStyle style, Score[] arrows);
}
