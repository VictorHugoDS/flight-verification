
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
import projeto.de.verificação.de.voos.Entidades.Aviao;
import projeto.de.verificação.de.voos.Persistencia.AviaoDAO;

/**Classe responsavel por salvar,editar,excluir e consultar uma lista de objetos da classe Avião em um arquivo.
* @author Victor Hugo Duarte Da Silva
*/

public class AviaoDAOImplArq implements AviaoDAO {
    
    String nome_do_arquivo = "Aviao.dat";
    List<Aviao> aviaoList = new ArrayList <>();

    
    private void salvarArquivo(){
        try {
            ObjectOutputStream in;
            in = new ObjectOutputStream(new FileOutputStream(nome_do_arquivo));
            in.writeObject(aviaoList);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AviaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AviaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArquivo(){
        try {
            ObjectInputStream out;
            out = new ObjectInputStream(new FileInputStream(nome_do_arquivo));
            aviaoList = (List<Aviao>) out.readObject();
            out.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AviaoDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void salvar(Aviao aviao) {
        boolean existe=false;
        lerArquivo();
        for(int i=0; i<aviaoList.size();i++){
            if (aviaoList.get(i).getId()==aviao.getId()){
                existe = true;
            }
        }
        if (!existe){
            aviaoList.add(aviao);
            salvarArquivo();
        } else {
            System.out.println("Não foi possivel salvar, objeto já existia!");
        }
    }

    @Override
    public void editar(Aviao aviao) {
        lerArquivo();
        for(int i=0; i<aviaoList.size();i++){
            if(aviaoList.get(i).getId()==aviao.getId()){
                aviaoList.set(i, aviao);
                salvarArquivo();
                break;
            }
        }
    }

    @Override
    public boolean excluir(int id) {
        lerArquivo();
        for (int i=0;i<aviaoList.size();i++) {
            Aviao c = aviaoList.get(i);
            if(c.getId()==id){
                aviaoList.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Aviao procurar_por_id(int id) {
        lerArquivo();
        for(int i=0; i<aviaoList.size();i++){
            if(aviaoList.get(i).getId()==id){
                return aviaoList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Aviao> lista_do_banco() {
        lerArquivo();
        return aviaoList;
    }
    
    @Override
    public int id_disponivel(){
        lerArquivo();
        if(aviaoList.isEmpty()){
            return 1;
        }
        
        int idmax=1;
        lerArquivo();
        for (Aviao a : aviaoList) {
            if(a.getId()>idmax){
                idmax=a.getId();
            }
        }
        return idmax+1;    
    }
}
