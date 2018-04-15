package deswebmob.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import deswebmob.usjt.br.servicedesk.R;
import deswebmob.usjt.br.servicedesk.model.Chamado;

/**
 * Leandro Pinheiro de Holanda 816113762
 */

public class DetalheChamadoActivity extends Activity {
    TextView txtNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_chamado);
        txtNome = (TextView) findViewById(R.id.chamado_nome);
        Intent intent = getIntent();
        Chamado ch =(Chamado)intent.getSerializableExtra(ListarChamadosActivity.CHAMADO);
        txtNome.setText(ch.getDescricao());
    }
}
