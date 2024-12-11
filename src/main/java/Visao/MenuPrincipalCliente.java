/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visao;

import Controle.ControleMenuPrincipalCliente;
import Modelo.Session;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class MenuPrincipalCliente extends javax.swing.JFrame {

    private final ControleMenuPrincipalCliente controlador;

    /**
     * Creates new form MenuPrincipalCliente
     */
    public MenuPrincipalCliente() {
        initComponents();
        controlador = new ControleMenuPrincipalCliente();
        this.controlador.inicia((DefaultTableModel)this.getListaLivros().getModel());
        if(Session.getCliente() == null){
            JOptionPane.showMessageDialog(null, "Cliente deve estar logado para acessar esta tela!");
            InterfaceCliente ic = new InterfaceCliente();
            ic.setVisible(true);
            java.awt.EventQueue.invokeLater(() -> this.dispose());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaLivros = new javax.swing.JTable();
        fieldPesquisa = new javax.swing.JTextField();
        labelPesquisa = new javax.swing.JLabel();
        botaoPesquisa = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuContaCliente = new javax.swing.JMenu();
        perfilMenu = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenuItem();
        menuDevolucao = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        listaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", "", null},
                {null, null, "", "", null},
                {null, null, "", "", null}
            },
            new String [] {
                "Nome", "Editora", "Autor(a)", "Ano", "Avaliação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaLivrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaLivros);
        if (listaLivros.getColumnModel().getColumnCount() > 0) {
            listaLivros.getColumnModel().getColumn(0).setResizable(false);
            listaLivros.getColumnModel().getColumn(1).setResizable(false);
            listaLivros.getColumnModel().getColumn(2).setResizable(false);
            listaLivros.getColumnModel().getColumn(3).setResizable(false);
            listaLivros.getColumnModel().getColumn(4).setResizable(false);
        }

        fieldPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPesquisaActionPerformed(evt);
            }
        });

        labelPesquisa.setText("Pesquisa");

        botaoPesquisa.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\iconePesquisa.png"));
        botaoPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoPesquisaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPesquisa)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisa)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(labelPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addGap(53, 53, 53))
        );

        menuContaCliente.setText("Conta");

        perfilMenu.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\perfil.png"));
        perfilMenu.setText("Perfil");
        perfilMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perfilMenuActionPerformed(evt);
            }
        });
        menuContaCliente.add(perfilMenu);

        logoutMenu.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\logout.png"));
        logoutMenu.setText("Logout");
        logoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuActionPerformed(evt);
            }
        });
        menuContaCliente.add(logoutMenu);

        jMenuBar1.add(menuContaCliente);

        menuDevolucao.setText("Devolução");
        menuDevolucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDevolucaoMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuDevolucao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuActionPerformed
        this.controlador.logout();
        this.dispose();
    }//GEN-LAST:event_logoutMenuActionPerformed

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        this.controlador.pesquisaLivro(this.getFieldPesquisa().getText(), (DefaultTableModel)this.getListaLivros().getModel());
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void perfilMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perfilMenuActionPerformed
        this.controlador.navegaPerfil();
        this.dispose();
    }//GEN-LAST:event_perfilMenuActionPerformed

    private void menuDevolucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDevolucaoMouseClicked
        this.controlador.navegaDevolucao();
        this.dispose();
    }//GEN-LAST:event_menuDevolucaoMouseClicked

    private void listaLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaLivrosMouseClicked
        if(evt.getClickCount() > 1){
            this.controlador.acessaLivro(this.listaLivros.getSelectedRow(), (DefaultTableModel)this.getListaLivros().getModel());
        }
    }//GEN-LAST:event_listaLivrosMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void fieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPesquisaActionPerformed
        
    }//GEN-LAST:event_fieldPesquisaActionPerformed

    public JTextField getFieldPesquisa() {
        return fieldPesquisa;
    }
    
    public JTable getListaLivros() {
        return listaLivros;
    }
    
    public void setListaLivros(JTable listaLivros) {
        this.listaLivros = listaLivros;
    }

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
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPesquisa;
    private javax.swing.JTable listaLivros;
    private javax.swing.JMenuItem logoutMenu;
    private javax.swing.JMenu menuContaCliente;
    private javax.swing.JMenu menuDevolucao;
    private javax.swing.JMenuItem perfilMenu;
    // End of variables declaration//GEN-END:variables
}
