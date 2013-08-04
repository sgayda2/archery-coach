package com.stoyan.archery;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class ShowPracticeActivity extends ListActivity {

    private Practice practice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long practiceId = getIntent().getLongExtra("practice_id", -1L);
        if (practiceId > 0) {
            practice = MemoryStorage.getInstance().getPracticeRound(practiceId);
        }

        if (practice == null) {
            Toast.makeText(ShowPracticeActivity.this, "Error Looking up scores", Toast.LENGTH_LONG).show();
            finish();
            return;
        }

        List<Score[]> values = MemoryStorage.getInstance().getScores(practice);
        ScoreListAdapter adapter = new ScoreListAdapter(this, Round.toRound(values));
        setListAdapter(adapter);
    }
}
