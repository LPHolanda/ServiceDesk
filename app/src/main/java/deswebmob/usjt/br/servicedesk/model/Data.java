package deswebmob.usjt.br.servicedesk.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Leandro Pinheiro de Holanda on 21/03/2018.
 */

public class Data {
    public static ArrayList<Chamado> buscarChamados(String chave){
        ArrayList<Chamado> lista = geraListaChamados();

        if(chave == null || chave.length() == 0){
            return lista;
        }

        ArrayList<Chamado> resultado = new ArrayList<>();

        for(Chamado chamado:lista){
            if(chamado.getFila().getNome().toUpperCase().contains(chave.toUpperCase())){
                resultado.add(chamado);
            }
        }
        return resultado;
    }

    public static ArrayList<Chamado> geraListaChamados(){
        ArrayList<Chamado> lista = new ArrayList<>();

        Chamado chamado = new Chamado();
        chamado.setNumero(1);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("Computador da secretária quebrado");
        Fila fila = new Fila();
        fila.setId(FilaId.DESKTOPS.id());
        fila.setNome(FilaId.DESKTOPS.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(2);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("Telefone não funciona");
        fila = new Fila();
        fila.setId(FilaId.TELEFONIA.id());
        fila.setNome(FilaId.TELEFONIA.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(3);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("troca de senha");
        fila = new Fila();
        fila.setId(FilaId.DESKTOPS.id());
        fila.setNome(FilaId.DESKTOPS.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(4);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(new Date());
        chamado.setStatus(Chamado.FECHADO);
        chamado.setDescricao("CRM");
        fila = new Fila();
        fila.setId(FilaId.PROJETO.id());
        fila.setNome(FilaId.PROJETO.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(5);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("incluir pipeline");
        fila = new Fila();
        fila.setId(FilaId.VENDAS.id());
        fila.setNome(FilaId.VENDAS.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(6);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("Gestão de Orçamento");
        fila = new Fila();
        fila.setId(FilaId.PROJETO.id());
        fila.setNome(FilaId.PROJETO.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(7);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("Rede MPLS");
        fila = new Fila();
        fila.setId(FilaId.PROJETO.id());
        fila.setNome(FilaId.PROJETO.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(8);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("Internet com lentidão");
        fila = new Fila();
        fila.setId(FilaId.REDES.id());
        fila.setNome(FilaId.REDES.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(9);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(null);
        chamado.setStatus(Chamado.ABERTO);
        chamado.setDescricao("liberar celular");
        fila = new Fila();
        fila.setId(FilaId.TELEFONIA.id());
        fila.setNome(FilaId.TELEFONIA.nome());
        chamado.setFila(fila);
        lista.add(chamado);

        chamado = new Chamado();
        chamado.setNumero(10);
        chamado.setDataAbertura(new Date());
        chamado.setDataFechamento(new Date());
        chamado.setStatus(Chamado.FECHADO);
        chamado.setDescricao("ponto com defeito");
        fila = new Fila();
        fila.setId(FilaId.REDES.id());
        fila.setNome(FilaId.REDES.nome());
        chamado.setFila(fila);
        lista.add(chamado);



        /*chamados.add("Desktops: Computador da secretária quebrado.");
        lista.add("Telefonia: Telefone não funciona.");
        lista.add("Redes: Manutenção no proxy.");
        lista.add("Servidores: Lentidão generalizada.");
        lista.add("Novos Projetos: CRM");
        lista.add("Manutenção Sistema ERP: atualizar versão.");
        lista.add("Novos Projetos: Rede MPLS");
        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
        lista.add("Manutenção Sistema ERP: erro contábil");
        lista.add("Novos Projetos: Gestão de Orçamento");
        lista.add("Novos Projetos: Big Data");
        lista.add("Manoel de Barros");
        lista.add("Redes: Internet com lentidão");
        lista.add("Novos Projetos: Chatbot");
        lista.add("Desktops: troca de senha");
        lista.add("Desktops: falha no Windows");
        lista.add("Novos Projetos: ITIL V3");
        lista.add("Telefonia: liberar celular");
        lista.add("Telefonia: mover ramal");
        lista.add("Redes: ponto com defeito");
        lista.add("Novos Projetos: ferramenta EMM");*/

        return lista;
    }
}
