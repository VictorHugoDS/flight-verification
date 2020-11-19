package projeto.de.verificação.de.voos.Entidades;

import java.io.Serializable;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.AviaoDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.AviaoDAO;

/**Classe para objetos do tipo avião que serão utilizados na criação dos voos.
* @author Victor Hugo Duarte Da Silva
*/
public class Aviao implements Serializable {
    private int id;
    private String nome;
    

    public Aviao(){
        AviaoDAO banco= new AviaoDAOImplArq();
        id = banco.id_disponivel();
    }
    
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
