package projeto.de.verificação.de.voos.Persistencia;

import java.util.List;
import projeto.de.verificação.de.voos.Entidades.Cidade;

/**Interface que irá isolar a camada de salvamento dos objetos da classe Cidadde.
* @author Victor Hugo Duarte Da Silva
*/
public interface CidadeDAO {
    public void salvar(Cidade cidade);
    
    public void editar(Cidade cidade);
    
    public boolean excluir(int id);
    
    public Cidade procurar_por_id(int id);
    
    public List<Cidade> lista_do_banco();
    
    public int id_disponivel();
}
