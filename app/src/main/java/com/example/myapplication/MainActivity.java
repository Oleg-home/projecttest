package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind();
        initRecycler();
    }

    private void bind() {
        rv = findViewById(R.id.rv);
    }

    private void initRecycler() {
        ListAdapter adapter = new ListAdapter();
        adapter.setData(getNumberList(550));
        rv.setAdapter(adapter);
    }

    private List<Integer> getNumberList(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return list;
    }
}