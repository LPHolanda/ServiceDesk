package deswebmob.usjt.br.servicedesk.model;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Leandro Pinheiro de Holanda on 22/03/2018.
 */

public class ViewHolder {
        private TextView numero,data,descricao;
        private ImageView imagem;

    public TextView getNumero() {
        return numero;
    }

    public void setNumero(TextView numero) {
        this.numero = numero;
    }

    public TextView getData() {
        return data;
    }

    public void setData(TextView data) {
        this.data = data;
    }

    public TextView getDescricao() {
        return descricao;
    }

    public void setDescricao(TextView descricao) {
        this.descricao = descricao;
    }

    public ImageView getImagem() {
        return imagem;
    }

    public void setImagem(ImageView imagem) {
        this.imagem = imagem;
    }
}

