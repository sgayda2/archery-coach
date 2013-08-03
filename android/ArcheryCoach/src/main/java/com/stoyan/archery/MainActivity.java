package com.stoyan.archery;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * Created by Stoyan Gaydarov on 7/31/13.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, PracticeActivity.class);
        Practice practice = MemoryStorage.getInstance().startNewPracticeRound();
        intent.putExtra("practice_id", practice.getId());
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
