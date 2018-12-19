package com.example.asus.timetable.Database;

import android.database.Cursor;

public class StudyClass {
    String class_name,day_of_week,teacher_name;
    int id,start_time_hour,end_time_hour,start_time_min,end_time_min;
    String deadline;

    public StudyClass() {
    }

    public StudyClass(String class_name, String day_of_week,String teacher_name, int id, int start_time_hour, int end_time_hour, int start_time_min, int end_time_min,String deadline) {
        this.class_name = class_name;
        this.day_of_week = day_of_week;
        this.teacher_name = teacher_name;
        this.id = id;
        this.start_time_hour = start_time_hour;
        this.end_time_hour = end_time_hour;
        this.start_time_min = start_time_min;
        this.end_time_min = end_time_min;
        this.deadline = deadline;
    }

    public StudyClass(Cursor cursor){
        int i = 0;
        setId(cursor.getInt(i++));
        setDay_of_week(cursor.getString(i++));
        setClass_name(cursor.getString(i++));
        setStart_time_hour(cursor.getInt(i++));
        setStart_time_min(cursor.getInt(i++));
        setEnd_time_hour(cursor.getInt(i++));
        setEnd_time_min(cursor.getInt(i++));
        setTeacher_name(cursor.getString(i++));
        setDeadline(cursor.getString(i++));

    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStart_time_hour() {
        return start_time_hour;
    }

    public void setStart_time_hour(int start_time_hour) {
        this.start_time_hour = start_time_hour;
    }

    public int getEnd_time_hour() {
        return end_time_hour;
    }

    public void setEnd_time_hour(int end_time_hour) {
        this.end_time_hour = end_time_hour;
    }

    public int getStart_time_min() {
        return start_time_min;
    }

    public void setStart_time_min(int start_time_min) {
        this.start_time_min = start_time_min;
    }

    public int getEnd_time_min() {
        return end_time_min;
    }

    public void setEnd_time_min(int end_time_min) {
        this.end_time_min = end_time_min;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}
