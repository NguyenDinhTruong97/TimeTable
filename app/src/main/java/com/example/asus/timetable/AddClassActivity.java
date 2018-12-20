package com.example.asus.timetable;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import java.text.Format;
import java.util.Calendar;
import java.util.Date;


public class AddClassActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener,DatePickerDialog.OnDateSetListener {

    TextView tvstarttimehour,tvstarttimemin,tvendtimehour,tvendtimemin,tvdeadline;
    Button btnstarttime, btnendtime, btndeadline,btnOK,btnCancel;
    EditText edtClassName,edtTecher;
    int temp,state;
    Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclass);
        toolbar = findViewById(R.id.toolbar);
        tvstarttimehour = findViewById(R.id.tv_starttime_hour);
        tvstarttimemin  = findViewById(R.id.tv_starttime_min);
        tvendtimehour = findViewById(R.id.tv_endtime_hour);
        tvendtimemin = findViewById(R.id.tv_endtime_min);
        tvdeadline = findViewById(R.id.tv_deadline);
        btnstarttime = findViewById(R.id.btn_starttime);
        btnendtime = findViewById(R.id.btn_endtime);
        btndeadline = findViewById(R.id.btn_deadline);
        btnOK = findViewById(R.id.btn_ok);
        btnCancel = findViewById(R.id.btn_cancel);
        edtClassName = findViewById(R.id.edt_classname);
        edtTecher = findViewById(R.id.edt_teacher);


        final Intent intent = getIntent();
        final String toolbarname = intent.getStringExtra("Add");
        final String dayofWeek = intent.getStringExtra("day");
        switch (dayofWeek){
            case "Thứ 2": state = 2; break;
        case "Thứ 3": state = 3; break;
        case "Thứ 4": state = 4; break;
        case "Thứ 5": state = 5; break;
        case "Thứ 6": state = 6; break;
        case "Thứ 7": state = 7; break;
        case "Chủ Nhật": state = 8; break;

    }

        toolbar.setTitle(toolbarname);

        btnstarttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
                temp = 0;
            }
        });

        btnendtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                temp = 1;
            }
        });

        btndeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddClassActivity.this,MainActivity.class);
                intent.putExtra("state",state);
                startActivity(intent);
            }
        });



        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edtClassName.getText().toString().isEmpty()){
                    Toast.makeText(AddClassActivity.this, "Bạn chưa nhập Tên lớp học", Toast.LENGTH_SHORT).show();
                } else if(tvstarttimehour.getText().toString().isEmpty()){
                    Toast.makeText(AddClassActivity.this, "Bạn chưa chọn Giờ bắt đầu", Toast.LENGTH_SHORT).show();
                } else if(tvendtimehour.getText().toString().isEmpty()){
                    Toast.makeText(AddClassActivity.this, "Bạn chưa chọn Giờ kết thúc", Toast.LENGTH_SHORT).show();
                } else if(Integer.parseInt(tvstarttimehour.getText().toString())>Integer.parseInt(tvendtimehour.getText().toString())){
                    Toast.makeText(AddClassActivity.this, "Mời bạn nhập lại thời gian (Giờ bắt đầu phải lớn hơn Giờ kết thúc)", Toast.LENGTH_SHORT).show();
                } else if(edtTecher.getText().toString().isEmpty()){
                    Toast.makeText(AddClassActivity.this, "Bạn chưa nhập tên giảng viên", Toast.LENGTH_SHORT).show();
                } else {

                    StudyClass studyClass = new StudyClass();
                    studyClass.setClass_name(edtClassName.getText().toString());
                    studyClass.setDay_of_week(dayofWeek);
                    studyClass.setStart_time_hour(Integer.parseInt(tvstarttimehour.getText().toString()));
                    studyClass.setStart_time_min(Integer.parseInt(tvstarttimemin.getText().toString()));
                    studyClass.setEnd_time_hour(Integer.parseInt(tvendtimehour.getText().toString()));
                    studyClass.setEnd_time_min(Integer.parseInt(tvendtimemin.getText().toString()));
                    studyClass.setTeacher_name(edtTecher.getText().toString());
                    studyClass.setDeadline(tvdeadline.getText().toString());
                    ClassDatabase classDatabase = new ClassDatabase(AddClassActivity.this);
                    classDatabase.open();
                    classDatabase.insertClass(studyClass);
                    Intent intent1 = new Intent(AddClassActivity.this, MainActivity.class);
                    intent1.putExtra("state",state);
                    Log.d("haha", "onClick: " + state);
                    startActivity(intent1);
                }
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        DecimalFormat df = new DecimalFormat("00");
        if (temp == 0) {tvstarttimehour.setText(df.format(i));
                        tvstarttimemin.setText(df.format(i1));}
        if (temp == 1) {tvendtimehour.setText(df.format(i));
                        tvendtimemin.setText(df.format(i1));}
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
