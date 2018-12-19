package com.example.asus.timetable.DayOfWeekFragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.asus.timetable.AddClassActivity;
import com.example.asus.timetable.Database.ClassDatabase;
import com.example.asus.timetable.Database.StudyClass;
import com.example.asus.timetable.ListViewAdapter;
import com.example.asus.timetable.R;
import java.util.ArrayList;

public class FragmentDayOfWeek extends Fragment {

    public View rootView;
    Button btnAdd;
    RecyclerView recyclerView;
    ArrayList<StudyClass> datalist = new ArrayList<>();
    ListViewAdapter listViewAdapter;
    LinearLayout linearLayout;
    Context context;
    int dayOfWeek;

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_dayofweek, container,false);
        btnAdd  = rootView.findViewById(R.id.btn_add);
        recyclerView = rootView.findViewById(R.id.rcview);
        linearLayout = rootView.findViewById(R.id.fragment_dow);
        context = getActivity();
        getData();
        listViewAdapter = new ListViewAdapter(datalist,context);
        recyclerView.setAdapter(listViewAdapter);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,AddClassActivity.class);
                switch (dayOfWeek){
                    case 2: {
                        intent.putExtra("Add", "Thêm môn học cho thứ 2");
                        intent.putExtra("day", "Thứ 2");
                        startActivity(intent);
                        break;
                    }
                    case 3: {
                        intent.putExtra("Add", "Thêm môn học cho thứ 3");
                        intent.putExtra("day", "Thứ 3");
                        startActivity(intent);
                        break;
                    }
                    case 4: {
                        intent.putExtra("Add", "Thêm môn học cho thứ 4");
                        intent.putExtra("day", "Thứ 4");
                        startActivity(intent);
                        break;
                    }
                    case 5: {
                        intent.putExtra("Add", "Thêm môn học cho thứ 5");
                        intent.putExtra("day", "Thứ 5");
                        startActivity(intent);
                        break;
                    }
                    case 6: {
                        intent.putExtra("Add", "Thêm môn học cho thứ 6");
                        intent.putExtra("day", "Thứ 6");
                        startActivity(intent);
                        break;
                    }
                    case 7: {
                        intent.putExtra("Add", "Thêm môn học cho thứ 7");
                        intent.putExtra("day", "Thứ 7");
                        startActivity(intent);
                        break;
                    }
                    case 8: {
                        intent.putExtra("Add", "Thêm môn học cho chủ nhật");
                        intent.putExtra("day", "Chủ Nhật");
                        startActivity(intent);
                        break;
                    }

                }

            }
        });

        return rootView;
    }
    private void getData(){
        ClassDatabase classDatabase = new ClassDatabase(context);
        classDatabase.open();
        datalist.addAll(classDatabase.getStudyClass(getDayOfWeek()));
    }

}
