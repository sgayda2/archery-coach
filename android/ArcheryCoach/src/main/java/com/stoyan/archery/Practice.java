package com.stoyan.archery;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class Practice {

    private final long id;
    private final long createTime;

    public Practice(long id) {
        this.id = id;
        this.createTime = System.currentTimeMillis();
    }

    public long getId() {
        return id;
    }

    public String toString() {
        DateFormat format = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        return "Practice(" + id + ") at " + format.format(new Date(createTime));
    }

}
