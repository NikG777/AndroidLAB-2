package com.example.lab2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Info> inffromintent = (ArrayList<Info>)getIntent().getSerializableExtra("info");
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recyclerviewid);
        setuprecycleview(inffromintent);
    }

    private void setuprecycleview(ArrayList<Info> info)
    {
        RecycleViewAdapter myadapter = new RecycleViewAdapter(info,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}
