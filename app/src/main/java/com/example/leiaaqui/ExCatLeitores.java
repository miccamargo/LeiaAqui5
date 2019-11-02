package com.example.leiaaqui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ExCatLeitores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_cat_leitores);
        Button exCatLeitores = (Button) findViewById(R.id.btnExcluirCatLeitores);

        exCatLeitores.setOnClickListener(new View.OnClickListener() {
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
                Toast.makeText(ExCatLeitores.this, radioGroup.getText(), Toast.LENGTH_SHORT).show();
                String DESCRICAO_LEITORES = radioGroup.toString();

                String resultado = crud.deletaCategoriaLeitores((Integer.parseInt(ID_LEITORES));
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }

        });
        exCatLeitores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExCatLeitores.this, MenuCatLeitores.class);
                startActivity(intent);
            }
        });

    }
                    /*
                String categoria = "";
                if (Estudante.isChecked())
                    categoria = "Estudante";
                 else if (Professor.isChecked())
                    categoria = "Professor";
                 else (Comum.isChecked())
                    categoria = "Usuário Comum";
                    */
}
