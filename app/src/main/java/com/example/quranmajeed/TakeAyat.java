package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TakeAyat extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_ayat);
        textView = findViewById(R.id.textView);

        String ayat = getIntent().getStringExtra("ayatNum");
        textView.setText(ayat);
    }
}