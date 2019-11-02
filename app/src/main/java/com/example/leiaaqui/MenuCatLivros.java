package com.example.leiaaqui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuCatLivros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_cat_livros);


        Button cadCatLivro = (Button) findViewById(R.id.btnCadCatLivro);
        cadCatLivro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuCatLivros.this, CatLivros.class);
                startActivity(it);
            }
        });

        Button altCatLivro = (Button) findViewById(R.id.btnAltCatLivro);
        altCatLivro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuCatLivros.this, AltCatLivros.class);
                startActivity(it);
            }
        });

        Button exCatLivro = (Button) findViewById(R.id.btnExCatLivro);
        exCatLivro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuCatLivros.this, ExCatLivros.class);
                startActivity(it);
            }
        });

    }
}
