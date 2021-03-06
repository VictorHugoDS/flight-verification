/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.de.verificação.de.voos.Telas;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projeto.de.verificação.de.voos.Entidades.Aviao;
import projeto.de.verificação.de.voos.Entidades.Cidade;
import projeto.de.verificação.de.voos.Entidades.Voo;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.AviaoDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.CidadeDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.Arquivo.VooDAOImplArq;
import projeto.de.verificação.de.voos.Persistencia.AviaoDAO;
import projeto.de.verificação.de.voos.Persistencia.CidadeDAO;
import projeto.de.verificação.de.voos.Persistencia.VooDAO;

/**
 *
 * @author rener
 */
public class JFramePrincipal extends javax.swing.JFrame {
    /**
     * Creates new form JFramePrincipal
     */
    public JFramePrincipal() {
        initComponents();
        carregarTabelaAviao();
        carregarTabelaCidadeEm();
        carregarTabelaCidadeDes();
        carregarTabelaVoo();
        
    }
    private AviaoDAO aviaoBanco = new AviaoDAOImplArq();
    private VooDAO vooBanco = new VooDAOImplArq();
    private CidadeDAO cidadeBanco = new CidadeDAOImplArq();
    private int id=0; //utilizado para editar voos

    /**Método que carrega a tabela de Voos
     *
     * 
     */
    private void carregarTabelaVoo(){
        List<Voo> lista = vooBanco.lista_do_banco();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTable.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (int i=0;i<lista.size();i++){
            Voo voo = lista.get(i);
            Object[] linha = new Object[9];
            linha[0] = voo.getId();
            linha[1] = voo.getAviao().getId();
            linha[2] = voo.getCidade_embarque().getId();
            linha[3] = voo.getCidade_desembarque().getId();
            linha[4] = voo.getCidade_embarque().getNome();
            linha[5] = voo.getCidade_desembarque().getNome();
            linha[6] = voo.getData().get(Calendar.DAY_OF_MONTH) + "/" + (voo.getData().get(Calendar.MONTH)+1) + "/" + voo.getData().get(Calendar.YEAR);
            linha[7] = voo.getData().get(Calendar.HOUR_OF_DAY) + ":" + voo.getData().get(Calendar.MINUTE);
            linha[8] = voo.getDuracao();
            modeloTabela.addRow(linha);
        }
    }
    /**Método que carrega a tabela de Aviões
     *
     * 
     */
    private void carregarTabelaAviao(){
        List<Aviao> lista = aviaoBanco.lista_do_banco();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableAvioes.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (int i=0;i<lista.size();i++){
            Aviao aviao = lista.get(i);
            Object[] linha = new Object[3];
            linha[0] = aviao.getId();
            linha[1] = aviao.getNome();
            modeloTabela.addRow(linha);
        }
    }
    /**Método que carrega a tabela de Cidades de Embarque
     *
     * 
     */
    private void carregarTabelaCidadeEm(){
        List<Cidade> lista = cidadeBanco.lista_do_banco();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableCidadeEm.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (int i=0;i<lista.size();i++){
            Cidade cidade = lista.get(i);
            Object[] linha = new Object[3];
            linha[0] = cidade.getId();
            linha[1] = cidade.getNome();
            modeloTabela.addRow(linha);
        }
    }
    /**Método que carrega a tabela de Cidades de Desembarque
     *
     * 
     */
    private void carregarTabelaCidadeDes(){
        List<Cidade> lista = cidadeBanco.lista_do_banco();
        DefaultTableModel modeloTabela = (DefaultTableModel) jTableCidadeDes.getModel();
        int qntLinhas = modeloTabela.getRowCount();
        
        
        for (int i = 0; i < qntLinhas; i++) {
            modeloTabela.removeRow(0);
        }
        for (int i=0;i<lista.size();i++){
            Cidade cidade = lista.get(i);
            Object[] linha = new Object[3];
            linha[0] = cidade.getId();
            linha[1] = cidade.getNome();
            modeloTabela.addRow(linha);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTableAvioes = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableCidadeEm = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCidadeDes = new javax.swing.JTable();
        jLabelAvioes = new javax.swing.JLabel();
        jLabelCidadeEm = new javax.swing.JLabel();
        jLabelCidadeDes = new javax.swing.JLabel();
        jTextFieldAno = new javax.swing.JTextField();
        jButtonEditAvioes = new javax.swing.JButton();
        jTextFieldHora = new javax.swing.JTextField();
        jButtonEditCidade = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMinuto = new javax.swing.JTextField();
        jButtonAtualizar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jTextFieldDia = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        jLabelDuracao = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jTextFieldDuracao = new javax.swing.JTextField();
        jButtonExcluir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAvioes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAvioes.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableAvioes);
        if (jTableAvioes.getColumnModel().getColumnCount() > 0) {
            jTableAvioes.getColumnModel().getColumn(0).setResizable(false);
            jTableAvioes.getColumnModel().getColumn(1).setResizable(false);
        }

        jTableCidadeEm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCidadeEm.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableCidadeEm);
        if (jTableCidadeEm.getColumnModel().getColumnCount() > 0) {
            jTableCidadeEm.getColumnModel().getColumn(0).setResizable(false);
            jTableCidadeEm.getColumnModel().getColumn(1).setResizable(false);
        }

        jTableCidadeDes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTableCidadeDes);
        if (jTableCidadeDes.getColumnModel().getColumnCount() > 0) {
            jTableCidadeDes.getColumnModel().getColumn(0).setResizable(false);
            jTableCidadeDes.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabelAvioes.setText("Selecione um Avião");

        jLabelCidadeEm.setText("Selecione uma cidade de Embarque:");

        jLabelCidadeDes.setText("Selecione a cidade de desembarque:");

        jButtonEditAvioes.setText("Editar Aviões");
        jButtonEditAvioes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditAvioesActionPerformed(evt);
            }
        });

        jButtonEditCidade.setText("Editar Cidades");
        jButtonEditCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditCidadeActionPerformed(evt);
            }
        });

        jLabel5.setText(":");

        jLabelData.setText("Dia:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText(" Voos ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonAtualizar.setText("Atualizar listas");
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar Campos");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Voo", "Id Avião", "Id Embarque", "Nome Embarque", "Id Desembarque", "Nome Desembarque", "Data", "Hora", "Duração"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(5).setResizable(false);
            jTable.getColumnModel().getColumn(6).setResizable(false);
            jTable.getColumnModel().getColumn(7).setResizable(false);
            jTable.getColumnModel().getColumn(8).setResizable(false);
        }

        jLabel1.setText("Informações sobre o Voo:");

        jLabel3.setText("Mês:");

        jLabel4.setText("Ano:");

        jLabelHorario.setText("Horário");

        jLabelDuracao.setText("Duração (em horas):");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTextFieldDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDuracaoActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(471, 471, 471)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabelAvioes)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabelCidadeEm)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelCidadeDes)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(126, 126, 126)
                                                    .addComponent(jLabelHorario)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel5))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(49, 49, 49)
                                                    .addComponent(jLabelData)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jTextFieldMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(131, 131, 131)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jLabel1)
                                                    .addGap(61, 61, 61))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jButtonSalvar)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jButtonLimpar)
                                                    .addGap(8, 8, 8))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(jButtonEditar)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jButtonExcluir)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabelDuracao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(70, 70, 70))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jButtonEditAvioes)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditCidade)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAtualizar)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabelAvioes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelCidadeDes)
                                    .addComponent(jLabelCidadeEm))
                                .addGap(9, 9, 9)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelData)
                            .addComponent(jTextFieldDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHorario)
                            .addComponent(jTextFieldHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDuracao)
                            .addComponent(jTextFieldDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSalvar)
                            .addComponent(jButtonLimpar))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEditAvioes)
                            .addComponent(jButtonAtualizar)
                            .addComponent(jButtonEditCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonExcluir)
                            .addComponent(jButtonEditar))
                        .addGap(17, 17, 17)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**Abre o Jpanel de Aviões
     *
     * @param evt
     */
    private void jButtonEditAvioesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditAvioesActionPerformed
        JFrame x  = new JFrame();
        x.add(new JPanelAviao());
        x.setSize(500,500);
        x.setVisible(false);
        x.setVisible(true);
    }//GEN-LAST:event_jButtonEditAvioesActionPerformed

     /**Abre o Jpanel de Cidades
     *
     * @param evt
     */
    private void jButtonEditCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditCidadeActionPerformed
        JFrame x  = new JFrame();
        x.add(new JPanelCidades());
        x.setSize(500,500);
        x.setVisible(false);
        x.setVisible(true);
    }//GEN-LAST:event_jButtonEditCidadeActionPerformed

    /**Atualiza as tabelas
     *
     * @param evt
     */
    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        carregarTabelaAviao();
        carregarTabelaCidadeEm();
        carregarTabelaCidadeDes();
        carregarTabelaVoo();
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    /**Através da seleção do Avião, da Cidade de embarque e desembarque nas suas respectivas tabelas e da aquisição das demais informações nos seus respectivos JTextField, tenta realizar o Salvamento de um Voo. 
     * Se alguma Tabela não for selecionada, ele exibirá uma mensagem de erro informando que alguma tabela não foi selecionada.
     * Se algum campo não for preenchido, ele exibirá uma mensagem de erro informando que algum campo não selecionado.
     * Além disso, ao tentar salvar, ele irá verificar se esse salvamento é válido ou não baseado na definição de voos válidos. Se não for verificado que o voo é valido, ele exibirá uma tela informando que o voo não é válido.
     * Por fim, se o método jButtonEditarActionPerformed tiver sido selecionado antes, ele tentará realizar uma edição ao invés de um salvamento.
     *
     * @param evt
     */
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Voo v = new Voo();
        int id_da_tabela,linhaA,linhaCE,linhaCD;
        
        linhaA = jTableAvioes.getSelectedRow();
        if( linhaA!=-1){
          id_da_tabela = (int)jTableAvioes.getValueAt(linhaA, 0);
          v.setAviao(aviaoBanco.procurar_por_id(id_da_tabela));
        }
        linhaCE = jTableCidadeEm.getSelectedRow();
        if (linhaCE!=-1){
            id_da_tabela = (int)jTableCidadeEm.getValueAt(linhaCE, 0);
            v.setCidade_embarque(cidadeBanco.procurar_por_id(id_da_tabela));
        }
        linhaCD = jTableCidadeDes.getSelectedRow();
        if (linhaCD!=-1){
            id_da_tabela = (int)jTableCidadeDes.getValueAt(linhaCD, 0);
            v.setCidade_desembarque(cidadeBanco.procurar_por_id(id_da_tabela));
        }
        try{
            int minuto = Integer.parseInt(jTextFieldMinuto.getText());
            int hora = Integer.parseInt(jTextFieldHora.getText());
            int dia = Integer.parseInt(jTextFieldDia.getText());
            int mes = Integer.parseInt(jTextFieldMes.getText())-1;
            int ano = Integer.parseInt(jTextFieldAno.getText());

            Calendar c = new GregorianCalendar(ano,mes,dia,hora,minuto,0);
            v.setData(c);
            int duracao = Integer.parseInt(jTextFieldDuracao.getText());
            v.setDuracao(duracao);

            if ((linhaA & linhaCE & linhaCD) != -1 ){
                //System.out.println(v.getId());
                if(id!=0){
                    v.setId(id);
                    Voo backup = vooBanco.procurar_por_id(id);
                    vooBanco.excluir(id);
                    if(!vooBanco.verificarValidade(v)){
                            String mensagem = "Voo inválido, verefique se o avião: " +v.getAviao().getNome()+ " de id: "+v.getAviao().getId()+" está de acordo com as regras de cadastro de um novo voo ";
                            JOptionPane.showMessageDialog(null, mensagem, "Erro ao salvar!", JOptionPane.ERROR_MESSAGE);
                            vooBanco.salvar(backup);
                        } else {
                            vooBanco.salvar(v);  
                            jButtonLimparActionPerformed( evt);
                        }
                    id=0;
                } else{
                    if(v.getAviao()!=null & v.getCidade_desembarque()!=null & v.getCidade_embarque()!=null){
                        if(!vooBanco.verificarValidade(v)){
                            String mensagem = "Voo inválido, verefique se o Avião: " +v.getAviao().getNome()+ " de Id: "+v.getAviao().getId()+" está de acordo com as regras de cadastro de um novo voo ";
                            JOptionPane.showMessageDialog(null, mensagem, "Erro ao salvar!", JOptionPane.ERROR_MESSAGE);
                        } else {
                            vooBanco.salvar(v);  
                            jButtonLimparActionPerformed( evt);
                        }



                    } else {
                        JOptionPane.showMessageDialog(null, "Alguma tabela não foi selecionada", "Erro ao salvar!", JOptionPane.ERROR_MESSAGE);

                    }
                }
            }
        } catch (java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Algum Campo não foi preenchido devidamente", "Erro ao salvar!", JOptionPane.ERROR_MESSAGE);
        }
        
        carregarTabelaVoo();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jTextFieldDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDuracaoActionPerformed

    /**Limpa todos os campos do JFrame, retornando eles aos seus respectivos estágios iniciais. Se o método jButtonEditarActionPerformed tiver sido selecionado antes, ele o reseta.
     *
     * @param evt
     */
    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldAno.setText("");
        jTextFieldDia.setText("");
        jTextFieldDuracao.setText("");
        jTextFieldHora.setText("");
        jTextFieldMes.setText("");
        jTextFieldMinuto.setText("");
        jTableAvioes.clearSelection();
        jTableCidadeEm.clearSelection();
        jTableCidadeDes.clearSelection();
        id=0;
    }//GEN-LAST:event_jButtonLimparActionPerformed

    /**Exclui um determinado elemento do Banco de dados com base em qual elemento está selecionado na tabela de Voos
     *
     * @param evt
     */
    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int[] linha = jTable.getSelectedRows();
        for (int pos: linha) {
            int id = (int) jTable.getValueAt(pos, 0);
            vooBanco.excluir(id);
        }
        carregarTabelaVoo();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    /**Adquire do banco as informações relacionada ao objeto selecionado na tabela de Voos e os coloca em seus respectivos JTextField e JTables.Além disso, altera a varial id para o devido salvamento.
     *
     * @param evt
     */
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        Voo v= new Voo();
        int linha= jTable.getSelectedRow(); //Pega o id da linha selecionada na tabela de voos
        int id; 
        if (linha!=-1){
            id =(int) jTable.getValueAt(linha, 0); //id do voo
            
            for(int i=0;i<jTableAvioes.getRowCount();i++){ //Procura na tabla de aviões o avião com id igual ao do voo selecionada
                int idA = (int)jTableAvioes.getValueAt(i, 0);
                if(vooBanco.procurar_por_id(id).getAviao().getId()==idA){
                    linha = i; //A variavel linha é reutilizada para armazenar a posição que o avião está na tabela de aviões
                    break;
                }
            }
            jTableAvioes.setRowSelectionInterval(linha, linha); //Seleciona o`Voo correto na tabela de aviões
           
            for(int i=0;i<jTableCidadeEm.getRowCount();i++){ //Procura na tabla de cidades de embarque a cidade com id igual ao do voo selecionada
                int idE = (int)jTableCidadeEm.getValueAt(i, 0);
                if(vooBanco.procurar_por_id(id).getCidade_embarque().getId()==idE){
                    linha = i; //A variavel linha é reutilizada para armazenar a posição que a cidade está na tabela de cidade de embarque
                    break;
                }
            }
            jTableCidadeEm.setRowSelectionInterval(linha, linha);
            
            for(int i=0;i<jTableCidadeDes.getRowCount();i++){ //Procura na tabla de cidade de desembarque a cidade com id igual ao do voo selecionada
                int idD = (int)jTableCidadeDes.getValueAt(i, 0);
                if(vooBanco.procurar_por_id(id).getCidade_desembarque().getId()==idD){
                    linha = i; //A variavel linha é reutilizada para armazenar a posição que a cidade está na tabela de cidade de desembarque
                    break;
                }
            }
            jTableCidadeDes.setRowSelectionInterval(linha, linha);
            jTextFieldAno.setText(""+vooBanco.procurar_por_id(id).getData().get(Calendar.YEAR));
            jTextFieldMes.setText(""+(vooBanco.procurar_por_id(id).getData().get(Calendar.MONTH)+1));
            jTextFieldDia.setText(""+vooBanco.procurar_por_id(id).getData().get(Calendar.DAY_OF_MONTH));
            jTextFieldHora.setText(""+vooBanco.procurar_por_id(id).getData().get(Calendar.HOUR_OF_DAY));
            jTextFieldMinuto.setText(""+vooBanco.procurar_por_id(id).getData().get(Calendar.MINUTE));
            jTextFieldDuracao.setText(""+vooBanco.procurar_por_id(id).getDuracao());
            this.id=id;
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonEditAvioes;
    private javax.swing.JButton jButtonEditCidade;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAvioes;
    private javax.swing.JLabel jLabelCidadeDes;
    private javax.swing.JLabel jLabelCidadeEm;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelDuracao;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTableAvioes;
    private javax.swing.JTable jTableCidadeDes;
    private javax.swing.JTable jTableCidadeEm;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldDia;
    private javax.swing.JTextField jTextFieldDuracao;
    private javax.swing.JTextField jTextFieldHora;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldMinuto;
    // End of variables declaration//GEN-END:variables
}
