package com.sviluppo.pierangelo.fragmentprova;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.sviluppo.pierangelo.fragmentprova.R.id.fragment_ott;

public class ProvaActivity extends AppCompatActivity implements UnoFragment.ProvaInvia {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prova);
    }

    @Override
    public void InviaDati(String nome, String cognome)
    {
        DueFragment due = (DueFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_ott);
        due.inserisciDati(nome, cognome);
    }
}
