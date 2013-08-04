package com.stoyan.archery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class ScoreListAdapter extends ArrayAdapter<Round> {

    public ScoreListAdapter(Context context, List<Round> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

}
