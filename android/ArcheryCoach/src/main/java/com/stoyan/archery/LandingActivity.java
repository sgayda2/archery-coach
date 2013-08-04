package com.stoyan.archery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Stoyan Gaydarov on 8/3/13.
 */
public class LandingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_landing);

        Button startNewButton = (Button) findViewById(R.id.newPracticeBtn);
        startNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPractice(MemoryStorage.getInstance().startNewPracticeRound());
            }
        });

        Button prevPracticeButton = (Button) findViewById(R.id.prevPracticeBtn);
        prevPracticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingActivity.this, PracticeListActivity.class));
            }
        });

        Button startLastPracticeButton = (Button) findViewById(R.id.lastPracticeBtn);
        startLastPracticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Practice practice = MemoryStorage.getInstance().getLastPracticeRound();
                if (practice == null) {
                    Toast.makeText(LandingActivity.this, "Error no previous Practice found", Toast.LENGTH_LONG).show();
                } else {
                    startPractice(practice);
                }
            }
        });
    }

    private void startPractice(Practice practice) {
        Intent intent = new Intent(this, PracticeActivity.class);
        intent.putExtra("practice_id", practice.getId());
        startActivity(intent);
    }
}
