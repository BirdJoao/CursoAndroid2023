package com.example.applistacurso.controller;

import com.example.applistacurso.model.CursoDesejado;

import java.util.ArrayList;
import java.util.List;

public class CursoController {

    private List listCursos;
    public List getListaDeCursos(){

        listCursos = new ArrayList<CursoDesejado>();

        listCursos.add(new CursoDesejado("Java"));
        listCursos.add(new CursoDesejado("Android"));
        listCursos.add(new CursoDesejado("Linux"));
        listCursos.add(new CursoDesejado("PHP"));
        listCursos.add(new CursoDesejado("MySql"));

        return listCursos;

    }

    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> dados = new ArrayList<>();

        for(int i = 0; i < getListaDeCursos().size(); i++){
            CursoDesejado objeto = (CursoDesejado) getListaDeCursos().get(i);
            dados.add(objeto.getCursoDesejado());
        }

        return dados;
    }

}
