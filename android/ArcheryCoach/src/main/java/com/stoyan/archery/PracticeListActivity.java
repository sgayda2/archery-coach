package com.stoyan.archery;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class PracticeListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Collection<Practice> values = MemoryStorage.getInstance().getAllPractices();
        List<Practice> valuesList = values instanceof List ? (List<Practice>) values : new ArrayList<Practice>(values);
        PracticeListAdapter adapter = new PracticeListAdapter(this, valuesList);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Practice practice = (Practice) getListAdapter().getItem(position);
        if (practice == null) {
            Toast.makeText(PracticeListActivity.this, "Error selecting practice", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, PracticeActivity.class);
            intent.putExtra("practice_id", practice.getId());
            startActivity(intent);
        }
    }
}
