package susanhenr.com.proyectojedi;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class Musica extends Activity implements View.OnClickListener{

    BoundService bService;
    boolean bound = false;

    private ServiceConnection connection = new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName className, IBinder my_binder){
        BoundService.MyBinder binder = (BoundService.MyBinder) my_binder;
          bService = binder.getService();
            bound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0){
            bound = false;
        }


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        ImageView iv2= (ImageView)findViewById(R.id.imageView2);

        ImageView iv3= (ImageView)findViewById(R.id.imageView3);

        ImageView iv4= (ImageView)findViewById(R.id.imageView4);

        Intent intent = new Intent(Musica.this, BoundService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_musica, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.imageButton):
                if(bound){
                    Log.v("entrooo", bound + "");
                    bService.play();
                }
                break;
            case(R.id.imageButton2):
                break;
            case(R.id.imageButton3):
                break;
        }
    }
}
