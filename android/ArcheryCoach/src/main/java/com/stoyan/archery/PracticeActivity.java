package com.stoyan.archery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class PracticeActivity extends Activity {

    private Practice practice;
    private Button insertBtn;
    private ListView list;
    private TextView lastFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_practice);

        long practiceId = getIntent().getLongExtra("practice_id", -1L);
        if (practiceId > 0) {
            practice = MemoryStorage.getInstance().getPracticeRound(practiceId);
        }

        if (practice == null) {
            practice = MemoryStorage.getInstance().startNewPracticeRound();
        }

        lastFive = (TextView) findViewById(R.id.lastFive);
        insertBtn = (Button) findViewById(R.id.insertButton);
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this, InsertScoresActivity.class);
                intent.putExtra("practice_id", practice.getId());
                startActivity(intent);
            }
        });

        list = (ListView) findViewById(R.id.scoreList);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Grab the values from storage
        List<Score[]> values = MemoryStorage.getInstance().getScores(practice);

        // Most recent at the top
        Collections.reverse(values);

        // Create the adapter
        ScoreListAdapter adapter = new ScoreListAdapter(this, Round.toRound(values));
        list.setAdapter(adapter);

        int count = 0;
        for (int i = 0; i < 5 && i < adapter.getCount(); i++) {
            Round r = adapter.getItem(i);
            count += r.getTotal();
        }

        lastFive.setText("Last 5: " + String.valueOf(count));
    }
}
