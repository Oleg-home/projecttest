package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> show());

    }

    private void show() {
        BottomSheetDialog bosh = new BottomSheetDialog(this, R.style.bottomCustomStyle);
        View view = getLayoutInflater().inflate(R.layout.bottom_dialog, findViewById(R.id.root));
        bosh.setContentView(view);
        bosh.show();

        view.postDelayed(() -> {
            view.findViewById(R.id.root).setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.red));
        }, 1000);
    }
}