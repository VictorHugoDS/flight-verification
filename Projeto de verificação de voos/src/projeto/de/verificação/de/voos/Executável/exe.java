/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.verificação.de.voos.Executável;

import java.util.ArrayList;
import projeto.de.verificação.de.voos.Entidades.Aviao;
import projeto.de.verificação.de.voos.Entidades.Cidade;
import projeto.de.verificação.de.voos.Entidades.Voo;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.AviaoDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.CidadeDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.VooDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.AviaoDAO;
import projeto.de.verificação.de.voos.Persistencia.CidadeDAO;
import projeto.de.verificação.de.voos.Persistencia.VooDAO;
import projeto.de.verificação.de.voos.Telas.JFramePrincipal;

/**Classe executável utilizada para testes.
* @author Victor Hugo Duarte Da Silva
*/
public class exe {
    public static void main(String[] args) {
        //JFramePrincipal tela = new JFramePrincipal();
        //tela.setVisible(true);
        ArrayList<Voo> lista = new ArrayList<>();
        VooDAO banco= new VooDAOImplArq();
        
        /*Voo v1 =new Voo();
        Voo v2 =new Voo();
        Aviao a1 = new Aviao();
        Aviao a2 = new Aviao();
        
        a1.setId(5);
        a2.setId(1);
        v1.setId(0);
        v2.setId(1);
        v1.setAviao(a1);
        v2.setAviao(a2);
        lista.add(v1);
        lista = v2.addVooEmOrdem(v2, lista);
        System.out.println(v1.getId() + "/" +v2.getId());
        System.out.println(lista.get(0).getId() + "/" +lista.get(1).getId());*/
        
   }
}
