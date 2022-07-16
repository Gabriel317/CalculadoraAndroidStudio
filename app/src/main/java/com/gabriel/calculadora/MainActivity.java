package com.gabriel.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.xml.xpath.XPathExpression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //criação de objeto Button para recuperar os id's do activitymain.xml
    private Button numZero, numUm, numDois, numTres, numQuatro, numCinco, numSeis, numSete, numOito, numNove, ponto, soma, subtracao, multiplicacao, divisao, igual, botao_limpar;

    //criação do TextView onde irá mostrar a Expressão e em baixo o Resultado
    private TextView txtExpressao, txtResultado;

    //como o backspace usado é uma imagem e não um botão como os demais, criamos o método para utilizar ImageView
    private ImageView backspace;

    public MainActivity() {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        IniciarComponentes();
        getSupportActionBar().hide();

        numZero.setOnClickListener(this);
        numUm.setOnClickListener(this);
        numDois.setOnClickListener(this);
        numTres.setOnClickListener(this);
        numQuatro.setOnClickListener(this);
        numCinco.setOnClickListener(this);
        numSeis.setOnClickListener(this);
        numSete.setOnClickListener(this);
        numOito.setOnClickListener(this);
        numNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        igual.setOnClickListener(this);

        //criação da função de limpar, que apaga tanto os valores quanto os resultados
        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        //criação da função para o backspace, usado para apagar número inserido
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        //criação da função para retornar o resultado dos valores e suas operações, clicando no botão de igual (=).
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               try {
                   Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                   double resultado = expressao.evaluate();

                   long longResult = (long) resultado;

                   if(resultado == (double)longResult){

                       txtResultado.setText((CharSequence) String.valueOf(longResult));
                   }else{

                       txtResultado.setText((CharSequence) String.valueOf(resultado));
                   }
               }catch(Exception e){

               }
            }
        });

    }

    //criação do método para recuperar os ID's, utilizando findViewById
    private void IniciarComponentes() {
        numZero = findViewById(R.id.num_zero);
        numUm = findViewById(R.id.num_um);
        numDois = findViewById(R.id.num_dois);
        numTres = findViewById(R.id.num_tres);
        numQuatro = findViewById(R.id.num_quatro);
        numCinco = findViewById(R.id.num_cinco);
        numSeis = findViewById(R.id.num_seis);
        numSete = findViewById(R.id.num_sete);
        numOito = findViewById(R.id.num_oito);
        numNove = findViewById(R.id.num_nove);
        ponto = findViewById(R.id.num_ponto);
        soma = findViewById(R.id.btn_soma);
        subtracao = findViewById(R.id.btn_subtracao);
        multiplicacao = findViewById(R.id.btn_multiplicacao);
        divisao = findViewById(R.id.btn_divisao);
        igual = findViewById(R.id.btn_igual);
        botao_limpar = findViewById(R.id.btn_limpar);
        txtResultado = findViewById(R.id.txt_resultado);
        txtExpressao = findViewById(R.id.txt_expressao);
        backspace = findViewById(R.id.backscape);

    }


    //criação da função para limpar os dados
    public void AcrescentarExpressao(String string, boolean limpar_dados) {


        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");

        }

        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

    }

    //criação do evento onclick, o mesmo é implementado para a interface na MainActivity, quando clicar no botão, a string será capturada e repassada para a interface.
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.num_zero:
                AcrescentarExpressao("0", true);
                break;

            case R.id.num_um:
                AcrescentarExpressao("1", true);
                break;

            case R.id.num_dois:
                AcrescentarExpressao("2", true);
                break;

            case R.id.num_tres:
                AcrescentarExpressao("3", true);
                break;

            case R.id.num_quatro:
                AcrescentarExpressao("4", true);
                break;

            case R.id.num_cinco:
                AcrescentarExpressao("5", true);
                break;

            case R.id.num_seis:
                AcrescentarExpressao("6", true);
                break;

            case R.id.num_sete:
                AcrescentarExpressao("7", true);
                break;

            case R.id.num_oito:
                AcrescentarExpressao("8", true);
                break;

            case R.id.num_nove:
                AcrescentarExpressao("9", true);
                break;

            case R.id.num_ponto:
                AcrescentarExpressao(".", true);
                break;

            case R.id.btn_soma:
                AcrescentarExpressao("+", false);
                break;

            case R.id.btn_subtracao:
                AcrescentarExpressao("-", false);
                break;

            case R.id.btn_multiplicacao:
                AcrescentarExpressao("*", false);
                break;

            case R.id.btn_divisao:
                AcrescentarExpressao("/", false);
                break;

        }
    }
}