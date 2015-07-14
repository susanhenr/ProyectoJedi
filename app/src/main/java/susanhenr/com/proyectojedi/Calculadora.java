package susanhenr.com.proyectojedi;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Calculadora extends ActionBarActivity implements View.OnClickListener {
    int res;
    int num1;
    int num2;
    boolean n1 = false;
    boolean n2 = false;
    String signo = "vacio";
    boolean estoast = false;


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            getActionBar().hide();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        ActionBar a = getSupportActionBar();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            if (a != null) a.hide();
        }
        else {
            if (a != null) a.show();
            Log.v("OCC", "Hide");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        switch (item.getItemId()){
            case R.id.action_settings:
                //return true;
            break;
            case R.id.action_modonotificaciones:

                //return true;
            break;

            //CÓDIGO LLAMADA
            case R.id.action_llamada:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:934137660"));
                startActivity(intent);
             break;
            //CÓDIGO NAVEGADOR
            case R.id.action_navegador:
                Uri url = Uri.parse("http://jediupc.com/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, url);
                startActivity(launchBrowser);

                break;
            case R.id.action_toast:
                estoast = true;
                break;
            case R.id.action_deestado:
                estoast = false;

                break;
            case R.id.action_logout:
                finish();
             break;

           // break;
           // return super.onOptionsItemSelected(item);
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

    //CÓDIGO PARA PERSISTENCIA AL GIRAR LA PANTALLA

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText r3 = (EditText) findViewById(R.id.resultado);
        r3.setText(savedInstanceState.getString("resultado"));
        num1 = savedInstanceState.getInt("num1");
        Log.v("resultadoOnRestore",savedInstanceState.getString("resultado"));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //super.onSaveInstanceState(outState);
        EditText r2 = (EditText) findViewById(R.id.resultado);
        outState.putString("resultado",r2.getText().toString());
        outState.putInt("num1",num1);
        Log.v("resultadoOnSave",r2.getText().toString());
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

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton0:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 0;
                        n1 = true;
                    }
                    else num1 = num1*10;
                }
                else{
                    if(!n2){
                        num2 = 0;
                        n2 = true;
                    }
                    else num2 = num2*10;
                }
                  break;
            case R.id.boton1:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 1;
                        n1 = true;
                    }
                    else num1 = (num1*10)+1;
                }
                else{
                    if(!n2){
                        num2 = 1;
                        n2 = true;
                    }
                    else num2 = (num2*10)+1;
                }
                break;
            case R.id.boton2:
                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 2;
                        n1 = true;
                    }
                    else num1 = (num1*10)+2;
                }
                else{
                    if(!n2){
                        num2 = 2;
                        n2 = true;
                    }
                    else num2 = (num2*10)+2;
                }
                break;
            case R.id.boton3:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 3;
                        n1 = true;
                    }
                    else num1 = (num1*10)+3;
                }
                else{
                    if(!n2){
                        num2 = 3;
                        n2 = true;
                    }
                    else num2 = (num2*10)+3;
                }
                break;
            case R.id.boton4:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 4;
                        n1 = true;
                    }
                    else num1 = (num1*10)+4;
                }
                else{
                    if(!n2){
                        num2 = 4;
                        n2 = true;
                    }
                    else num2 = (num2*10)+4;
                }

                break;
            case R.id.boton5:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 5;
                        n1 = true;
                    }
                    else num1 = (num1*10)+5;
                }
                else{
                    if(!n2){
                        num2 = 5;
                        n2 = true;
                    }
                    else num2 = (num2*10)+5;
                }

                break;
            case R.id.boton6:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 6;
                        n1 = true;
                    }
                    else num1 = (num1*10)+6;
                }
                else{
                    if(!n2){
                        num2 = 6;
                        n2 = true;
                    }
                    else num2 = (num2*10)+6;
                }


                break;
            case R.id.boton7:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 7;
                        n1 = true;
                    }
                    else num1 = (num1*10)+7;
                }
                else{
                    if(!n2){
                        num2 = 7;
                        n2 = true;
                    }
                    else num2 = (num2*10)+7;
                }

                break;
            case R.id.boton8:

                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 8;
                        n1 = true;
                    }
                    else num1 = (num1*10)+8;
                }
                else{
                    if(!n2){
                        num2 = 8;
                        n2 = true;
                    }
                    else num2 = (num2*10)+8;
                }
                break;
            case R.id.boton9:
                if(signo.equals("vacio")){
                    if(!n1){
                        num1 = 9;
                        n1 = true;
                    }
                    else num1 = (num1*10)+9;
                }
                else{
                    if(!n2){
                        num2 = 9;
                        n2 = true;
                    }
                    else num2 = (num2*10)+9;
                }

                break;
            case R.id.botonsuma:
                signo = "+";

                break;
            case R.id.botonresta:
                signo = "-";
                break;
            case R.id.botondivision:
                signo = "/";
                break;
            case R.id.botonmultiplicacion:
                signo = "*";
                break;
            case R.id.botonigual:
                if(signo.equals("+")){
                    res= num1+num2;
                    signo = "vacio";
                    num1 = res;

                }
                if(signo.equals("-")){
                    res= num1-num2;
                    signo = "vacio";
                    num1 = res;
                }
                if(signo.equals("/")){

                    if(num2 == 0) {
                        if(estoast){
                            //CÓDIGO NOTIFICACIÓN TOAST
                            Toast.makeText(Calculadora.this, "ERROR: División entre 0", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //código NOTIFICACIONES DE ESTADO
                            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


                            NotificationCompat.Builder mBuilder =
                                    new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.sunny35).setContentTitle("Error").setContentText("División entre 0");


                            Intent resultIntent = new Intent(getApplicationContext(), Calculadora.class);

                            TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                            stackBuilder.addParentStack(Calculadora.class);
                            stackBuilder.addNextIntent(resultIntent);

                            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                            mBuilder.setContentIntent(resultPendingIntent);

                            mNotificationManager.notify(1, mBuilder.build());
                        }


                    }
                    else res= num1/num2;
                    signo = "vacio";
                    num1 = res;
                }
                if(signo.equals("*")){
                    res= num1*num2;
                    signo = "vacio";
                    num1 = res;
                }
                EditText r = (EditText) findViewById(R.id.resultado);
                r.setText(String.valueOf(res));
                n1 = false;
                n2 = false;
                break;
            case R.id.llamada:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:934137660"));
                startActivity(intent);
                break;
            case R.id.botonc:
                num1 = 0;
                num2 = 0;
                n1 = false;
                n2 = false;
                signo = "vacio";
                EditText r1 = (EditText) findViewById(R.id.resultado);
                r1.setText(String.valueOf(""));
                break;


        }
    }
}
