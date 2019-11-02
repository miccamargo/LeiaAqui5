package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CatLivros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_livros);
        Button cadCatLivros = (Button) findViewById(R.id.btnCadastrarCatLivros);

        cadCatLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText codCategoria = (EditText) findViewById(R.id.txtIDCatLivro);
                CheckBox Livro = (CheckBox) findViewById((R.id.checkCatLivro));
                CheckBox Periodico = (CheckBox) findViewById((R.id.checkCatPeriodico));
                CheckBox Revista = (CheckBox) findViewById((R.id.checkCatRevista));
                CheckBox Jornal = (CheckBox) findViewById((R.id.checkCatJornal));
                CheckBox Didatica = (CheckBox) findViewById((R.id.checkCatDidatica));
                CheckBox Relatorio = (CheckBox) findViewById((R.id.checkCatRelatorio));
                CheckBox Tese = (CheckBox) findViewById((R.id.checkCatTese));
                CheckBox Mestrado = (CheckBox) findViewById((R.id.checkCatMestrado));
                EditText DiaEmprestimo = (EditText) findViewById(R.id.txtDiasEmprestimoCatLivro);
                EditText TaxaMulta = (EditText) findViewById(R.id.txtTaxaMulta);
                String DIAS_LIVROS = DiaEmprestimo.getText().toString();
                String TAXA_LIVROS = TaxaMulta.getText().toString();

                String s = "";
                if (Livro.isChecked()) {
                    s += "\n Livro";
                }
                if (Periodico.isChecked()) {
                    s += "\n Periódico";
                }
                if (Revista.isChecked()) {
                    s += "\n Revista";
                }
                if (Jornal.isChecked()) {
                    s += "\n Jornal";
                }
                if (Didatica.isChecked()) {
                    s += "\n Nota Didática";
                }
                if (Relatorio.isChecked()) {
                    s += "\n Relatório Técnico";
                }
                if (Tese.isChecked()) {
                    s += "\n Tese de Doutorado";
                }
                if (Mestrado.isChecked()) {
                    s += "\n Dissertação de Mestrado";
                }

                String DESCRICAO_LIVROS = s.getText().toString();

                String resultado = crud.insereDadosCatLivros(DIAS_LIVROS, DESCRICAO_LIVROS, TAXA_LIVROS);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
        cadCatLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatLivros.this, MenuCatLivros.class);
                startActivity(intent);
            }
        });
    }

}
