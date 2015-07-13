package susanhenr.com.proyectojedi;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Login extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button) findViewById(R.id.button20);
        button.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        usuario.setText(savedInstanceState.getString("usuario"));
        contraseña.setText(savedInstanceState.getString("contraseña"));

        Log.v("resultadoOnRestoreUs", savedInstanceState.getString("usuario"));
        Log.v("resultadoOnRestoreCo", savedInstanceState.getString("contraseña"));


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        EditText usuario = (EditText) findViewById(R.id.usuario);
        outState.putString("usuario",usuario.getText().toString());
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        outState.putString("contraseña", contraseña.getText().toString());

        Log.v("resultadoOnSaveUs", usuario.getText().toString());
        Log.v("resultadoOnSaveCo", contraseña.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button20:
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                Bundle b = new Bundle();
                EditText vUsuario = (EditText) findViewById(R.id.usuario);
                EditText vContraseña = (EditText) findViewById(R.id.contraseña);
                String usuario = vUsuario.getText().toString();
                String contraseña = vContraseña.getText().toString();
                b.putString("usuario",usuario);
                b.putString("contraseña",contraseña);
                intent.putExtra("login", b);

                IntentsOpenHelper ioh = new IntentsOpenHelper(getApplicationContext());
                SQLiteDatabase db = ioh.getWritableDatabase();
                if(db != null){
                    Cursor c = ioh.login(usuario,contraseña,db);
                    if(c.moveToFirst()){
                        Log.v("teodio",usuario);
                        String con = c.getString( c.getColumnIndex("contraseña") );
                       if(con.equals(contraseña) ) {
                           startActivity(intent);
                       }
                        else {
                           Log.v("teodio",c.getColumnIndex("contraseña") +"");
                           AlertDialog alertDialog;
                           alertDialog = new AlertDialog.Builder(this).create();
                           alertDialog.setTitle("Mensaje");
                           alertDialog.setMessage("Contraseña incorrecta");
                           alertDialog.show();
                       }
                    }
                    else{
                        AlertDialog alertDialog;
                        alertDialog = new AlertDialog.Builder(this).create();
                        alertDialog.setTitle("Mensaje");
                        alertDialog.setMessage("Usuario incorrecto");
                        alertDialog.show();
                    }
                    db.close();
                }

                break;
            case R.id.button2:
                Intent intent1 = new Intent(getApplicationContext(),Registro.class);
                startActivity(intent1);
                break;
        }
    }
}
