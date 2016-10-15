package com.sviluppo.pierangelo.fragmentprova;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class DueFragment extends Fragment {

    TextView nome;
    TextView cognome;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_due, container, false);

        nome = (TextView) view.findViewById(R.id.textNome);
        cognome = (TextView) view.findViewById(R.id.textCognome);

        return view;
    }

    // creo funzione di ricezione dati, poi la richiamerò nell'activity principale
    public void inserisciDati(String tmp_name, String tmp_cognome) {
        nome.setText(tmp_name);
        cognome.setText(tmp_cognome);
    }
}
