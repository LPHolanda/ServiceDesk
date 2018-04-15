package deswebmob.usjt.br.servicedesk.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;

import deswebmob.usjt.br.servicedesk.R;
import deswebmob.usjt.br.servicedesk.model.Chamado;
import deswebmob.usjt.br.servicedesk.model.ChamadoNetwork;

public class MainActivity extends Activity {
    public static final String CHAMADO = "br.usjt.desenvmob.aula03.chamados";
    private EditText txtFila;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFila = (EditText) findViewById(R.id.busca_fila);
        ctx = this;
    }

    public void buscarChamados(View view) {
        String fila = txtFila.getText().toString();
        new DownloadJSONChamado().execute("http://10.0.2.2:8080/arqsw_sdesk_a4_remasterized/rest/chamados");
       /* Intent intent = new Intent(this, ListarChamadosActivity.class);
        intent.putExtra(CHAMADO, fila);
        startActivity(intent);*/
    }

    private class DownloadJSONChamado extends AsyncTask<String , Void , ArrayList<Chamado>> {

        @Override
        protected ArrayList<Chamado> doInBackground(String... strings) {
            ArrayList<Chamado> chamados = new ArrayList<>();

            try {
                chamados = ChamadoNetwork.buscarChamados("http://10.0.2.2:8080/arqsw_sdesk_a4_remasterized/rest/chamados");
            } catch (IOException e) {
                e.printStackTrace();
            }

            return chamados;
        }

        protected void onPostExecute(ArrayList<Chamado> chamados){
            Intent i = new Intent(ctx, ListarChamadosActivity.class);
            i.putExtra(CHAMADO, chamados);
            startActivity(i);
        }
    }
}
