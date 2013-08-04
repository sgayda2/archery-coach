package com.stoyan.archery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Stoyan Gaydarov on 8/2/13.
 */
public class InsertScoresActivity extends Activity {

    private int arrow;
    private int[] arrows;
    private Score[] scores;
    private TextView finalScore;
    private Button submitBtn;
    private Practice practice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_insert);

        long practiceId = getIntent().getLongExtra("practice_id", -1L);
        if (practiceId > 0) {
            practice = MemoryStorage.getInstance().getPracticeRound(practiceId);
        }

        if (practice == null) {
            practice = MemoryStorage.getInstance().startNewPracticeRound();
        }

        arrow = 0;
        arrows = new int[] {R.id.arrow1, R.id.arrow2, R.id.arrow3, R.id.arrow4, R.id.arrow5, R.id.arrow6 };
        scores = new Score[arrows.length];

        finalScore = (TextView) findViewById(R.id.finalScore);
        submitBtn = (Button) findViewById(R.id.submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check all the scores
                for (int i = 0; i < scores.length; i++) {
                    if (scores[i] == null) {
                        return;
                    }
                }

                if(MemoryStorage.getInstance().store(practice, scores)) {
                    finish();
                } else {
                    Toast.makeText(InsertScoresActivity.this, "Error Saving", Toast.LENGTH_LONG).show();
                }
            }
        });

        setupButton(R.id.scoreX, Score.X);
        setupButton(R.id.score10, Score.Ten);
        setupButton(R.id.score9, Score.Nine);
        setupButton(R.id.score8, Score.Eight);
        setupButton(R.id.score7, Score.Seven);
        setupButton(R.id.score6, Score.Six);
        setupButton(R.id.score5, Score.Five);
        setupButton(R.id.score4, Score.Four);
        setupButton(R.id.score3, Score.Three);
        setupButton(R.id.score2, Score.Two);
        setupButton(R.id.score1, Score.One);
        setupButton(R.id.scoreM, Score.Miss);
    }

    public void setupButton(int res, final Score buttonScore) {
        Button button = (Button) findViewById(res);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickScore(buttonScore);
            }
        });
    }

    public void onClickScore(Score score) {
        arrow = arrow % arrows.length;

        TextView view = (TextView) findViewById(arrows[arrow]);
        view.setText(score.display);
        scores[arrow] = score;

        arrow++;

        int value = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != null) {
                value += scores[i].points;
            }
        }

        finalScore.setText(String.valueOf(value));
    }
}
