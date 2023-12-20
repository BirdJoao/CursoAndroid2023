package com.example.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applistacurso.R;
import com.example.applistacurso.controller.CursoController;
import com.example.applistacurso.controller.PessoaController;
import com.example.applistacurso.model.CursoDesejado;
import com.example.applistacurso.model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editNome, editSobrenome, editCurso, editTelefone;
    Button btnSalvar, btnLimpar, btnFechar;
    Pessoa pessoa;
    List<CursoDesejado> listaDeCurso;
    PessoaController controller;
    CursoController cursoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        listaDeCurso = cursoController.getListaDeCursos();

        pessoa = new Pessoa();
        controller.buscar(pessoa);

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

                controller.limpar();
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


                controller.salvar(pessoa);
            }
        });

    }
}