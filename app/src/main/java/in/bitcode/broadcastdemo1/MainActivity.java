package in.bitcode.broadcastdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mBrDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBrDemo = new DemoBR();

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
        intentFilter.addAction("in.bitcode.media.download.COMPLETE");
        registerReceiver(mBrDemo, intentFilter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mBrDemo);
        super.onDestroy();
    }
}