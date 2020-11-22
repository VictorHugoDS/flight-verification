package projeto.de.verificação.de.voos.Persistencia;

import java.util.List;
import projeto.de.verificação.de.voos.Entidades.Aviao;

/**Interface que irá isolar a camada de salvamento dos objetos da classe Avião.
* @author Victor Hugo Duarte Da Silva
*/
public interface AviaoDAO {

    /** Salva em no banco um determinado Aviao 
     *
     * @param aviao
     */
    public void salvar(Aviao aviao);
    
    /** Edita um determinado elemento do banco tendo como parametro o Aviao passado por ele, se o aviao passado não existir no banco, nada acontece
     *
     * @param aviao
     */
    public void editar(Aviao aviao);
    
    /** Exclui um elemento do banco baseado em seu id. Se o id não for encontrado, retorna falso
     *
     * @param id
     * @return boolean
     */
    public boolean excluir(int id);
    
    /** Retorna um Aviao tendo base um id passado. Se o id não for encontrado, retorna null
     *
     * @param id
     * @return Aviao
     */
    public Aviao procurar_por_id(int id);
    
    /** Retorna todo o banco no formato de List
     *
     * @return List&ltAviao&gt
     */
    public List<Aviao> lista_do_banco();
    
    /** Retorna um valor de id disponível no banco
     *
     * @return int
     */
    public int id_disponivel();
}
