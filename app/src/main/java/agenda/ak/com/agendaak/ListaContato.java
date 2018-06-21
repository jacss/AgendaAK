package agenda.ak.com.agendaak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import agenda.ak.com.agendaak.dao.ContatoDAO;
import agenda.ak.com.agendaak.model.Contato;

public class ListaContato extends AppCompatActivity {
    private Button btnCadastrar;
    private Button btnAgenda;
    private ListView listaView;
    private Contato contato = new Contato();
    private ContatoDAO dao;
    private ArrayList<Contato> listViewContato;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contato);

        btnCadastrar = findViewById(R.id.btnCadastrar_Id);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaContato.this, CadastrarContato.class);
                startActivity(intent);
            }
        });
        listaView = findViewById(R.id.listVie_ID);
        registerForContextMenu(listaView);

        listaView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                contato = (Contato) adapter.getItemAtPosition(position);
                return false;
            }
        });

        listaView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
                //seleciona o contato na listview
                Contato contatoEscolhido = (Contato) adapter.getItemAtPosition(i);
                Intent intent = new Intent(ListaContato.this, CadastrarContato.class);
                intent.putExtra("contato-escolhido", contatoEscolhido);
                startActivity(intent);
            }
        });

    }

    @Override
    //método que seleciona o contato par ser deletado
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar este contato!!");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                dao = new ContatoDAO(ListaContato.this);
                dao.deletarContato(contato);
                dao.close();
                carregarContato();
                return true;
            }
        });
    }

    public void onResume() {
        super.onResume();
        carregarContato();
    }
        //método que atualiza os contatos na listview
    public void carregarContato() {
        dao = new ContatoDAO(ListaContato.this);
        listViewContato = dao.getLista();
        dao.close();
        if (listViewContato != null) {
            adapter = new ArrayAdapter<Contato>(ListaContato.this, android.R.layout.simple_list_item_1, listViewContato);
            listaView.setAdapter(adapter);
        }
    }
}
