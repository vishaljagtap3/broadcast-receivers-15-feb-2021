package in.bitcode.broadcastdemo1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class DemoBR extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            String message = intent.getBooleanExtra("state", false) ? "Airplane Mode ON" : "Airplane Mode OFF";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
        if (intent.getAction().equals("in.bitcode.media.download.COMPLETE")) {
            Toast.makeText(context, intent.getAction() +  "\n" + intent.getStringExtra("path"), Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(context, intent.getAction(), Toast.LENGTH_LONG).show();
        }
    }

}
