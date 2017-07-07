package bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.adimsayar;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import bt.bootcampfinalexam.R;

public class AdimSayarActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {

    private SensorManager sensorManager;
    private TextView count;
    boolean activityRunning;
    private Button btn_sayacSifirla;
    private int stepsInSensor = 0;
    private int stepsAtReset;
private  String myPref;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adim_sayar);
        count = (TextView) findViewById(R.id.txt);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        btn_sayacSifirla= (Button) findViewById(R.id.btn_adimsifirla);
        btn_sayacSifirla.setOnClickListener(this);


    }

    void onCreate() {
        SharedPreferences prefs = getSharedPreferences(myPref, MODE_PRIVATE);
        stepsAtReset = prefs.getInt("stepsAtReset", 0);
    }
    public void onClick(View v) {
        stepsAtReset = stepsInSensor;

        SharedPreferences.Editor editor =
                getSharedPreferences(myPref, MODE_PRIVATE).edit();
        editor.putInt("stepsAtReset", stepsAtReset);
        editor.commit();

        // you can now display 0:
        count.setText(String.valueOf(0));
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityRunning = true;

        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Adım sayamıyor!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
        sensorManager.unregisterListener(this);


    }

    @Override
    public void onSensorChanged(final SensorEvent event) {

        if (activityRunning) {
            stepsInSensor = Integer.valueOf((int) event.values[0]);
            int stepsSinceReset = stepsInSensor - stepsAtReset;
            count.setText(String.valueOf(stepsSinceReset));
            int aa= Integer.parseInt(count.getText().toString());

            if(aa==10){
                Toast.makeText(this, "Tebrikler", Toast.LENGTH_LONG).show();
                onPause();
            }
        }else{
            event.values[0] = 0;
        }
        }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

}
