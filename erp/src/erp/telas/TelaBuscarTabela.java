/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.telas;

import erp.dao.ClientesDAO;
import erp.jdbc.ConnectionFactory;
import erp.objects.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Miguel/Renato
 */
public class TelaBuscarTabela extends javax.swing.JInternalFrame {
Connection con = null;

 
    // conexao 
    public TelaBuscarTabela(Connection conexao) {
         this.con = conexao;
         
    }
    /**
     * Creates new form TelaBuscarTabela
     */
    public TelaBuscarTabela() throws SQLException {
         this.con = new ConnectionFactory().getConnection();
        initComponents();
        con = ConnectionFactory.getConnection();
        //listarValoresClientes(); // não usado no momento
        pesquisarClientes();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Listar Clientes");
        setFocusable(false);
        setPreferredSize(new java.awt.Dimension(600, 345));
        setRequestFocusEnabled(false);

        jLabel1.setText("Digite o nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jScrollPane2.setPreferredSize(new java.awt.Dimension(453, 355));

        tblClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setPreferredSize(new java.awt.Dimension(305, 300));
        jScrollPane2.setViewportView(tblClientes);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        setBounds(0, 0, 600, 355);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
    try {
        // TODO add your handling code here:
        pesquisarClientes();
    } catch (SQLException ex) {
        Logger.getLogger(TelaBuscarTabela.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
   private void pesquisarClientes () throws SQLException {
       String sql = "select id as Id, nome as Nome, rg as RG, cpf as CPF, endereco as Endereço, cep as CEP, "
               + "cidade as Cidade, uf as UF, numero as Numero, bairro as Bairro from clientes where nome like ?";
      /*PreparedStatement st = con.prepareStatement(sql);
       ResultSet rs = null; */
            
       try {
            PreparedStatement st = con.prepareStatement(sql);
       ResultSet rs = null;
           st = con.prepareStatement(sql);
           st.setString(1, txtNome.getText()+"%");
           rs = st.executeQuery();
           
           tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
       
   }
    
    private void listarValoresClientes (){
        try {
            ClientesDAO objclientes = new ClientesDAO();
            DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();
            model.setNumRows(0);
            ArrayList<Clientes> lista = (ArrayList<Clientes>) objclientes.listar();
            for (int num = 0 ; num < lista.size() ; num ++){
                model.addRow(new Object[]{
                
                lista.get(num).getId(),
                lista.get(num).getNome(),
                lista.get(num).getRg(),
                lista.get(num).getCpf(),
                lista.get(num).getEndereco(),
                lista.get(num).getCep(),
                lista.get(num).getCidade(),
                lista.get(num).getUf(),
                lista.get(num).getNumero(),
                lista.get(num).getBairro(),
               });
            }
            JOptionPane.showMessageDialog(null, "Listagem realizada com sucesso!!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
}
}
