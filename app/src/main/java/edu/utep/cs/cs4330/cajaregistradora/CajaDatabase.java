package edu.utep.cs.cs4330.cajaregistradora;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CajaDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UnasVeroDB";
    public static final String TABLE_NAME = "CajaRegistradora";
    public static final String COL_1 = "Transaccion";
    public static final String COL_2 = "Dinero";



    public CajaDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+COL_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_2+" INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void deleteAllData(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(int datos){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,datos);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }
        return true;
    }
    public boolean delete(String item){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, COL_2 + "=" + "'"+item+"'", null) > 0;
    }

}
