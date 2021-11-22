/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.view;

import erp.controllernovo.ControllerParcelamentoVendas;
import erp.jdbc.ConnectionFactory;
import erp.objects.ModeloParcelamento;
import erp.objects.ModeloTabela;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Renato
 */
public class ParcelamentoVendas extends javax.swing.JDialog {
    
    
        int quant_parcela , i=1 , cont = 1 ;
        float porc , valorvenda , valor_parcela;
        ModeloTabela modelo;
        ModeloParcelamento mod = new ModeloParcelamento();
        ControllerParcelamentoVendas controller = new ControllerParcelamentoVendas();

    /**
     * Creates new form ParcelamentoVendas
     */
    public ParcelamentoVendas(java.awt.Frame parent, boolean modal, int cod) {
        super(parent, modal);
        initComponents();
        Connection con =  ConnectionFactory.getConnection();
        ResultSet rs = null ;
        try {Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery("select * from tbvendas where id  = " + cod);
        rs.first();
        
        txtCodigoVenda.setText(String.valueOf(cod));
        txtValorVenda.setText(String.valueOf(rs.getFloat("subtotal")));
        txtData.setText(String.valueOf(rs.getString("data")));
        
        }catch(Exception e ){
            
        }
    }
    
    public ParcelamentoVendas(java.awt.Dialog parent, boolean modal , int cod) {
        super(parent, modal);
        initComponents();
        Connection con =  ConnectionFactory.getConnection();
        ResultSet rs = null ;
        try {Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery("select * from tbvendas where id  = " + cod);
        rs.first();
        
        txtCodigoVenda.setText(String.valueOf(cod));
        txtValorVenda.setText(String.valueOf(rs.getFloat("subtotal")));
        txtData.setText(String.valueOf(rs.getString("data")));
        
        }catch(Exception e ){
            
        }
    }

    private ParcelamentoVendas(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCabecalho6 = new javax.swing.JPanel();
        lbCabecalho6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtCodigoVenda = new javax.swing.JTextField();
        txtJuros = new javax.swing.JTextField();
        txtQuantParcelas = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtValorVenda = new javax.swing.JTextField();
        txtValorTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaParcelamento = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(624, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpCabecalho6.setBackground(new java.awt.Color(0, 88, 227));
        jpCabecalho6.setForeground(new java.awt.Color(255, 255, 255));
        jpCabecalho6.setMaximumSize(new java.awt.Dimension(853, 29));
        jpCabecalho6.setMinimumSize(new java.awt.Dimension(853, 29));

        lbCabecalho6.setBackground(new java.awt.Color(0, 88, 227));
        lbCabecalho6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        lbCabecalho6.setForeground(new java.awt.Color(255, 255, 255));
        lbCabecalho6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCabecalho6.setText("Parcelamento de Vendas");
        lbCabecalho6.setMaximumSize(new java.awt.Dimension(853, 29));
        lbCabecalho6.setMinimumSize(new java.awt.Dimension(853, 29));
        lbCabecalho6.setPreferredSize(new java.awt.Dimension(853, 29));

        javax.swing.GroupLayout jpCabecalho6Layout = new javax.swing.GroupLayout(jpCabecalho6);
        jpCabecalho6.setLayout(jpCabecalho6Layout);
        jpCabecalho6Layout.setHorizontalGroup(
            jpCabecalho6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCabecalho6Layout.createSequentialGroup()
                .addComponent(lbCabecalho6, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 227, Short.MAX_VALUE))
        );
        jpCabecalho6Layout.setVerticalGroup(
            jpCabecalho6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbCabecalho6, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        getContentPane().add(jpCabecalho6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 624, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setText("Codigo da Venda : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 170, -1));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel2.setText("Quantidade de Parcelas : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel3.setText("Valor da Venda : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 170, -1));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel4.setText("Juros : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 160, -1));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setText("Data : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 160, -1));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel6.setText("Valor Total : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 170, -1));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton2.setText("Parcelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 170, 40));

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jButton3.setText("Finalizar Venda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 170, 40));

        txtCodigoVenda.setEditable(false);
        txtCodigoVenda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        getContentPane().add(txtCodigoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 170, -1));

        txtJuros.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        getContentPane().add(txtJuros, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 170, -1));

        txtQuantParcelas.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        txtQuantParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantParcelasActionPerformed(evt);
            }
        });
        getContentPane().add(txtQuantParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 170, -1));

        txtData.setEditable(false);
        txtData.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        txtData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 170, -1));

        txtValorVenda.setEditable(false);
        txtValorVenda.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        txtValorVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorVendaActionPerformed(evt);
            }
        });
        getContentPane().add(txtValorVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 170, -1));

        txtValorTotal.setEditable(false);
        txtValorTotal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        getContentPane().add(txtValorTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 170, -1));

        tabelaParcelamento.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        tabelaParcelamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaParcelamento);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 600, 140));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantParcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantParcelasActionPerformed

    private void txtValorVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorVendaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        quant_parcela = Integer.parseInt(txtQuantParcelas.getText());
        porc = Float.parseFloat(txtJuros.getText());
        valorvenda = Float.parseFloat(txtValorVenda.getText());
        valor_parcela = valorvenda / quant_parcela;
        tabelaParcelamento.removeAll();
        try {
            
            preencher();
        } catch (Exception e) {
        }

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed


        int j = 1; // controla todas as inserçoes de parcelas no banco
        String datavenc = txtData.getText();
        String dia , mes , ano ;
        
        
        dia = ""+datavenc.charAt(0)+datavenc.charAt(1) +"/";
        mes = ""+datavenc.charAt(3)+datavenc.charAt(4);
        ano = "/"+datavenc.charAt(6)+datavenc.charAt(7)+datavenc.charAt(8)+datavenc.charAt(9);
        int anoInt = Integer.parseInt(""+datavenc.charAt(6) + datavenc.charAt(7) + datavenc.charAt(8) + datavenc.charAt(9));
        int mesInt = Integer.parseInt(mes);
        
        
        while(j < cont){
            if (mesInt <10) {
                mod.setCodVenda(Integer.parseInt( txtCodigoVenda.getText()));
                mod.setValorParcela(valor_parcela+ (valor_parcela *(porc / 100) ));
                mod.setValor_total(Float.parseFloat(txtValorTotal.getText()));
                mod.setValor_venda(Float.parseFloat(txtValorVenda.getText()));
                mod.setNumeroParc(j);
                mod.setDataVenc(dia + "0" + mesInt + "/" + anoInt);
                controller.salvarParcelas(mod);
                
            }else{
                mod.setCodVenda(Integer.parseInt(txtCodigoVenda.getText()));
                mod.setValorParcela(valor_parcela+ (valor_parcela *(porc / 100) ));
                mod.setValor_total(Float.parseFloat(txtValorTotal.getText()));
                mod.setValor_venda(Float.parseFloat(txtValorVenda.getText()));
                mod.setNumeroParc(j);
                mod.setDataVenc(dia + mesInt + "/" + anoInt);
                controller.salvarParcelas(mod);
            }
            
            mesInt++;
            if(mesInt > 12 ) {
                anoInt++;
                mesInt = 1;
            }
            j++;
        }
        JOptionPane.showMessageDialog(null, "Parcelas Geradas.\nVenda Finalizada!");
        
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

     public void preencher() throws SQLException{
      ArrayList dados = new ArrayList();
      
      String[] Colunas = new String[]{"Codigo","Data","Valor"};
      Connection con = ConnectionFactory.getConnection();
      ResultSet rs = null;
      
      float valorAtualizadoParcela,valorTotal=0;
      String data = txtData.getText();
      String dia , mes , ano ;
      dia = ""+data.charAt(0)+data.charAt(1) +"/";
      mes = ""+data.charAt(3)+data.charAt(4);
      ano = "/"+data.charAt(6)+data.charAt(7)+data.charAt(8)+data.charAt(9);
      
      valorAtualizadoParcela = valor_parcela + (valor_parcela*(porc/100));
      int anoInt = Integer.parseInt(""+data.charAt(6) + data.charAt(7) + data.charAt(8) + data.charAt(9));
      int mesInt = Integer.parseInt(mes);
       while(i<=quant_parcela) {      
           
           valorTotal = valorTotal + valorAtualizadoParcela;
           if (mesInt <10) {
               dados.add(new Object[]{i,dia+"0" + mesInt + "/" + anoInt, valorAtualizadoParcela });
                              
           }else{
               dados.add(new Object[]{i,dia+ mesInt + "/" + anoInt, valorAtualizadoParcela });
           }
          
           mesInt++;
           if (mesInt > 12) {
               anoInt++;
               mesInt = 1;
           }
           i++;
           cont++;
       
       } 
       
       txtValorTotal.setText(String.valueOf(valorTotal));
      
       modelo = new ModeloTabela(dados, Colunas);
       JTable table = new JTable(modelo);
       tabelaParcelamento.setModel(modelo);
       tabelaParcelamento.getColumnModel().getColumn(0).setPreferredWidth(80);
       tabelaParcelamento.getColumnModel().getColumn(0).setResizable(false);
       tabelaParcelamento.getColumnModel().getColumn(1).setPreferredWidth(133);
       tabelaParcelamento.getColumnModel().getColumn(1).setResizable(false);
       tabelaParcelamento.getColumnModel().getColumn(2).setPreferredWidth(133);
       tabelaParcelamento.getColumnModel().getColumn(2).setResizable(false);
       tabelaParcelamento.getColumnModel().getColumn(3).setPreferredWidth(120);
       tabelaParcelamento.getColumnModel().getColumn(3).setResizable(false);
       
       tabelaParcelamento.getTableHeader().setReorderingAllowed(false);
       tabelaParcelamento.setAutoResizeMode(tabelaParcelamento.AUTO_RESIZE_OFF);
       tabelaParcelamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   
       
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
            java.util.logging.Logger.getLogger(ParcelamentoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParcelamentoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParcelamentoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParcelamentoVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ParcelamentoVendas dialog = new ParcelamentoVendas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpCabecalho6;
    private javax.swing.JLabel lbCabecalho6;
    private javax.swing.JTable tabelaParcelamento;
    private javax.swing.JTextField txtCodigoVenda;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtJuros;
    private javax.swing.JTextField txtQuantParcelas;
    private javax.swing.JTextField txtValorTotal;
    private javax.swing.JTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables

    public int getCodVenda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
