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
    //EditText r = (EditText) findViewById(R.id.resultado); NUNCA INICIALIZAR AQUI
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
            Log.v("orientacion", String.valueOf(newConfig.orientation));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
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
            case R.id.action_llamada:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:934137660"));
                startActivity(intent);
            //    return true;
             break;
            case R.id.action_navegador:
                Uri url = Uri.parse("http://jediupc.com/");
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, url);
                startActivity(launchBrowser);

               // return true;
                break;
            case R.id.action_toast:
                estoast = true;
               // return true;
                break;
            case R.id.action_deestado:
                estoast = false;
                //return true;
                break;
            case R.id.action_logout:
                finish();
            //    return true;
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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        EditText r3 = (EditText) findViewById(R.id.resultado);
        r3.setText(savedInstanceState.getString("resultado"));
        num1 = savedInstanceState.getInt("num1");
       // num1 = savedInstanceState.getInt("resultado");
        Log.v("resultadoOnRestore",savedInstanceState.getString("resultado"));
        //Log.v("valornum1",String.valueOf(num1));
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
                /*if(!n1) {
                    num1 = 0;
                    n1 = true;
                }
                else {
                    num2 = 0;
                    n2 = true;
                }*/
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
                Log.d("num1delcero",String.valueOf(num1));
                Log.d("num2delcero",String.valueOf(num2));

                //   EditText r = (EditText) findViewById(R.id.resultado);
                // r.setText("0",TextView.BufferType.EDITABLE);
                  break;
            case R.id.boton1:
                /*if(!n1){
                    num1 = 1;
                    n1 = true;
                }
                else {
                    num2 = 1;
                    n2 = true;
                }*/
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
                Log.d("num1deluno",String.valueOf(num1));
                Log.d("num2deluno",String.valueOf(num2));
                // EditText r1 = (EditText) findViewById(R.id.resultado);
                //r1.setText("1",TextView.BufferType.EDITABLE);
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
                /*if(!n1){
                    num1 = 2;
                    n1 = true;
                }

                else {
                    num2 = 2;
                    n2 = true;
                }*/
                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.boton3:
                /*if(!n1){
                    num1 = 3;
                    n1 = true;
                }
                else {
                    num2 = 3;
                    n2 = true;
                }*/
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
                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.boton4:
                /*if(!n1) {
                    num1 = 4;
                    n1 = true;
                }
                else {
                    num2 = 4;
                    n2 = true;
                }*/
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

                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.boton5:
               /* if(!n1){
                    num1 = 5;
                    n1 = true;
                }
                else{
                    num2 = 5;
                    n2 = true;
                }*/
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

                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.boton6:
                /*if(!n1) {
                    num1 = 6;
                    n1 = true;
                }
                else {
                    num2 = 6;
                    n2 = true;
                }*/
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


                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.boton7:
               /* if(!n1) {
                    num1 = 7;
                    n1 = true;
                }
                else {
                    num2 = 7;
                    n2 = true;
                }*/
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

                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.boton8:
               /* if(!n1) {
                    num1 = 8;
                    n1 = true;
                }
                else {
                    num2 = 8;
                    n2 = true;
                }
*/
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
                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.boton9:
                /*if(!n1) {
                    num1 = 9;
                    n1 = true;
                }
                else {
                    num2 = 9;
                    n2 = true;
                }*/
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

                Log.d("num1",String.valueOf(num1));
                Log.d("num2",String.valueOf(num2));
                break;
            case R.id.botonsuma:
                signo = "+";

                Log.d("signo",signo);
                break;
            case R.id.botonresta:
                signo = "-";
                Log.d("signo",signo);
                break;
            case R.id.botondivision:
                signo = "/";
                Log.d("signo",signo);
                break;
            case R.id.botonmultiplicacion:
                signo = "*";
                Log.d("signo",signo);
                break;
            case R.id.botonigual:
                if(signo.equals("+")){
                    res= num1+num2;
                    signo = "vacio";
                    num1 = res;
                    Log.d("res",String.valueOf(res));

                }
                if(signo.equals("-")){
                    res= num1-num2;
                    signo = "vacio";
                    num1 = res;
                    Log.d("res",String.valueOf(res));
                }
                if(signo.equals("/")){

                    if(num2 == 0) {
                        if(estoast){
                            Toast.makeText(Calculadora.this, "ERROR: División entre 0", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


                            // Para la notificaciones, en lugar de crearlas directamente, lo hacemos mediante
                            // un Builder/contructor.
                            NotificationCompat.Builder mBuilder =
                                    new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.sunny35).setContentTitle("Error").setContentText("División entre 0");


                            // Creamos un intent explicito, para abrir la app desde nuestra notificaci�n
                            Intent resultIntent = new Intent(getApplicationContext(), Calculadora.class);

                            //El objeto stack builder contiene una pila artificial para la Acitivty empezada.
                            //De esta manera, aseguramos que al navegar hacia atr�s
                            //desde la Activity nos lleve a la home screen.

                            //Desde donde la creamos
                            TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                            // A�ade la pila para el Intent,pero no el intent en s�
                            stackBuilder.addParentStack(Calculadora.class);
                            // A�adimos el intent que empieza la activity que est� en el top de la pila
                            stackBuilder.addNextIntent(resultIntent);

                            //El pending intent ser� el que se ejecute cuando la notificaci�n sea pulsada
                            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                            mBuilder.setContentIntent(resultPendingIntent);

                            // mId nos permite actualizar las notificaciones en un futuro
                            // Notificamos
                            mNotificationManager.notify(1, mBuilder.build());
                           // Log.v("alguna vez entro",estoast+"");
                        }


                       /* AlertDialog alertDialog;
                        alertDialog = new AlertDialog.Builder(this).create();
                        alertDialog.setTitle("División entre 0");
                        alertDialog.setMessage("ERROR");
                        alertDialog.show();*/
                    }
                    else res= num1/num2;
                    signo = "vacio";
                    num1 = res;
                    Log.d("res",String.valueOf(res));
                }
                if(signo.equals("*")){
                    res= num1*num2;
                    signo = "vacio";
                    num1 = res;
                    Log.d("res",String.valueOf(res));
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
