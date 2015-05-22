package com.example.pierangelo.demolistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


// array of options --> ArrayAdapter --> ListView

//List view: {views: contenuto_listview.xml}


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
    }

    private void populateListView() {
        /// Creaiamo la Lista di items
        String[] myItems = {"Roma", "Berlino", "Parigi", "Londra", "Madrid"};

        /// Costruiamo l'adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,                                   /// context
                R.layout.contenuto_listview,            /// layout della listViw (da me creato in layout/contenuto_listview.xml
                myItems);                               ///dati da mostrare (Items)

        /// Configuriamo la listView
        ListView list = (ListView) findViewById(R.id.listViewTest);
        list.setAdapter(adapter);
    }


}
