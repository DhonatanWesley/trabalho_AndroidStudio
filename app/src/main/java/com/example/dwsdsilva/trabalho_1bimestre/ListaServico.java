package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListaServico extends AppCompatActivity {

    private ListView listaServico;

    private Button btn_ChamaCadServico;

    private ArrayAdapter<Servico> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_servicos);

        listaServico = findViewById(R.id.lista_servico);
        carregarListaServico();


        this.btn_ChamaCadServico = this.findViewById(R.id.btn_chamaCadServico);

        this.btn_ChamaCadServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaServico.this, CadServico.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaServico();
    }

    private void carregarListaServico() {

        ServicoDAO servicoDAO = new ServicoDAO(this);
        List<Servico> servicos = servicoDAO.buscaServico();
        servicoDAO.close();

        adapter = new ArrayAdapter<Servico>(this, android.R.layout.simple_list_item_1, servicos);
        listaServico.setAdapter(adapter);
    }

}
