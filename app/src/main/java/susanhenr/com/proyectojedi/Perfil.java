package susanhenr.com.proyectojedi;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;


public class Perfil extends ActionBarActivity implements View.OnClickListener{

    private static final int SELECT_PICTURE = 1;

    private String selectedImagePath;
    public Uri selectedImageUri;
    private ImageView img;
String h;
    List<Address> l;
    LocationManager lm;
    LocationListener lis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        l = null;
        setContentView(R.layout.activity_perfil);
        //Depende del import utilizado, deberás usar getActionBar()
        ActionBar a = getSupportActionBar();
        //Aquí comprobamos la orientación del telefono en el momento del oncreate.
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Debemos comprobar si la action bar es null
            if (a != null) a.hide();
            Log.v("OCC", "Hide");
        }
        else {
            if (a != null) a.show();
            Log.v("OCC", "Hide");
        }
//  CÓDIGO PARA OBTENER USUARIO QUE HIZO LOGIN

        TextView textusu = (TextView) findViewById(R.id.textView5);
        TextView textpunt = (TextView) findViewById(R.id.textView9);
        SharedPreferences sp  = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String u = sp.getString("usuariologin","");
        Log.v("usuario",u);
        textusu.setText(u);

        //CÓDIGO PARA OBTENER LA MEJOR PUNTUACIÓN
        //Busco en la base de datos el usuario que tengo en login y obtengo su puntuación



        IntentsOpenHelper ioh = new IntentsOpenHelper(getApplicationContext());
        SQLiteDatabase db = ioh.getWritableDatabase();
        if(db != null) {
            boolean result = false;


            Cursor c = ioh.getpuntuacion(textusu.toString(), db);
            if(c!=null && c.getCount()>0) {
                if (c.moveToFirst()) {
                    String punt = c.getString(c.getColumnIndex("puntuacion"));
                    textpunt.setText(punt);
                }
            }
        }

        //CÓDIGO GPS
        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lis = new LocationListener() {


            @Override
            public void onStatusChanged(String provider, int status,
                                        Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }

            @Override
            public void onLocationChanged(Location location) {
                // TODO Auto-generated method stub
                //Log.v("teodiogps", h);
                Geocoder gc = new Geocoder(getApplicationContext());
                try {
                    l = gc.getFromLocation(location.getLatitude(),
                            location.getLongitude(), 5);
                    Log.v("teodiogps", l.size()+"");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < l.size(); ++i) {
                    Log.v("LOGgay", l.get(i).getAddressLine(0).toString());
                    TextView t = (TextView) findViewById(R.id.textView15);
                    if(i==0) t.setText("");
                    t.setText(t.getText()+"\n"+l.get(i).getAddressLine(0).toString());
                }
                Log.v("LOG", ((Double) location.getLatitude()).toString());
            }
        };

        if (lm.getAllProviders().contains(LocationManager.NETWORK_PROVIDER))
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, lis);

        if (lm.getAllProviders().contains(LocationManager.GPS_PROVIDER))
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, lis);

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
       img = (ImageView)findViewById(R.id.imageView);

        String uris = savedInstanceState.getString("img");

        img.setImageURI(Uri.parse(uris));



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
      Uri s = selectedImageUri;
        outState.putString("img", s + "");

        super.onSaveInstanceState(outState);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
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
        switch (v.getId()){
            case R.id.button4:
                selectImage();
                break;
        }
    }

    //CÓDIGO PARA SELECCIÓN DE LA FOTO
    //SE PUEDE INGRESAR A LA OPCIÓN DE IMPORTAR FOTO DESDE LA CÁMARA PERO NO GUARDA LA IMAGEN. ( ERA OPCIONAL)

    private void selectImage() {
        img = (ImageView)findViewById(R.id.imageView);

        final CharSequence[] options = { "Tomar una foto", "Elegir de la galeria","Cancelar" };

        AlertDialog.Builder builder = new AlertDialog.Builder(Perfil.this);
        builder.setTitle("Añade una foto!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Tomar una foto"))
                {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    startActivityForResult(intent, 1);
                }
                else if (options[item].equals("Elegir de la galeria"))
                {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent,"Select Picture"),1);

                }
                else if (options[item].equals("Cancelar")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                 selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                System.out.println("Image Path : " + selectedImagePath);
                img.setImageURI(selectedImageUri);
            }
        }
    }
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
    @Override
    protected void onPause(){
       lm.removeGpsStatusListener((GpsStatus.Listener) lis);
        super.onPause();
    }

}
