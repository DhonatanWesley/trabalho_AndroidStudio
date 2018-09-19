package com.example.dwsdsilva.trabalho_1bimestre;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CadClnActivity extends AppCompatActivity{

    private Button btCadCliente;
    private TextInputEditText clnNome, clnEmail, clnTelefone, clnVeiculo;

    public static final String CAD_CLIENTE = "CAD_CLIENTE";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadcln);

        final Context context = getApplicationContext();

        this.btCadCliente = this.findViewById(R.id.btCadCliente);
        this.clnNome      = this.findViewById(R.id.clnNome     );
        this.clnEmail     = this.findViewById(R.id.clnEmail    );
        this.clnTelefone  = this.findViewById(R.id.clnTelefone );
        this.clnVeiculo   = this.findViewById(R.id.clnVeiculo  );

        this.btCadCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarCln(context);
            }
        });

    }

    private void cadastrarCln(Context context) {

        String nome     = clnNome    .getText().toString();
        String email    = clnEmail   .getText().toString();
        String telefone = clnTelefone.getText().toString();
        String veiculo  = clnVeiculo .getText().toString();

        SharedPreferences.Editor cliente = context.getSharedPreferences(CAD_CLIENTE, Context.MODE_PRIVATE ).edit();
        cliente.putString("nome"    , nome    );
        cliente.putString("email"   , email   );
        cliente.putString("telefone", telefone);
        cliente.putString("veiculo" , veiculo );

        Toast.makeText(getApplicationContext(),
                "Cadastrado", Toast.LENGTH_SHORT).show();

    }
}
