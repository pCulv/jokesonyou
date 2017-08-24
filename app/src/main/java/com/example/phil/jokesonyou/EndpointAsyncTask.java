package com.example.phil.jokesonyou;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.MyJokes;
import com.example.myandroidlibrary.JokeActivity;
import com.example.phil.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;


public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    public EndpointAsyncTask(Context context) {
        this.mContext = context;

    }

    @Override
    protected String doInBackground(Void... params){
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi
                    .Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result != null) {
            Intent newJoke = new Intent(mContext, JokeActivity.class);
            newJoke.putExtra("joke", result);
            mContext.startActivity(newJoke);
        }
    }
}
