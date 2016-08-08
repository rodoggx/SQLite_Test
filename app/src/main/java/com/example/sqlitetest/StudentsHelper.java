package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//step 2 create new class
//step 3 alt + enter to methods, manually add constructors
public class StudentsHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "students.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "students";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";

    //step 6
    String CREATE_STUDENTS_TABLE = "Create Table " + TABLE_NAME + " " +
            "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_NAME + " TEXT," +
            COLUMN_AGE + " TEXT" +
            ")";

    public StudentsHelper(Context context) {
        //step 4 constants are capital, db is created, db changes/upgrade require new version
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //step 5 called when we first install application
        sqLiteDatabase.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXISTS students");
        onCreate(sqLiteDatabase);
    }
}
