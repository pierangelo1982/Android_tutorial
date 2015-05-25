package com.example.pierangelo.listviewjson;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.pierangelo.listviewjson.R.layout.contenuto_list;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popolaListView();
    }

    private void popolaListView() {
        String[] myitems = {"Roma", "Berlino", "Madrid", "Lisbona"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.contenuto_list, myitems);

        ListView listView = (ListView) findViewById(R.id.listViewTest);
        listView.setAdapter(adapter);
    }


}
