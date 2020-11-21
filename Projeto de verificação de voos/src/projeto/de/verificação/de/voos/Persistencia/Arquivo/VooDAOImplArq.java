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
import projeto.de.verificação.de.voos.Entidades.Voo;
import projeto.de.verificação.de.voos.Persistencia.VooDAO;

/**Classe responsavel por salvar,editar,excluir e consultar uma lista de objetos da classe Voo em um arquivo.
* @author Victor Hugo Duarte Da Silva
*/

public class VooDAOImplArq implements VooDAO {
    
    String nome_do_arquivo = "Voo.dat";
    List<Voo> vooList = new ArrayList <>();
    
    private void salvarArquivo(){
        try {
            ObjectOutputStream in;
            in = new ObjectOutputStream(new FileOutputStream(nome_do_arquivo));
            in.writeObject(vooList);
            in.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VooDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VooDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void lerArquivo(){
        try {
            ObjectInputStream out;
            out = new ObjectInputStream(new FileInputStream(nome_do_arquivo));
            vooList = (List<Voo>) out.readObject();
            out.close();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(VooDAOImplArq.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void salvar(Voo voo) {
        boolean existe=false;
        lerArquivo();
        for(int i=0; i<vooList.size();i++){
            if (vooList.get(i).getId()==voo.getId()){
                existe = true;
            }
        }
        if (!existe){
            vooList.add(voo);
            salvarArquivo();
        } else {
            System.out.println("Não foi possivel salvar, objeto já existia!");
        }    }

    @Override
    public void editar(Voo voo) {
        lerArquivo();
        for(int i=0; i<vooList.size();i++){
            if(vooList.get(i).getId()==voo.getId()){
                vooList.set(i, voo);
                salvarArquivo();
                break;
            }
        }    }

    @Override
    public boolean excluir(int id) {
        lerArquivo();
        for (int i=0;i<vooList.size();i++) {
            Voo c = vooList.get(i);
            if(c.getId()==id){
                vooList.remove(i);
                salvarArquivo();
                return true;
            }
        }
        return false;
    }

    @Override
    public Voo procurar_por_id(int id) {
        lerArquivo();
        for(int i=0; i<vooList.size();i++){
            if(vooList.get(i).getId()==id){
                return vooList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Voo> lista_do_banco() {
       lerArquivo();
       return vooList;    
    }
    
    @Override
    public int id_disponivel(){
        lerArquivo();
        if(vooList.isEmpty()){
            return 1;
        }
        
        if(vooList.isEmpty()){
            return 1;
        }
        int idmax=1;
        lerArquivo();
        for (Voo v : vooList) {
            if(v.getId()>idmax){
                idmax=v.getId();
            }
        }
        return idmax+1;    
    }
    
}
