/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import erp.jdbc.ConnectionFactory;
import erp.objects.Clientes;
import erp.objects.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class FornecedorDAO {
    
    Connection con = null;
    
    public FornecedorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public FornecedorDAO(Connection conexao) {
         this.con = conexao;
    }

    public void adicionarFornecedor(Fornecedor obj){
        try {
            String sql = "INSERT INTO fornecedores (nome_f) values (?)";
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, obj.getNome());
            stm.executeUpdate();
            
         JOptionPane.showMessageDialog(null,"Cadastrado. ");
         
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro no cadastro " + e);
            
        }
    
    }
    
      // metodo para listar todas as linhas da tabela fornecedores ordenado por ID
     public ResultSet listarFornecedor(){   
         String sql = "SELECT * FROM fornecedores ORDER BY id";
         PreparedStatement st = null;
         try {
             st = con.prepareStatement(sql);
             return st.executeQuery();
         } catch (Exception e) {
             
             JOptionPane.showMessageDialog(null, "Erro : "+e);
             return null;
         }
         
     }

}
