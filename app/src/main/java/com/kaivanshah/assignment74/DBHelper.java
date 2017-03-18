package com.kaivanshah.assignment74;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by kaivanrasiklal.s on 17-03-2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "SampleDB2";

    // Contacts table name
    private static final String TABLE_SAMPLE = "SampleTBL";

    // Contacts Table Columns names
    private static final String KEY_ID = "Id";
    private static final String KEY_FNAME = "FName";
    private static final String KEY_LNAme = "LName";



    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SAMPLE_TABLE = "CREATE TABLE " + TABLE_SAMPLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_FNAME + " TEXT,"
                + KEY_LNAme + " TEXT)";
        db.execSQL(CREATE_SAMPLE_TABLE);



        ContentValues values = new ContentValues();
        values.put(KEY_FNAME, "Kaivan"); //
        values.put(KEY_LNAme, "Shah"); //

        db.insert(TABLE_SAMPLE, null, values);

        values = null;
        values = new ContentValues();
        values.put(KEY_FNAME, "Nirali"); //
        values.put(KEY_LNAme, "Vora"); //

        db.insert(TABLE_SAMPLE, null, values);



        values = null;
        values = new ContentValues();
        values.put(KEY_FNAME, "Jinal"); //
        values.put(KEY_LNAme, "Shah"); //

        db.insert(TABLE_SAMPLE, null, values);



        values = null;
        values = new ContentValues();
        values.put(KEY_FNAME, "Mahir"); //
        values.put(KEY_LNAme, "Shah"); //

        db.insert(TABLE_SAMPLE, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SAMPLE);
        // Create tables again
        onCreate(db);

    }

    // Getting All Contacts
    public ArrayList<SampleCLS> getAllProducts() {
        ArrayList<SampleCLS> oList = new ArrayList<SampleCLS>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SAMPLE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                SampleCLS oSampleCLS = new SampleCLS();
                oSampleCLS._Id = Integer.parseInt(cursor.getString(0));
                oSampleCLS._FName = cursor.getString(1);
                oSampleCLS._LName = cursor.getString(2);
                oList.add(oSampleCLS);
            } while (cursor.moveToNext());
        }

        // return product list
        return oList;
    }
}
