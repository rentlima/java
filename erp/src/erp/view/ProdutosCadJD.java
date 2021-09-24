/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.view;

import erp.controllernovo.TelaProdutosController;
import erp.dao.FornecedorDAO;
import erp.dao.ProdutosDAO;
import erp.jdbc.ConnectionFactory;
import erp.metodos.SoNumeros;
import erp.objects.Produtos;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.Document;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Renato
 */
public class ProdutosCadJD extends javax.swing.JDialog {
      
      private TelaProdutosController controller;
      Connection con = null;
    /**
     * Creates new form ProdutosCadJD
     */
      
      public ProdutosCadJD (Connection conexao){
          this.con = conexao;
      }
      
      Font font = new Font("Yu Gothic UI Semibold",Font.PLAIN,14);
      
    public ProdutosCadJD(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        con = ConnectionFactory.getConnection();
        controller = new TelaProdutosController(this);
        txtQuantidade.setDocument(new SoNumeros());
        txtId.setEditable(false);
        listar();
        restaurar();
        bloquearCampos();
        jComboBox1.setSelectedItem(null);
        jButton1.setEnabled(false); // botão de salvar
        tblProdutos.getTableHeader().setFont(font);
        
        
        
    }
    
Vector<Integer> id = new Vector<Integer>();
public void restaurar(){ // faz o id ser salvo no vetor e o combobox ser preenchido
    try {
        FornecedorDAO dao = new FornecedorDAO();
        ResultSet rs = dao.listarFornecedor();
        
        while (rs.next()){
            id.addElement(rs.getInt(1));
            jComboBox1.addItem(rs.getString(2));
        }
    } catch (Exception e) {
    }
}

    public void cadastrarProduto(){
        String nome_P , tipo , fornecedor;
        int quantidade;
        float valor_v , custo_c;
        
        nome_P = txtNome.getText();
        tipo = txtTipo.getText();
        quantidade =Integer.parseInt( txtQuantidade.getText());
        custo_c = Float.parseFloat(txtCusto_c.getText().replaceAll(",", "."));
        valor_v = Float.parseFloat(txtValor.getText().replaceAll(",", "."));
        fornecedor = jComboBox1.getSelectedItem().toString(); // pega o id que está salvo no vetor e usar no ComboBOX
        
        
        Produtos p = new Produtos();
        p.setNome_P(nome_P);
        p.setTipo(tipo);
        p.setQuantidade(quantidade);
        p.setCusto_c(custo_c);
        p.setValor_v(valor_v);
        p.setCod_forn(fornecedor);
        
        ProdutosDAO dao = new ProdutosDAO();
        dao.adicionarProduto(p);
        
        
        
        
        
    }
    
    public void listar() throws SQLException{
        String sql = "select codigo as Codigo, nome as Nome , tipo as Tipo , quantidade as Quantidade , "
                + "custo_c as Valor_Compra  , valor_v as Valor_Venda , fornecedor as Fornecedor from produtos where nome like ?";
        try {
              PreparedStatement st = con.prepareStatement(sql);
              ResultSet rs = null;
              st = con.prepareStatement(sql);
              st.setString(1, txtPesquisa.getText()+"%");
              rs = st.executeQuery();
           
           tblProdutos.setModel(DbUtils.resultSetToTableModel(rs));
               
               
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
    }
    
    
    /* NÃO UTILIZADO / METODO RESTAURAR TEM A MESMA FUNÇÃO
     public void combo(){ // faz os comboBox serem preenchidos pelos nome de fornecedores da DB;
         String sql = "SELECT nome_f FROM fornecedores  ";
         try {
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = null;
             rs = st.executeQuery();
             
             while(rs.next()){
                 jComboBox1.addItem(rs.getString(1));
             }
             
         } catch (Exception e) {
         }
         
     }
*/
    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    public JTextField getjTextField1() {
        return txtNome;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.txtNome = jTextField1;
    }

    public JTextField getjTextField2() {
        return txtCusto_c;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.txtCusto_c = jTextField2;
    }

    public JTextField getjTextField3() {
        return txtTipo;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.txtTipo = jTextField3;
    }

    public JTextField getjTextField4() {
        return txtQuantidade;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.txtQuantidade = jTextField4;
    }

    public JTextField getjTextField5() {
        return txtValor;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.txtValor = jTextField5;
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
        txtCusto_c = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtTipo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        txtPesquisa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Produtos");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dados do Produto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCusto_c.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel1.add(txtCusto_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 180, 30));

        txtValor.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 180, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel5.setText("Valor de Venda :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 110, 30));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setText("Custo de compra :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 30));

        txtNome.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 290, 30));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel1.setText("Nome :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 30));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setText("Tipo :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 50, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setText("Quantidade :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, 30));

        txtQuantidade.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantidadeActionPerformed(evt);
            }
        });
        jPanel1.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 120, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel7.setText("Fornecedor :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, 30));

        jComboBox1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 200, 30));

        txtTipo.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 240, 30));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/285657_floppy_guardar_save_icon.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 110, -1));

        btnEditar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/118801_refresh_icon.png"))); // NOI18N
        btnEditar.setText("Alterar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 110, -1));

        btnExcluir.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/1282956_close_delete_deny_no_out_icon.png"))); // NOI18N
        btnExcluir.setText("Deletar");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 110, -1));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/299068_add_sign_icon (2).png"))); // NOI18N
        jButton2.setText("Novo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 110, -1));

        txtId.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtId.setForeground(new java.awt.Color(0, 0, 0));
        txtId.setFocusable(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 70, 30));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel8.setText("ID :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, -1, 30));

        tblProdutos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblProdutos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProdutos.getTableHeader().setReorderingAllowed(false);
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutos);

        txtPesquisa.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        jLabel6.setText("Digite o nome do produto p/ buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(866, 489));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            cadastrarProduto();
            listar();
            limparCampos();
            bloquearCampos();
            txtId.setText(null);
        }catch(Exception e){
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        try {
            // TODO add your handling code here:
            listar();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosCadJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        int id = Integer.parseInt(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString());
        
        txtId.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString());
        txtNome.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 1).toString());
        txtTipo.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 2).toString());
        txtQuantidade.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(),3).toString());
        txtCusto_c.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 4).toString()); 
        txtValor.setText(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 5).toString());
        jComboBox1.setSelectedItem(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 6).toString());
        
        ativarCampos();
        jButton1.setEnabled(false);
        txtId.setEnabled(false);
        
        
        
    }//GEN-LAST:event_tblProdutosMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
     try{   
        controller.excluirProdutos();
        limparCampos();
        bloquearCampos();
        txtId.setText(null);
        listar();
     }catch(Exception e ){
         JOptionPane.showMessageDialog(null, e);
     }
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ativarCampos();
        limparCampos();
        jButton1.setEnabled(true);
        txtId.setEnabled(false);
        txtId.setText(null);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {Produtos p = new Produtos();
        p.setCodigo(Integer.parseInt(tblProdutos.getValueAt(tblProdutos.getSelectedRow(), 0).toString()));
        p.setNome_P(txtNome.getText());
        p.setTipo(txtTipo.getText());
        p.setCusto_c(Float.parseFloat(txtCusto_c.getText().toString()));
        p.setValor_v(Float.parseFloat(txtValor.getText().toString()));
        p.setQuantidade(Integer.parseInt(txtQuantidade.getText().toString()));
        p.setCod_forn(jComboBox1.getSelectedItem().toString());
        
        ProdutosDAO dao = new ProdutosDAO();
        dao.alterarProduto(p);
        limparCampos();
        bloquearCampos();
        listar();
        txtId.setText(null);
        }catch(Exception e ){
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantidadeActionPerformed

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
            java.util.logging.Logger.getLogger(ProdutosCadJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosCadJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosCadJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosCadJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {ProdutosCadJD dialog = new ProdutosCadJD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }catch(Exception e){
                
            }
            }
        });
    }

    public JTable getTblProdutos() {
        return tblProdutos;
    }

    public void setTblProdutos(JTable tblProdutos) {
        this.tblProdutos = tblProdutos;
    }
    
    public void bloquearCampos(){
        txtNome.setEnabled(false);
        txtCusto_c.setEnabled(false);
        txtQuantidade.setEnabled(false);
        txtTipo.setEnabled(false);
        txtValor.setEnabled(false);
        jComboBox1.setEnabled(false);
    }
    public void ativarCampos(){
         txtNome.setEnabled(true);
        txtCusto_c.setEnabled(true);
        txtQuantidade.setEnabled(true);
        txtTipo.setEnabled(true);
        txtValor.setEnabled(true);
        jComboBox1.setEnabled(true);
    }
    public void limparCampos(){
        txtCusto_c.setText(null);
        txtNome.setText(null);
        txtQuantidade.setText(null);
        txtTipo.setText(null);
        txtValor.setText(null);
        jComboBox1.setSelectedItem(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtCusto_c;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtTipo;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
