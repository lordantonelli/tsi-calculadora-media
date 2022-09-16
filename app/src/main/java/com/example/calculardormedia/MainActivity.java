package com.example.calculardormedia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtEmail;
    private EditText txtNota1;
    private EditText txtNota2;
    private TextView lblMedia;
    private Button btnCalcular;
    private Button btnExibir;
    private Button btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtNome = findViewById(R.id.txtNome);
        this.txtEmail = findViewById(R.id.txtEmail);
        this.txtNota1 = findViewById(R.id.txtNota1);
        this.txtNota2 = findViewById(R.id.txtNota2);
        this.lblMedia = findViewById(R.id.lblMedia);
        this.btnCalcular = findViewById(R.id.btnCalcular);
        this.btnExibir = findViewById(R.id.btnExibir);
        this.btnSair = findViewById(R.id.btnSair);

        this.btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        this.btnExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Criando uma string que vai ser exibida
                String msg = "";

                // Pegando o texto digitado na caixa txtNome e
                // colocando em msg, com uma quebra de linha no final
                msg += txtNome.getText() + "\n";

                // Pegando o texto digitado na caixa txtEmail e
                // colocando em msg, com uma quebra de linha no final
                msg += txtEmail.getText() + "\n";

                // Pegando as notas digitadas em suas caixas e
                // colocando em msg
                msg += "Notas: " + txtNota1.getText() + " e " + txtNota2.getText();

                // Finalmente, exibindo msg em um toast
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        this.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Criando variáveis para fazer as contas
                double n1, n2, media;

                /**
                 * Pegando e convertendo o valor digitado em txtNota1.
                 * Atenção!!! O método getText() "quase" devolve uma string,
                 * mas não é uma string de verdade.
                 * Então, em alguns momentos, teremos que forçar a conversão
                 * para uma string "de verdade". Se não fizer isso,
                 * ele não deixa usar o método para converter para double.
                 */
                n1 = Double.parseDouble(txtNota1.getText().toString());

                // Pegando e convertendo o valor em txtNota2
                n2 = Double.parseDouble(txtNota2.getText().toString());

                // Calculando a média
                media = (n1 + n2) / 2;

                // Colocando a média na tela, em lblMedia
                // (tem que converter para string antes)
                lblMedia.setText(String.valueOf(media));
            }
        });
    }
}



