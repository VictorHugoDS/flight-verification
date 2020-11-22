package projeto.de.verificação.de.voos.Persistencia;

import java.util.List;
import projeto.de.verificação.de.voos.Entidades.Cidade;

/**Interface que irá isolar a camada de salvamento dos objetos da classe Cidadde.
* @author Victor Hugo Duarte Da Silva
*/
public interface CidadeDAO {

    /** Salva em no banco uma determinada Cidade
     *
     * @param cidade
     */
    public void salvar(Cidade cidade);
    
    /**Edita um determinado elemento do banco tendo como parametro a Cidade passado por ele, se a Cidade passado não existir no banco, nada acontece
     *
     * @param cidade
     */
    public void editar(Cidade cidade);
    
    /**Exclui um elemento do banco baseado em seu id. Se o id não for encontrado, retorna falso
     *
     * @param id
     * @return boolean
     */
    public boolean excluir(int id);
    
    /**Retorna uma Cidade tendo base um id passado. Se o id não for encontrado, retorna null
     *
     * @param id
     * @return Cidade
     */
    public Cidade procurar_por_id(int id);
    
    /**Retorna todo o banco no formato de List
     *
     * @return List&ltCidade&gt
     */
    public List<Cidade> lista_do_banco();
    
    /** Retorna um valor de id disponível no banco
     *
     * @return int
     */
    public int id_disponivel();
}
