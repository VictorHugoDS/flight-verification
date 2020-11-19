package projeto.de.verificação.de.voos.Persistencia;

import java.util.List;
import projeto.de.verificação.de.voos.Entidades.Voo;

/**Interface que irá isolar a camada de salvamento dos objetos da classe Voo.
* @author Victor Hugo Duarte Da Silva
*/
public interface VooDAO {
    public void salvar(Voo voo);
    
    public void editar(Voo voo);
    
    public boolean excluir(int id);
    
    public Voo procurar_por_id(int id);
    
    public List<Voo> lista_do_banco();
    
    public int id_disponivel();
}
