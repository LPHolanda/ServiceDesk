package deswebmob.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import deswebmob.usjt.br.servicedesk.R;
import deswebmob.usjt.br.servicedesk.model.Chamado;
import deswebmob.usjt.br.servicedesk.model.ChamadoAdapter;
import deswebmob.usjt.br.servicedesk.model.Data;

public class ListarChamadosActivity extends Activity {
    public static final String CHAMADO = "br.usjt.desenvmob.aula03.chamado";
    ArrayList<Chamado> chamados;
    ListView listView;
    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        final Intent intent = getIntent();
        chamados =(ArrayList<Chamado>)intent.getSerializableExtra(MainActivity.CHAMADOS);

        /*
             String nomeFila = intent.getStringExtra(MainActivity.FILA);
            try {
            chamados = ChamadoNetwork.buscarChamados("http://10.0.2.2:8080/arqsw_sdesk_a4_remasterized/rest/chamados");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        listView = (ListView) findViewById(R.id.lista_chamados);
        ChamadoAdapter adapter = new ChamadoAdapter(this, chamados);
        listView.setAdapter(adapter);
        contexto = this;
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Chamado chamado = chamados.get(position);
                        Intent intent1 = new Intent(contexto, DetalheChamadoActivity.class);
                        intent1.putExtra(CHAMADO, chamado);
                        startActivity(intent1);
                    }
                }
        );
    }
}
