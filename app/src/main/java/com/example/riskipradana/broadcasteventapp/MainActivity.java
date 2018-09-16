package com.example.riskipradana.broadcasteventapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String ACTION_DOWNLOAD_STATUS = "Download Status";
    private BroadcastReceiver downloadReceiver;
    private Button btnDonwload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Incoming Message");
        btnDonwload = findViewById(R.id.btn_download);
        btnDonwload.setOnClickListener(this);
        //receive broadcast
        downloadReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Download Finis!", Toast.LENGTH_SHORT).show();
            }
        };
        //downloadReceiver registered -> so can receive event/action -> with (ACTION_DOWNLOAD_STATUS) Tag
        IntentFilter downloadIntentFilter = new IntentFilter(ACTION_DOWNLOAD_STATUS);
        registerReceiver(downloadReceiver, downloadIntentFilter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_download){
            Intent downloadServiceIntent = new Intent(this, DownloadIntentService.class);
            startService(downloadServiceIntent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(downloadReceiver != null){
            unregisterReceiver(downloadReceiver);
        }
    }
}
