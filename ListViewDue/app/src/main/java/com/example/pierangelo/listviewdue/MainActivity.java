package com.example.pierangelo.listviewdue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/// array of option --> ArrayAdapter --> ListView

/// list view:{views: contenuto_list.xml}

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// creo l'azione
        popolaListView();

        /// creo aziione per pop up quando clicchi su items
        azioneclick();
    }


    private void popolaListView() {

        /// create List of items
        String[] valori = {"Roma", "Berlino", "Parigi", "Londra"};

        /// build adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.contenuto_list, valori);

        /// Configure ListView
        ListView list = (ListView) findViewById(R.id.listViewUno);
        list.setAdapter(adapter);

    }

    private void azioneclick() {
        ListView list = (ListView) findViewById(R.id.listViewUno);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String messaggio = "Tu hai cliccato  # " + position
                        + ", che è la stringa: " + textView.getText().toString(); ///position indica id dell'item
                Toast.makeText(MainActivity.this, messaggio, Toast.LENGTH_LONG).show();

            }
        });
    }


}
