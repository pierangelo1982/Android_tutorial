package com.sviluppo.pierangelo.fragmentprova;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class UnoFragment extends Fragment
{
    public EditText tNome;
    public EditText tCognome;
    public Button btnIvia;
    ProvaInvia prova;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_uno, container, false);

        tNome = (EditText) view.findViewById(R.id.inputNome);
        tCognome = (EditText) view.findViewById(R.id.inputCognome);
        btnIvia = (Button) view.findViewById(R.id.buttonInvia);
        btnIvia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String tmp_nome = tNome.getText().toString();
                String tmp_cognome = tCognome.getText().toString();
                prova.InviaDati(tmp_nome, tmp_cognome);
            }
        });
        return view;
    }

    ///creo lpinterface da richiamare nell'activity principale'
    interface ProvaInvia
    {
        public void InviaDati(String nome, String cognome);// all'interno delle parentesi passo le funzioni, variabili ecc... che voglio
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        try {
            prova = (ProvaInvia) context;
        } catch (Exception e) {

        }
     }

}
