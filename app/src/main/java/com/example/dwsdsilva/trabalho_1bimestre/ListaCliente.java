package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ListaCliente extends AppCompatActivity{

    private Button btn_ChamaCadCln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_clientes);

        this.btn_ChamaCadCln = this.findViewById(R.id.btn_chamaCadCln);

        this.btn_ChamaCadCln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaCliente.this, CadClnActivity.class);
                startActivity(intent);
            }
        });


    }

}
