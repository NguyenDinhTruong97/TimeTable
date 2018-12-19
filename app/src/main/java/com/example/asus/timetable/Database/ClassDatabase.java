package com.example.asus.timetable.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ClassDatabase {
    public ClassSQLiteOpenHelper classSQLiteOpenHelper;
    public SQLiteDatabase database;

    public ClassDatabase(Context context){
        classSQLiteOpenHelper = ClassSQLiteOpenHelper.getInstant(context);
    }

    public void open(){
        database = classSQLiteOpenHelper.getWritableDatabase();
    }

    public void insertClass(StudyClass studyClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClassSQLiteOpenHelper.DAY_OF_WEEK, studyClass.getDay_of_week());
        contentValues.put(ClassSQLiteOpenHelper.CLASS_NAME, studyClass.getClass_name());
        contentValues.put(ClassSQLiteOpenHelper.START_TIME_HOUR, studyClass.getStart_time_hour());
        contentValues.put(ClassSQLiteOpenHelper.START_TIME_MIN, studyClass.getEnd_time_min());
        contentValues.put(ClassSQLiteOpenHelper.END_TIME_HOUR, studyClass.getEnd_time_hour());
        contentValues.put(ClassSQLiteOpenHelper.END_TIME_MIN, studyClass.getEnd_time_min());
        contentValues.put(ClassSQLiteOpenHelper.TEACHER_NAME,studyClass.getTeacher_name());
        contentValues.put(ClassSQLiteOpenHelper.DEADLINE,studyClass.getDeadline());
        database.insertOrThrow(ClassSQLiteOpenHelper.TABLE_NAME,null, contentValues);

    }

    public void updateClass(StudyClass studyClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClassSQLiteOpenHelper.DAY_OF_WEEK, studyClass.getDay_of_week());
        contentValues.put(ClassSQLiteOpenHelper.CLASS_NAME, studyClass.getClass_name());
        contentValues.put(ClassSQLiteOpenHelper.START_TIME_HOUR, studyClass.getStart_time_hour());
        contentValues.put(ClassSQLiteOpenHelper.START_TIME_MIN, studyClass.getStart_time_min());
        contentValues.put(ClassSQLiteOpenHelper.END_TIME_HOUR, studyClass.getEnd_time_hour());
        contentValues.put(ClassSQLiteOpenHelper.END_TIME_MIN, studyClass.getEnd_time_min());
        contentValues.put(ClassSQLiteOpenHelper.TEACHER_NAME,studyClass.getTeacher_name());
        contentValues.put(ClassSQLiteOpenHelper.DEADLINE,studyClass.getDeadline());
        database.update(ClassSQLiteOpenHelper.TABLE_NAME,contentValues,ClassSQLiteOpenHelper.CLASS_ID + " = " + studyClass.getId(),null);

    }

    public ArrayList<StudyClass>getAllClass(){
        ArrayList<StudyClass> arrayList = new ArrayList<>();
        Cursor cursor = database.query(ClassSQLiteOpenHelper.TABLE_NAME,null,null, null,null,null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            StudyClass studyClass = new StudyClass(cursor);
            arrayList.add(studyClass);
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }


    public ArrayList<StudyClass>getStudyClass(int date){
        String dayofWeek = "";
        switch (date){
            case 2: dayofWeek = "Thứ 2"; break;
            case 3: dayofWeek = "Thứ 3"; break;
            case 4: dayofWeek = "Thứ 4"; break;
            case 5: dayofWeek = "Thứ 5"; break;
            case 6: dayofWeek = "Thứ 6"; break;
            case 7: dayofWeek = "Thứ 7"; break;
            case 8: dayofWeek = "Chủ Nhật"; break;

        }
        ArrayList<StudyClass> arrayList = new ArrayList<>();
        Cursor cursor = database.query(ClassSQLiteOpenHelper.TABLE_NAME,null,ClassSQLiteOpenHelper.DAY_OF_WEEK + " = '"+ dayofWeek +"'" ,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            StudyClass studyClass = new StudyClass(cursor);
            arrayList.add(studyClass);
            cursor.moveToNext();
        }
        cursor.close();
        return arrayList;
    }


    public void deleteClass(int ClassID){
        database.delete(ClassSQLiteOpenHelper.TABLE_NAME,"id = " + ClassID, null);

    }
}
