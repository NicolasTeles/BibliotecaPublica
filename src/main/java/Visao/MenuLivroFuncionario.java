package Visao;

import Controle.ControleMenuLivroFuncionario;
import Modelo.Session;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author pichau
 */
public class MenuLivroFuncionario extends javax.swing.JFrame {

    private final ControleMenuLivroFuncionario controlador;   
    
    /**
     * Creates new form MenuLivroFuncionario
     */
    public MenuLivroFuncionario() {
        initComponents();
        controlador = new ControleMenuLivroFuncionario();
        this.controlador.inicia((DefaultTableModel)this.getListaLivros().getModel());
        if(Session.getFuncionario() == null){
            JOptionPane.showMessageDialog(null, "Funcionario deve estar logado para acessar esta tela!");
            this.controlador.irInterfaceGeral();
            java.awt.EventQueue.invokeLater(() -> this.dispose());
        }
        if(Session.getFuncionario().getEadm() == false){
            Funcionarios.setVisible(false);
        }
    }

    public void setListaLivros(JTable listaLivros) {
        this.listaLivros = listaLivros;
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
        adicionarLivros = new javax.swing.JButton();
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

        listaLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", "", null, null},
                {null, null, "", "", null, null},
                {null, null, "", "", null, null}
            },
            new String [] {
                "Nome", "Editora", "Autor(a)", "Ano", "Avaliação", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        adicionarLivros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adicionarLivros.setText("Adicionar Livro");
        adicionarLivros.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        adicionarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarLivrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelPesquisa)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoPesquisa))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(adicionarLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(adicionarLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        menuConta.setText("Conta");

        botaoPerfil.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\perfil.png"));
        botaoPerfil.setText("Perfil");
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
        Funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FuncionariosMouseClicked(evt);
            }
        });
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPerfilActionPerformed
        this.controlador.irPerfilFuncionario();
        this.dispose();
    }//GEN-LAST:event_botaoPerfilActionPerformed

    public JTable getListaLivros() {
        return listaLivros;
    }
    
    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        this.controlador.pesquisaLivro(this.getFieldPesquisa().getText().toLowerCase(),(DefaultTableModel)this.getListaLivros().getModel());
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void adicionarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarLivrosActionPerformed
        this.controlador.telaCadastroLivro();
        this.dispose();
    }//GEN-LAST:event_adicionarLivrosActionPerformed

    private void botaoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogoutMouseClicked
        this.controlador.logoutFuncionario();
        this.controlador.irInterfaceGeral();
        this.dispose();
    }//GEN-LAST:event_botaoLogoutMouseClicked

    private void menuLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLivrosMouseClicked
        
    }//GEN-LAST:event_menuLivrosMouseClicked

    private void menuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseClicked
        this.controlador.irMenuCliente();
        this.dispose();
    }//GEN-LAST:event_menuClientesMouseClicked

    private void FuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FuncionariosMouseClicked
        this.controlador.irMenuFuncionarios();
        this.dispose();
    }//GEN-LAST:event_FuncionariosMouseClicked

    private void listaLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaLivrosMouseClicked
        if(evt.getClickCount() > 1){
           this.controlador.acessaLivro(this.listaLivros.getSelectedRow(), (DefaultTableModel)this.getListaLivros().getModel());
        }
    }//GEN-LAST:event_listaLivrosMouseClicked

    private void fieldPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPesquisaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuLivroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuLivroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuLivroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuLivroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuLivroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Funcionarios;
    private javax.swing.JButton adicionarLivros;
    private javax.swing.JMenuItem botaoLogout;
    private javax.swing.JMenuItem botaoPerfil;
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPesquisa;
    private javax.swing.JTable listaLivros;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuConta;
    private javax.swing.JMenu menuLivros;
    // End of variables declaration//GEN-END:variables
}
