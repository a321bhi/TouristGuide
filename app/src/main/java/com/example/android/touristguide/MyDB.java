package com.example.android.touristguide;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
public class MyDB extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME ="UserDetails.db";
    public static final String TABLE_USER ="users";
    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_MOB = "mob";
    public static final String COLUMN_EMAIL= "email";
    public static final String COLUMN_DOB = "dob";
    public static final String COLUMN_UNAME = "uname";
    public static final String COLUMN_PASSWORD = "pass";

    public MyDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+TABLE_USER+"("+
                COLUMN_NAME+" TEXT, "+COLUMN_MOB+" TEXT, "+COLUMN_EMAIL+" TEXT, "
                +COLUMN_DOB+" TEXT, "
                +COLUMN_UNAME+" TEXT, "+
                COLUMN_PASSWORD+" TEXT"+ ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        onCreate(db);
    }
    public void addUser(UserCredentials userCred){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, userCred.getName());
        values.put(COLUMN_MOB,userCred.getMob());
        values.put(COLUMN_EMAIL,userCred.getEmail());
        values.put(COLUMN_DOB, userCred.getDob());
        values.put(COLUMN_UNAME, userCred.getUserName());
        values.put(COLUMN_PASSWORD, userCred.getPass());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USER, null, values);
    }
    public String getPassFromDB(String username){
        String dbString ="";
        SQLiteDatabase db= getReadableDatabase();
        String query = "SELECT "+ COLUMN_PASSWORD+" FROM "+TABLE_USER+" WHERE "+COLUMN_UNAME+ " LIKE "+username;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        //while (!c.isAfterLast()){
            //c.moveToLast();
            //c.moveToFirst();
            //if(c.getString(c.getColumnIndex("pass"))!= null){
                dbString += c.getString(c.getColumnIndex("pass"));

          //  //}
        //}
        db.close();
        return dbString;
    }
}
