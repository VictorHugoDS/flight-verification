package projeto.de.verificação.de.voos.Entidades;

import java.io.Serializable;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.AviaoDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.AviaoDAO;

/**Classe para objetos do tipo avião que serão utilizados na criação dos voos.
* @author Victor Hugo Duarte
*/
public class Aviao implements Serializable {
    private int id;
    private String nome;
    
    /** Método contrutor de Aviao. Ao instanciar um objeto por ele, um id será automaticamente atribuido a ele
     *
     */
    public Aviao(){
        AviaoDAO banco= new AviaoDAOImplArq();
        id = banco.id_disponivel();
    }
    
    /**Retorna o Id do Aviao
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**Altera o Id do Aviao
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Retorna o nome do Aviao
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /** Altera o nome do Aviao
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
