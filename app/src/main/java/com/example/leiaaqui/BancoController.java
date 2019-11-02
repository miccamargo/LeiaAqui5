package com.example.leiaaqui;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;


public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    //CRUD - Categoria Leitores

    public String insereDadosCatLeitores(String DIAS_LEITORES, String DESCRICAO_LEITORES){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getDiasLeitores(), DIAS_LEITORES);
        valores.put(CriaBanco.getDescricaoLeitores(), DESCRICAO_LEITORES);
        resultado = db.insert(CriaBanco.getTabelaLeitores(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDadosCatLeitores(){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdLeitores(),CriaBanco.getDiasLeitores(), CriaBanco.getDescricaoLeitores()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLeitores(), campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosCatLeitoresPorID(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdLeitores(),CriaBanco.getDiasLeitores(), CriaBanco.getDescricaoLeitores()};
        String where = CriaBanco.getIdLeitores() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLeitores(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public void alteraRegistroCatLeitores(int id, String diasleitores, String descricao){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.getIdLeitores() + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.getDescricaoLeitores(), descricao);
        valores.put(CriaBanco.getDiasLeitores(), diasleitores);

        db.update(CriaBanco.getTabelaLeitores(), valores, where, null);
        db.close();
    }

    public void deletaCategoriaLeitores(int id){
        String where = CriaBanco.getIdLeitores() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaLeitores(),where,null);
        db.close();
    }


    //CRUD - Categoria Livros

    public String insereDadosCatLivros(String DIAS_LIVROS, String DESCRICAO_LIVROS, String TAXA_LIVROS){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getDiasLivros(), DIAS_LIVROS);
        valores.put(CriaBanco.getDescricaoLivros(), DESCRICAO_LIVROS);
        valores.put(CriaBanco.getTaxaLivros(), TAXA_LIVROS);
        resultado = db.insert(CriaBanco.getTabelaLivros(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDadosCatLivros(){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdLivros(),CriaBanco.getDiasLivros(), CriaBanco.getDescricaoLivros(), CriaBanco.getTaxaLivros()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLivros(), campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosCatLivrosPorID(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdLivros(),CriaBanco.getDiasLivros(), CriaBanco.getDescricaoLivros(), CriaBanco.getTaxaLivros()};
        String where = CriaBanco.getIdLivros() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLivros(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public void alteraRegistroCatLivros(int id, String Dias_livros, String descricao_livros, String taxa_livros){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.getIdLivros() + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.getDiasLivros(), Dias_livros);
        valores.put(CriaBanco.getDescricaoLivros(), descricao_livros);
        valores.put(CriaBanco.getTaxaLivros(), taxa_livros);

        db.update(CriaBanco.getTabelaLivros(), valores, where, null);
        db.close();
    }

    public void deletaCategoriaLivros(int id){
        String where = CriaBanco.getIdLivros() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaLivros(),where,null);
        db.close();
    }


    //CRUD - Livros

    public String insereDadosLivro(int id, String TITULO_LIVRO, String AUTOR_LIVRO, String EDITORA_LIVRO,
                                   String NUMEROPAGINA_LIVRO, String ISBN_LIVRO, String PALAVRACHAVE_LIVRO,
                                   String DATAPUPLICACAO_LIVRO, String NUMEROEDICAO_LIVRO, String IDCATEGORIALIVRO_FK){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getTituloLivro(), TITULO_LIVRO);
        valores.put(CriaBanco.getAutorLivro(), AUTOR_LIVRO);
        valores.put(CriaBanco.getEditoraLivro(), EDITORA_LIVRO);
        valores.put(CriaBanco.getNumeropaginaLivro(),NUMEROPAGINA_LIVRO);
        valores.put(CriaBanco.getIsbnLivro(),ISBN_LIVRO);
        valores.put(CriaBanco.getPalavrachaveLivro(),PALAVRACHAVE_LIVRO);
        valores.put(CriaBanco.getDatapuplicacaoLivro(),DATAPUPLICACAO_LIVRO);
        valores.put(CriaBanco.getNumeroedicaoLivro(),NUMEROEDICAO_LIVRO);
        valores.put(CriaBanco.getIdcategorialivroFk(),IDCATEGORIALIVRO_FK);
        resultado = db.insert(CriaBanco.getTabelaLivro(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    public Cursor carregaDadosLivros(){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdLivro(),CriaBanco.getTituloLivro(), CriaBanco.getAutorLivro(), CriaBanco.getEditoraLivro(),
                CriaBanco.getNumeropaginaLivro(),CriaBanco.getIsbnLivro(), CriaBanco.getPalavrachaveLivro(), CriaBanco.getDatapuplicacaoLivro(),
                CriaBanco.getNumeroedicaoLivro(), CriaBanco.getIdcategorialivroFk()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLivro(), campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosLivrosPorID(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdLivro(),CriaBanco.getTituloLivro(), CriaBanco.getAutorLivro(), CriaBanco.getEditoraLivro(),
                CriaBanco.getNumeropaginaLivro(),CriaBanco.getIsbnLivro(), CriaBanco.getPalavrachaveLivro(), CriaBanco.getDatapuplicacaoLivro(),
                CriaBanco.getNumeroedicaoLivro(), CriaBanco.getIdcategorialivroFk()};
        String where = CriaBanco.getIdLivro() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaLivro(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistroLivro(int id, String TITULO_LIVRO, String AUTOR_LIVRO, String EDITORA_LIVRO,
                                    String NUMEROPAGINA_LIVRO, String ISBN_LIVRO, String PALAVRACHAVE_LIVRO,
                                    String DATAPUPLICACAO_LIVRO, String NUMEROEDICAO_LIVRO, String IDCATEGORIALIVRO_FK
    ){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.getIdLivros() + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.getTituloLivro(), TITULO_LIVRO);
        valores.put(CriaBanco.getAutorLivro(), AUTOR_LIVRO);
        valores.put(CriaBanco.getEditoraLivro(), EDITORA_LIVRO);
        valores.put(CriaBanco.getNumeropaginaLivro(),NUMEROPAGINA_LIVRO);
        valores.put(CriaBanco.getIsbnLivro(),ISBN_LIVRO);
        valores.put(CriaBanco.getPalavrachaveLivro(),PALAVRACHAVE_LIVRO);
        valores.put(CriaBanco.getDatapuplicacaoLivro(),DATAPUPLICACAO_LIVRO);
        valores.put(CriaBanco.getNumeroedicaoLivro(),NUMEROEDICAO_LIVRO);
        valores.put(CriaBanco.getIdcategorialivroFk(),IDCATEGORIALIVRO_FK);

        db.update(CriaBanco.getTabelaLivro(), valores, where, null);
        db.close();
    }

    public void deletaLivro(int id){
        String where = CriaBanco.getIdLivro() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaLivro(),where,null);
        db.close();
    }

    //CRUD - Cliente

    public String insereDadosCliente(int id, String NOME_CLIENTE, String ENDERECO_CLIENTE, String CELULAR_CLIENTE,
                                     String EMAIL_CLIENTE, String CPF_CLIENTE, String DATANASC_CLIENTE,
                                     String IDCATEGORIALEITOR_FK){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getNomeCliente(), NOME_CLIENTE);
        valores.put(CriaBanco.getEnderecoCliente(), ENDERECO_CLIENTE);
        valores.put(CriaBanco.getCelularCliente(), CELULAR_CLIENTE);
        valores.put(CriaBanco.getEmailCliente(),EMAIL_CLIENTE);
        valores.put(CriaBanco.getCpfCliente(),CPF_CLIENTE);
        valores.put(CriaBanco.getDatanascCliente(),DATANASC_CLIENTE);
        valores.put(CriaBanco.getIdcategorialeitorFk(),IDCATEGORIALEITOR_FK);
        resultado = db.insert(CriaBanco.getTabelaCliente(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDadosCliente(){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdCliente(),CriaBanco.getNomeCliente(), CriaBanco.getEnderecoCliente(), CriaBanco.getCelularCliente(),
                CriaBanco.getEmailCliente(),CriaBanco.getCpfCliente(), CriaBanco.getDatanascCliente(), CriaBanco.getIdcategorialeitorFk()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaCliente(), campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosClienteporID(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdCliente(),CriaBanco.getNomeCliente(), CriaBanco.getEnderecoCliente(), CriaBanco.getCelularCliente(),
                CriaBanco.getEmailCliente(),CriaBanco.getCpfCliente(), CriaBanco.getDatanascCliente(), CriaBanco.getIdcategorialeitorFk()};
        String where = CriaBanco.getIdCliente() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaCliente(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public void alteraRegistroCliente(int id, String NOME_CLIENTE, String ENDERECO_CLIENTE, String CELULAR_CLIENTE,
                                      String EMAIL_CLIENTE, String CPF_CLIENTE, String DATANASC_CLIENTE,
                                      String IDCATEGORIALEITOR_FK
    ){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.getIdLivros() + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.getNomeCliente(), NOME_CLIENTE);
        valores.put(CriaBanco.getEnderecoCliente(), ENDERECO_CLIENTE);
        valores.put(CriaBanco.getCelularCliente(), CELULAR_CLIENTE);
        valores.put(CriaBanco.getEmailCliente(),EMAIL_CLIENTE);
        valores.put(CriaBanco.getCpfCliente(),CPF_CLIENTE);
        valores.put(CriaBanco.getDatanascCliente(),DATANASC_CLIENTE);
        valores.put(CriaBanco.getIdcategorialeitorFk(),IDCATEGORIALEITOR_FK);

        db.update(CriaBanco.getTabelaCliente(), valores, where, null);
        db.close();
    }

    public void deletaCliente(int id){
        String where = CriaBanco.getIdLivro() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaCliente(),where,null);
        db.close();
    }

    //CRUD - Cliente

    public String insereDadosAluguel(int id, String IDCLIENTE_FK, String IDLIVRO_FK){
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getNomeCliente(), IDCLIENTE_FK);
        valores.put(CriaBanco.getEnderecoCliente(), IDLIVRO_FK);
        resultado = db.insert(CriaBanco.getTabelaAluguel(), null, valores);
        db.close();
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor carregaDadosAluguel(){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdclienteFk(), CriaBanco.getIdlivroFk()};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaAluguel(), campos, null, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadosAluguelporID(int id){
        Cursor cursor;
        String[] campos = {CriaBanco.getIdclienteFk(), CriaBanco.getIdlivroFk()};
        String where = CriaBanco.getIdAluguel() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.getTabelaAluguel(),campos,where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }


    public void alteraRegistroAluguel(int id, String IDCLIENTE_FK, String IDLIVRO_FK){
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.getIdLivros() + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.getIdclienteFk(), IDCLIENTE_FK);
        valores.put(CriaBanco.getIdlivroFk(), IDLIVRO_FK);

        db.update(CriaBanco.getTabelaAluguel(), valores, where, null);
        db.close();
    }

    public void deletaAluguel(int id){
        String where = CriaBanco.getIdLivro() + "=" + id;
        db = banco.getReadableDatabase();
        db.delete(CriaBanco.getTabelaAluguel(),where,null);
        db.close();
    }

    //Métodos de consulta




}