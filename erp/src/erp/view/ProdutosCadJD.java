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
        jButton1.setEnabled(false); // botão de salvar
        
        
        
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
        txtPesquisa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Produtos");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtCusto_c, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 120, -1));
        jPanel1.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 120, -1));

        jLabel5.setText("Valor de Venda :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 100, 20));

        jLabel2.setText("Custo de compra :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 200, -1));

        jLabel1.setText("Nome :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        jLabel3.setText("Tipo :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, -1, 20));

        jLabel4.setText("Quantidade :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, 20));
        jPanel1.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 82, -1));

        jLabel7.setText("Fornecedor :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, -1));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 120, -1));

        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 150, -1));

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 80, -1));

        btnEditar.setText("Alterar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 80, -1));

        btnExcluir.setText("Deletar");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 80, -1));

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        jPanel1.add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 160, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 30, 30));

        jButton2.setText("Novo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, -1));

        txtId.setFocusable(false);
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, -1));

        jLabel8.setText("ID :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 20));

        tblProdutos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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
        txtId.setEnabled(true);
        
        
        
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
