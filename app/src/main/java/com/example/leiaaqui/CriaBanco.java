package com.example.leiaaqui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CriaBanco extends SQLiteOpenHelper  {

    //BANCO DE DADOS
    private static final String NOME_BANCO = "LeiaAqui.db";

    //TABELA CATEGORIA_LEITORES
    private static final String TABELA_LEITORES = "CATEGORIA_LEITORES";
    private static final String ID_LEITORES = "IDCATEGORIALEITORES";
    private static final String DIAS_LEITORES = "DIASEMPRESTIMOS";
    private static final String DESCRICAO_LEITORES = "DESCRICAO";

    //TABELA CATEGORIA_LIVROS
    private static final String TABELA_LIVROS = "CATEGORIA_LIVROS";
    private static final String ID_LIVROS = "IDCATEGORIALIVROS";
    private static final String DIAS_LIVROS = "DIASEMPRESTIMIO";
    private static final String TAXA_LIVROS = "TAXALIVROS";
    private static final String DESCRICAO_LIVROS = "DESCRICAO";

    //TABELA LIVRO
    private static final String TABELA_LIVRO = "LIVRO";
    private static final String ID_LIVRO = "IDLIVRO";
    private static final String TITULO_LIVRO = "TITULO";
    private static final String AUTOR_LIVRO = "AUTORES";
    private static final String EDITORA_LIVRO = "EDITORA";
    private static final String NUMEROPAGINA_LIVRO = "NUMEROPAGINA";
    private static final String ISBN_LIVRO = "ISBN";
    private static final String PALAVRACHAVE_LIVRO = "PALAVRACHAVE";
    private static final String DATAPUPLICACAO_LIVRO = "DATAPUPLICACAO";
    private static final String NUMEROEDICAO_LIVRO = "NUMEROEDICAO";
    private static final String IDCATEGORIALIVRO_FK = "IDCATEGORIALIVROS";


    //TABELA CLIENTE
    private static final String TABELA_CLIENTE = "CLIENTE";
    private static final String ID_CLIENTE = "IDCLIENTE";
    private static final String NOME_CLIENTE = "NOME";
    private static final String ENDERECO_CLIENTE = "ENDERECO";
    private static final String CELULAR_CLIENTE = "CELULAR";
    private static final String EMAIL_CLIENTE = "EMAIL";
    private static final String CPF_CLIENTE = "CPF";
    private static final String DATANASC_CLIENTE = "DATANASC";
    private static final String IDCATEGORIALEITOR_FK = "IDCATEGORIALEITORES";

    //TABELA ALUGUEL
    private static final String TABELA_ALUGUEL = "ALUGUEL";
    private static final String ID_ALUGUEL = "IDALUGUEL";
    private static final String IDCLIENTE_FK = "IDCLIENTE";
    private static final String IDLIVRO_FK = "IDLIVRO";


    private static final int VERSAO = 1;


    public CriaBanco(Context context) {
        super(context, getNomeBanco(), null, getVERSAO());
    }

    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTabelaLeitores() {
        return TABELA_LEITORES;
    }

    public static String getIdLeitores() {
        return ID_LEITORES;
    }

    public static String getDiasLeitores() {
        return DIAS_LEITORES;
    }

    public static String getDescricaoLeitores() {
        return DESCRICAO_LEITORES;
    }

    public static String getTabelaLivros() {
        return TABELA_LIVROS;
    }

    public static String getIdLivros() {
        return ID_LIVROS;
    }

    public static String getDiasLivros() {
        return DIAS_LIVROS;
    }

    public static String getTaxaLivros() {return  TAXA_LIVROS; }

    public static String getDescricaoLivros() {
        return DESCRICAO_LIVROS;
    }

    public static String getTabelaLivro() {
        return TABELA_LIVRO;
    }

    public static String getIdLivro() {
        return ID_LIVRO;
    }

    public static String getTituloLivro() {
        return TITULO_LIVRO;
    }

    public static String getAutorLivro() {
        return AUTOR_LIVRO;
    }

    public static String getEditoraLivro() {
        return EDITORA_LIVRO;
    }

    public static String getNumeropaginaLivro() {
        return NUMEROPAGINA_LIVRO;
    }

    public static String getIsbnLivro() {
        return ISBN_LIVRO;
    }

    public static String getPalavrachaveLivro() {
        return PALAVRACHAVE_LIVRO;
    }

    public static String getDatapuplicacaoLivro() {
        return DATAPUPLICACAO_LIVRO;
    }

    public static String getNumeroedicaoLivro() {
        return NUMEROEDICAO_LIVRO;
    }

    public static String getIdcategorialivroFk() {
        return IDCATEGORIALIVRO_FK;
    }

    public static String getTabelaCliente() {
        return TABELA_CLIENTE;
    }

    public static String getIdCliente() {
        return ID_CLIENTE;
    }

    public static String getNomeCliente() {
        return NOME_CLIENTE;
    }

    public static String getEnderecoCliente() {
        return ENDERECO_CLIENTE;
    }

    public static String getCelularCliente() {
        return CELULAR_CLIENTE;
    }

    public static String getEmailCliente() {
        return EMAIL_CLIENTE;
    }

    public static String getCpfCliente() {
        return CPF_CLIENTE;
    }

    public static String getDatanascCliente() {
        return DATANASC_CLIENTE;
    }

    public static String getIdcategorialeitorFk() {
        return IDCATEGORIALEITOR_FK;
    }

    public static String getTabelaAluguel() {
        return TABELA_ALUGUEL;
    }

    public static String getIdAluguel() {
        return ID_ALUGUEL;
    }

    public static String getIdclienteFk() {
        return IDCLIENTE_FK;
    }

    public static String getIdlivroFk() {
        return IDLIVRO_FK;
    }

    public static int getVERSAO() {
        return VERSAO;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL( "CREATE TABLE " + getTabelaLeitores() + "("
                + getIdLeitores() + " integer primary key autoincrement,"
                + getDiasLeitores() + "text, "
                + getDescricaoLeitores() + "text)");

        db.execSQL( "CREATE TABLE " + getTabelaLivros() + "("
                + getIdLivros() + " integer primary key autoincrement,"
                + getDiasLivros() + "text, "
                + getTaxaLivros() + "text, "
                + getDescricaoLivros() + "text)");


        db.execSQL( "CREATE TABLE " + getTabelaLivro() + "("
                + getIdLivro() + " integer primary key autoincrement,"
                + getTituloLivro() + "text, "
                + getAutorLivro() + "text, "
                + getEditoraLivro() + "text, "
                + getNumeropaginaLivro() + "text, "
                + getIsbnLivro() + "text, "
                + getPalavrachaveLivro() + "text, "
                + getDatapuplicacaoLivro() + "text, "
                + getNumeroedicaoLivro() + "text, "
                + getIdcategorialivroFk() + "integer, foreign key(IDCATEGORIALIVROS) references" + " TABELA_LIVROS(IDCATEGORIALIVROS) " + ")" );


        db.execSQL( "CREATE TABLE " + getTabelaCliente() + "("
                + getIdCliente() + " integer primary key autoincrement,"
                + getNomeCliente() + "text, "
                + getEnderecoCliente() + "text, "
                + getCelularCliente() + "text, "
                + getEmailCliente() + "text, "
                + getCpfCliente() + "text, "
                + getDatanascCliente() + "text, "
                + getIdcategorialeitorFk() + "integer, foreign key(IDCATEGORIALEITORES) references" + " TABELA_LEITORES(IDCATEGORIALEITORES) " + ")" );

        db.execSQL("CREATE TABLE " + getTabelaAluguel() + "("
                + getIdAluguel() + " integer primary key autoincrement,"
                + getIdlivroFk() + " integer,"
                + getIdclienteFk() + "integer,  foreign key(IDLIVRO) references" + " TABELA_LIVRO(IDLIVRO), foreign key(IDCLIENTE) references" + " TABELA_CLIENTE(IDCLIENTE)" + ")" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase SQLiteDatabase, int i, int i1) {
        SQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_LEITORES);
        onCreate(SQLiteDatabase);

        SQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_ALUGUEL);
        onCreate(SQLiteDatabase);

        SQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_LIVRO);
        onCreate(SQLiteDatabase);

        SQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_LIVROS);
        onCreate(SQLiteDatabase);

        SQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA_CLIENTE);
        onCreate(SQLiteDatabase);

    }
}