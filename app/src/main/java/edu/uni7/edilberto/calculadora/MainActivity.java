package edu.uni7.edilberto.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int resultado;
    private ArrayList<String> historico = new ArrayList<String>();

    EditText etRes;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button bt0;
    Button btAdi;
    Button btSub;
    Button btMul;
    Button btDiv;
    Button btCle;
    Button btIgu;
    Button btHis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadScreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SystemUtil.salvarHistorico(MainActivity.this, historico);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String s = SystemUtil.recuperarHistorico(MainActivity.this);
        char[] a = s.toCharArray();
        if (a.length > 0) {
            for (int i=0; i < a.length; i++) {
                historico.add(String.valueOf(a[i]));
            }
        }
    }

    private void loadScreen() {
        etRes = findViewById(R.id.etRes);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
        bt7 = findViewById(R.id.bt7);
        bt8 = findViewById(R.id.bt8);
        bt9 = findViewById(R.id.bt9);
        bt0 = findViewById(R.id.bt0);
        btAdi = findViewById(R.id.btAdi);
        btSub = findViewById(R.id.btSub);
        btMul = findViewById(R.id.btMul);
        btDiv = findViewById(R.id.btDiv);
        btCle = findViewById(R.id.btCle);
        btIgu = findViewById(R.id.btIgu);
        btHis = findViewById(R.id.btHis);
        resultado = 0;

        btHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HistoricoActivity.class);
                i.putExtra("historico", (Serializable) historico);
                startActivity(i);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("1");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("2");
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("3");
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("4");
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("5");
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("6");
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("7");
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("8");
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("9");
            }
        });

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("0");
            }
        });

        btAdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("+");
            }
        });

        btSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("-");
            }
        });

        btMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("*");
            }
        });

        btDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("/");
            }
        });

        btCle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.setText("");
            }
        });

        btIgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.append("=");
                etRes.append(String.valueOf(calcularResultado()));
                historico.add(String.valueOf(etRes.getText()));
            }
        });
    }

    private int calcularResultado() {
        String calculo = String.valueOf(etRes.getText());
        char c;
        char operacao;
        int n;
        int resultado = 0;

        for(int i=0; i<calculo.length(); i+=2) {
            c = calculo.charAt(i);
            n = Integer.parseInt(String.valueOf(c));
            if (i==0) resultado = n;
            else {
                operacao = calculo.charAt(i-1);
                if (operacao == '+') resultado += n;
                else if (operacao == '-') resultado -= n;
                else if (operacao == '*') resultado *= n;
                else if (operacao == '/') resultado /= n;
            }
        }
        return resultado;
    }

}
