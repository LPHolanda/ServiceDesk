package deswebmob.usjt.br.servicedesk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText txtNome;
    public static final String NOME = "deswebmob.usjt.br.servicedesk.fila";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNome = findViewById(R.id.busca_fila);
    }

    public void buscarChamados(View view) {
        Intent intent = new Intent(this, ListarChamadosActivity.class);
        String fila = txtNome.getText().toString();
        intent.putExtra(NOME, fila);
        startActivity(intent);
    }
}
