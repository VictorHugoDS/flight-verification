package projeto.de.verificação.de.voos.Entidades;

import java.io.Serializable;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.CidadeDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.CidadeDAO;

/**Classe para objetos do tipo cidade que serão utilizados na criação dos voos.
* @author Victor Hugo Duarte 
*/
public class Cidade implements Serializable {
    private int id;
    private String nome;
    
    /** Método contrutor de Cidade. Ao instanciar um objeto por ele, um id será automaticamente atribuido a ele
     *
     */
    public Cidade(){
        CidadeDAO banco = new CidadeDAOImplArq();
        id = banco.id_disponivel();
    }

    /**Retorna o id da Cidade
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**Altera o id da Cidade
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Retorna o nome da Cidade
     *
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**Altera o nome da Cidade
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
