package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind();
    }

    private void bind() {
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        root = findViewById(R.id.root);

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv1.getVisibility() == View.VISIBLE){
                    tv1.setVisibility(View.GONE);
                } else {
                    tv1.setVisibility(View.VISIBLE);
                }
            }
        });

        tv1.setOnClickListener(null);

    }
}