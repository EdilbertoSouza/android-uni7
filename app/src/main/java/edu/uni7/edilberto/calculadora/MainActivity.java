package edu.uni7.edilberto.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etRes = (EditText) findViewById(R.id.etRes);

        Button bt0 = (Button) findViewById(R.id.bt0);
        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.setText("0 ");
            }
        });

        Button bt1 = (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etRes.setText("1 ");
            }
        });

    }

}
