/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visao;

import Controle.ControleMenuPrincipalCliente;
import Controle.ControleReservaLivro;
import Modelo.Livro;
import Modelo.Session;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class ReservaLivro extends javax.swing.JFrame {
    
    private final ControleReservaLivro controlador;
    private final Livro livro;
    /**
     * Creates new form ReservaLivro
     */
    public ReservaLivro() {
        initComponents();
        controlador = new ControleReservaLivro();
        if(Session.getCliente() == null){
            JOptionPane.showMessageDialog(null, "O cliente deve estar logado para acessar essa tela!");
            InterfaceCliente ic = new InterfaceCliente();
            ic.setVisible(true);
            java.awt.EventQueue.invokeLater(() -> this.dispose());
        }
        this.livro = null;
    }
    
    public ReservaLivro(Livro livro){
        initComponents();
        controlador = new ControleReservaLivro();
        if(Session.getCliente() == null){
            JOptionPane.showMessageDialog(null, "O cliente deve estar logado para acessar essa tela!");
            InterfaceCliente ic = new InterfaceCliente();
            ic.setVisible(true);
            java.awt.EventQueue.invokeLater(() -> this.dispose());
        }
        this.livro = livro;
        this.getTextNome().setText(livro.getNome());
        this.getTextAutor().setText(livro.getAutor());
        this.getTextEditora().setText(livro.getEditora());
        this.getTextAno().setText(Integer.toString(livro.getAnoPubli()));
        if(livro.getNumAvaliacoes() > 0){
            this.labelAval.setText((double)livro.getTotalAvaliacao()/livro.getNumAvaliacoes() + "/5");
        }else{
            this.labelAval.setText("Não ha avaliacoes para esse livro ainda");
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
        labelAutor = new javax.swing.JLabel();
        labelAno = new javax.swing.JLabel();
        labelEditora = new javax.swing.JLabel();
        labelEstrela = new javax.swing.JLabel();
        labelAval = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        textAutor = new javax.swing.JTextField();
        textAno = new javax.swing.JTextField();
        textEditora = new javax.swing.JTextField();
        botaoReservar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labelNome.setText("Nome:");

        labelAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAutor.setText("Autor:");

        labelAno.setText("Ano de publicação:");

        labelEditora.setText("Editora:");

        labelEstrela.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\Icones\\aval.png"));

        labelAval.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelAval.setText("5/5");

        textNome.setEditable(false);
        textNome.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textNome.setText("Nome Muito LEGAL");
        textNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeActionPerformed(evt);
            }
        });

        textAutor.setEditable(false);
        textAutor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textAutor.setText("legless jonh");
        textAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAutorActionPerformed(evt);
            }
        });

        textAno.setEditable(false);
        textAno.setText("4444");

        textEditora.setEditable(false);
        textEditora.setText("Jonas Edicoes");

        botaoReservar.setText("Reservar");
        botaoReservar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoReservarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelEditora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEditora))
                    .addComponent(labelNome)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textAno, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(labelEstrela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAval)
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(labelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelAutor)
                                    .addComponent(textAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(labelEstrela, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelAno)
                            .addComponent(textAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEditora)
                            .addComponent(textEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(labelAval, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoReservar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

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

    private void textNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeActionPerformed

    private void textAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAutorActionPerformed

    private void botaoReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoReservarActionPerformed
        this.controlador.reserva(this.livro);
        MenuPrincipalCliente mpc = new MenuPrincipalCliente();
        mpc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoReservarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        MenuPrincipalCliente mpc = new MenuPrincipalCliente();
        mpc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(ReservaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservaLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaLivro().setVisible(true);
            }
        });
    }

    public JTextField getTextAno() {
        return textAno;
    }

    public void setTextAno(JTextField textAno) {
        this.textAno = textAno;
    }

    public JTextField getTextAutor() {
        return textAutor;
    }

    public void setTextAutor(JTextField textAutor) {
        this.textAutor = textAutor;
    }

    public JTextField getTextEditora() {
        return textEditora;
    }

    public void setTextEditora(JTextField textEditora) {
        this.textEditora = textEditora;
    }

    public JTextField getTextNome() {
        return textNome;
    }

    public void setTextNome(JTextField textNome) {
        this.textNome = textNome;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoReservar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAno;
    private javax.swing.JLabel labelAutor;
    private javax.swing.JLabel labelAval;
    private javax.swing.JLabel labelEditora;
    private javax.swing.JLabel labelEstrela;
    private javax.swing.JLabel labelNome;
    private javax.swing.JTextField textAno;
    private javax.swing.JTextField textAutor;
    private javax.swing.JTextField textEditora;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}