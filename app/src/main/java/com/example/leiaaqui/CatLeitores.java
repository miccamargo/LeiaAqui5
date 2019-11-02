package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CatLeitores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_leitores);
        Button cadCatLeitores = (Button) findViewById(R.id.btnCadastrarCatLeitores);

        cadCatLeitores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoController crud = new BancoController(getBaseContext());
                EditText codCategoria = (EditText) findViewById(R.id.txtIDCatLeitor);
                RadioButton Estudante = (RadioButton) findViewById((R.id.radioEstudante));
                RadioButton Professor = (RadioButton) findViewById((R.id.radioProfessor));
                RadioButton Comum = (RadioButton) findViewById((R.id.radioComum));
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
                EditText DiaEmprestimo = (EditText) findViewById(R.id.txtDiasEmprestimoLeitor);
                String ID_LEITORES = codCategoria.getText().toString();
                String DIAS_LEITORES = DiaEmprestimo.getText().toString();

                int selectedID = radioGroup.getCheckedRadioButtonId();
                radioGroup = (RadioGroup) findViewById(selectedID);
                Toast.makeText(CatLeitores.this, radioGroup.getText(), Toast.LENGTH_SHORT).show();
                String DESCRICAO_LEITORES = radioGroup.toString();

                String resultado = crud.insereDadosCatLeitores(DESCRICAO_LEITORES, DIAS_LEITORES);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }

        });
        cadCatLeitores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatLeitores.this, MenuCatLeitores.class);
                startActivity(intent);
            }
        });

    }