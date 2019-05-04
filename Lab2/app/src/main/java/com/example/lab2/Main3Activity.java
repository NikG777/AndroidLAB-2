package com.example.lab2;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    ViewPager viewPager;
    CustomSwipeAdaptor adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Info> inffromintent = (ArrayList<Info>)getIntent().getSerializableExtra("mas");
        int index = (int)getIntent().getExtras().getInt("index");
        setContentView(R.layout.activity_main3);
        viewPager = (ViewPager)findViewById(R.id.view_pager );
        adapter = new CustomSwipeAdaptor(this,inffromintent);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(index);
    }
}
