package projeto.de.verificação.de.voos.Persistencia;

import java.util.List;
import projeto.de.verificação.de.voos.Entidades.Aviao;

/**Interface que irá isolar a camada de salvamento dos objetos da classe Avião.
* @author Victor Hugo Duarte Da Silva
*/
public interface AviaoDAO {
    public void salvar(Aviao aviao);
    
    public void editar(Aviao aviao);
    
    public boolean excluir(int id);
    
    public Aviao procurar_por_id(int id);
    
    public List<Aviao> lista_do_banco();
    
    public int id_disponivel();
}
