package projeto.de.verificação.de.voos.Persistencia.Arquivo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
    ArrayList<Voo> vooList = new ArrayList <>();
    
    /** Abre um arquivo e salva a vooList nele
     *
     *@throws FileNotFoundException
     *@throws IOException
     */
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
    
    /** Abre um arquivo e copia todos os objetos salvo nele para a lista vooList
     *
     *@throws IOException
     *@throws ClassNotFoundException
     */
    private void lerArquivo(){
        try {
            ObjectInputStream out;
            out = new ObjectInputStream(new FileInputStream(nome_do_arquivo));
            vooList = (ArrayList<Voo>) out.readObject();
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
            vooList = addVooEmOrdem(voo,vooList);
            salvarArquivo();
        } else {
            System.out.println("Não foi possivel salvar, objeto já existia!");
        }    
    }

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
    public ArrayList<Voo> lista_do_banco() {
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
    /**Recebe uma Voo e uma ArrayList para incluir esse voo na posição correta desta lista. Essa posição tem como chave os ids dos Aviões associados a esses Voos, depois, é considerado a data dos voos para inserir o Voo na ArrayList. 
     *
     * @return ArrayList&ltVoo&gt
     * @param v
     * @param lista
     */
    private ArrayList<Voo> addVooEmOrdem(Voo v,ArrayList<Voo> lista){
        Voo atual = new Voo();
        
        if(lista.isEmpty()){ //verifica se a lista está vazia
            lista.add(v);
            return lista;
        }
        for(int i=0;i<lista.size();i++){
            atual = lista.get(i);
            if(atual.getAviao().getId()>v.getAviao().getId()){ //Verifica se o Id do avião atual da lsita é maior(>) que o id do avião de v
                lista.add(i, v);
                break;
            } else {
                if(atual.getAviao().getId()<v.getAviao().getId()){  //Verifica se o Id do avião atual da lsita é menor(<) que o id do avião de v
                    if(i==lista.size()-1){  //Verefica se está no final da lista
                        lista.add(v);
                        break;
                    }
                } else{
                    if(atual.getAviao().getId()==v.getAviao().getId()){   //Verifica se o Id do avião atual da lsita é igual(==) ao id do avião de v
                        if(i==0){
                            if(i==lista.size()-1){
                                if(atual.getData().after(v.getData())){
                                  lista.add(i, v);
                                  break;
                              } else {
                                  if(i==lista.size()-1){ //Verefica se a lista possui somente 1 elemento
                                      lista.add(v);
                                      break;
                                  }
                              }  
                            } else {
                                if(atual.getData().after(v.getData())){
                                    lista.add(i, v);
                                    break; 
                                }
                            }
                            
                        } else {
                            if(i==lista.size()-1 ){  //Verefica se está no final da lista
                                if(v.getData().after(atual.getData())){
                                    lista.add(v);
                                    break;
                                } else {
                                    lista.add(i, v);
                                    break;
                                }
                            } else {
                                Voo proximo = new Voo();
                                proximo= lista.get(i+1);
                                if(proximo.getAviao().getId()==v.getAviao().getId()){ //Verifica se o Id do proximo avião da lsita é igual(==) ao id do avião de v
                                    if(atual.getData().before(v.getData()) & v.getData().before(proximo.getData())){
                                       lista.add(i+1, v);
                                       break;
                                   } else {
                                       if(atual.getData().after(v.getData()) & proximo.getData().after(v.getData())){
                                           lista.add(i,v);
                                           break;
                                       }
                                   }   
                                } else {
                                    if(atual.getData().after(v.getData())){
                                        lista.add(i, v);
                                        break;
                                    } else {
                                        lista.add(i+1, v);
                                        break;
                                    }
                                }
                        }
                        }
                        
                    }
                }
                
            }
            
        }
        return lista;
    }
    @Override
    public boolean verificarValidade(Voo v){
        Voo prox = new Voo();
        Voo ant = new Voo();
        lerArquivo();
        vooList = addVooEmOrdem(v,vooList);
        int i= vooList.indexOf(v);
        if(i==0){
            if(vooList.size()==1){
                return true;
            } else {
                prox = vooList.get(i+1);
                if(prox.getAviao().getId()!=v.getAviao().getId()){
                    return true;
                } else {
                    if(v.getCidade_desembarque().getId()!=prox.getCidade_embarque().getId()){
                        return false;
                    } else{
                        Calendar data_v = new GregorianCalendar();
                        data_v=  (Calendar)v.getData().clone();
                        data_v.add(Calendar.HOUR_OF_DAY, v.getDuracao());
                        return !data_v.after(prox.getData());
                    }
                }
            } 
        } else {
            if (i==vooList.size()-1){
                ant = vooList.get(i-1);
                if(ant.getAviao().getId()!=v.getAviao().getId()){
                    return true;
                } else {
                    if(ant.getCidade_desembarque().getId()!=v.getCidade_embarque().getId()){
                        return false;
                    } else {
                        Calendar data_ant = new GregorianCalendar();
                        data_ant= (Calendar)ant.getData().clone();
                        data_ant.add(Calendar.HOUR_OF_DAY, ant.getDuracao());
                        return !data_ant.after(v.getData());
                    }
                        
                }
            } else {
                ant = vooList.get(i-1);
                prox = vooList.get(i+1);
                if(ant.getAviao().getId()==v.getAviao().getId() & v.getAviao().getId()!=prox.getAviao().getId()){
                    if(ant.getCidade_desembarque().getId()!=v.getCidade_embarque().getId()){
                        System.out.println("s");return false;
                    } else {
                        Calendar data_ant = new GregorianCalendar();
                        data_ant= (Calendar)ant.getData().clone();
                        data_ant.add(Calendar.HOUR_OF_DAY, ant.getDuracao());
                        return !data_ant.after(v.getData());
                    }
                } else {
                    if(ant.getAviao().getId()!= v.getAviao().getId() & v.getAviao().getId() == prox.getAviao().getId()){
                        if(v.getCidade_desembarque().getId()!=prox.getCidade_embarque().getId()){
                            return false;
                            
                        } else {
                            
                            Calendar data_v = new GregorianCalendar();
                            data_v=  (Calendar)v.getData().clone();
                            data_v.add(Calendar.HOUR_OF_DAY, v.getDuracao());
                            return !data_v.after(prox.getData());
                        }
                    }
                } return !(ant.getAviao().getId()==v.getAviao().getId() & v.getAviao().getId()==prox.getAviao().getId());
            }
        }
    }
}

