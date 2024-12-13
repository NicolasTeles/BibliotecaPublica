package Visao;

import Controle.ControleMenuFuncionariosAdm;
import Modelo.Session;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pichau
 */
public class MenuFuncionariosAdm extends javax.swing.JFrame {

    private final ControleMenuFuncionariosAdm controlador;
   
    /**
     * Creates new form MenuLivroFuncionario
     */
    public MenuFuncionariosAdm() {
        initComponents();
        controlador = new ControleMenuFuncionariosAdm();
        this.controlador.inicia((DefaultTableModel)this.getListaFuncionarios().getModel());
        if(Session.getFuncionario().getEadm() == false){
            JOptionPane.showMessageDialog(null, "Voce deve ser um administrador para entrar nessa tela!");
            controlador.irInterfaceGeral();
            java.awt.EventQueue.invokeLater(() -> this.dispose());
        }
    }

    public JTable getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(JTable listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
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
        listaFuncionarios = new javax.swing.JTable();
        fieldPesquisa = new javax.swing.JTextField();
        labelPesquisa = new javax.swing.JLabel();
        botaoPesquisa = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuConta = new javax.swing.JMenu();
        botaoPerfil = new javax.swing.JMenuItem();
        botaoLogout = new javax.swing.JMenuItem();
        menuLivros = new javax.swing.JMenu();
        menuClientes = new javax.swing.JMenu();
        Funcionarios = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane2.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        listaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", null},
                {null, null, "", null},
                {null, null, "", null}
            },
            new String [] {
                "Nome", "Login", "CPF", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaFuncionarios);

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

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Adicionar Funcionário");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoPesquisa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPesquisa)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 22, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisa))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuConta.setText("Conta");

        botaoPerfil.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\perfil.png"));
        botaoPerfil.setText("Perfil");
        botaoPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoPerfilMouseClicked(evt);
            }
        });
        botaoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPerfilActionPerformed(evt);
            }
        });
        menuConta.add(botaoPerfil);

        botaoLogout.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\logout.png"));
        botaoLogout.setText("Logout");
        botaoLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLogoutMouseClicked(evt);
            }
        });
        menuConta.add(botaoLogout);

        jMenuBar1.add(menuConta);

        menuLivros.setText("Livros");
        menuLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuLivrosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuLivros);

        menuClientes.setText("Clientes");
        menuClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuClientesMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuClientes);

        Funcionarios.setText("Funcionarios");
        jMenuBar1.add(Funcionarios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPerfilActionPerformed
        controlador.irPerfilFuncionario();
        this.dispose();
    }//GEN-LAST:event_botaoPerfilActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controlador.telaCadastroFuncionario();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        controlador.pesquisaFuncionario(this.getFieldPesquisa().getText().toLowerCase(), (DefaultTableModel)this.getListaFuncionarios().getModel());
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void botaoPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPerfilMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPerfilMouseClicked

    private void botaoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogoutMouseClicked
        controlador.logoutFuncionario();
        controlador.irInterfaceGeral();
        this.dispose();
    }//GEN-LAST:event_botaoLogoutMouseClicked

    private void menuLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLivrosMouseClicked
        controlador.irMenuLivro();
        this.dispose();
    }//GEN-LAST:event_menuLivrosMouseClicked

    private void menuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseClicked
        controlador.irMenuCliente();
        this.dispose();
    }//GEN-LAST:event_menuClientesMouseClicked

    private void listaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaFuncionariosMouseClicked
        if(evt.getClickCount()>1){
            this.dispose();
            this.controlador.acessaFuncionario(this.listaFuncionarios.getSelectedRow(), (DefaultTableModel)this.getListaFuncionarios().getModel());
        }
    }//GEN-LAST:event_listaFuncionariosMouseClicked

    private void fieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPesquisaActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // rtedsfa
    }//GEN-LAST:event_jScrollPane2MouseClicked

    public JTextField getFieldPesquisa() {
        return fieldPesquisa;
    }

    public void setFieldPesquisa(JTextField fieldPesquisa) {
        this.fieldPesquisa = fieldPesquisa;
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
            java.util.logging.Logger.getLogger(MenuFuncionariosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFuncionariosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFuncionariosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFuncionariosAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFuncionariosAdm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Funcionarios;
    private javax.swing.JMenuItem botaoLogout;
    private javax.swing.JMenuItem botaoPerfil;
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPesquisa;
    private javax.swing.JTable listaFuncionarios;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuConta;
    private javax.swing.JMenu menuLivros;
    // End of variables declaration//GEN-END:variables
}
