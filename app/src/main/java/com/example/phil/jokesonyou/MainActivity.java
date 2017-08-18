package com.example.phil.jokesonyou;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.MyJokes;
import com.example.myandroidlibrary.JokeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        String jokeExtra = MyJokes.getJoke();

        Intent newJoke = new Intent(this, JokeActivity.class);
        newJoke.putExtra("joke", jokeExtra);
        startActivity(newJoke);
    }

    private class EndpointsAsyncTask extends AsyncTask<String, Void, String> {
        private MyApi myApiService = null;

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}
