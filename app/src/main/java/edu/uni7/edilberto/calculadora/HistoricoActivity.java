package edu.uni7.edilberto.calculadora;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoricoActivity extends AppCompatActivity{

    ArrayList<String> aHistorico;
    ArrayAdapter<String> adapter;
    ListView lvHistorico;
    Button btHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        Bundle extras = getIntent().getExtras();
        aHistorico = extras.getStringArrayList("historico");

        if (aHistorico.size() > 0) {
            adapter = new ArrayAdapter<String>(HistoricoActivity.this, android.R.layout.simple_list_item_1, aHistorico);
        }
        lvHistorico = findViewById(R.id.lvHistorico);
        lvHistorico.setAdapter(adapter);

        btHistorico = findViewById(R.id.btHistorico);
        btHistorico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lvHistorico.setAdapter(null);
                SystemUtil.salvarHistorico(HistoricoActivity.this, new ArrayList<String>());
            }
        });
    }

}
