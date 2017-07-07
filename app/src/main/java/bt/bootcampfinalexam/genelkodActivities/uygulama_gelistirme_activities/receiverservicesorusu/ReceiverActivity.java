package bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.receiverservicesorusu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bt.bootcampfinalexam.R;

public class ReceiverActivity extends AppCompatActivity implements View.OnClickListener {
  //  EditText numara;
  //  Button btnsave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Intent intent=new Intent();
        intent.setAction("android.provider.Telephony.SMS_RECEIVED");
        sendBroadcast(intent);



      // numara= (EditText) findViewById(R.id.edtnumb);
      // btnsave= (Button) findViewById(R.id.btnn);
      // btnsave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      //  Intent intent = new Intent("numara");
      //  intent.putExtra("extra", numara.getText().toString());
      //  Intent intent=new Intent();
      //  intent.setAction("android.provider.Telephony.SMS_RECEIVED");
      //  sendBroadcast(intent);
    }
}
