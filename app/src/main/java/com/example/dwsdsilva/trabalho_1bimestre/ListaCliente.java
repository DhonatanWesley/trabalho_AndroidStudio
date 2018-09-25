package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListaCliente extends AppCompatActivity{

    private ListView listaCliente;

    private Button btn_ChamaCadCln;

    private  ArrayAdapter<Cliente> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_clientes);

        listaCliente = findViewById(R.id.lista_cliente);
        carregarListaCliente();


        this.btn_ChamaCadCln = this.findViewById(R.id.btn_chamaCadCln);

        this.btn_ChamaCadCln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaCliente.this, CadClnActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaCliente();
    }

    private void carregarListaCliente() {

        ClienteDAO clienteDAO = new ClienteDAO(this);
        List<Cliente> clientes = clienteDAO.buscaCliente();
        clienteDAO.close();

        adapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, clientes);
        listaCliente.setAdapter(adapter);
    }

}
