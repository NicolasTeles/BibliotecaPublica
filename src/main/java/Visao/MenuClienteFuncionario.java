package Visao;

import Controle.ControleMenuClienteFuncionario;
import Modelo.Cliente;
import Modelo.Session;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pichau
 */
public class MenuClienteFuncionario extends javax.swing.JFrame {

    private final ControleMenuClienteFuncionario controlador;

    
    public MenuClienteFuncionario() {
        initComponents();
        controlador = new ControleMenuClienteFuncionario();
        this.controlador.inicia( (DefaultTableModel)this.listaClientes.getModel());
        if(Session.getFuncionario() == null){
            JOptionPane.showMessageDialog(null, "Funcionario deve estar logado para acessar esta tela!");
            InterfaceGeral ig = new InterfaceGeral();
            ig.setVisible(true);
            java.awt.EventQueue.invokeLater(() -> this.dispose());
        }
        if(Session.getFuncionario().getEadm() == false){
            Funcionarios.setVisible(false);
        }
    }

    public JTable getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(JTable listaClientes) {
        this.listaClientes = listaClientes;
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
        listaClientes = new javax.swing.JTable();
        fieldPesquisa = new javax.swing.JTextField();
        labelPesquisa = new javax.swing.JLabel();
        botaoPesquisa = new javax.swing.JLabel();
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

        listaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, "", null},
                {null, null, "", null},
                {null, null, "", null}
            },
            new String [] {
                "Nome", "Email", "CPF", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(listaClientes);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPesquisa)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(22, 22, 22))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(fieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botaoPesquisa)
                            .addGap(345, 345, 345)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoPesquisa)
                    .addComponent(fieldPesquisa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPerfilActionPerformed
        MenuPerfilFuncionario perfil = new MenuPerfilFuncionario();
        perfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoPerfilActionPerformed

    private void botaoPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoPesquisaMouseClicked
        this.controlador.pesquisaCliente(this.getFieldPesquisa().getText().toLowerCase(), (DefaultTableModel)this.listaClientes.getModel());
    }//GEN-LAST:event_botaoPesquisaMouseClicked

    private void botaoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogoutMouseClicked
        controlador.logoutFuncionario();
        InterfaceGeral ig = new InterfaceGeral();
        ig.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoLogoutMouseClicked

    private void menuLivrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuLivrosMouseClicked
        MenuLivroFuncionario livro = new MenuLivroFuncionario();
        livro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuLivrosMouseClicked

    private void menuClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientesMouseClicked
        MenuClienteFuncionario cliente = new MenuClienteFuncionario();
        cliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuClientesMouseClicked

    private void FuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FuncionariosMouseClicked
        if(!Session.getFuncionario().getEadm()){
            JOptionPane.showMessageDialog(null, "Você não é ADM");
            return;
        }
        MenuFuncionariosAdm funcionario = new MenuFuncionariosAdm();
       funcionario.setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_FuncionariosMouseClicked

    private void listaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaClientesMouseClicked
        if(evt.getClickCount() > 1){
            this.dispose();
            Cliente cliente = this.controlador.alteraCliente(this.listaClientes.getSelectedRow(), 
                    (DefaultTableModel)this.listaClientes.getModel());
            AlterarEstadoCliente aec = new AlterarEstadoCliente(cliente);
            aec.setVisible(true);
        }
    }//GEN-LAST:event_listaClientesMouseClicked

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
            java.util.logging.Logger.getLogger(MenuClienteFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuClienteFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuClienteFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuClienteFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuClienteFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Funcionarios;
    private javax.swing.JMenuItem botaoLogout;
    private javax.swing.JMenuItem botaoPerfil;
    private javax.swing.JLabel botaoPesquisa;
    private javax.swing.JTextField fieldPesquisa;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelPesquisa;
    private javax.swing.JTable listaClientes;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuConta;
    private javax.swing.JMenu menuLivros;
    // End of variables declaration//GEN-END:variables
}
