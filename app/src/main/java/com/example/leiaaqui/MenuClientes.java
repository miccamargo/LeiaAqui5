package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MenuClientes extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_clientes);
        Button cadCliente = (Button) findViewById(R.id.btnCadCliente);
        cadCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuClientes.this, Clientes.class);
                startActivity(it);
            }
        });

        Button altCliente = (Button) findViewById(R.id.btnAltCliente);
        altCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuClientes.this, AltClientes.class);
                startActivity(it);
            }
        });

        Button exCliente = (Button) findViewById(R.id.btnExCliente);
        exCliente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuClientes.this, ExClientes.class);
                startActivity(it);
            }
        });


    }}
