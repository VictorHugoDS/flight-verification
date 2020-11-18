package projeto.de.verificação.de.voos.Entidades;

import java.io.Serializable;

/**Classe para objetos do tipo cidade que serão utilizados na criação dos voos.
* @author Victor Hugo Duarte Da Silva
*/
public class Cidade implements Serializable {
    private int id;
    private String nome;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
