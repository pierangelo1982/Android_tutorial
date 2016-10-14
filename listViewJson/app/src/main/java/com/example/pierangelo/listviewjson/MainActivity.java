package com.example.pierangelo.listviewjson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {

    ///String urlok = "https://www.dati.lombardia.it/resource/r9fb-4fm4.json";
    String urlok = "http://perfectacavi.it/cables.json";

    private Context context;

    static final String TAG_TITOLO = "titolo";
    static final String TAG_PUB = "tipo_cavo";
    static final String TAG_IMG = "immagine";

    ArrayList<HashMap<String, String>> jsonlist = new ArrayList<HashMap<String, String>>();



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
            this.dialog.setMessage("Gira la Ruota gira la ruota");
            this.dialog.show();
        }

        @Override
        protected void onPostExecute(final Void success) {

            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            ///ArrayAdapter
            ArrayList myjson = new ArrayList(jsonlist);
            TagAdapter adapter = new TagAdapter(MainActivity.this, myjson);
            ListView list = (ListView) findViewById(android.R.id.list);
            list.setAdapter(adapter);

            Log.d("milano", String.valueOf(TAG_IMG));

            /*
            ListAdapter adapter = new SimpleAdapter(context, jsonlist, R.layout.contenuto_lista,
                    new String[]{TAG_DENOMINAZIO, TAG_COMUNE, TAG_INDIRIZZO},
                    new int[]{R.id.labelDenominazione, R.id.labelComune, R.id.labelIndirizzo});

            ListView list = (ListView) findViewById(android.R.id.list);
            list.setAdapter(adapter); */

        }


        protected Void doInBackground(String... params) {

            ///String urlok = "http://falegnameriapea.it/json/index/";

            JSONParser jParser = new JSONParser(); // get JSON data from URL

            String par = jParser.makeServiceCall(urlok, JSONParser.GET);

                try {
                    JSONArray json = new JSONArray(par);

                    ///for (int i = 0; i < json.length(); i++) {
                    for (int i = 0; i < 3; i++) {


                        //JSONObject b = json.getJSONObject(i);
                        ///JSONObject c = b.getJSONObject("fields");
                        JSONObject c = json.getJSONObject(i);
                        String titolo = c.getString(TAG_TITOLO);
                        String pubdate = c.getString(TAG_PUB);
                        String immagine = c.getString(TAG_IMG);

                        HashMap<String, String> map = new HashMap<String, String>();

                        map.put(TAG_TITOLO, titolo);
                        map.put(TAG_PUB, pubdate);
                        map.put(TAG_IMG, "http://www.perfectacavi.it/" + immagine);

                        jsonlist.add(map);
                    }
            } catch (JSONException e) {
                    e.printStackTrace();
                }
            return null;
        }



    }


}
