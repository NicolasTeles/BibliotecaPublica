package Visao;


import Controle.ControleMenuPerfilFuncionario;
import Modelo.Session;
import javax.swing.JOptionPane;
/**
 *
 * @author pichau
 */
public class MenuPerfilFuncionario extends javax.swing.JFrame {

    private final ControleMenuPerfilFuncionario controlador;

    /**
     * Creates new form MenuPrincipalFuncionario
     */
    public MenuPerfilFuncionario() {
        initComponents();
        controlador = new ControleMenuPerfilFuncionario();
        if(Session.getFuncionario() == null){
            JOptionPane.showMessageDialog(null, "Funcionario deve estar logado para acessar esta tela!");
            InterfaceGeral ig = new InterfaceGeral();
            ig.setVisible(true);
            java.awt.EventQueue.invokeLater(() -> this.dispose());
        }
        if(Session.getFuncionario().getEadm() == false){
            Funcionarios.setVisible(false);
        }
        
        textNome.setText(Session.getFuncionario().getNome());
        textCPF.setText(Session.getFuncionario().getCpf());
        textEmail.setText(Session.getFuncionario().getLogin());
        if(Session.getFuncionario().getEadm()){
            textStatus.setText("Administrador");
        }else{
            textStatus.setText("Funcionário");
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
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        LabelCPF = new javax.swing.JLabel();
        textCPF = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        labelStatus = new javax.swing.JLabel();
        textStatus = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelNome.setText("Nome:");

        textNome.setEditable(false);
        textNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        LabelCPF.setText("CPF:");

        textCPF.setEditable(false);

        labelEmail.setText("Email:");

        textEmail.setEditable(false);

        labelStatus.setText("Cargo");

        textStatus.setEditable(false);
        textStatus.setText("Non ademir");
        textStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textStatusActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\user.png"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Editar Dados");
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
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCPF)
                    .addComponent(labelEmail)
                    .addComponent(labelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(textStatus, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textCPF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(textEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelCPF)
                            .addComponent(textCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStatus))))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        menuConta.setText("Conta");

        botaoPerfil.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+ "\\src\\main\\java\\Icones\\perfil.png"));
        botaoPerfil.setText("Perfil");
        botaoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPerfilActionPerformed(evt);
            }
        });
        menuConta.add(botaoPerfil);

        botaoLogout.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\perfil.png"));
        botaoLogout.setText("Logout");
        botaoLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoLogoutMouseClicked(evt);
            }
        });
        botaoLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLogoutActionPerformed(evt);
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
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPerfilActionPerformed

    private void textStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textStatusActionPerformed

    private void botaoLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLogoutActionPerformed
        this.controlador.logoutFuncionario();
        LoginFuncionario login = new LoginFuncionario();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoLogoutActionPerformed

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CadastroFuncionario editar = new CadastroFuncionario(Session.getFuncionario());
        editar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoLogoutMouseClicked
       this.controlador.logoutFuncionario();
       InterfaceGeral ig = new InterfaceGeral();
       ig.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_botaoLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPerfilFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPerfilFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Funcionarios;
    private javax.swing.JLabel LabelCPF;
    private javax.swing.JMenuItem botaoLogout;
    private javax.swing.JMenuItem botaoPerfil;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JMenu menuClientes;
    private javax.swing.JMenu menuConta;
    private javax.swing.JMenu menuLivros;
    private javax.swing.JTextField textCPF;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textStatus;
    // End of variables declaration//GEN-END:variables
}
