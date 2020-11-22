package projeto.de.verificação.de.voos.Persistencia;

import java.util.ArrayList;
import java.util.List;
import projeto.de.verificação.de.voos.Entidades.Voo;

/**Interface que irá isolar a camada de salvamento dos objetos da classe Voo.
* @author Victor Hugo Duarte Da Silva
*/
public interface VooDAO {

    /**Salva em no banco um determinado Voo
     *
     * @param voo
     */
    public void salvar(Voo voo);
    
    /**Edita um determinado elemento do banco tendo como parametro o Voo passado por ele, se Voo passado não existir no banco, nada acontece
     *
     * @param voo
     */
    public void editar(Voo voo);
    
    /**Exclui um elemento do banco baseado em seu id. Se o id não for encontrado, retorna falso
     *
     * @param id
     * @return boolean
     */
    public boolean excluir(int id);
    
    /**Retorna um Voo tendo base um id passado. Se o id não for encontrado, retorna null
     *
     * @param id
     * @return Voo
     */
    public Voo procurar_por_id(int id);
    
    /**Retorna todo o banco no formato de ArrayList
     *
     * @return ArrayList&ltVoo&gt
     */
    public ArrayList<Voo> lista_do_banco();
    
    /**Retorna um valor de id disponível no banco
     *
     * @return int
     */
    public int id_disponivel();
    
    /** Verifica se um determinado Voo é válido no banco baseado nas regras de validade de um Voo, esse Voo não pode existir no banco para que a validação seja feita de forma correta. Caso contrario o método sempre retornará False
     *
     * @param v
     * @return boolean
     */
    public boolean verificarValidade(Voo v);
    
}
