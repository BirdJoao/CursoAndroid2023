package com.example.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.applistacurso.model.Pessoa;

public class PessoaController {
    @NonNull
    @Override
    public String toString() {
        Log.d("MVC", "Controller iniciada");
        return super.toString();
    }

    public void salvar(Pessoa pessoa) {
        Log.d("MVC", "salvo: "+pessoa.toString());
    }
}
