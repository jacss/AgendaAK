package agenda.ak.com.agendaak.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import agenda.ak.com.agendaak.CadastrarContato;
import agenda.ak.com.agendaak.model.Contato;

public class ContatoDAO extends SQLiteOpenHelper {

    private static final String DATABASE = "bdagenda";
    private static final int VERSION = 1;
    private CadastrarContato contato = new CadastrarContato();

    public ContatoDAO(Context context) {
        super(context, DATABASE, null, VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        String sql = "CREATE TABLE tblcontato(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nome TEXT NOT NULL, telefone TEXT NOT NULL, email TEXT NOT NULL);";
        bd.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS tblcontato";
        bd.execSQL(sql);

    }

    //Metodo Salvar
    public void salvarContato(Contato contato) {
        ContentValues values = new ContentValues();

        values.put("nome", contato.getNomeContato());
        values.put("telefone", contato.getTeleContato());
        values.put("email", contato.getEmailContato());

        getWritableDatabase().insert("tblcontato", null, values);

    }

    //Alterar contato
    public void alterarContato(Contato contato) {
        ContentValues values = new ContentValues();

        values.put("nome", contato.getNomeContato());
        values.put("telefone", contato.getTeleContato());
        values.put("email", contato.getEmailContato());

        String[] args = {contato.getId().toString()};
        getWritableDatabase().update("tblcontato", values, "id=?", args);

    }

    //Método para deletar Contato
    public void deletarContato(Contato contato) {
        String[] args = {contato.getId().toString()};
        getWritableDatabase().delete("tblcontato", "id=?", args);


    }

    //Metodo de Listar os contatos
    public ArrayList<Contato> getLista() {
        String[] columns = {"id", "nome", "telefone", "email"};
        Cursor cursor = getWritableDatabase().query("tblcontato", columns, null, null, null, null, null, null);
        ArrayList<Contato> contatos = new ArrayList<Contato>();

        while (cursor.moveToNext()) {
            Contato contato = new Contato();
            contato.setId(cursor.getLong(0));
            contato.setNomeContato(cursor.getString(1));
            contato.setTeleContato(cursor.getString(2));
            contato.setEmailContato(cursor.getString(3));
            contatos.add(contato);

        }

        return contatos;
    }


}
