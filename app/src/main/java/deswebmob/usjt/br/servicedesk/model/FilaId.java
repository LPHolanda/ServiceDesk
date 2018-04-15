package deswebmob.usjt.br.servicedesk.model;

/**
 * Created by Leandro Pinheiro de Holanda 816113762 on 21/03/2018.
 */

public enum FilaId {
    PROJETO(1, "Novos Projetos"),
    REDES(5, "Redes"),
    SERVIDORES(4, "Servidores"),
    DESKTOPS(7, "Desktops"),
    TELEFONIA(6, "Telefonia"),
    ERP(3, "Manutenção do Sistema ERP"),
    VENDAS(2, "Manutenção do Sistema de Vendas");

    private final int id;
    private final String nome;

    FilaId(int num, String s){
        id = num;
        nome = s;
    }

    public int id(){
        return id;
    }

    public String nome(){
        return nome;
    }
}


