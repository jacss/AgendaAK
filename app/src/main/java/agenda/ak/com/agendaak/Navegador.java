package agenda.ak.com.agendaak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Navegador extends AppCompatActivity {
    private Button botaoGo;
    private EditText editTextNavegador;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);

        botaoGo = findViewById(R.id.botaoGo_Id);
        editTextNavegador = findViewById(R.id.editTextNavegador_Id);
        webView = findViewById(R.id.webView_Id);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        botaoGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                webView.loadUrl("https://" + editTextNavegador.getText().toString());
                editTextNavegador.setText("");
            }
        });
    }
}
