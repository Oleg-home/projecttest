package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    EditText etSearch;
    View divider;
    ConstraintLayout root;
    GradientDrawable etBackground = new GradientDrawable();
    private boolean isOpen = false;
    private boolean isAnimating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bind();
        initRecycler();
    }

    private void bind() {
        rv = findViewById(R.id.rv);
        etSearch = findViewById(R.id.etSearch);
        divider = findViewById(R.id.divider);
        root = findViewById(R.id.root);

        etBackground.setCornerRadii(new float[]{60f, 60f, 60f, 60f, 60f, 60f, 60f, 60f});
        etBackground.setColor(getResources().getColor(R.color.blue));
        etSearch.addTextChangedListener(getTextWatcher());
        etSearch.setBackground(etBackground);

        root.setOnClickListener(v -> animateCorners());
    }

    private void animateCorners() {
        if (isAnimating) return;
        float start = 60;
        float end = 0;
        if (isOpen) {
            start = 0;
            end = 60;
        }
        isOpen = !isOpen;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(start, end);
        valueAnimator.addUpdateListener(animation -> {
            float c = (Float) animation.getAnimatedValue();
            etBackground.setCornerRadii(new float[]{60f, 60f, 60f, 60f, c, c, c, c});
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                isAnimating = false;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                isAnimating = false;
            }

            @Override
            public void onAnimationStart(Animator animation) {
                isAnimating = true;
            }
        });
        valueAnimator.setDuration(200);
        valueAnimator.start();
    }


    private void initRecycler() {
        ListAdapter adapter = new ListAdapter();
        adapter.setData(getNumberList(25));
        rv.setAdapter(adapter);
    }

    private TextWatcher getTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 2) {
                    etBackground.setCornerRadii(new float[]{60f, 60f, 60f, 60f, 0f, 0f, 0f, 0f});
                    divider.setVisibility(View.VISIBLE);
                    rv.setVisibility(View.VISIBLE);
                } else {
                    etBackground.setCornerRadii(new float[]{60f, 60f, 60f, 60f, 60f, 60f, 60f, 60f});
                    divider.setVisibility(View.GONE);
                    rv.setVisibility(View.GONE);
                }
                etSearch.setBackground(etBackground);
            }
        };
    }

    private List<Integer> getNumberList(int count) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return list;
    }
}