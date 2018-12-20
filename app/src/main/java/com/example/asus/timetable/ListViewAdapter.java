package com.example.asus.timetable;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.timetable.Database.ClassDatabase;
import com.example.asus.timetable.Database.StudyClass;

import java.util.ArrayList;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ViewHolder> {

    ArrayList<StudyClass> listdata;
    Context context;

    public ListViewAdapter(ArrayList<StudyClass> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final StudyClass studyClass = listdata.get(position);

        holder.tvClassname.setText(studyClass.getClass_name());
        holder.tvStarttime.setText(studyClass.getStart_time_hour() +":"+studyClass.getEnd_time_min());
        holder.tvEndtime.setText(studyClass.getEnd_time_hour() +":"+studyClass.getEnd_time_min());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,UpdateClassActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",studyClass.getId());
                bundle.putString("class name",studyClass.getClass_name());
                bundle.putString("day of week",studyClass.getDay_of_week());
                bundle.putInt("start hour",studyClass.getStart_time_hour());
                bundle.putInt("start min",studyClass.getStart_time_min());
                bundle.putInt("end hour",studyClass.getEnd_time_hour());
                bundle.putInt("end min",studyClass.getEnd_time_min());
                bundle.putString("teacher",studyClass.getTeacher_name());
                bundle.putString("deadline",studyClass.getDeadline());
                intent.putExtras(bundle);
                view.getContext().startActivity(intent);
            }
        });

        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Xoá môn học");
                builder.setMessage("Bạn có chắc là muốn xoá môn học này chứ?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                ClassDatabase classDatabase = new ClassDatabase(context);
                                classDatabase.open();
                                classDatabase.deleteClass(studyClass.getId());
                                listdata.remove(studyClass);
                                notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        });
                 builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

//                ClassDatabase classDatabase = new ClassDatabase(context);
//                classDatabase.open();
//                classDatabase.deleteClass(studyClass.getId());
//                listdata.remove(studyClass);
//                notifyDataSetChanged();

            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
        class ViewHolder extends RecyclerView.ViewHolder{
            LinearLayout linearLayout;
            TextView tvClassname, tvStarttime, tvEndtime;
            Button btnDel;
        public ViewHolder(View itemView) {
            super(itemView);
            tvClassname = itemView.findViewById(R.id.tv_classname);
            tvStarttime = itemView.findViewById(R.id.tv_starttime);
            tvEndtime = itemView.findViewById(R.id.tv_endtime);
            btnDel = itemView.findViewById(R.id.btn_delete);
            linearLayout = itemView.findViewById(R.id.listitem);

        }
    }

}
