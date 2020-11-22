package projeto.de.verificação.de.voos.Persistencia.Arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import projeto.de.verificação.de.voos.Entidades.Cidade;
import projeto.de.verificação.de.voos.Persistencia.CidadeDAO;

/**Classe responsavel por salvar,editar,excluir e consultar uma lista de objetos da classe Cidade em um arquivo.
* @author Victor Hugo Duarte Da Silva
*/
public class CidadeDAOImplArq implements CidadeDAO {
    
    String nome_do_arquivo = "Cidade.dat";
    List<Cidade> cidadeList = new ArrayList <>();
    
    /** Abre um arquivo e salva a cidadeList nele
     *
     *@throws FileNotFoundException
     *@throws IOException
     */
    private void salvarArquivo(){
        try {
            ObjectOutputStream in;
            in = new ObjectOutputStream(new FileOutputStream(nome_do_arquivo));
            in.writeObject(cidadeList);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CidadeDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CidadeDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** Abre um arquivo e copia todos os objetos salvo nele para a lista cidadeList
     *
     *@throws IOException
     *@throws ClassNotFoundException
     */
    private void lerArquivo(){
        try {
            ObjectInputStream out;
            out = new ObjectInputStream(new FileInputStream(nome_do_arquivo));
            cidadeList = (List<Cidade>) out.readObject();
            out.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(CidadeDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void salvar(Cidade cidade) {
        boolean existe=false;
        lerArquivo();
        for(int i=0; i<cidadeList.size();i++){
            if (cidadeList.get(i).getId()==cidade.getId()){
                existe = true;
            }
        }
        if (!existe){
            cidadeList.add(cidade);
            salvarArquivo();
        } else {
            System.out.println("Não foi possivel salvar, objeto já existia!");
        }
    }

    @Override
    public void editar(Cidade cidade) {
        lerArquivo();
        for(int i=0; i<cidadeList.size();i++){
            if(cidadeList.get(i).getId()==cidade.getId()){
                cidadeList.set(i, cidade);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean excluir(int id) {
        lerArquivo();
        for (int i=0;i<cidadeList.size();i++) {
            Cidade c = cidadeList.get(i);
            if(c.getId()==id){
                cidadeList.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Cidade procurar_por_id(int id) {
        lerArquivo();
        for(int i=0; i<cidadeList.size();i++){
            if(cidadeList.get(i).getId()==id){
                return cidadeList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Cidade> lista_do_banco() {
       lerArquivo();
       return cidadeList;
    }
    
    @Override
    public int id_disponivel(){
        lerArquivo();
        if(cidadeList.isEmpty()){
            return 1;
        }
        
        int idmax=1;
        lerArquivo();
        for (Cidade c : cidadeList) {
            if(c.getId()>idmax){
                idmax=c.getId();
            }
        }
        return idmax+1;
    }
    
}
