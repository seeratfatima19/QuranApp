package com.example.quranmajeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplaySurah extends AppCompatActivity {

    ListView listView;
    TextView textView;
    EditText searchBar;
    AppCompatButton seacrchButton;
    ArrayList<String> surah= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_surah);

        listView = (ListView) findViewById(R.id.surahData);
        textView = (TextView) findViewById(R.id.textView2);
        searchBar = (EditText)findViewById(R.id.searchBar);
        seacrchButton = (AppCompatButton)findViewById(R.id.searchbutton);
        // get surah name and position from intent
        Intent intent = getIntent();
        int surahNumber = intent.getIntExtra("number",0);
        String name = intent.getStringExtra("surahName");

        textView.setText(name);
        // get start and end point of surah
        QDH qdh=new QDH();
        int start = qdh.SSP[surahNumber];
        int end = qdh.surahAyatCount[surahNumber]+start-1;

        // get surah array
        QuranArabicText qat = new QuranArabicText();

        surah.add(qat.QuranArabicText[0]);

        for (int i = start; i <= end; i++) {
            surah.add(qat.QuranArabicText[i]);
        }

        // display surah
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,surah);
        listView.setAdapter(arrayAdapter);

        // handle click event
        seacrchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ayat = searchBar.getText().toString();
                int numAyat = Integer.parseInt(ayat);
                int numToDisplay = start+numAyat-1;

                String toDisplay = qat.QuranArabicText[start+numAyat-1];
                Intent intent = new Intent(DisplaySurah.this,TakeAyat.class);
                intent.putExtra("ayatNum",toDisplay);

                if(numToDisplay<=end){
                    intent.putExtra("flag",true);
                }
                else{
                    intent.putExtra("flag",false);
                }
                startActivity(intent);

            }
        });
    }
}