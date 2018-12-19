package com.example.asus.timetable.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClassSQLiteOpenHelper extends SQLiteOpenHelper {

    public static String dbName = "class.db";
    public static int dbVersion = 1;
    public  static  ClassSQLiteOpenHelper classSQLiteOpenHelper;

    final static String TABLE_NAME = "class";
    final static String CLASS_ID ="id";
    public static String DAY_OF_WEEK = "day_of_week";
    final static String CLASS_NAME="class_name";
    final static String START_TIME_HOUR = "start_time_hour";
    final static String START_TIME_MIN = "start_time_min";
    final static String END_TIME_HOUR = "end_time_hour";
    final static String END_TIME_MIN = "end_time_min";
    final static String TEACHER_NAME = "techer_name";
    final static String DEADLINE = "deadline";


    public static String CREATE_TABLE_CLASS = "CREATE TABLE " +  TABLE_NAME + "(" +
            CLASS_ID    + "   INTEGER         PRIMARY KEY AUTOINCREMENT," +
            DAY_OF_WEEK + "     VARCHAR (0, 128) NOT NULL," +
            CLASS_NAME  + "     VARCHAR (0, 128) NOT NULL," +
            START_TIME_HOUR  + "     INTEGER             NOT NULL," +
            START_TIME_MIN  + "     INTEGER             NOT NULL," +
            END_TIME_HOUR    + "     INTEGER             NOT NULL," +
            END_TIME_MIN    + "     INTEGER             NOT NULL," +
            TEACHER_NAME + "       VARCHAR(0,128)       NOT NULL,"+
            DEADLINE +      "      VARCHAR(0,128 ) NOT NULL"+
            ");";

    public ClassSQLiteOpenHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    public static ClassSQLiteOpenHelper getInstant(Context context){
        if(classSQLiteOpenHelper == null){
            classSQLiteOpenHelper = new ClassSQLiteOpenHelper(context);
        }
        return classSQLiteOpenHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CLASS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
