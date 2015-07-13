package susanhenr.com.proyectojedi;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Registro extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
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
            case R.id.button3:
                TextView newusuario = (TextView) findViewById(R.id.nuevousuario);
                TextView newcontraseña = (TextView) findViewById(R.id.nuevacontraseña);
                String usuario = newusuario.getText().toString();
                String contraseña = newcontraseña.getText().toString();

                IntentsOpenHelper ioh = new IntentsOpenHelper(getApplicationContext());
                SQLiteDatabase db = ioh.getWritableDatabase();
                if(db != null){
                   ioh.registro(usuario, contraseña, db);
                    Intent intent = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent);
                    db.close();
                }
                break;
        }
    }


}
