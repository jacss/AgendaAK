package agenda.ak.com.agendaak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import agenda.ak.com.agendaak.dao.ContatoDAO;
import agenda.ak.com.agendaak.model.Contato;

public class MainActivity extends AppCompatActivity {

    private Button btnAgenda;

    private Contato contato = new Contato();
    private ContatoDAO dao;
    private ArrayList<Contato>listViewContato;
    private ArrayAdapter adapter;
    private Button btnCalculadora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgenda = findViewById(R.id.btnAgenda_ID);
        btnCalculadora = findViewById(R.id.btnCalculadora_ID);


        btnAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaContato.class);
                startActivity(intent);
            }
        });
        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, Calculadora.class);
                startActivity(intent);
            }
        });
    }

}
