package com.stoyan.archery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class PracticeActivity extends Activity {

    private Practice practice;
    private Button insertBtn;
    private Button showBtn;

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

        insertBtn = (Button) findViewById(R.id.insertButton);
        showBtn = (Button) findViewById(R.id.showButton);

        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this, InsertScoresActivity.class);
                intent.putExtra("practice_id", practice.getId());
                startActivity(intent);
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this, ShowPracticeActivity.class);
                intent.putExtra("practice_id", practice.getId());
                startActivity(intent);
            }
        });
    }
}
