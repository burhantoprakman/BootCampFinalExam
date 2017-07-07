package bt.bootcampfinalexam.genelkodActivities.uygulama_gelistirme_activities.receiverservicesorusu;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import bt.bootcampfinalexam.R;

/**
 * Created by ${Burhan} on 23.06.2017.
 * burhantoprakman@gmail.com
 */

public class OpenSoundService extends Service {

    private final String TAG = "Android Service Demo";
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        Toast.makeText(this, "Close Sound Servis Olusturuldu", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
        mediaPlayer = MediaPlayer.create(this, R.raw.microsoft_startup_sound);

        //surekli calmaya devam etmesin diye.
        mediaPlayer.setLooping(false);

        //sound bittiginde servisi destroy et.

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Servis Sonlandırıldı.", Toast.LENGTH_LONG).show();

        mediaPlayer.stop();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //servis basladiginda yapilacaklar.
        Toast.makeText(this, "Service Başladı.", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
        mediaPlayer.start();
        return START_STICKY;
    }
}