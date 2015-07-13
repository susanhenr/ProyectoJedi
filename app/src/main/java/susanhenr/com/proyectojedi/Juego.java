package susanhenr.com.proyectojedi;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class Juego extends ActionBarActivity implements View.OnClickListener{
    String uriuno = "drawable/uno";
    String uridos = "drawable/dos";
    String uritres = "drawable/tres";
    String uricuatro = "drawable/cuatro";
    String uricinco = "drawable/cinco";
    String uriseis = "drawable/seis";
    String urisiete = "drawable/siete";
    String uriocho = "drawable/ocho";
    boolean bo1 = false;
    boolean bo2 = false;
    boolean bo3 = false;
    boolean bo4= false;
    boolean bo5= false;
    boolean bo6= false;
    boolean bo7= false;
    boolean bo8= false;
    boolean bo9= false;
    boolean bo10= false;
    boolean bo11= false;
    boolean bo12= false;
    boolean bo13= false;
    boolean bo14= false;
    boolean bo15= false;
    boolean bo16= false;

    ImageButton b1;
    ImageButton b2;
    ImageButton b3;
    ImageButton b4;
    ImageButton b5;
    ImageButton b6;
    ImageButton b7;
    ImageButton b8;
    ImageButton b9;
    ImageButton b10;
    ImageButton b11;
    ImageButton b12;
    ImageButton b13;
    ImageButton b14;
    ImageButton b15;
    ImageButton b16;

    int id1 = -1;
    int id2 = -1;
    int id3 = -1;
    int id4 = -1;
    int id5 = -1;
    int id6 = -1;
    int id7 = -1;
    int id8 = -1;
    int id9 = -1;
    int id10 = -1;
    int id11= -1;
    int id12 = -1;
    int id13 = -1;
    int id14 = -1;
    int id15 = -1;
    int id16 = -1;


    int random;
    int i;
    TextView puntuacion;
    int x;
    int y;

    boolean bx;
    boolean by;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
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

      b1 = (ImageButton) findViewById(R.id.m1);
       b2 = (ImageButton) findViewById(R.id.m2);
        b3= (ImageButton) findViewById(R.id.m3);
        b4= (ImageButton) findViewById(R.id.m4);
        b5= (ImageButton) findViewById(R.id.m5);
        b6= (ImageButton) findViewById(R.id.m6);
        b7= (ImageButton) findViewById(R.id.m7);
        b8= (ImageButton) findViewById(R.id.m8);
        b9= (ImageButton) findViewById(R.id.m9);
        b10= (ImageButton) findViewById(R.id.m10);
        b11= (ImageButton) findViewById(R.id.m11);
        b12= (ImageButton) findViewById(R.id.m12);
       b13= (ImageButton) findViewById(R.id.m13);
        b14= (ImageButton) findViewById(R.id.m14);
       b15= (ImageButton) findViewById(R.id.m15);
       b16= (ImageButton) findViewById(R.id.m16);



        puntuacion = (TextView) findViewById(R.id.textView13);

        for(i = 1; i<= 16; ++i){
            random = (int) Math.floor(Math.random()*(1-16+1)+16);
            boolean ok = todocorrecto(random,i);
            while(!ok){
                random = (int) Math.floor(Math.random()*(1-16+1)+16);
                ok = todocorrecto(random,i);
            }

        }


    }

    private boolean todocorrecto(int random, int i){
        if(random == 1){
            if(!bo1){
                Context context = b1.getContext();
                int id= obtenerid(i,context);
                b1.setImageResource(id);
                id1 = i;
              /*  if(i == 1){
                    Context context = b1.getContext();
                    int id = context.getResources().getIdentifier(uriuno, "drawable",
                            context.getPackageName());
                    b1.setImageResource(id);
                }
                else if(i==2){

                }*/
            }
            else return false;
        }
        else if (random == 2){
            if(!bo2){
                Context context = b2.getContext();
                int id= obtenerid(i,context);
                b2.setImageResource(id);
                id2 = i;

            }
            else return false;

        }
        else if (random == 3){
            if(!bo3){
                Context context = b3.getContext();
                int id= obtenerid(i,context);
                b3.setImageResource(id);
                id3 = i;

            }
            else return false;

        }
        else if (random == 4){
            if(!bo4){
                Context context = b4.getContext();
                int id= obtenerid(i,context);
                b4.setImageResource(id);
                id4 = i;

            }
            else return false;

        }
        else if (random == 5){
            if(!bo5){
                Context context = b5.getContext();
                int id= obtenerid(i,context);
                b5.setImageResource(id);
                id5 = i;
            }
            else return false;

        }
        else if (random == 6){
            if(!bo6){
                Context context = b6.getContext();
                int id= obtenerid(i,context);
                b6.setImageResource(id);
                id6 = i;
            }
            else return false;

        }
        else if (random == 7){
            if(!bo7){
                Context context = b7.getContext();
                int id= obtenerid(i,context);
                b7.setImageResource(id);
                id7 = i;
            }
            else return false;

        }
        else if (random == 8){
            if(!bo8){
                Context context = b8.getContext();
                int id= obtenerid(i,context);
                b8.setImageResource(id);
                id8 = i;
            }
            else return false;

        }
        else if (random == 9){
            if(!bo9){
                Context context = b9.getContext();
                int id= obtenerid(i,context);
                b9.setImageResource(id);
                id9 = i;
            }
            else return false;
        }
        else if (random == 10){
            if(!bo10){
                Context context = b10.getContext();
                int id= obtenerid(i,context);
                b10.setImageResource(id);
                id10 = i;
            }
            else return false;

        }
        else if (random == 11){
            if(!bo11){
                Context context = b11.getContext();
                int id= obtenerid(i,context);
                b11.setImageResource(id);
                id11 = i;
            }
            else return false;

        }
        else if (random == 12){
            if(!bo12){
                Context context = b12.getContext();
                int id= obtenerid(i,context);
                b12.setImageResource(id);
                id12 = i;
            }
            else return false;

        }
        else if (random == 13){
            if(!bo13){
                Context context = b13.getContext();
                int id= obtenerid(i,context);
                b13.setImageResource(id);
                id13 = i;
            }
            else return false;
        }
        else if (random == 14){
            if(!bo14){
                Context context = b14.getContext();
                int id= obtenerid(i,context);
                b14.setImageResource(id);
                id14 = i;
            }
            else return false;
        }
        else if (random == 15){
            if(!bo15){
                Context context = b15.getContext();
                int id= obtenerid(i,context);
                b15.setImageResource(id);
                id15 = i;
            }
            else return false;
        }
        else if (random == 16){
            if(!bo16){
                Context context = b16.getContext();
                int id= obtenerid(i,context);
                b16.setImageResource(id);
                id16 = i;
            }
            else return false;
        }
        return false;
    }

    private int obtenerid(int i, Context context) {
        int id = -1;
        if(i==1){
            id = context.getResources().getIdentifier(uriuno, "drawable",
                    context.getPackageName());
        }
        else if (i==2){

            id = context.getResources().getIdentifier(uridos, "drawable",
                    context.getPackageName());

        }
        else if (i==3){

            id = context.getResources().getIdentifier(uritres, "drawable",
                    context.getPackageName());

        }
        else if (i==4){

            id = context.getResources().getIdentifier(uricuatro, "drawable",
                    context.getPackageName());

        }
        else if (i==5){

            id = context.getResources().getIdentifier(uricinco, "drawable",
                    context.getPackageName());

        }
        else if (i==6){

            id = context.getResources().getIdentifier(uriseis, "drawable",
                    context.getPackageName());

        }
        else if (i==7){

            id = context.getResources().getIdentifier(urisiete, "drawable",
                    context.getPackageName());

        }
        else if (i==8){

            id = context.getResources().getIdentifier(uriocho, "drawable",
                    context.getPackageName());

        }
        return id;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_juego, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case R.id.action_ranking:
                Intent intent = new Intent(getApplicationContext(),Ranking.class);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m1:
                if(!bx){
                    x=id1;
                    bx = true;
                }
                else{
                    y = id1;
                    by = true;
                }
                comprobar();
                //ImageButton bmem11= (ImageButton) findViewById(R.id.m1);
               /* Random r = new Random();

                int imageResource = getResources().getIdentifier(uriuno, null, getPackageName());
                Drawable image = getResources().getDrawable(imageResource);
                bmem11.setImageDrawable(image);*/

                break;
            case R.id.m2:
                if(!bx){
                    x=id2;
                    bx = true;
                }
                else{
                    y = id2;
                    by = true;
                }
                break;
            case R.id.m3:
                if(!bx){
                    x=id3;
                    bx = true;
                }
                else{
                    y = id3;
                    by = true;
                }

                break;
            case R.id.m4:
                if(!bx){
                    x=id4;
                    bx = true;
                }
                else{
                    y = id4;
                    by = true;
                }
                break;
            case R.id.m5:
                if(!bx){
                    x=id5;
                    bx = true;
                }
                else{
                    y = id5;
                    by = true;
                }
                break;
            case R.id.m6:
                if(!bx){
                    x=id6;
                    bx = true;
                }
                else{
                    y = id6;
                    by = true;
                }
                break;
            case R.id.m7:
                if(!bx){
                    x=id7;
                    bx = true;
                }
                else{
                    y = id7;
                    by = true;
                }
                break;
            case R.id.m8:
                if(!bx){
                    x=id8;
                    bx = true;
                }
                else{
                    y = id8;
                    by = true;
                }

                break;
            case R.id.m9:
                if(!bx){
                    x=id9;
                    bx = true;
                }
                else{
                    y = id9;
                    by = true;
                }
                break;
            case R.id.m10:
                if(!bx){
                    x=id10;
                    bx = true;
                }
                else{
                    y = id10;
                    by = true;
                }
                break;
            case R.id.m11:
                if(!bx){
                    x=id11;
                    bx = true;
                }
                else{
                    y = id11;
                    by = true;
                }
                break;
            case R.id.m12:
                if(!bx){
                    x=id12;
                    bx = true;
                }
                else{
                    y = id12;
                    by = true;
                }
                break;
            case R.id.m13:
                if(!bx){
                    x=id13;
                    bx = true;
                }
                else{
                    y = id13;
                    by = true;
                }

                break;
            case R.id.m14:
                if(!bx){
                    x=id14;
                    bx = true;
                }
                else{
                    y = id14;
                    by = true;
                }
                break;
            case R.id.m15:
                if(!bx){
                    x=id15;
                    bx = true;
                }
                else{
                    y = id15;
                    by = true;
                }

                break;
            case R.id.m16:
                if(!bx){
                    x=id16;
                    bx = true;
                }
                else{
                    y = id16;
                    by = true;
                }
                break;


        }

    }

    private void comprobar() {
        if(x == y){
            int punt = Integer.parseInt(puntuacion + "");
            punt++;
            puntuacion.setText(punt + "");
            bx= false;
            by = false;
        }
    }
}
