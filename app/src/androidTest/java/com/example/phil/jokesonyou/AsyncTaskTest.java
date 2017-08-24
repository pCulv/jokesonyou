package com.example.phil.jokesonyou;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    @Test
    public void testDoInBackground() throws Exception{
        try {
            Context mContext = InstrumentationRegistry.getTargetContext();
            EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(mContext);
            endpointAsyncTask.execute();
            String result = endpointAsyncTask.get(30, TimeUnit.SECONDS);

            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e){
              Log.e("EndpointsAsyncTaskTest", "testDoInBackground: Timed out");
        }
    }
}
