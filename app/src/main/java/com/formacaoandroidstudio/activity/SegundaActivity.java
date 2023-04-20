package com.formacaoandroidstudio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private TextView textNome, textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.textIdade);

        /* Recuperar os dados enviados através do objeto Bundle que recupera de uma activity para outra activity. */
        Bundle dados = getIntent().getExtras();

        /* Para recuperar o valor passado é preciso utilizar uma chave (key) que é o mesmo valor do nome. No caso, repare que estamos
        * usando a chave 'Nome' e repare também que o N é maiusculo, ou seja, tem que ser idêntico. */
        String nome = dados.getString("Nome");
        int idade = dados.getInt("Idade");

        /* Configurar valores configurados - Lembrando que na tela só carrega String, logo temos que fazer um valueOf. */
        textNome.setText(nome);
        textIdade.setText(String.valueOf(idade));

    }
}
