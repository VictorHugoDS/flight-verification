/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.verificação.de.voos.Entidades;

import java.io.Serializable;
import java.util.Calendar;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.VooDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.VooDAO;

public class Voo implements Serializable {
    private int id;
    private Aviao aviao;
    private Cidade cidade_embarque;
    private Cidade cidade_desembarque;
    private Calendar data;
    private int duracao;
    
    public Voo(){
        VooDAO banco = new VooDAOImplArq();
        id = banco.id_disponivel();   
        //data.set(Calendar.SECOND, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Cidade getCidade_embarque() {
        return cidade_embarque;
    }

    public void setCidade_embarque(Cidade cidade_embarque) {
        this.cidade_embarque = cidade_embarque;
    }

    public Cidade getCidade_desembarque() {
        return cidade_desembarque;
    }

    public void setCidade_desembarque(Cidade cidade_desembarque) {
        this.cidade_desembarque = cidade_desembarque;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
}
