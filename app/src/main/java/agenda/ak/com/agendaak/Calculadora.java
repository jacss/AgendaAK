package agenda.ak.com.agendaak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculadora extends AppCompatActivity {
    private EditText editResultado;
    private Button botaoZero;
    private Button botaoUm;
    private Button botaoDois;
    private Button botaoTres;
    private Button botaoQuatro;
    private Button botaoCinco;
    private Button botaoSeis;
    private Button botaoSete;
    private Button botaoOito;
    private Button botaoNove;
    private Button botaoPonto;
    private Button botaoLimpar;
    private Button botaoIgual;
    private Button botaoSoma;
    private Button botaoSubtrair;
    private Button botaoMultiplicar;
    private Button botaoDividir;
    private Button botaoPorcentagem;
    private double valor1;
    private double valor2;
    private String sinal;
    private String sinalMult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        editResultado = findViewById(R.id.editResultado_Id);
        botaoZero = findViewById(R.id.botaoZero_Id);
        botaoUm = findViewById(R.id.botao1_Id);
        botaoDois = findViewById(R.id.botao2_Id);
        botaoTres = findViewById(R.id.botao3_Id);
        botaoQuatro = findViewById(R.id.botao4_Id);
        botaoCinco = findViewById(R.id.botao5_Id);
        botaoSeis = findViewById(R.id.botao6_Id);
        botaoSete = findViewById(R.id.botao7_Id);
        botaoOito = findViewById(R.id.botao8_Id);
        botaoNove = findViewById(R.id.botao9_Id);


        botaoLimpar = findViewById(R.id.botaoLimpar_Id);
        botaoIgual = findViewById(R.id.botaoIgual_Id);
        botaoSoma = findViewById(R.id.botaoSoma_Id);
        botaoSubtrair = findViewById(R.id.botaoSubtrair_Id);
        botaoMultiplicar = findViewById(R.id.botaoMultiplicar_Id);
        botaoDividir = findViewById(R.id.botaoDividir_Id);
        botaoPorcentagem = findViewById(R.id.botaoPorcentagem_Id);
        botaoPonto = findViewById(R.id.botaoPonto_Id);


        botaoZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "0");
            }
        });
        botaoUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "1");

            }
        });
        botaoDois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "2");
            }
        });
        botaoTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "3");

            }
        });
        botaoQuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "4");

            }
        });
        botaoCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "5");

            }
        });
        botaoSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "6");

            }
        });
        botaoSete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "7");

            }
        });
        botaoOito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "8");

            }
        });
        botaoNove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + "9");

            }
        });
        botaoPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editResultado.setText(editResultado.getText() + ".");
            }
        });
        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              editResultado.setText("+");


            }
        });
        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpaCampo();
            }
        });
        botaoIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor2 = Double.parseDouble(editResultado.getText().toString());
                if (sinal.equals("soma")) {
                    editResultado.setText(String.valueOf(valor1 + valor2));

                } else if (sinal.equals("subtrair")) {
                    editResultado.setText(String.valueOf(valor1 - valor2));
                } else if (sinal.equals("multiplica")) {
                    editResultado.setText(String.valueOf(valor1 * valor2));
                } else if (sinal.equals("dividir")) {
                    if (valor2 == 0) {
                        Toast.makeText(Calculadora.this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show();
                        limpaCampo();
                    } else {
                        editResultado.setText(String.valueOf(valor1 / valor2));
                    }


                }


            }
        });
        botaoSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Double.parseDouble(editResultado.getText().toString());
                //limpaCampo();
                sinal = "soma";
            }
        });
        botaoSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Double.parseDouble(editResultado.getText().toString());
               // limpaCampo();
                sinal = "subtrair";
            }
        });
        botaoMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Double.parseDouble(editResultado.getText().toString());
               //limpaCampo();
                sinalMult = "mult";
                sinal = "multiplica";
            }
        });
        botaoDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1 = Double.parseDouble(editResultado.getText().toString());
                //limpaCampo();
                sinal = "dividir";
            }
        });
        botaoPorcentagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (sinalMult.equals("mult")) {

                    valor2 = Double.parseDouble(editResultado.getText().toString());

                    editResultado.setText(String.valueOf((valor1 * valor2) / 100));

                }
            }
        });

    }

    public void limpaCampo() {

        editResultado.setText("");
    }
}
