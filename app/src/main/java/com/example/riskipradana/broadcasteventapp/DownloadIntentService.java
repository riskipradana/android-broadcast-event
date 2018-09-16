package com.example.riskipradana.broadcasteventapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class DownloadIntentService extends IntentService {

    public static final String TAG = "DownloadIntentService";

    public DownloadIntentService() {
        super("DownloadIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.d(TAG, "Download Intent Service Started");

        if (intent != null) {
           try {
               Thread.sleep(5000);
           }catch (InterruptedException e){
               e.printStackTrace();
           }

           //broadcast event -> dengan action yang telah ditentukan (ACTION_DOWNLOAD_STATUS)
           Intent notifyFinishIntent = new Intent(MainActivity.ACTION_DOWNLOAD_STATUS);
           sendBroadcast(notifyFinishIntent);
        }
    }
}
