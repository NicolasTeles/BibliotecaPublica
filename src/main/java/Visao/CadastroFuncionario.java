/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visao;

import Controle.ControleCadastroFuncionario;
import DAO.FuncionarioDAO;
import Modelo.Funcionario;
import Modelo.Session;

import javax.swing.*;

/**
 *
 * @author nicol
 */
public class CadastroFuncionario extends javax.swing.JFrame {

    private final ControleCadastroFuncionario controlador;

    /**
     * Creates new form CadastroCliente
     */
    public CadastroFuncionario() {
        this.setTitle("Cadastro de funcionarios");
        initComponents();
        controlador = new ControleCadastroFuncionario();
    }
    
    public CadastroFuncionario(Funcionario funcionario) {
        this.setTitle("Cadastro de funcionarios");
        initComponents();
        controlador = new ControleCadastroFuncionario(funcionario);
        this.nomeTextField.setText(funcionario.getNome());
        this.emailTextField.setText(funcionario.getLogin());
        this.cpfTextField.setText(funcionario.getCpf());
        this.cpfTextField.setEditable(false);
        int selectedIndex = funcionario.getEadm() ? 1 : 0;
        this.eAdmComboBox.setSelectedIndex(selectedIndex);
        this.eAdmComboBox.setEditable(false);
        this.BotaoCadastro.setText("Atualizar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nomeTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        cpfTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        senhaField = new javax.swing.JPasswordField();
        senhaLabel = new javax.swing.JLabel();
        confirmaSenhaLabel = new javax.swing.JLabel();
        confirmaSenhaField = new javax.swing.JPasswordField();
        BotaoCadastro = new javax.swing.JButton();
        buttonVoltar1 = new javax.swing.JButton();
        emailTextField = new javax.swing.JTextField();
        cpfLabel = new javax.swing.JLabel();
        eAdmComboBox = new javax.swing.JComboBox<>();
        eAdmLabel = new javax.swing.JLabel();

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 660));

        nomeLabel.setText("Nome:");

        emailLabel.setText("Email:");

        senhaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaFieldActionPerformed(evt);
            }
        });

        senhaLabel.setText("Senha:");

        confirmaSenhaLabel.setText("Confirme a senha:");

        confirmaSenhaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaSenhaFieldActionPerformed(evt);
            }
        });

        BotaoCadastro.setText("Cadastrar");
        BotaoCadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotaoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastroActionPerformed(evt);
            }
        });

        buttonVoltar1.setText("Voltar");
        buttonVoltar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltar1ActionPerformed(evt);
            }
        });

        cpfLabel.setText("CPF:");

        eAdmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionario", "Administrador" }));
        eAdmComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eAdmComboBoxActionPerformed(evt);
            }
        });

        eAdmLabel.setText("Cargo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eAdmLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmaSenhaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(buttonVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                            .addComponent(BotaoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(confirmaSenhaField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(senhaField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(eAdmComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cpfTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nomeTextField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cpfLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eAdmLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eAdmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(senhaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confirmaSenhaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmaSenhaField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonVoltar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void senhaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaFieldActionPerformed

    private void confirmaSenhaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaSenhaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmaSenhaFieldActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        //botao invisivel: ignorar funcao, nao apagar
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltar1ActionPerformed
        MenuFuncionariosAdm menu = new MenuFuncionariosAdm();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonVoltar1ActionPerformed

    private void BotaoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastroActionPerformed
        
        FuncionarioDAO fd = FuncionarioDAO.getInstancia();
        
        if(fd.consultaFuncionario(this.cpfTextField.getText()) != null){
            String nome = this.nomeTextField.getText();
            String email = this.emailTextField.getText();
            String cpf = this.cpfTextField.getText();
            char[] senha = this.senhaField.getPassword();
            char[] confirmaSenha = this.senhaField.getPassword();
            boolean cargo = (this.eAdmComboBox.getSelectedIndex() == 1);
            
            boolean retorno = this.controlador.atualizaFuncionario(nome, email, cpf, senha, confirmaSenha, cargo);
            
            if(retorno){
                JOptionPane.showMessageDialog(null, "Conta atualizada com sucesso");
                Session.criaFuncionario(fd.consultaFuncionario(this.cpfTextField.getText()));
                MenuPerfilFuncionario mpf = new MenuPerfilFuncionario();
                mpf.setVisible(true);
                this.dispose();
            }
        }else if(controlador.cadastraFuncionario(this.nomeTextField.getText(), this.emailTextField.getText(), this.cpfTextField.getText(), 
                this.senhaField.getPassword(), this.confirmaSenhaField.getPassword(), 
                String.valueOf(this.geteAdmComboBox().getSelectedItem()))){
            MenuFuncionariosAdm menu = new MenuFuncionariosAdm();
            menu.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BotaoCadastroActionPerformed

    public JPasswordField getConfirmaSenhaField() {
        return confirmaSenhaField;
    }

    public void setConfirmaSenhaField(JPasswordField confirmaSenhaField) {
        this.confirmaSenhaField = confirmaSenhaField;
    }

    public JTextField getCpfTextField() {
        return cpfTextField;
    }

    public void setCpfTextField(JTextField cpfTextField) {
        this.cpfTextField = cpfTextField;
    }

    public JComboBox<String> geteAdmComboBox() {
        return eAdmComboBox;
    }

    public void seteAdmComboBox(JComboBox<String> eAdmComboBox) {
        this.eAdmComboBox = eAdmComboBox;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JTextField getNomeTextField() {
        return nomeTextField;
    }

    public void setNomeTextField(JTextField nomeTextField) {
        this.nomeTextField = nomeTextField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public void setSenhaField(JPasswordField senhaField) {
        this.senhaField = senhaField;
    }

    private void eAdmComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eAdmComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eAdmComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCadastro;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton buttonVoltar1;
    private javax.swing.JPasswordField confirmaSenhaField;
    private javax.swing.JLabel confirmaSenhaLabel;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JComboBox<String> eAdmComboBox;
    private javax.swing.JLabel eAdmLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JPasswordField senhaField;
    private javax.swing.JLabel senhaLabel;
    // End of variables declaration//GEN-END:variables

    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
