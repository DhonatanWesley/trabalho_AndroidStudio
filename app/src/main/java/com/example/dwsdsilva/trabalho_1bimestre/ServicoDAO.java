package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ServicoDAO extends SQLiteOpenHelper {

    public ServicoDAO(Context context) {
        super(context, "Servico", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE servico ( "                           +
                              "   id          INTEGER PRIMARY KEY AUTOINCREMENT," +
                              "   nome        TEXT,"                              +
                              "   responsavel TEXT,"                              +
                              "   duracao     TEXT,"                              +
                              "   valor       TEXT ) ";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS servico");
        this.onCreate(db);
    }

    public void addServico(Servico servico){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome"        , servico.getNome()        );
        values.put("responsavel" , servico.getResponsavel() );
        values.put("duracao"     , servico.getDuracao()     );
        values.put("valor"       , servico.getValor()       );

        db.insert("servico", null, values);
        db.close();


    }

    public List<Servico> buscaServico() {

        String sql = "Select * from servico;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);

        List<Servico> servicos = new ArrayList<Servico>();

        while (c.moveToNext()){

            Servico servico = new Servico();

            servico.setNome       ( c.getString(c.getColumnIndex("nome"       )));
            servico.setResponsavel( c.getString(c.getColumnIndex("responsavel")));
            servico.setDuracao    ( c.getString(c.getColumnIndex("duracao"    )));
            servico.setValor      ( c.getString(c.getColumnIndex("valor"      )));

            servicos.add(servico);
        }

        db.close();

        return servicos;
    }
}
