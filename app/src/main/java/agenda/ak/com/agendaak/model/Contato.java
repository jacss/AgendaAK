package agenda.ak.com.agendaak.model;

import java.io.Serializable;

public class Contato implements Serializable{
    private String nomeContato;
    private String teleContato;
    private String emailContato;
    private Long id;

    @Override
    public String toString() {
        return nomeContato.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTeleContato() {
        return teleContato;
    }

    public void setTeleContato(String teleContato) {
        this.teleContato = teleContato;
    }

    public String getEmailContato() {
        return emailContato;
    }

    public void setEmailContato(String emailContato) {
        this.emailContato = emailContato;
    }
}
