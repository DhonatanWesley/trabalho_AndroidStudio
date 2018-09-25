package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadServico extends AppCompatActivity {


    private Button btCadServico;

    ServicoDAO servicoDAO = new ServicoDAO(CadServico.this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cad_servico);

        final Context context = getApplicationContext();

        this.btCadServico = this.findViewById(R.id.btn_chamaCadServico);

        this.btCadServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastrarServico();
            }
        });

    }

    private void CadastrarServico() {

        Servico servico = new Servico();

        EditText campoNome    = this.findViewById(R.id.servicoNome       );
        EditText campoRespon  = this.findViewById(R.id.servicoResposavel );
        EditText campoDuracao = this.findViewById(R.id.servicoDuracao    );
        EditText campoValor   = this.findViewById(R.id.servicoValor      );

        servico.setNome       ( campoNome   .getText().toString() );
        servico.setResponsavel( campoRespon .getText().toString() );
        servico.setDuracao    ( campoDuracao.getText().toString() );
        servico.setValor      ( campoValor  .getText().toString() );

        this.servicoDAO.addServico(servico);

        Toast.makeText(getApplicationContext(),
                "Servico Cadastrado Com Sucesso", Toast.LENGTH_SHORT).show();

        finish();

    }

}
