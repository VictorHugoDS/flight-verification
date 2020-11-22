package projeto.de.verificação.de.voos.Persistencia;

import java.util.List;
import projeto.de.verificação.de.voos.Entidades.Aviao;

/**Interface que irá isolar a camada de salvamento dos objetos da classe Avião.
* @author Victor Hugo Duarte Da Silva
*/
public interface AviaoDAO {

    /**
     *
     * @param aviao
     */
    public void salvar(Aviao aviao);
    
    /**
     *
     * @param aviao
     */
    public void editar(Aviao aviao);
    
    /**
     *
     * @param id
     * @return
     */
    public boolean excluir(int id);
    
    /**
     *
     * @param id
     * @return
     */
    public Aviao procurar_por_id(int id);
    
    /**
     *
     * @return
     */
    public List<Aviao> lista_do_banco();
    
    /**
     *
     * @return
     */
    public int id_disponivel();
}
