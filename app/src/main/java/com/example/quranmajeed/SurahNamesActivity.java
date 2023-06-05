package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SurahNamesActivity extends AppCompatActivity {

    ArrayList<String> ar = new ArrayList<>();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_names);

        QDH qdh = new QDH();
        ar = qdh.GetSurahNames();

        for(int i=0;i<ar.size();i++) {
            System.out.println(ar.get(i).toString());
        }
        list = findViewById(R.id.surahNameView);

        ArrayAdapter arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ar);
        list.setAdapter(arrayAdapter);
    }
}