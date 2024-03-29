package com.example.leiaaqui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AltClientes extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt_clientes);
        Button altCliente = (Button) findViewById(R.id.btnAlterarCliente);

        Spinner spinner = findViewById(R.id.txtCategoriaCliente);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.catLeitores, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        altCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText) findViewById(R.id.txtNomeCliente);
                EditText Email = (EditText) findViewById((R.id.txtEmailCliente));
                EditText CPF = (EditText) findViewById(R.id.txtCPFCliente);
                EditText Endereço = (EditText) findViewById(R.id.txtEnderecoCliente);
                EditText Celular = (EditText) findViewById(R.id.txtCelularCliente);
                EditText DataNasc = (EditText) findViewById(R.id.txtDataNascCliente);
                Spinner CatCliente = (Spinner) findViewById(R.id.txtCategoriaCliente);
                String NOME_CLIENTE = nome.getText().toString();
                String ENDERECO_CLIENTE = Endereço.getText().toString();
                String CELULAR_CLIENTE = Celular.getText().toString();
                String EMAIL_CLIENTE = Email.getText().toString();
                String CPF_CLIENTE = CPF.getText().toString();
                String DATANASC_CLIENTE = DataNasc.getText().toString();
                String IDCATEGORIALEITOR_FK = CatCliente.getSelectedItem().toString();
                String resultado;
                resultado = crud.alteraRegistroCliente(NOME_CLIENTE, ENDERECO_CLIENTE, CELULAR_CLIENTE,
                        EMAIL_CLIENTE, CPF_CLIENTE, DATANASC_CLIENTE,
                        Integer.parseInt(IDCATEGORIALEITOR_FK);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
        altCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AltClientes.this, MenuClientes.class);
                startActivity(intent);
            }
        });
    }
}

