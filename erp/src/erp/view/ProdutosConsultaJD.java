/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.view;
import erp.jdbc.ConnectionFactory;
import erp.objects.Produtos;
import erp.telas.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.proteanit.sql.DbUtils;
//import erp.view.VendaJD;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Renato
 */
public class ProdutosConsultaJD extends javax.swing.JDialog {

    Connection con = null;
     
     public ProdutosConsultaJD(Connection conexao) {
         this.con = conexao;
     }
    /**
     * Creates new form ProdutosConsultaJD
     */
    public ProdutosConsultaJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        con = ConnectionFactory.getConnection();
        try {
            listar();
        } catch(Exception e){
            
        }
    }

    ProdutosConsultaJD(java.awt.Dialog parent , boolean modal) {
        super(parent , modal);
        initComponents();
        con = ConnectionFactory.getConnection();
        try {
            listar();
        } catch(Exception e){
            
        }
        
    }
    private DefaultTableModel tablemodel;
    public Produtos produto;
    public TelaPrincipal tela;

    

    public Produtos getProduto() {
        return produto;
    }
    
    
    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbCabecalho = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        txtProdutoNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        produtoTabela = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 50, 199));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(853, 29));
        jPanel2.setMinimumSize(new java.awt.Dimension(853, 29));

        lbCabecalho.setBackground(new java.awt.Color(0, 50, 199));
        lbCabecalho.setForeground(new java.awt.Color(255, 255, 255));
        lbCabecalho.setText("Consulta produto da venda");
        lbCabecalho.setMaximumSize(new java.awt.Dimension(853, 29));
        lbCabecalho.setMinimumSize(new java.awt.Dimension(853, 29));
        lbCabecalho.setPreferredSize(new java.awt.Dimension(853, 29));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nome do Produto");

        btnPesquisar.setBackground(new java.awt.Color(0, 50, 199));
        btnPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtProdutoNome.setBackground(new java.awt.Color(255, 255, 255));
        txtProdutoNome.setForeground(new java.awt.Color(0, 0, 0));
        txtProdutoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProdutoNomeKeyReleased(evt);
            }
        });

        produtoTabela =  new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        produtoTabela.setBackground(new java.awt.Color(255, 255, 255));
        produtoTabela.setForeground(new java.awt.Color(0, 0, 0));
        produtoTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        produtoTabela.setMinimumSize(new java.awt.Dimension(105, 400));
        produtoTabela.setPreferredSize(new java.awt.Dimension(225, 400));
        produtoTabela.getTableHeader().setReorderingAllowed(false);
        produtoTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtoTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(produtoTabela);

        btnSair.setBackground(new java.awt.Color(102, 102, 102));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setText("Sair");
        btnSair.setMaximumSize(new java.awt.Dimension(79, 32));
        btnSair.setMinimumSize(new java.awt.Dimension(79, 32));
        btnSair.setPreferredSize(new java.awt.Dimension(79, 32));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtProdutoNome)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            listar();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutosConsultaJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    public void listar() throws SQLException{
        Connection con = ConnectionFactory.getConnection();

        String sql = "SELECT codigo as codigo, nome as Nome , tipo as Tipo , quantidade as Quantidade ,valor_v as Valor_Venda from produtos where nome like ? ";
        
        try {
        ResultSet rs = null;
        PreparedStatement st = null;
        st = con.prepareStatement(sql);
        st.setString(1, txtProdutoNome.getText()+"%");
        rs = st.executeQuery();
        
        produtoTabela.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e ){
            
        }
        
        
    }
    
    
    
    private void produtoTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtoTabelaMouseClicked
        //obtem a linha da tabela
       /*String sql = "SELECT * from produtos where codigo =?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = null;
            st.setInt(1, (int) produtoTabela.getValueAt(produtoTabela.getSelectedRow(), 0));
            rs = st.executeQuery();
            
            while (rs.next()){
                System.out.println("erp.view.ProdutosConsultaJD.produtoTabelaMouseClicked()");
                venda.getTxtProduto().setText(rs.getString(1));
                venda.getTxtValorUnitario().setText(rs.getString(6));
            }
        } catch (Exception e) {
        }
        */
       
       /* int row = produtoTabela.getSelectedRow();
        
        produto = new Produtos();
        
        //coloca valores na instancia de produto
        produto.setCodigo((Integer) produtoTabela.getValueAt(row, 0));
        produto.setNome_P((String) produtoTabela.getValueAt(row, 1));
        produto.setQuantidade((Integer) produtoTabela.getValueAt(row, 3));
        //produto.setValor_v((Float) Float.parseFloat(produtoTabela.getValueAt(row, 4).toString()));
        
        this.dispose();        
        
     */
       

        
 

    }//GEN-LAST:event_produtoTabelaMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtProdutoNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProdutoNomeKeyReleased
       
            
    }//GEN-LAST:event_txtProdutoNomeKeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    
        
        
    }//GEN-LAST:event_formComponentShown

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
            java.util.logging.Logger.getLogger(ProdutosConsultaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosConsultaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosConsultaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosConsultaJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProdutosConsultaJD dialog = new ProdutosConsultaJD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCabecalho;
    private javax.swing.JTable produtoTabela;
    private javax.swing.JTextField txtProdutoNome;
    // End of variables declaration//GEN-END:variables
}