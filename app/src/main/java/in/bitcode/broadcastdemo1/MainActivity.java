package in.bitcode.broadcastdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver mBrDemo;
    private Button mBtnRegisterBR;

    private BroadcastReceiver mBREvent = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText( context, "Sticky: " + intent.getAction(), Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnRegisterBR = findViewById(R.id.btnRegisterBR);
        mBtnRegisterBR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentFilter intentFilter = new IntentFilter("in.bitcode.some.EVENT");
                registerReceiver(mBREvent, intentFilter);
            }
        });

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