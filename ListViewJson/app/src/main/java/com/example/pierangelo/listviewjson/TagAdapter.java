package com.example.pierangelo.listviewjson;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by pierangelo on 01/08/15.
 */

public class TagAdapter extends BaseAdapter {

    private Bitmap bm;
    // Declare Variables
    Context context;
    LayoutInflater inflater;
    ArrayList<HashMap<String, String>> data;
    HashMap<String, String> resultp = new HashMap<String, String>();

    public TagAdapter(Context context,
                           ArrayList<HashMap<String, String>> arraylist) {
        this.context = context;
        data = arraylist;
    }


    public class ViewHolder{
        TextView txtDenominazio;
        TextView txtComune;
        TextView txtIndirizzo;
        ImageView txtImage;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            ///LayoutInflater inflater = LayoutInflater.from(getContext());
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            resultp = data.get(position);

            ///convertView = inflater.inflate(R.layout.contenuto_lista, parent, false);
            convertView = inflater.inflate(R.layout.contenuto_lista, parent, false);
            holder.txtDenominazio = (TextView) convertView.findViewById(R.id.labelDenominazione);
            holder.txtComune = (TextView) convertView.findViewById(R.id.labelComune);
            holder.txtIndirizzo = (TextView) convertView.findViewById(R.id.labelIndirizzo);
            holder.txtImage = (ImageView) convertView.findViewById(R.id.labelImage);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtDenominazio.setText(resultp.get(MainActivity.TAG_TITOLO));
        holder.txtComune.setText(resultp.get(MainActivity.TAG_PUB));
        holder.txtIndirizzo.setText(resultp.get(MainActivity.TAG_IMG));

        String url = resultp.get(MainActivity.TAG_IMG);
        //String url = "http://www.glrarredamenti.com/media/uploaded_images/magiclotus60.jpg.500x469_q85_box-0%2C0%2C400%2C375_crop_detail.jpg";
        //bm = Utils.getBitmapFromURL(url);

        // Loader image - will be shown before loading image
        int loader = R.drawable.powered_by_google_dark;

        ImageLoader imgLoader = new ImageLoader(context.getApplicationContext());
        imgLoader.DisplayImage(url, loader, holder.txtImage);


        Log.d("brescia", String.valueOf(bm));
        return convertView;
    }



}
