package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadCliente extends AppCompatActivity{

    private Button btCadCliente;

    ClienteDAO clienteDAO = new ClienteDAO(CadCliente.this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_cliente);

        final Context context = getApplicationContext();

        this.btCadCliente = this.findViewById(R.id.btCadCliente);

        this.btCadCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarCln();
            }
        });

    }

    private void cadastrarCln() {

        Cliente cliente = new Cliente();

        EditText campoNome     = this.findViewById(R.id.clnNome     );
        EditText campoEmail    = this.findViewById(R.id.clnEmail    );
        EditText campoTelefone = this.findViewById(R.id.clnTelefone );
        EditText campoVeiculo  = this.findViewById(R.id.clnVeiculo  );

        cliente.setNome    ( campoNome    .getText().toString() );
        cliente.setEmail   ( campoEmail   .getText().toString() );
        cliente.setTelefone( campoTelefone.getText().toString() );
        cliente.setVeiculo ( campoVeiculo .getText().toString() );

        this.clienteDAO.addCliente(cliente);

        Toast.makeText(getApplicationContext(),
                "Cliente Cadastrado Com Sucesso", Toast.LENGTH_SHORT).show();

        finish();

    }
}
