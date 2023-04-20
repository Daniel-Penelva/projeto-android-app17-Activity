package com.formacaoandroidstudio.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonEnviar = findViewById(R.id.buttonEnviar);

        /* Adicionando um evento de click no botão - dentro do parametro vai receber uma interface OnClickListener e instanciar
        uma Classe anônima View. Dentro dela vai ser implementado o método de Click. */
        buttonEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                /* Vai de uma activity a outra activity através do método startActivity() que recebe como parâmetro um intent (intenção).
                   Mas antes é preciso instanciar uma intent que recebe como parâmetro um contexto e a activity que quer abrir.
                   Para passar dados pode usar o método putExtra. Dentro do parametro vai o indice do array e o valor.*/
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);
                intent.putExtra("Nome", "Daniel Penelva");
                intent.putExtra("Idade", 35);
                startActivity(intent);


            }
        });

    }


}

/**
 * Anotações:
 *
 * -> Activity
 *
 * A classe Activity é um componente crucial de um app para Android, e a maneira como as atividades são lançadas e reunidas é uma parte fundamental do modelo
 * de aplicativo da plataforma. Diferentemente dos paradigmas de programação em que os apps são lançados com um método main(), o sistema Android inicia o código
 * em uma instância Activity invocando métodos de callback que correspondem a estágios específicos do ciclo de vida.
 *
 * -> Declarar filtros de intent
 * Você pode aproveitar esse recurso declarando um atributo <intent-filter> no elemento <activity>. A definição desse elemento inclui um elemento <action> e,
 * opcionalmente, um <category> e/ou um <data>. Esses elementos são combinados para especificar o tipo de intent ao qual sua atividade pode responder.
 *
 * o elemento <action> especifica que essa atividade envia dados. Declarar o elemento <category> como DEFAULT permite que a atividade receba solicitações de
 * inicialização. O elemento <data> especifica o tipo de dado que essa atividade pode enviar.
 *
 * Filtros de intent são um recurso muito poderoso da plataforma Android. Eles oferecem a capacidade de iniciar uma atividade com base não apenas em uma
 * solicitação explícita, mas também implícita. Por exemplo, uma solicitação explícita pode dizer ao sistema para "Iniciar a atividade de envio de e-mail no
 * app Gmail". Por outro lado, uma solicitação implícita diz ao sistema para "Iniciar uma tela de envio de e-mail em qualquer atividade que possa fazer o
 * trabalho". Quando a IU (Interface do Usuário = tela do app) do sistema pergunta a um usuário qual app usar na execução de uma tarefa, um filtro de intent está
 * em ação.
 *
 * -> Declarar permissões
 * Você pode usar a tag <activity> do manifesto para controlar quais apps podem iniciar uma atividade específica. Uma atividade mãe não pode iniciar uma atividade
 * filha a menos que as duas tenham as mesmas permissões no manifesto. Se você declarar um elemento <uses-permission> para uma atividade mãe, cada atividade filha
 * precisará ter um elemento <uses-permission> correspondente.
 *
 * -> Como gerenciar o ciclo de vida da atividade activity
 * Ao longo da vida útil de uma atividade, ela passa por vários estados. Uma série de callbacks são usados para lidar com transições entre estados. As seções a
 * seguir apresentam esses callbacks.
 *
 *     => onCreate()
 *        Você precisa implementar esse callback, que é acionado quando o sistema cria sua atividade, vai ser chamado uma única vez. A implementação inicializará
 *        os componentes essenciais da atividade. Por exemplo, aqui, o app criará visualizações e vinculará dados a listas. Mais importante, é nesse local que
 *        você precisa chamar setContentView() para definir o layout da interface do usuário da atividade. Quando onCreate() termina, o próximo callback sempre
 *        é onStart().
 *
 *     => onStart()
 *        Quando onCreate() sai, a atividade entra no estado "Iniciado" e se torna visível para o usuário. Esse callback contém o que equivale aos preparativos
 *        finais da atividade para ir para o primeiro plano e se tornar interativa.
 *
 *     => onResume()
 *        O sistema invoca esse callback imediatamente antes de a atividade começar a interagir com o usuário. Neste ponto, a atividade fica na parte superior da
 *        pilha de atividades e captura toda a entrada do usuário. A maior parte da funcionalidade principal de um app é implementada no método onResume().
 *        O callback onPause() sempre segue onResume().
 *
 *     => onPause()
 *        O sistema chama onPause() quando a atividade perde o foco e entra em um estado "Pausado". Esse estado ocorre quando, por exemplo, o usuário toca no botão
 *        "Voltar" ou "Recentes". Quando o sistema chama onPause() para sua atividade, isso significa, tecnicamente, que ela ainda está parcialmente visível.
 *        Porém, na maioria das vezes, é uma indicação de que o usuário está deixando a atividade e que logo ela entrará no estado "Interrompido" ou "Retomado".
 *        Uma atividade no estado "Pausado" pode continuar atualizando a IU se o usuário estiver esperando por isso. Exemplos de uma dessas atividades incluem a
 *        exibição da tela de um mapa de navegação ou de um player de mídia sendo reproduzido. Mesmo que essas atividades percam o foco, o usuário espera que a IU
 *        continue sendo atualizada.
 *
 *        OBS. Não use onPause() para salvar dados do app ou do usuário, fazer chamadas de rede ou executar transações de banco de dados. Para mais informações
 *             sobre como salvar dados, consulte Como salvar e restaurar o estado da atividade.
 *             Quando a execução de onPause() termina, o próximo callback é onStop() ou onResume(), dependendo do que acontece depois que a atividade entra no
 *             estado "Pausado".
 *
 *      => onStop()
 *         O sistema chama onStop() quando a atividade não está mais visível para o usuário. Isso pode acontecer porque a atividade está sendo destruída, uma nova
 *         atividade está sendo iniciada ou uma atividade existente está entrando em um estado "Retomado" e está cobrindo a atividade interrompida. Em todos esses
 *         casos, a atividade interrompida não fica mais visível.
 *         O próximo callback que o sistema chamar será onRestart(), se a atividade voltar a interagir com o usuário, ou onDestroy(), se essa atividade for
 *         completamente encerrada.
 *
 *     => onRestart()
 *        O sistema invoca esse callback quando uma atividade no estado "Interrompido" está prestes a ser reiniciada. onRestart() restaura o estado da atividade a
 *        partir do momento em que ela foi interrompida. Esse callback é sempre seguido por onStart().
 *
 *    => onDestroy()
 *       O sistema invoca esse callback antes de uma atividade ser destruída. Esse é o último callback que a atividade recebe. onDestroy() normalmente é
 *       implementado para garantir que todos os recursos de uma atividade sejam liberados quando ela (ou o processo que a contém) for destruída.
 *
 * Portanto, o Activity é maneira de interagir com o usuário. Temos a Activity como uma classe Java e dentro dessa classe java temos o arquivo xml que compoem a
 * interface. Então a Activity é basicamente uma interface do seu App. E para cada nova tela que se cria para o app teremos um Activity. Por exemplo, imagine, que
 * tenha um app com uma tela principal e outra tela secundária, logo precisaremos de duas activity. E essas activitys quando são abertas elas trabalham com um
 * conceito de pilha, ou seja, quando você abre a tela secundaria, a tela principal fica como plano de fundo e a tela secundaria fica sobre ela.
 *
 *
 *                                                       (Classe Java)                        (Arquivo XML)
 *                    APP  <------------------------------ Activity <----------------------------- xml
 *                   Tela                                public Class Activity{}                 Login:
 *                  do App                                                                       Senha:
 *
 *  Criando uma Activity, para isso vai no package activity com o botão direito do mouse vai em:
 *  new > activity > Empity Activity
 *              OBS. Gallery (vai abrir a opção de vários layouts)
 *  Ao criar a activity automaticamente também irá criar a activity_main.xml.
 * */