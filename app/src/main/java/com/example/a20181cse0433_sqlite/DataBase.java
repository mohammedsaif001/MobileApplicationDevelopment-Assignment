package com.example.a20181cse0433_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "BOOKINGS.db";
    public static final String TABLE_NAME = "FLIGHT";
    public static final String col1 = "Name";
    public static final String col2 = "Mobile";
    public static final String col3 = "Arrival";
    public static final String col4 = "Destination";
    public static final String col5 = "Date";
    public static final String col6 = "Time";


    public DataBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1); //Change to DB_NAME , null , 1
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+"(NAME TEXT,MOBILE TEXT,ARRIVAL TEXT,DESTINATION TEXT,DATE TEXT,TIME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    //Adding Function for Insertion
    public boolean insertData433(String name, String mobile, String arrival, String dest, String date, String time){
        SQLiteDatabase db433 = this.getWritableDatabase();
        ContentValues contentValues433 = new ContentValues();
        contentValues433.put(col1,name);
        contentValues433.put(col2,mobile);
        contentValues433.put(col3,arrival);
        contentValues433.put(col4,dest);
        contentValues433.put(col5,date);
        contentValues433.put(col6,time);

        long res433 = db433.insert(TABLE_NAME,null,contentValues433);
        if(res433==-1) return false;
        else return true;
    }


    //Adding Function to Display the data in the table
    public Cursor display433() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public Cursor findByName433(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME+" where Name = ?",new String[]{name});
        return res;
    }

    public Cursor findByArrival433(String arrival){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME+" where Arrival = ?",new String[]{arrival});
        return res;
    }

    public Cursor findByDestination433(String destination){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME+" where Destination = ?",new String[]{destination});
        return res;
    }


}
