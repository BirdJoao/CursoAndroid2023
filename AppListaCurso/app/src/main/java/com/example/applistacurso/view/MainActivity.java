package com.example.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applistacurso.R;
import com.example.applistacurso.controller.PessoaController;
import com.example.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    SharedPreferences.Editor listaVip;
    SharedPreferences preferences;
    public static final String NOME_PREFERENCES = "pref_listavip";
    EditText editNome, editSobrenome, editCurso, editTelefone;
    Button btnSalvar, btnLimpar, btnFechar;
    Pessoa pessoa;
    PessoaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        pessoa.setNome(preferences.getString("primeiroNome","NA"));
        pessoa.setSobrenome(preferences.getString("sobrenome","NA"));
        pessoa.setCurso(preferences.getString("curso","NA"));
        pessoa.setTelefone(preferences.getString("telefone","NA "));

        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.buttonLimpar);
        btnFechar = findViewById(R.id.buttonFechar);
        btnSalvar = findViewById(R.id.buttonSalvar);

        editNome.setText(pessoa.getNome());
        editSobrenome.setText(pessoa.getSobrenome());
        editCurso.setText(pessoa.getCurso());
        editTelefone.setText(pessoa.getTelefone());

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Vai se fuder", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNome.setText("");
                editSobrenome.setText("");
                editCurso.setText("");
                editTelefone.setText("");

                //Limoando shared de preferencias
                listaVip.clear();
                listaVip.apply();

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pessoa.setNome(editNome.getText().toString());
                pessoa.setSobrenome(editSobrenome.getText().toString());
                pessoa.setCurso(editCurso.getText().toString());
                pessoa.setTelefone(editTelefone.getText().toString());


                Toast.makeText(MainActivity.this, "Salvo " +pessoa.toString(), Toast.LENGTH_SHORT).show();

                listaVip.putString("primeiroNome", pessoa.getNome());
                listaVip.putString("sobrenome", pessoa.getSobrenome());
                listaVip.putString("curso", pessoa.getCurso());
                listaVip.putString("telefone", pessoa.getTelefone());
                listaVip.apply();

                controller.salvar(pessoa);
            }
        });

    }
}