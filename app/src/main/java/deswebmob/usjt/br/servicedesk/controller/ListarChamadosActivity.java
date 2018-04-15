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
    public static final String CHAMADO = "deswebmbo.usjt.br.servicedesk";
    ArrayList<Chamado> chamados;
    ListView listView;
    Activity contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        Intent intent = getIntent();
        String nomeFila = intent.getStringExtra(MainActivity.NOME);
        chamados = Data.buscarChamados(nomeFila);
        listView = findViewById(R.id.lista_chamados);
        ChamadoAdapter adapter = new ChamadoAdapter(this, chamados);
        listView.setAdapter(adapter);
        contexto = this;

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Chamado chamado = chamados.get(position);
                        Intent intent1 = new Intent(contexto, DetalheChamadoActivity.class);
                        intent1.putExtra(CHAMADO, chamado);
                        startActivity(intent1);
                    }
                }
        );
    }
}
