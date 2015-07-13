package susanhenr.com.proyectojedi;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

/**
 * Created by susanhenriquez on 9/7/15.
 */
public class BoundService extends Service {
    public int código = 0;

    private final IBinder binder = new MyBinder();
    MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    public IBinder onBind(Intent intent) {


        try {
            Uri myUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.song);
           mediaPlayer.setDataSource(getApplicationContext(),myUri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void play(){
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            Log.v("entrooo",código+"");
        }
    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return super.bindService(service, conn, flags);
    }


    public class MyBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }

        public IBinder onBind(Intent arg0) {
            return binder;
        }

        public void onDestroy() {
            //TODO código para liberar recursos
        }

    }
}