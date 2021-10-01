/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.view;

import erp.controllernovo.ControllerProdutos;
import erp.controllernovo.ControllerProdutosItemVenda;
import erp.controllernovo.ControllerVenda;
import erp.dao.RelatoriosVendasDAO;
import erp.jdbc.ConnectionFactory;
import erp.objects.ModelProdutosItemVenda;
import erp.objects.ModeloTabela;
import erp.objects.Produtos;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Renato
 */
public class RelatorioVendasJD extends javax.swing.JDialog {

    ControllerProdutos controllerProdutos = new ControllerProdutos();
    Produtos produtos = new Produtos();
    ControllerProdutosItemVenda controller = new ControllerProdutosItemVenda();
    ModelProdutosItemVenda modelProdutosItemVenda = new ModelProdutosItemVenda();
    ArrayList<ModelProdutosItemVenda> listaModelProdutosItemVendas = new ArrayList<>();
    ArrayList<Produtos> listaModelProdutos = new ArrayList<>();
    RelatoriosVendasDAO dao = new RelatoriosVendasDAO();

    /**
     * Creates new form RelatorioVendasJD
     */
    public RelatorioVendasJD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void mostrarRelatorio() {
        JasperPrint a = new JasperPrint();
        JasperViewer jv = new JasperViewer(a);
        jv.setVisible(true);

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
        jLabel2 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalhes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setText("Digite a Data para realizar a pesquisa :");

        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N

        btnListar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        tabelaVendas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabelaVendas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVendas);

        tblDetalhes= new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblDetalhes.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tblDetalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblDetalhes);

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setText("Itens da Venda");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel4.setText("Vendas realizadas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 88, 227));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RELATÓRIO DE VENDAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/1282956_close_delete_deny_no_out_icon.png"))); // NOI18N
        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/1582587_arrow_refresh_reload_rotate icon_icon.png"))); // NOI18N
        jButton2.setText("Alterar");

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novas/24705_emblem_print_icon (1).png"))); // NOI18N
        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(766, 639));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        preencherTabelaVendas();
    }//GEN-LAST:event_btnListarActionPerformed

    private void tabelaVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVendasMouseClicked
        try {
            int cod = (int) tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 0);
            preencherTabelaDetalhes("select * from tbvendas inner join tbitemvenda on tbvendas.id  = tbitemvenda.idVenda inner join produtos on tbitemvenda.idProduto = produtos.codigo where tbvendas.id = " + cod);

        } catch (Exception e) {

        }


    }//GEN-LAST:event_tabelaVendasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            excluirVenda();
            preencherTabelaVendas();
            resetarTabelaDetalhes();
        } catch (Exception e) {
        }

        /*
         * LINHAS ABAIXO NÃO UTILIZADAS NO MOMENTO "ERRO NA EXCLUSÃO DA TBVENDA"
         */
 /*       int linha = tabelaVendas.getSelectedRow();
       int codVenda =(int) tabelaVendas.getValueAt(linha, 0);
       listaModelProdutos = new ArrayList<>();
       listaModelProdutosItemVendas = controller.getListaProdutosItemVendaController(codVenda);
        for (int i = 0; i < listaModelProdutosItemVendas.size(); i++) {
            produtos = new Produtos();
            produtos.setCodigo(listaModelProdutosItemVendas.get(i).getModelProdutos().getCodigo());
            produtos.setQuantidade(
                    listaModelProdutosItemVendas.get(i).getModelProdutos().getQuantidade()
                    +
                    listaModelProdutosItemVendas.get(i).getModelVendasProdutos().getQtd_itens());
            
            listaModelProdutos.add(produtos);
        }
       
      if( controllerProdutos.alterarEstoque(listaModelProdutos)){
          ControllerVenda cvenda = new ControllerVenda();
          cvenda.excluirVenda(codVenda);
          preencherTabelaVendas();
          
      }else {
          JOptionPane.showConfirmDialog(null, "ERRO");
          
      }
       
        
         */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int linha = tabelaVendas.getSelectedRow();
        int idVenda = (int) tabelaVendas.getValueAt(linha, 0);
        try {
            dao.gerarRelatorioVendaPDF(idVenda); // vai gerar pdf

        } catch (SQLException ex) {
            Logger.getLogger(RelatorioVendasJD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendasJD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void excluirVenda() throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement st;
        Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        int linha = (int) tabelaVendas.getValueAt(tabelaVendas.getSelectedRow(), 0);

        rs = stm.executeQuery("select * from tbvendas inner join tbitemvenda on tbvendas.id  = tbitemvenda.idVenda inner join produtos on tbitemvenda.idProduto = produtos.codigo where id = '" + linha + "' ");

        try {
            rs.first();
            do {
                int qtdEstoque = rs.getInt("quantidade");
                int qtdVendida = rs.getInt("qtd_produto");
                int soma = qtdEstoque + qtdVendida;

                st = con.prepareStatement("update produtos set quantidade = ? where codigo = ? ");
                st.setInt(1, soma);
                st.setInt(2, rs.getInt("idProduto"));
                st.execute();

                st = con.prepareStatement("delete from tbitemvenda where idVenda = ?");
                st.setInt(1, rs.getInt("idVenda"));
                st.execute();

            } while (rs.next());
            st = con.prepareStatement("delete from tbvendas where id = ?");
            st.setInt(1, linha);
            st.execute();
            st.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Venda Excluida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }

    }

    public void preencherTabelaVendas() {
        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "Select id as ID , data as Data , subtotal as ValorTotal, nomeCliente as Cliente, cpfCliente as CPF , id_cliente as ID_Cliente, tipo_pagamento as Tipo_de_Pagamento from tbvendas where data = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, txtData.getText());
            ResultSet rs = null;
            rs = st.executeQuery();
            tabelaVendas.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO : " + e);
        }
    }

    public void resetarTabelaDetalhes() {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Produtos", "Quantidade"};
        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tblDetalhes.setModel(modelo);
        tblDetalhes.getColumnModel().getColumn(0).setPreferredWidth(400);
        tblDetalhes.getColumnModel().getColumn(0).setResizable(false);
        tblDetalhes.getColumnModel().getColumn(1).setPreferredWidth(256);
        tblDetalhes.getColumnModel().getColumn(1).setResizable(false);

        tblDetalhes.getTableHeader().setReorderingAllowed(false);
        tblDetalhes.setAutoResizeMode(tblDetalhes.AUTO_RESIZE_OFF);
        tblDetalhes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void preencherTabelaDetalhes(String SQL) throws SQLException {
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[]{"Produtos", "Quantidade"};

        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery(SQL);
        try {
            rs.first();
            do {
                dados.add(new Object[]{rs.getString("nome"), rs.getInt("qtd_produto")});

            } while (rs.next());

        } catch (Exception e) {
        }

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tblDetalhes.setModel(modelo);
        tblDetalhes.getColumnModel().getColumn(0).setPreferredWidth(400);
        tblDetalhes.getColumnModel().getColumn(0).setResizable(false);
        tblDetalhes.getColumnModel().getColumn(1).setPreferredWidth(256);
        tblDetalhes.getColumnModel().getColumn(1).setResizable(false);

        tblDetalhes.getTableHeader().setReorderingAllowed(false);
        tblDetalhes.setAutoResizeMode(tblDetalhes.AUTO_RESIZE_OFF);
        tblDetalhes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
            java.util.logging.Logger.getLogger(RelatorioVendasJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendasJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendasJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendasJD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RelatorioVendasJD dialog = new RelatorioVendasJD(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnListar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaVendas;
    private javax.swing.JTable tblDetalhes;
    private javax.swing.JFormattedTextField txtData;
    // End of variables declaration//GEN-END:variables
}
