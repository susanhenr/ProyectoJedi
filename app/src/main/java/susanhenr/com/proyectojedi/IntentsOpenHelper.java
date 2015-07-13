package susanhenr.com.proyectojedi;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        //Cursor c = db.query("SELECT * FROM login WHERE usuario = ('" + usuario + "') AND contrasena = ('" + contraseña + "')");

    }

   public void ingresapuntuacion (String usuario, Integer puntuacion, SQLiteDatabase db){
        db.execSQL("INSERT INTO ranking (usuario,puntuacion) VALUES('" +
                usuario + "','" + puntuacion + "');");
        db.close();
    }
    public Cursor getpuntuacion(String usuario, SQLiteDatabase db) {

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
        return c;
    }

}
