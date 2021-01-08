package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind();

    }

    private void bind() {
        rv = findViewById(R.id.rv);
        Adapter adapter = new Adapter();
        adapter.setData(getList());
        adapter.setClicker(new Adapter.Clicker() {
            @Override
            public void onClick(String text) {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
        rv.setAdapter(adapter);
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
}