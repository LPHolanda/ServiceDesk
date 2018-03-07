package deswebmob.usjt.br.servicedesk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListarChamadosActivity extends Activity {
    ArrayList<String> chamados;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        chamados = geraListaChamados();
        listView = findViewById(R.id.lista_chamados);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, chamados);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> geraListaChamados(){
        ArrayList<String> chamados = new ArrayList<>();

        chamados.add("Desktops: Computador da secretária quebrado.");
        chamados.add("Telefonia: Telefone não funciona.");
        chamados.add("Redes: Manutenção no proxy.");
        chamados.add("Servidores: Lentidão generalizada.");
        chamados.add("Novos Projetos: CRM");
        chamados.add("Manutenção Sistema ERP: atualizar versão.");
        chamados.add("Novos Projetos: Rede MPLS");
        chamados.add("Manutenção Sistema de Vendas: incluir pipeline.");
        chamados.add("Manutenção Sistema ERP: erro contábil");
        chamados.add("Novos Projetos: Gestão de Orçamento");
        chamados.add("Novos Projetos: Big Data");
        chamados.add("Manoel de Barros");
        chamados.add("Redes: Internet com lentidão");
        chamados.add("Novos Projetos: Chatbot");
        chamados.add("Desktops: troca de senha");
        chamados.add("Desktops: falha no Windows");
        chamados.add("Novos Projetos: ITIL V3");
        chamados.add("Telefonia: liberar celular");
        chamados.add("Telefonia: mover ramal");
        chamados.add("Redes: ponto com defeito");
        chamados.add("Novos Projetos: ferramenta EMM");

        return chamados;
    }
}
