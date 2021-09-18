/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.view;

import erp.controllernovo.TelaClientesCadController;

import erp.telas.TelaPrincipal;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicPanelUI;
import javax.swing.plaf.multi.MultiPanelUI;

/**
 *
 * @author Renato
 */
public class ViewCadastroCliente extends javax.swing.JFrame {
       // private final TelaClientesCadController controller;
    /**
     * Creates new form ViewCadastroCliente
     */
    public ViewCadastroCliente() {
       // controller = new TelaClientesCadController(this);
        initComponents();
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCadNome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCadCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCadRg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCadTelefone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtCadEndereco = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCadCidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCadCep = new javax.swing.JFormattedTextField();
        txtCadBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbUf = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(600, 500));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(816, 639));

        jPanel4.setPreferredSize(new java.awt.Dimension(600, 500));

        jButton1.setBackground(new java.awt.Color(187, 187, 250));
        jButton1.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 0));
        jButton1.setText("Adicionar Cliente");
        jButton1.setToolTipText("Adicionar");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Dados Pessoais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setMinimumSize(new java.awt.Dimension(600, 140));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 140));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(45, 139, 206));
        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 24));

        txtCadNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadNomeKeyPressed(evt);
            }
        });
        jPanel3.add(txtCadNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 250, 35));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/user (96).png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 120));

        try {
            txtCadCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCadCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadCpfActionPerformed(evt);
            }
        });
        txtCadCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadCpfKeyPressed(evt);
            }
        });
        jPanel3.add(txtCadCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 250, 35));

        jLabel2.setBackground(new java.awt.Color(45, 139, 206));
        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("RG:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, 24));

        txtCadRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadRgActionPerformed(evt);
            }
        });
        txtCadRg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadRgKeyPressed(evt);
            }
        });
        jPanel3.add(txtCadRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 250, 35));

        jLabel9.setBackground(new java.awt.Color(45, 139, 206));
        jLabel9.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Telefone:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, 24));

        txtCadTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadTelefoneActionPerformed(evt);
            }
        });
        txtCadTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadTelefoneKeyPressed(evt);
            }
        });
        jPanel3.add(txtCadTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 250, 35));

        jLabel3.setBackground(new java.awt.Color(45, 139, 206));
        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CPF:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 24));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 154));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 154));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCadEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadEnderecoActionPerformed(evt);
            }
        });
        txtCadEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadEnderecoKeyPressed(evt);
            }
        });
        jPanel2.add(txtCadEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 250, 35));

        jLabel11.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Bairro:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, 24));

        txtCadCidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadCidadeKeyPressed(evt);
            }
        });
        jPanel2.add(txtCadCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 250, 35));

        jLabel4.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CEP:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, 24));

        try {
            txtCadCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCadCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadCepKeyPressed(evt);
            }
        });
        jPanel2.add(txtCadCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 250, 35));

        txtCadBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCadBairroActionPerformed(evt);
            }
        });
        txtCadBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCadBairroKeyPressed(evt);
            }
        });
        jPanel2.add(txtCadBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 250, 35));

        jLabel6.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Endereço:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 24));

        jLabel5.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cidade:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 24));

        jLabel7.setFont(new java.awt.Font("Myanmar Text", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("UF:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 27, -1));

        cbUf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        cbUf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUfActionPerformed(evt);
            }
        });
        cbUf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbUfKeyPressed(evt);
            }
        });
        jPanel2.add(cbUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, 35));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/home__96_-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Novo Cliente");

        jButton2.setBackground(new java.awt.Color(187, 187, 250));
        jButton2.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("Voltar");
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(300, 80, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     //controller.salvarCliente();
     this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void txtCadNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadNomeKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadNomeKeyPressed

    private void txtCadCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadCpfActionPerformed

    private void txtCadCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadCpfKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadCpfKeyPressed

    private void txtCadRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadRgActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCadRgActionPerformed

    private void txtCadRgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadRgKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadRgKeyPressed

    private void txtCadTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadTelefoneActionPerformed

    private void txtCadTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadTelefoneKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadTelefoneKeyPressed

    private void txtCadEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadEnderecoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCadEnderecoActionPerformed

    private void txtCadEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadEnderecoKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadEnderecoKeyPressed

    private void txtCadCidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadCidadeKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadCidadeKeyPressed

    private void txtCadCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadCepKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadCepKeyPressed

    private void txtCadBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCadBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCadBairroActionPerformed

    private void txtCadBairroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCadBairroKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_txtCadBairroKeyPressed

    private void cbUfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUfActionPerformed

    private void cbUfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbUfKeyPressed
        // TODO add your handling code here:
        enter(evt);
    }//GEN-LAST:event_cbUfKeyPressed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        
        jButton1.setBackground(new Color(0,153,0));
        jButton1.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setBackground(new Color(187,187,250));
        jButton1.setForeground(new Color(0,153,0));
        
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setBackground(new Color(204,0,0));
        jButton2.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setBackground(new Color(187,187,250));
        jButton2.setForeground(new Color(204,0,0));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
  
    }//GEN-LAST:event_jButton2ActionPerformed

    public void enter(java.awt.event.KeyEvent evt){
    if (evt.getKeyCode() == evt.VK_ENTER){
            try {
               // controller.salvarCliente();
            } catch (Exception ex) {
                Logger.getLogger(ViewCadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
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
            java.util.logging.Logger.getLogger(ViewCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewCadastroCliente tela = new ViewCadastroCliente();
                tela.setVisible(true);
              
                
            }
        });
    }

    public JComboBox<String> getCbUf() {
        return cbUf;
    }

    public void setCbUf(JComboBox<String> cbUf) {
        this.cbUf = cbUf;
    }

    public JTextField getTxtCadBairro() {
        return txtCadBairro;
    }

    public void setTxtCadBairro(JTextField txtCadBairro) {
        this.txtCadBairro = txtCadBairro;
    }

    public JFormattedTextField getTxtCadCep() {
        return txtCadCep;
    }

    public void setTxtCadCep(JFormattedTextField txtCadCep) {
        this.txtCadCep = txtCadCep;
    }

    public JTextField getTxtCadCidade() {
        return txtCadCidade;
    }

    public void setTxtCadCidade(JTextField txtCadCidade) {
        this.txtCadCidade = txtCadCidade;
    }

    public JFormattedTextField getTxtCadCpf() {
        return txtCadCpf;
    }

    public void setTxtCadCpf(JFormattedTextField txtCadCpf) {
        this.txtCadCpf = txtCadCpf;
    }

    public JTextField getTxtCadEndereco() {
        return txtCadEndereco;
    }

    public void setTxtCadEndereco(JTextField txtCadEndereco) {
        this.txtCadEndereco = txtCadEndereco;
    }

    public JTextField getTxtCadNome() {
        return txtCadNome;
    }

    public void setTxtCadNome(JTextField txtCadNome) {
        this.txtCadNome = txtCadNome;
    }

    public JTextField getTxtCadRg() {
        return txtCadRg;
    }

    public void setTxtCadRg(JTextField txtCadRg) {
        this.txtCadRg = txtCadRg;
    }

    public JTextField getTxtCadTelefone() {
        return txtCadTelefone;
    }

    public void setTxtCadTelefone(JTextField txtCadTelefone) {
        this.txtCadTelefone = txtCadTelefone;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbUf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtCadBairro;
    private javax.swing.JFormattedTextField txtCadCep;
    private javax.swing.JTextField txtCadCidade;
    private javax.swing.JFormattedTextField txtCadCpf;
    private javax.swing.JTextField txtCadEndereco;
    private javax.swing.JTextField txtCadNome;
    private javax.swing.JTextField txtCadRg;
    private javax.swing.JTextField txtCadTelefone;
    // End of variables declaration//GEN-END:variables
}
