package com.example.myandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);



        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        String joke = getIntent().getStringExtra(INTENT_EXTRA_JOKE);
        TextView jokeTextView = findViewById(R.id.jokeText);
        if (jokeTextView != null) {
            jokeTextView.setText(joke);
        }
    }
}
