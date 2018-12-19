package com.example.asus.timetable;



import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.asus.timetable.DayOfWeekFragment.FragmentDayOfWeek;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView tvCurrent;
    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);
    Intent intent = getIntent();
    int state = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        tvCurrent = findViewById(R.id.tv_current);
        navigationView = findViewById(R.id.nav);

        toolbar.setTitle("Thời khoá biểu");
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        if(state ==0){
            currentDay();
        } else {
            state = intent.getIntExtra("state",0);
            stateCurrent();
        }




    }

//    public void currentState() {
//        switch (state){
//            case 2:{
//                toolbar.setTitle("Thứ 2");
//                tvCurrent.setText("CÁC LỚP HỌC");
//                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
//                fragmentDayOfWeek.setDayOfWeek(2);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragmentDayOfWeek);
//                transaction.commit();
//                break;
//            }
//            case 3:{
//                toolbar.setTitle("Thứ 3");
//                tvCurrent.setText("CÁC LỚP HỌC");
//                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
//                fragmentDayOfWeek.setDayOfWeek(2);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragmentDayOfWeek);
//                transaction.commit();
//                break;
//            }
//            case 4:{
//                toolbar.setTitle("Thứ 4");
//                tvCurrent.setText("CÁC LỚP HỌC");
//                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
//                fragmentDayOfWeek.setDayOfWeek(2);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragmentDayOfWeek);
//                transaction.commit();
//                break;
//            }
//            case 5:{
//                toolbar.setTitle("Thứ 5");
//                tvCurrent.setText("CÁC LỚP HỌC");
//                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
//                fragmentDayOfWeek.setDayOfWeek(2);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragmentDayOfWeek);
//                transaction.commit();
//                break;
//            }
//            case 6:{
//                toolbar.setTitle("Thứ 6");
//                tvCurrent.setText("CÁC LỚP HỌC");
//                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
//                fragmentDayOfWeek.setDayOfWeek(2);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragmentDayOfWeek);
//                transaction.commit();
//                break;
//            }
//            case 7:{
//                toolbar.setTitle("Thứ 7");
//                tvCurrent.setText("CÁC LỚP HỌC");
//                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
//                fragmentDayOfWeek.setDayOfWeek(2);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragmentDayOfWeek);
//                transaction.commit();
//                break;
//            }
//            case 8:{
//                toolbar.setTitle("Chủ nhật");
//                tvCurrent.setText("CÁC LỚP HỌC");
//                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
//                fragmentDayOfWeek.setDayOfWeek(2);
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.container, fragmentDayOfWeek);
//                transaction.commit();
//                break;
//            }
//
//        }
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.monday : {
                toolbar.setTitle("Thứ 2");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Monday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(2);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case R.id.tuesday: {
                toolbar.setTitle("Thứ 3");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Tuesday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(3);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case R.id.wednesday: {
                toolbar.setTitle("Thứ 4");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Wednesday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(4);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case R.id.thusday: {
                toolbar.setTitle("Thứ 5");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Thursday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(5);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case R.id.friday: {
                toolbar.setTitle("Thứ 6");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Friday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(6);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case R.id.saturday: {
                toolbar.setTitle("Thứ 7");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Saturday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(7);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case R.id.sunday: {
                toolbar.setTitle("Chủ Nhật");
                tvCurrent.setText("CÁC LỚP HỌC");
                tvCurrent.setTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Sunday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(8);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case R.id.home: {
                currentDay();
            }

        }
        drawerLayout.closeDrawer(Gravity.START);
        return false;
    }

    public void currentDay(){
        switch (day) {
            case Calendar.SUNDAY: {
                tvCurrent.setText("CHỦ NHÂT");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Sunday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(8);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case Calendar.MONDAY:{
                tvCurrent.setText("THỨ HAI");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Monday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(2);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
            }
                break;
            case Calendar.TUESDAY: {
                tvCurrent.setText("THỨ BA");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Tuesday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(3);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case Calendar.WEDNESDAY: {
                tvCurrent.setText("THỨ TƯ");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Wednesday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(4);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case Calendar.THURSDAY: {
                tvCurrent.setText("THỨ NĂM");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Thursday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(5);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case Calendar.FRIDAY: {
                tvCurrent.setText("THỨ SÁU");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Friday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(6);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
            case Calendar.SATURDAY: {
                tvCurrent.setText("THỨ BẢY");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Saturday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(7);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }


        }

    }

    public void stateCurrent(){
        switch (state){
            case 2:{
                toolbar.setTitle("Thứ 2");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Monday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(2);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
             case 3:{
                toolbar.setTitle("Thứ 3");
                tvCurrent.setText("CÁC LỚP HỌC");
                 toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Tuesday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(3);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
             case 4:{
                toolbar.setTitle("Thứ 4");
                tvCurrent.setText("CÁC LỚP HỌC");
                 toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Wednesday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(4);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
             case 5:{
                toolbar.setTitle("Thứ 5");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Thursday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(5);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
             case 6:{
                toolbar.setTitle("Thứ 6");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Friday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(6);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
             case 7:{
                toolbar.setTitle("Thứ 7");
                tvCurrent.setText("CÁC LỚP HỌC");
                toolbar.setBackgroundColor(getResources().getColor( R.color.Saturday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(7);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }
             case 8:{
                toolbar.setTitle("Chủ Nhật");
                tvCurrent.setText("CÁC LỚP HỌC");
                 toolbar.setTitleTextColor(getResources().getColor(R.color.colorWhite));
                toolbar.setBackgroundColor(getResources().getColor( R.color.Sunday));
                FragmentDayOfWeek fragmentDayOfWeek = new FragmentDayOfWeek();
                fragmentDayOfWeek.setDayOfWeek(8);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragmentDayOfWeek);
                transaction.commit();
                break;
            }

        }
    }


}
