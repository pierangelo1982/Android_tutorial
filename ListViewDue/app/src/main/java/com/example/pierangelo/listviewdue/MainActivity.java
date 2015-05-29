package com.example.pierangelo.listviewdue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;


/// array of option --> ArrayAdapter --> ListView

/// list view:{views: contenuto_list.xml}

public class MainActivity extends Activity {

    ListView listViewUno;
    TextView denominazioneLabel;
    TextView name;
    TextView api;
    Button Btngetdata;
    ArrayList<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();

    //URL to get JSON Array
    private static String url = "https://www.dati.lombardia.it/resource/r9fb-4fm4.json";

    //JSON Node Names
    private static final String TAG_DENOMINAZIONE = "denominazione";
    private static final String TAG_COMUNE = "comune_provincia";
    private static final String TAG_INDIRIZZO = "indirizzo";
    private static final String TAG_TELEFONO = "telefono";

    JSONArray android = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();


        /// creo aziione per pop up quando clicchi su items
        //azioneclick();
    }


    
}
