package deswebmob.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import deswebmob.usjt.br.servicedesk.R;
import deswebmob.usjt.br.servicedesk.model.Chamado;
import deswebmob.usjt.br.servicedesk.model.Fila;

/**
 * Leandro Pinheiro de Holanda 816113762
 */

public class DetalheChamadoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_chamado);
        Intent intent = getIntent();
        Chamado chamado = (Chamado)intent.getSerializableExtra(ListarChamadosActivity.CHAMADO);
        ImageView foto = (ImageView) findViewById(R.id.imagem_fila);
        try {
            foto.setImageBitmap(MainActivity._filas.get(Fila.getFila(MainActivity._filas,
                    chamado.getFila().getId())).getImagem());
        } catch (Exception e){
            foto.setImageDrawable(getDrawable(R.drawable.ic_not_found));
        }
        TextView fila = (TextView)findViewById(R.id.busca_fila);
        fila.setText(chamado.getFila().getNome());
        TextView numero = (TextView)findViewById(R.id.numero_status_chamado);
        numero.setText(""+chamado.getNumero());
        TextView status = (TextView)findViewById(R.id.numero_status_chamado);
        status.setText(""+chamado.getStatus());
        DateFormat formatter = new SimpleDateFormat(Chamado.DATE_PATTERN);
        TextView abertura = (TextView)findViewById(R.id.abertura_fechamento_chamado);
        abertura.setText(formatter.format(chamado.getDataAbertura()));
        TextView fechamento = (TextView)findViewById(R.id.abertura_fechamento_chamado);
        fechamento.setText(chamado.getDataFechamento() == null?" ":
                formatter.format(chamado.getDataFechamento()));
        TextView descricao = (TextView)findViewById(R.id.descricao_chamado);
        descricao.setText(""+chamado.getDescricao());
    }
}
