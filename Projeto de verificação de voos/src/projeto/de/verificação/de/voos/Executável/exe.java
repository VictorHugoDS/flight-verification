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

/**Classe executável para iniciar o Jframe principal e para executar alguns testes no sistema.
* @author Victor Hugo Duarte Da Silva
*/
public class exe {
    public static void main(String[] args) {
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
                
            }
        });
        
   }
}
