package susanhenr.com.proyectojedi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            case R.id.button:
                Intent intent = new Intent(getApplicationContext(),Calculadora.class);
                startActivity(intent);
                break;
            case R.id.button5:
                Intent intent1 = new Intent(getApplicationContext(),Perfil.class);
                startActivity(intent1);
                break;
            case R.id.button6:
                Intent intent2 = new Intent(getApplicationContext(),Juego.class);
                startActivity(intent2);
                break;
            case R.id.button7:
                Intent intent3 = new Intent(getApplicationContext(),Musica.class);
                startActivity(intent3);
                break;
            case R.id.button8:
                Intent intent4 = new Intent(getApplicationContext(),Ranking.class);
                startActivity(intent4);
                break;
        }
    }
}
