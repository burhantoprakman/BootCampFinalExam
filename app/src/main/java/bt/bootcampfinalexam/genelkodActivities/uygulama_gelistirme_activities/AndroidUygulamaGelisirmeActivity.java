package bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import bt.bootcampfinalexam.R;
import bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.adimsayar.AdimSayarActivity;
import bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.firebasegetdata.FirebaseGetDataActivity;
import bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.firebaselogin.FirebaseActivity;
import bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.receiverservicesorusu.ReceiverActivity;
import bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.TemelSQLSorusu.TemelSQLActivity;

public class AndroidUygulamaGelisirmeActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_uygulama_gelisirme);
    }

    public void temelSql(View view) {
        intent = new Intent(this, TemelSQLActivity.class);
        startActivity(intent);

    }


    public void webapi(View view) {
        intent = new Intent(this, FirebaseGetDataActivity.class);
        startActivity(intent);

    }

    public void receiver(View view) {
        intent = new Intent(this, ReceiverActivity.class);
        startActivity(intent);

    }


    public void adimsayar(View view) {
        intent = new Intent(this, AdimSayarActivity.class);
        startActivity(intent);

    }

    public void firebase(View view) {
        intent = new Intent(this, FirebaseActivity.class);
        startActivity(intent);

    }

}
