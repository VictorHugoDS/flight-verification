/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.verificação.de.voos.Entidades;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Voo implements Serializable {
    private int id;
    private Aviao aviao;
    private Cidade cidade_origem;
    private Cidade cidade_destino;
    private GregorianCalendar data;
    private int duracao;

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

    public Cidade getCidade_origem() {
        return cidade_origem;
    }

    public void setCidade_origem(Cidade cidade_origem) {
        this.cidade_origem = cidade_origem;
    }

    public Cidade getCidade_destino() {
        return cidade_destino;
    }

    public void setCidade_destino(Cidade cidade_destino) {
        this.cidade_destino = cidade_destino;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
}
