/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import java.sql.Connection;
import erp.jdbc.ConnectionFactory;
import erp.objects.Clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class ClientesDAO {
    
     Connection con = null;
    
    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public ClientesDAO(Connection conexao) {
         this.con = conexao;
    }

    public ClientesDAO(Clientes list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void adicionarCliente(Clientes obj){
        try {
            String sql = "INSERT INTO clientes (nome, rg , cpf , endereco , cep , cidade , uf , telefone , bairro) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getRg());
            stm.setString(3, obj.getCpf());
            stm.setString(4, obj.getEndereco());
            stm.setString(5, obj.getCep());
            stm.setString(6, obj.getCidade());
            stm.setString(7, obj.getUf());
            stm.setString(8, obj.getTelefone());
            stm.setString(9, obj.getBairro());
            stm.executeUpdate();
            
         JOptionPane.showMessageDialog(null,"Cadastrado. ");
         
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro no cadastro " + e);
            
        }
    
    }

    public void updateClientes(Clientes obj) {
        try {
            String sql = "update clientes set nome=?, rg=? , cpf=? , endereco=? , cep=? , cidade=? , uf=? , telefone=? , bairro=? where id=? ";
            
            PreparedStatement stm = con.prepareStatement(sql);
            
            stm.setString(1, obj.getNome());
            stm.setString(2, obj.getRg());
            stm.setString(3, obj.getCpf());
            stm.setString(4, obj.getEndereco());
            stm.setString(5, obj.getCep());
            stm.setString(6, obj.getCidade());
            stm.setString(7, obj.getUf());
            stm.setString(8, obj.getTelefone());
            stm.setString(9, obj.getBairro());
            stm.setInt(10, obj.getId());
            
            stm.executeUpdate();
        
            
            
            
            JOptionPane.showMessageDialog(null,"Cadastro Alterado ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " +e);
        }
    }
    
    public void deleteCliente(Clientes obj){
        try {
            String sql = "delete from clientes where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getId());
           
            
            stm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente Excluido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro : "+ e);
        }
    }

    public List<Clientes> listar() throws SQLException{
           
       // Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        
        
        List<Clientes> clientes = new ArrayList<>();
         try {
             stmt = con.prepareStatement("SELECT * FROM clientes");
             rs = stmt.executeQuery();
             
           while (rs.next()){
               Clientes cliente = new Clientes();
               cliente.setBairro(rs.getString("bairro"));
               cliente.setCep(rs.getString("cep"));
               cliente.setCidade(rs.getString("cidade"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setEndereco(rs.getString("endereco"));
               cliente.setId(rs.getInt("id"));
               cliente.setNome(rs.getString("nome"));
               cliente.setRg(rs.getString("rg"));
               cliente.setUf(rs.getString("uf"));
               cliente.setTelefone(rs.getString("telefone"));
               clientes.add(cliente);
           } 
             
         } catch (SQLException ex) {
             Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
         }finally {
            stmt.close();
            rs.close();
            con.close();
             
         }
       return clientes;
    }
    public boolean extBD(Clientes excluirClientes) throws SQLException {
       // Esse metodo vai consultar o banco e trazer dados ;
       String sql = "select * from clientes where id = ?";
       
       PreparedStatement st = con.prepareStatement(sql);
       st.setInt(1, excluirClientes.getId());
       
       st.executeQuery();
       
       //esses dados podem ser recebidos por esse metodo abaixo;
       // essa variavel result ?? o resultado da pesquisa no banco;
      ResultSet result = st.getResultSet();
      
       
        return result.next();
}
    
    public boolean existeCpf(Clientes ext) throws SQLException {
       // Esse metodo vai consultar o banco e trazer dados ;
       String sql = "select * from clientes where cpf = ?";
       
       PreparedStatement st = con.prepareStatement(sql);
       st.setString(1, ext.getCpf());
       
       st.executeQuery();
       
       //esses dados podem ser recebidos por esse metodo abaixo;
       // essa variavel result ?? o resultado da pesquisa no banco;
      ResultSet result = st.getResultSet();
      
       
        return result.next();
}
    public void receberNome(Clientes nome) throws SQLException{
        String sql = "select nome from clientes where cpf ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1,nome.getNome() );
        st.setString(2, nome.getCpf());
        
        st.executeUpdate();
    }
    
// 
    
    
    //      metodo de consulta abaixo feito para testes    //
    //      metodo de consulta abaixo feito para testes    //
    
    
    
    
  /*public void consultar(Clientes cli) throws SQLException{
      
      ResultSet rs = null; 
      try {
          String sql = "select * from clientes where id = ?";
      PreparedStatement st = con.prepareStatement(sql);
      
      st.setInt(1,cli.getId());
      rs = st.executeQuery();
          if (rs.next()) {
              cli.setNome(rs.getString(2));
              cli.setRg(rs.getString(3));
              cli.setCpf(rs.getString(4));
              cli.setEndereco(rs.getString(5));
              cli.setCep(rs.getString(6));
              cli.setCidade(rs.getString(7));
              cli.setUf(rs.getString(8));
              cli.setNumero(rs.getString(9));
              cli.setBairro(rs.getString(10));
              
              
          } else {
          }
      
      
      
      } catch (Exception e) {
      }
  
      
      
      
  }
        */
    
    
    public List<Clientes>buscarClientesPeloNome(String nome){
        
         try {
             List<Clientes> clientesLista = new ArrayList<>();
             String sql = "select * from clientes like nome";
             PreparedStatement st = con.prepareStatement(sql);
             st.setString(1,nome);
             ResultSet rs = st.executeQuery();
             while (rs.next()){
                 Clientes obj = new Clientes();
                 obj.setId(rs.getInt("id"));
                 obj.setNome(rs.getString("nome"));
                 obj.setRg(rs.getString("rg"));
                 obj.setCpf(rs.getString("cpf"));
                 obj.setEndereco(rs.getString("endereco"));
                 obj.setCep(rs.getString("cep"));
                 obj.setCidade(rs.getString("cidade"));
                 obj.setUf(rs.getString("uf"));
                 obj.setTelefone(rs.getString("telefone"));
                 obj.setBairro(rs.getString("bairro"));
                 
                 
                 clientesLista.add(obj);
                 
             }
             return clientesLista;

    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"ERRO : " + e);
    }
         return null;
    }
    
    public List<Clientes>buscarClientesPeloCpf(String cpf){
        
         try {
             List<Clientes> clientesLista = new ArrayList<>();
             String sql = "select * from clientes like cpf";
             PreparedStatement st = con.prepareStatement(sql);
             st.setString(1,cpf);
             ResultSet rs = st.executeQuery();
             while (rs.next()){
                 Clientes obj = new Clientes();
                 obj.setId(rs.getInt("id"));
                 obj.setNome(rs.getString("nome"));
                 obj.setRg(rs.getString("rg"));
                 obj.setCpf(rs.getString("cpf"));
                 obj.setEndereco(rs.getString("endereco"));
                 obj.setCep(rs.getString("cep"));
                 obj.setCidade(rs.getString("cidade"));
                 obj.setUf(rs.getString("uf"));
                 obj.setTelefone(rs.getString("telefone"));
                 obj.setBairro(rs.getString("bairro"));
                 
                 
                 clientesLista.add(obj);
                 
             }
             return clientesLista;

    }catch(Exception e){
        JOptionPane.showMessageDialog(null,"ERRO : " + e);
    }
         return null;
    }
}

