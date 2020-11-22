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

/**Classe para objetos do tipo Voo. É a classe principal do sistema e possui tanto um Aviao associado a ela quanto Cidade de embarque e desembarque
 *
 * @author Victor Hugo Duarte
 */
public class Voo implements Serializable {
    private int id;
    private Aviao aviao;
    private Cidade cidade_embarque;
    private Cidade cidade_desembarque;
    private Calendar data;
    private int duracao;
    
    /** Método contrutor de Voo. Ao instanciar um objeto por ele, um id será automaticamente atribuido a ele
     *
     */
    public Voo(){
        VooDAO banco = new VooDAOImplArq();
        id = banco.id_disponivel();   
        //data.set(Calendar.SECOND, 0);
        
    }

    /**Retorna o id de Voo
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**Altera o id de Voo
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Retorna o Aviao associado ao Voo
     *
     * @return Aviao
     */
    public Aviao getAviao() {
        return aviao;
    }

    /**Altera o Aviao associado ao Voo
     *
     * @param aviao
     */
    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    /**Retorna a cidade de embarque associada ao Voo
     *
     * @return Cidade
     */
    public Cidade getCidade_embarque() {
        return cidade_embarque;
    }

    /**Altera a cidade de embarque associada ao Voo
     *
     * @param cidade_embarque
     */
    public void setCidade_embarque(Cidade cidade_embarque) {
        this.cidade_embarque = cidade_embarque;
    }

    /**Retorna a cidade de desembarque associada ao Voo
     *
     * @return Cidade
     */
    public Cidade getCidade_desembarque() {
        return cidade_desembarque;
    }

    /**Altera a cidade de desembarque associada ao Voo
     *
     * @param cidade_desembarque
     */
    public void setCidade_desembarque(Cidade cidade_desembarque) {
        this.cidade_desembarque = cidade_desembarque;
    }

    /**Retorna a Data que será realizada o Voo
     *
     * @return Calendar
     */ 
    public Calendar getData() {
        return data;
    }

    /** Altera a Data que será realizada o Voo
     *
     * @param data
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /** Retorna a duração do Voo
     *
     * @return int
     */
    public int getDuracao() {
        return duracao;
    }

    /** Altera a duração do Voo
     *
     * @param duracao
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
}
