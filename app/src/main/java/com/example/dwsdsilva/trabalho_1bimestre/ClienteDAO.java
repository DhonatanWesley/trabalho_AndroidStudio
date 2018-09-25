package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends SQLiteOpenHelper {


    public ClienteDAO(Context context) {
        super(context, "LavaCar", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE cliente ( "                  +
                              "   id INTEGER PRIMARY KEY AUTOINCREMENT," +
                              "   nome     TEXT,"                        +
                              "   email    TEXT,"                        +
                              "   telefone TEXT,"                        +
                              "   veiculo  TEXT ) "                      ;
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS cliente");
        this.onCreate(db);
    }

    public void addCliente(Cliente cliente){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome"     , cliente.getNome()    );
        values.put("email"    , cliente.getEmail()   );
        values.put("telefone" , cliente.getTelefone());
        values.put("veiculo"  , cliente.getVeiculo() );

        db.insert("cliente", null, values);
        db.close();


    }

    public List<Cliente> buscaCliente() {

        String sql = "Select * from cliente;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);

        List<Cliente> clientes = new ArrayList<Cliente>();
        while (c.moveToNext()){

            Cliente cliente = new Cliente();

            cliente.setNome    ( c.getString(c.getColumnIndex("nome"    )));
            cliente.setEmail   ( c.getString(c.getColumnIndex("email"   )));
            cliente.setTelefone( c.getString(c.getColumnIndex("telefone")));
            cliente.setVeiculo ( c.getString(c.getColumnIndex("veiculo" )));

            clientes.add(cliente);
        }

        db.close();

        return clientes;
    }
}
