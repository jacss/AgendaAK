package agenda.ak.com.agendaak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agenda.ak.com.agendaak.dao.ContatoDAO;
import agenda.ak.com.agendaak.model.Contato;

public class CadastrarContato extends AppCompatActivity {

    private EditText nomeContato;
    private EditText textoTelefone;
    private EditText textoEmail;
    private Button btnPolimofismo;
    private Contato editarContato;
    private Contato contato = new Contato();
    private ContatoDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_contato);

        dao = new ContatoDAO(CadastrarContato.this);
        Intent intent = getIntent();
        editarContato= (Contato) intent.getSerializableExtra("contato-escolhido");

        nomeContato = findViewById(R.id.textoNome_ID);
        textoTelefone = findViewById(R.id.textoTelefone_ID);
        textoEmail = findViewById(R.id.textoEmail_ID);

        btnPolimofismo = findViewById(R.id.btnPolimosfismo_ID);

        if(editarContato!=null){
            btnPolimofismo.setText("Alterar Cadastro");

            nomeContato.setText(editarContato.getNomeContato());
            textoTelefone.setText(editarContato.getTeleContato());
            textoEmail.setText(editarContato.getEmailContato());

            contato.setId(editarContato.getId());
        }else {
            btnPolimofismo.setText("Novo Contato");
        }

        btnPolimofismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contato.setNomeContato(nomeContato.getText().toString());
                contato.setTeleContato(textoTelefone.getText().toString());
                contato.setEmailContato(textoEmail.getText().toString());

                if(btnPolimofismo.getText().toString().equals("Novo Contato")){
                    if(nomeContato.getText().equals(null)||textoEmail.getText().equals(null)||textoTelefone.getText().equals(null)){
                        Toast.makeText(CadastrarContato.this,"O campo nome não pode ser vasio!!", Toast.LENGTH_SHORT).show();
                    }else {
                        dao.salvarContato(contato);
                        Toast.makeText(CadastrarContato.this,"Registro salvo com sucesso!!", Toast.LENGTH_SHORT).show();
                        dao.close();
                        }


                }else{
                    dao.alterarContato(contato);
                    dao.close();
                }


            }
        });

    }

}
