package com.example.pierangelo.listviewjson;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ListActivity {

    private Context context;
    private static String url = "https://www.dati.lombardia.it/resource/r9fb-4fm4.json";

    private static final String TAG_DENOMINAZIO = "denominazione";
    private static final String TAG_COMUNE = "comune";
    private static final String TAG_INDIRIZZO = "indirizzo";
    //private static final String TREAD = "Tread";

    ArrayList<HashMap<String, String>> jsonlist = new ArrayList<HashMap<String, String>>();

    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ProgressTask(MainActivity.this).execute();
    }


    private class ProgressTask extends AsyncTask<String, Void, Void> {

        private ProgressDialog dialog;

        private MainActivity activity;

        public ProgressTask(MainActivity activity) {

            this.activity = activity;

            context = activity;

            dialog = new ProgressDialog(context);

        }

        private Context context;

        protected void onPreExecute() {

            this.dialog.setMessage("Progress start");
            this.dialog.show();

        }

        @Override
        protected void onPostExecute(final Void success) {

            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            ListAdapter adapter = new SimpleAdapter(context, jsonlist, R.layout.contenuto_lista,
                    new String[]{TAG_DENOMINAZIO, TAG_COMUNE, TAG_INDIRIZZO},
                    new int[]{R.id.labelDenominazione, R.id.labelComune, R.id.labelIndirizzo});

            setListAdapter(adapter);

            lv = getListView();

        }

        
        protected Void doInBackground(String... params) {

            JSONParser jParser = new JSONParser(); // get JSON data from URL
            JSONArray json = jParser.getJSONFromUrl(url);

            for (int i = 0; i < json.length(); i++)
                try {

                    JSONObject c = json.getJSONObject(i);
                    String denominazione = c.getString(TAG_DENOMINAZIO);
                    String comune = c.getString(TAG_COMUNE);
                    String indirizzo = c.getString(TAG_INDIRIZZO);

                    HashMap<String, String> map = new HashMap<String, String>();

                    map.put(TAG_DENOMINAZIO, denominazione);
                    map.put(TAG_COMUNE, comune);
                    map.put(TAG_INDIRIZZO, indirizzo);

                    jsonlist.add(map);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            return null;
        }

    }
}

