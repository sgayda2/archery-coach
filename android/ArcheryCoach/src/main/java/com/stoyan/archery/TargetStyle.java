package com.stoyan.archery;

/**
 * Created by Stoyan Gaydarov on 8/2/13.
 */
public interface TargetStyle {

    /**
     * @return distance in meters
     */
    public int distance();

    /**
     * @return target diameter in centimeters
     */
    public int targetSize();

}
