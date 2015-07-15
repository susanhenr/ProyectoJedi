package susanhenr.com.proyectojedi;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by susanhenriquez on 3/7/15.
 */
public class IntentsOpenHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "proyecto";
    private static final String STATISTICS_TABLE_NAME = "login";
    private static final String STATISTICS_TABLE_CREATE = "CREATE TABLE " + STATISTICS_TABLE_NAME + " (usuario TEXT primary key, contraseña TEXT, puntuacion INTEGER)";
    private static final String STATISTICS_TABLE_NAME_RANKING = "ranking";
    private static final String STATISTICS_TABLE_CREATE_RANKING = "CREATE TABLE " + STATISTICS_TABLE_NAME_RANKING + " (usuario TEXT primary key, puntuacion INTEGER)";


    public IntentsOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(STATISTICS_TABLE_CREATE);
      db.execSQL(STATISTICS_TABLE_CREATE_RANKING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STATISTICS_TABLE_NAME);
       //
       //
        db.execSQL("DROP TABLE IF EXISTS " + STATISTICS_TABLE_NAME_RANKING);
        db.execSQL(STATISTICS_TABLE_CREATE);
        db.execSQL(STATISTICS_TABLE_CREATE_RANKING);
    }
   void registro(String usuario, String contraseña, SQLiteDatabase db) {
       db = this.getWritableDatabase();
       db.execSQL("INSERT INTO login (usuario,contraseña,puntuacion) VALUES('" +
                       usuario + "','" + contraseña + "','" + 0 + "');");
        db.close();
    }

    public Cursor login(String usuario, String contraseña, SQLiteDatabase db) {

        String[] columns = {"usuario","contraseña"};
        String[] where = {usuario};
        Cursor c = db.query(
                STATISTICS_TABLE_NAME,  // The table to query
                columns,                                    // The columns to return
                "usuario=?",                                   // The columns for the WHERE clause
                where,                                      // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );
        return c;

    }

   public void ingresapuntuacion (String usuario, Integer puntuacion, SQLiteDatabase db){
       db.execSQL("INSERT INTO ranking (usuario,puntuacion) VALUES('" +
                usuario + "','" + puntuacion + "');");
        db.close();
    }

    //Esta funcion me da error:
    //      Caused by: android.database.sqlite.SQLiteException: no such table: ranking (code 1): , while compiling: SELECT usuario, puntuacion FROM ranking WHERE usuario=?


    public Cursor getpuntuacion(String usuario, SQLiteDatabase db) {
/*
        String[] columns = {"usuario","puntuacion"};
        String[] where = {usuario};
        Cursor c = db.query(
                STATISTICS_TABLE_NAME_RANKING,  // The table to query
                columns,                                    // The columns to return
                "usuario=?",                                   // The columns for the WHERE clause
                where,                                      // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );
        return c;*/
        return null;
    }


    //FUNCIONES PARA RANKING

    public Cursor obtenranking(SQLiteDatabase db) {
        String[] columns = {"usuario","puntuacion"};
      //  String[] where = {};
       Cursor c = db.query(
                STATISTICS_TABLE_NAME_RANKING,  // The table to query
                columns,                                    // The columns to return
                null,                                   // The columns for the WHERE clause
                null,                                      // The values for the WHERE clause
                null,                                       // don't group the rows
                null,                                       // don't filter by row groups
                null                                        // The sort order
        );

        //ERROR!!!!
       // Cursor c = this.getReadableDatabase().rawQuery(
          //      "SELECT * FROM ranking" , null);

        return c;

    }
    public ArrayList<Jugador> getranking( IntentsOpenHelper ioh) {
        ArrayList<Jugador> resultado = null;

        String columnas[] = {"usuario", "puntuacion"};
        SQLiteDatabase db = ioh.getWritableDatabase();
        if (db != null) {
            Cursor c = ioh.obtenranking(db);
            // if(c.moveToFirst()){
            int nom, punt;// indices para las columnas
// se obtiene el índice de cada columna
            nom = c.getColumnIndex("usuario");
            punt = c.getColumnIndex("puntuacion");
            String[] s;
            for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
                Jugador j = new Jugador();
                j.setNombre(c.getString(nom));
               int x = c.getInt(punt);
                j.setPuntuacion(x);
                resultado.add(j);
            }
            c.close();


        }
        return resultado;
    }
}
