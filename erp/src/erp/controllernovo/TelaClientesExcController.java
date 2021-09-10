/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.controllernovo;

import erp.dao.ClientesDAO;
import erp.jdbc.ConnectionFactory;
import erp.objects.Clientes;


import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import erp.view.ClienteDelJD;

/**
 *
 * @author Renato
 */
public class TelaClientesExcController {
    private ClienteDelJD view; 

    public TelaClientesExcController (ClienteDelJD view){
      this.view = view;  
    }
       
   public void excluirClientes() throws SQLException{
   int id = Integer.parseInt( view.getTblClientes().getValueAt(view.getTblClientes().getSelectedRow(), 0).toString());
    
    Clientes list = new Clientes(id);
    Connection conn = new ConnectionFactory().getConnection();
      ClientesDAO aa = new ClientesDAO(conn);
    boolean buscar = aa.extBD(list);
    if (buscar){
    ClientesDAO test = new ClientesDAO();
  test.deleteCliente(list);
       //JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
    }else{
       JOptionPane.showMessageDialog(null, "ID não encontrado!!!");  
    } 
       
   }
    
    
}
