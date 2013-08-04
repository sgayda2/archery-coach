package com.stoyan.archery;

import android.*;
import android.R;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.List;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class PracticeListAdapter extends ArrayAdapter<Practice> {

    public PracticeListAdapter(Context context, Practice[] values) {
        super(context, R.layout.simple_list_item_1, values);
    }

    public PracticeListAdapter(Context context, List<Practice> values) {
        super(context, R.layout.simple_list_item_1, values);
    }
}
