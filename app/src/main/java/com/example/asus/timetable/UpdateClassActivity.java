package com.example.asus.timetable;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.example.asus.timetable.Database.ClassDatabase;
import com.example.asus.timetable.Database.StudyClass;
import com.example.asus.timetable.DateAndTime.DatePickerFragment;
import com.example.asus.timetable.DateAndTime.TimePickerFragment;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;

public class UpdateClassActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener{

    Toolbar toolbar;
    EditText className,teacherName;
    Button btnStarttime,btnEndtime,btnOk,btnCancel,btnDeadline;
    TextView tvStarttime_hour,tvStarttime_min,tvEndtime_hour,tvEndtime_min,tvdeadline;
    Context context = UpdateClassActivity.this;
    int temp;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_class);

        Bundle bundle = getIntent().getExtras();
        int startHour,startMin,endHour,endMin;
        String teacher,deadline,nameClass;
        final int id = bundle.getInt("id");
        final String dayOfWeek = bundle.getString("day of week");
        startHour = bundle.getInt("start hour");
        startMin = bundle.getInt("start min");
        endHour = bundle.getInt("end hour");
        endMin = bundle.getInt("end min");
        teacher = bundle.getString("teacher");
        deadline = bundle.getString("deadline");
        nameClass = bundle.getString("class name");

        className = findViewById(R.id.edt_update_classname);
        toolbar = findViewById(R.id.toolbar);
        teacherName = findViewById(R.id.edt_update_teacher);
        btnStarttime = findViewById(R.id.btn_update_starttime);
        btnEndtime = findViewById(R.id.btn_update_endtime);
        btnOk = findViewById(R.id.btn_update_ok);
        btnCancel = findViewById(R.id.btn_update_cancel);
        btnDeadline = findViewById(R.id.btn_update_deadline);
        tvStarttime_hour = findViewById(R.id.tv_starttime_hour2);
        tvStarttime_min = findViewById(R.id.tv_starttime_min2);
        tvEndtime_hour = findViewById(R.id.tv_endtime_hour2);
        tvEndtime_min = findViewById(R.id.tv_endtime_min2);
        tvdeadline = findViewById(R.id.tv_deadline2);

        DecimalFormat df = new DecimalFormat("00");
        className.setText(nameClass);
        teacherName.setText(teacher);
        tvStarttime_hour.setText(""+df.format(startHour));
        tvStarttime_min.setText(""+df.format(startMin));
        tvEndtime_hour.setText(""+df.format(endHour));
        tvEndtime_min.setText(""+df.format(endMin));
        tvdeadline.setText(deadline);
        toolbar.setTitle(nameClass);


        final ClassDatabase classDatabase = new ClassDatabase(context);
        classDatabase.open();
        final StudyClass studyClass = new StudyClass();


        btnStarttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
                temp = 0;
            }
        });

        btnEndtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                temp = 1;
            }
        });

        btnDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");

            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studyClass.setId(id);
                studyClass.setClass_name(className.getText().toString());
                studyClass.setTeacher_name(teacherName.getText().toString());
                studyClass.setDay_of_week(dayOfWeek);
                studyClass.setStart_time_hour(Integer.parseInt(tvStarttime_hour.getText().toString()));
                studyClass.setStart_time_min(Integer.parseInt(tvStarttime_min.getText().toString()));
                studyClass.setEnd_time_hour(Integer.parseInt(tvEndtime_hour.getText().toString()));
                studyClass.setEnd_time_min(Integer.parseInt(tvEndtime_min.getText().toString()));
                studyClass.setDeadline(tvdeadline.getText().toString());

                classDatabase.updateClass(studyClass);
                Intent intent = new Intent(UpdateClassActivity.this,MainActivity.class);
                startActivity(intent);

                Toast.makeText(UpdateClassActivity.this, "Cập nhật thành công!!", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(UpdateClassActivity.this,MainActivity.class);
                startActivity(intent1);
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        DecimalFormat df = new DecimalFormat("00");
        if (temp == 0) {tvStarttime_hour.setText(df.format(i));
                        tvStarttime_min.setText(df.format(i1));}
        if (temp == 1) {tvEndtime_hour.setText(df.format(i));
                        tvEndtime_min.setText(df.format(i1));}
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, i);
        cal.set(Calendar.MONTH, i1);
        cal.set(Calendar.DAY_OF_MONTH, i2);
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(cal.getTime());
        tvdeadline.setText(currentDate);
    }
}
