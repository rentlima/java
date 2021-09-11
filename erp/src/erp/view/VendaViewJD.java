/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.view;

import erp.controllernovo.ControllerVenda;
import erp.jdbc.ConnectionFactory;
import erp.objects.ModeloTabela;
import erp.objects.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Renato
 */
public class VendaViewJD extends javax.swing.JDialog {
    ConnectionFactory conn = new ConnectionFactory();
    Venda modelovenda = new Venda();
    int flag = 1,codVenda;
    float preco_produto,total = 0;
    
    ControllerVenda controleVenda = new ControllerVenda();
    
    /**
     * Creates new form VendaViewJD
     */
    public VendaViewJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Connection con = ConnectionFactory.getConnection();
        

        

        
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
        jLabel1 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jftData = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNomeProduto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValorUnitario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPesquisa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaItensVenda = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu de Vendas");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CPF do Cliente :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCpfKeyReleased(evt);
            }
        });
        jPanel1.add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 150, 23));

        jLabel2.setText("Nome :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));
        jPanel1.add(txtNomeCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 230, 23));

        jLabel3.setText("Data : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        try {
            jftData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jftData, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 120, 23));

        jLabel4.setText("Produto : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));
        jPanel1.add(txtNomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 150, 23));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, 24));

        jLabel5.setText("Quantidade");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        txtQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantidadeFocusGained(evt);
            }
        });
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyReleased(evt);
            }
        });
        jPanel1.add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 120, 23));

        jLabel6.setText("Valor Unitario");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        txtValorUnitario.setEditable(false);
        jPanel1.add(txtValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 140, 23));

        tabelaPesquisa = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabelaPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPesquisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaPesquisa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 153, 874, 150));

        tabelaItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tabelaItensVenda);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 344, 874, 150));

        jLabel7.setText("Itens da Venda : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 316, -1, -1));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("VALOR TOTAL DA COMPRA :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 539, 182, 40));

        txtValorTotal.setEditable(false);
        jPanel1.add(txtValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 539, 140, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setForeground(new java.awt.Color(0, 153, 0));
        jButton1.setText("Realizar Venda");

        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("Cancelar venda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 520, -1, -1));

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 30, 80, 100));

        btnDeletar.setText("Deletar");
        jPanel1.add(btnDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, 80, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1016, 689));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCpfKeyReleased
        String sql = "SELECT nome from clientes where cpf like ?";
        
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement st = null;
            ResultSet rs = null;
            st = con.prepareStatement(sql);
            st.setString(1, txtCpf.getText());
            rs = st.executeQuery();
            
            while(rs.next()) {
                txtNomeCliente.setText(rs.getString("nome"));
            }
            
            
        } catch (Exception e) {
            
        }
        
        if (evt.getKeyCode() == evt.VK_BACK_SPACE){
            txtNomeCliente.setText(null);
        }
    }//GEN-LAST:event_txtCpfKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement st = con.prepareStatement("insert into tbvendas (subtotal) values (?) ");
            st.setFloat(1, 0);
            st.execute(); 
            st.close();
            
            ResultSet rs = null ;
            Statement stm = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from tbvendas");
            rs.last();
            codVenda = rs.getInt("id");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro : " +e);
        }
       pesquisarProdutos();
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tabelaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPesquisaMouseClicked
         
        try {
            preencherProduto();
            somaProdutos();
        } catch (Exception e) {
        }

        
        
    }//GEN-LAST:event_tabelaPesquisaMouseClicked

    private void txtQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantidadeFocusGained
       
        
        
    }//GEN-LAST:event_txtQuantidadeFocusGained

    private void txtQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyReleased
        try {
            somaProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(VendaViewJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtQuantidadeKeyReleased

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
   
    
        int idVenda,quantidade = 0 ;
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Statement stm;
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select  * from produtos where nome = '"+txtNomeProduto.getText()+"'");
            rs.first();
            quantidade = rs.getInt("quantidade");
            if(quantidade >= Integer.parseInt(txtQuantidade.getText())){
                 
                 modelovenda.setNomeProduto(txtNomeProduto.getText());
                 modelovenda.setQtdItens(Integer.parseInt(txtQuantidade.getText()));
                 modelovenda.setId(codVenda);
                 try {
            controleVenda.adicionar(modelovenda);
        } catch (SQLException ex) {
            Logger.getLogger(VendaViewJD.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
                 
                 
                 try {
            preencherItensVenda("select * from produtos inner join tbitemvenda on produtos.codigo = tbitemvenda.idProduto inner join tbvendas on tbvendas.id = tbitemvenda.idVenda where tbvendas.id = "+codVenda);
        } catch (SQLException ex) {
            Logger.getLogger(VendaViewJD.class.getName()).log(Level.SEVERE, null, ex);
        }
                
            }else{
                JOptionPane.showMessageDialog(null, "Quantidade informada não está disponivel no estoque");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VendaViewJD.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        try{ 
            
  
        
       // Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        //rs = stm.executeQuery("SELECT * FROM produtos where nome =' "+txtNomeProduto.getText()+"'");
        //rs.first();
        
        }catch(Exception e){
            
        }
            
 
        
        try {
            somaProdutos();
        } catch (SQLException ex) {
            Logger.getLogger(VendaViewJD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        pesquisarProdutos();
        
       
   
    
    
    
    
        
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(VendaViewJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaViewJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaViewJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaViewJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VendaViewJD dialog = new VendaViewJD(new javax.swing.JFrame(), true);
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
// METODOS 
        
   public void pesquisarProdutos(){
       String sql = "SELECT codigo as Codigo, nome as Nome ,quantidade as Quantidade , valor_v as Valor_Unitario from produtos where nome like ? ";
       
       try {
           Connection con = ConnectionFactory.getConnection();
           PreparedStatement st = con.prepareStatement(sql);
           ResultSet rs = null;
           st.setString(1, txtNomeProduto.getText()+ "%");
           rs = st.executeQuery();
           
         
               tabelaPesquisa.setModel(DbUtils.resultSetToTableModel(rs));
          
           
       } catch (Exception e) {
       }
   
   }
   
   public void somaProdutos() throws SQLException{
      total = 0;
      int qtd = 0;
      float valor = 0;
    try{  Connection con = ConnectionFactory.getConnection();
      ResultSet rs = null;
      Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
      rs = stm.executeQuery("select * from tbitemvenda inner join produtos on tbitemvenda.idProduto = produtos.codigo where idVenda ="+codVenda);
     // rs.first();
       while (rs.next()) {  
           qtd  =rs.getInt("qtd_produto");
           valor = rs.getFloat("valor_v");
           total =total + rs.getFloat("valor_v")*rs.getInt("qtd_produto");
       }
     
       txtValorTotal.setText(String.valueOf(total));
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Erro : " +e);
    }
   }
   
   public void preencherItensVenda(String SQL) throws SQLException{
      ArrayList dados = new ArrayList();
      
      String[] Colunas = new String[]{"Descrição","Quantidade","Valor total"};
      Connection con = ConnectionFactory.getConnection();
      ResultSet rs = null;
      Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
      rs = stm.executeQuery(SQL);
      rs.first();
       do {      
           float valorproduto = rs.getFloat("valor_v");
           int qtdvendida = rs.getInt("qtd_produto");
           dados.add(new Object[]{rs.getString("nome"),rs.getInt("qtd_produto"),valorproduto * qtdvendida});
       } while (rs.next());
      
       ModeloTabela modelo = new ModeloTabela(dados, Colunas);
       tabelaItensVenda.setModel(modelo);
       tabelaItensVenda.getColumnModel().getColumn(0).setPreferredWidth(400);
       tabelaItensVenda.getColumnModel().getColumn(0).setResizable(false);
       tabelaItensVenda.getColumnModel().getColumn(1).setPreferredWidth(160);
       tabelaItensVenda.getColumnModel().getColumn(1).setResizable(false);
       tabelaItensVenda.getColumnModel().getColumn(2).setPreferredWidth(308);
       tabelaItensVenda.getColumnModel().getColumn(2).setResizable(false);
       
       tabelaItensVenda.getTableHeader().setReorderingAllowed(false);
       tabelaItensVenda.setAutoResizeMode(tabelaItensVenda.AUTO_RESIZE_OFF);
       tabelaItensVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       somaProdutos();
      
      
      
      
      
       
       
       
       
   }
   
        public void preencherProduto(){
            
            txtNomeProduto.setText(tabelaPesquisa.getValueAt(tabelaPesquisa.getSelectedRow(), 1).toString());
            txtQuantidade.setText("1");
            txtValorUnitario.setText(tabelaPesquisa.getValueAt(tabelaPesquisa.getSelectedRow(), 3).toString());
        }






// METODOS 
        
        
        
        
        
        
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFormattedTextField jftData;
    private javax.swing.JTable tabelaItensVenda;
    private javax.swing.JTable tabelaPesquisa;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeProduto;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorUnitario;
    // End of variables declaration//GEN-END:variables
}
