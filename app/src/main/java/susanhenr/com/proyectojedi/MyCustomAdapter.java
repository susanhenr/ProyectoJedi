package susanhenr.com.proyectojedi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by susanhenriquez on 14/7/15.
 */
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.AdapterViewHolder> {
    ArrayList<Jugador> ranking;

    MyCustomAdapter(ArrayList<Jugador> result){
        ranking = result;

       /* String columnas[] = { "nombre", "puntuacion" };
          IntentsOpenHelper ioh = new IntentsOpenHelper(getApplicationContext());
            SQLiteDatabase db = ioh.getWritableDatabase();
        if(db != null){
                   Cursor c = ioh.obtenranking(db);
            // if(c.moveToFirst()){
            int nom, punt;// indices para las columnas
// se obtiene el índice de cada columna
            nom = c.getColumnIndex("nombre");
            punt = c.getColumnIndex("puntuacion");
            String[] s;
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                s = new String[]{c.getString(nom), c.getString(puntuacion)};
                ranking.add(s);
            }
            c.close();*/

    }


    @Override
    public MyCustomAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Instancia un layout XML en la correspondiente vista.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //Inflamos en la vista el layout para cada elemento
        View view = inflater.inflate(R.layout.rowlayout, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomAdapter.AdapterViewHolder adapterViewholder, int position) {

        adapterViewholder.nombre.setText(ranking.get(position).getNombre());
        adapterViewholder.puntuacion.setText(ranking.get(position).getPuntuacion());

    }

    @Override
    public int getItemCount() {
        //Debemos retornar el tamaño de todos los elementos contenidos en el viewholder
        //Por defecto es return 0 --> No se mostrará nada.
        return ranking.size();
    }



    //Definimos una clase viewholder que funciona como adapter para
    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        /*
        *  Mantener una referencia a los elementos de nuestro ListView mientras el usuario realiza
        *  scrolling en nuestra aplicación. Así que cada vez que obtenemos la vista de un item,
        *  evitamos las frecuentes llamadas a findViewById, la cuál se realizaría únicamente la primera vez y el resto
        *  llamaríamos a la referencia en el ViewHolder, ahorrándonos procesamiento.
        */


        public TextView nombre;
        public TextView puntuacion;
        public View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            this.v = itemView;
            this.nombre = (TextView) itemView.findViewById(R.id.textView17);
            this.puntuacion = (TextView) itemView.findViewById(R.id.textView16);
        }
    }
    //ArrayList<Jugador> ranking;


   /* MyCustomAdapter(){
   //     ranking = new ArrayList<>();
        String columnas[] = { "nombre", "puntuacion" };
     //   IntentsOpenHelper ioh = new IntentsOpenHelper(getApplicationContext());
   //     SQLiteDatabase db = ioh.getWritableDatabase();
        if(db != null){
    //        Cursor c = ioh.obtenranking(db);
           // if(c.moveToFirst()){
                int nom, punt;// indices para las columnas
// se obtiene el índice de cada columna
                nom = c.getColumnIndex("nombre");
                punt = c.getColumnIndex("puntuacion");
                String[] s;
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                s = new String[] { c.getString(nom), c.getString(puntuacion)};
                ranking.add(s);
            }
            c.close();
            //}

    }

    @Override
    public MyCustomAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Instancia un layout XML en la correspondiente vista.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //Inflamos en la vista el layout para cada elemento
        View view = inflater.inflate(R.layout.rowlayout, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyCustomAdapter.AdapterViewHolder adapterViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
         return ranking.size();

    }

    private class AdapterViewHolder {
        public TextView name;
        public TextView phone;
        public View v;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            this.v = itemView;
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.phone = (TextView) itemView.findViewById(R.id.phone);
        }
    }*/
}
