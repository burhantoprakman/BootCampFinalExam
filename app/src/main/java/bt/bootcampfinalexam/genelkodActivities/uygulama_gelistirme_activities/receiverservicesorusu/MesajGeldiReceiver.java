package bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.receiverservicesorusu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

import java.util.Objects;

public class MesajGeldiReceiver extends BroadcastReceiver {
    final SmsManager sms = SmsManager.getDefault();


    @Override
    public void onReceive(Context context, Intent intent) {
        final Bundle bundle = intent.getExtras();
        try {

            String state = intent.getExtras().getString("extra");
            //String numb="+905053665620";
            String numb="+905316266902";


            if (bundle != null) {

                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();



                if(Objects.equals(senderNum, numb)){
                        Intent bootUp = new Intent(context, OpenSoundService.class);
                        context.startService(bootUp);
                }

                } // end for loop
            } // bundle is null

        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);

        }
    }
}
