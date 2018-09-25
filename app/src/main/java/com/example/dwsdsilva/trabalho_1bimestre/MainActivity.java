package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_Clientes;
    private Button bt_Servicos;
    private Button bt_Atendimentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Chama Lista de Clientes

        this.bt_Clientes = this.findViewById(R.id.btChamaCliente);
        this.bt_Clientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaCliente.class);
                startActivity(intent);
            }
        });

//      Chama Lista de Serviços

        this.bt_Servicos = this.findViewById(R.id.btn_chamaCadServico);
        this.bt_Servicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaServico.class);
                startActivity(intent);
            }
        });

//      Chama Lista de Atendimentos (not implemented)

        this.bt_Atendimentos = this.findViewById(R.id.btnChamaAtendimento);
        this.bt_Atendimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaAtendimento.class);
                startActivity(intent);
            }
        });

//      Chama Lista de Funcionários (Not Implemented)



    }

}
