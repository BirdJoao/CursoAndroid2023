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
        SharedPreferences.Editor listaVip = preferences.edit();

        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);
        btnLimpar = findViewById(R.id.buttonLimpar);
        btnFechar = findViewById(R.id.buttonFechar);
        btnSalvar = findViewById(R.id.buttonSalvar);


        pessoa = new Pessoa();
        controller = new PessoaController();
        pessoa.setNome("João");
        pessoa.setSobrenome("Marques");
        pessoa.setCurso("Java");
        pessoa.setTelefone("14998005451");

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
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            //ssss
            //ss
            public void onClick(View v) {
                String nome, sobrenome, curso, telefone;
                nome = editNome.getText().toString();
                sobrenome = editSobrenome.getText().toString();
                curso = editCurso.getText().toString();
                telefone = editTelefone.getText().toString();


                Toast.makeText(MainActivity.this, nome +" " + sobrenome + " Cursando o curso " + curso + " contato: " +telefone, Toast.LENGTH_SHORT).show();

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