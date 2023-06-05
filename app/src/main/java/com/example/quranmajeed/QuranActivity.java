package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QuranActivity extends AppCompatActivity {

    AppCompatButton ayat;
    AppCompatButton surah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);

        surah = (AppCompatButton)findViewById(R.id.surahButton);
        ayat = (AppCompatButton)findViewById(R.id.ayatButton);
        surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuranActivity.this,SurahNamesActivity.class);
                startActivity(intent);
            }
        });

        ayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuranActivity.this, TakeAyat.class);
                startActivity(intent);
            }
        });


    }
}