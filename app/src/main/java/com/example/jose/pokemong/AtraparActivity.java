package com.example.jose.pokemong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import adapters.RecyclerAdapter;

public class AtraparActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrapar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);



        mRecyclerView.setHasFixedSize(true);



    }
}





