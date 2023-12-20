package com.example.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistacurso.model.Pessoa;
import com.example.applistacurso.view.MainActivity;

public class PessoaController {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_listavip";

    public  PessoaController(MainActivity mainActivity){
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }


    @NonNull
    @Override
    public String toString() {
        Log.d("MVC", "Controller iniciada");
        return super.toString();
    }


    public void salvar(Pessoa pessoa) {

        Log.i("MVC", "salvo: "+pessoa.toString());

        listaVip.putString("primeiroNome", pessoa.getNome());
        listaVip.putString("sobrenome", pessoa.getSobrenome());
        listaVip.putString("curso", pessoa.getCurso());
        listaVip.putString("telefone", pessoa.getTelefone());
        listaVip.apply();
    }

    public Pessoa buscar(Pessoa pessoa){
        pessoa.setNome(preferences.getString("primeiroNome","NA"));
        pessoa.setSobrenome(preferences.getString("sobrenome","NA"));
        pessoa.setCurso(preferences.getString("curso","NA"));
        pessoa.setTelefone(preferences.getString("telefone","NA "));
        return pessoa;
    }

    public void limpar(){
        listaVip.clear();
        listaVip.apply();
    }
}
