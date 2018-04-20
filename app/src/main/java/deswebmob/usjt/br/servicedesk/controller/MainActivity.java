package deswebmob.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import deswebmob.usjt.br.servicedesk.R;
import deswebmob.usjt.br.servicedesk.model.Chamado;
import deswebmob.usjt.br.servicedesk.model.Fila;
import deswebmob.usjt.br.servicedesk.model.ChamadoNetwork;
import deswebmob.usjt.br.servicedesk.model.FilaDb;

/**
 * Created by Leandro Pinheiro de Holanda 816113762
 */

public class MainActivity extends Activity {
    public static final String CHAMADOS = "br.usjt.deswebmob.servicedeskcco.chamados";
    public static final String SDESK_HOST = "http://192.168.0.10:8080/arqdes_sdesk_final/";
    private EditText txtFila;
    Context contexto;
    public static ArrayList<Fila> _filas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFila = (EditText)findViewById(R.id.busca_fila);
        contexto = this;
        new DownloadJsonFilas().execute(SDESK_HOST + "rest/filas", SDESK_HOST + "img/");
    }

    public void buscarChamados(View view) {
        String fila = txtFila.getText().toString();
        new DownloadJsonChamados().execute(SDESK_HOST + "rest/chamados");

    }

    private class DownloadJsonChamados extends AsyncTask<String, Void, ArrayList<Chamado>>{

        @Override
        protected ArrayList<Chamado> doInBackground(String... strings) {
            ArrayList<Chamado> chamados = new ArrayList<>();
            try {
                chamados = ChamadoNetwork.buscarChamados(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return chamados;
        }

        protected void onPostExecute(ArrayList<Chamado> chamados){
            Intent intent = new Intent(contexto, ListarChamadosActivity.class);
            intent.putExtra(CHAMADOS, chamados);
            startActivity(intent);
        }

    }

    private class DownloadJsonFilas extends AsyncTask<String, Void, ArrayList<Fila>>{
        @Override
        protected ArrayList<Fila> doInBackground(String... strings) {
            FilaDb db = new FilaDb(contexto);
            ArrayList<Fila> filas = db.listarFilas();
            Log.println(Log.DEBUG,"MainActivity" , "Carregou as filas do SQLITE. " +
                    filas == null?"Fila vazia":filas.size()+" filas");
            if (filas == null || filas.size() == 0) {
                Log.println(Log.DEBUG,"MainActivity" , "Banco vazio. Vai carregar as filas do REST");
                try {
                    filas = ChamadoNetwork.buscarFilas(strings[0], strings[1]);
                    Log.println(Log.DEBUG,"MainActivity" , "Carregou do REST");
                    db.inserirFila(filas);
                    Log.println(Log.DEBUG,"MainActivity" , "Inseriu no SQLITE");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    DateFormat formatter = new SimpleDateFormat(Fila.DATE_PATTERN);
                    String sData = formatter.format(filas.get(filas.size()-1).getDataAtualizacao());
                    ArrayList<Fila> filasNovas = ChamadoNetwork.buscarFilas(strings[0]+"/" +
                            sData, strings[1]);
                    if(filasNovas == null){
                        filasNovas = new ArrayList<>();
                    }
                    Log.println(Log.DEBUG,"MainActivity" , "Carregou as filas novas; tem "+filasNovas.size());
                    for(Fila fila: filasNovas){
                        int posicao = Fila.getFila(filas, fila.getId());
                        if (posicao >= 0) {
                            filas.remove(posicao);
                        }
                        filas.add(fila);
                        Log.println(Log.DEBUG,"MainActivity" , "Alterou no ArrayList a fila "+fila);
                    }
                    db.atualizaFilas(filasNovas);
                    Log.println(Log.DEBUG,"MainActivity" , "Inseriu as filas novas no SQLITE");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return filas;
        }

        protected void onPostExecute(ArrayList<Fila> filas){
            _filas = filas;
        }

    }
}
