package com.example.leiaaqui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

public class ConsultaDadosCatLeitores extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_dados_cat_leitores);
        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDadosCatLeitores();
        String[] nomeCampos = new String[] {CriaBanco.getIdLeitores(), CriaBanco.getTabelaLeitores()};
        int[] idViews = new int[] {R.id.txtIDCatLeitor};
        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_consulta_dados_cat_leitores,cursor,nomeCampos,idViews, 0);
        lista = (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.getIdLeitores()));
                Intent intent = new Intent(ConsultaDadosCatLeitores.this, AltCatLeitores.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}
