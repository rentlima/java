/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import erp.jdbc.ConnectionFactory;
import erp.objects.Produtos;
import java.sql.Connection;
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
public class ProdutosDAO {
    
    Connection con = null;
    
    public ProdutosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public ProdutosDAO(Connection conexao) {
         this.con = conexao;
    }
    
    public void adicionarProduto(Produtos p){
        
        try {
            String sql = "INSERT INTO PRODUTOS(nome_P,tipo,marca,modelo,quantidade,valor) values(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,p.getNome_P());
            st.setString(2, p.getTipo());
            st.setString(3, p.getMarca());
            st.setString(4, p.getModelo());
            st.setInt(5, p.getQuantidade());
            st.setDouble(6, p.getValor());
            st.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Produto Cadastrado");   
            
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " +e);
        }
       
        
        
    }
    
    public void alterarProduto(Produtos p){
       try{
           String sql = "UPDATE produtos set nome_P=?,tipo=?,marca=?,modelo=?,quantidade=?,valor=? where codigo =?";
           PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,p.getNome_P());
            st.setString(2, p.getTipo());
            st.setString(3, p.getMarca());
            st.setString(4, p.getModelo());
            st.setInt(5, p.getQuantidade());
            st.setDouble(6, p.getValor());
            st.setInt(7, p.getCodigo());
            st.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Produto Alterado");  
           
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Erro : " +e);
           
       }
        
       
      
    }
    public void deletarProduto(Produtos p){
           
        try {
            String sql = "delete from produtos where codigo=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, p.getCodigo());
            
            JOptionPane.showMessageDialog(null, "Produto Excluido"); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro : " +e);
        }
        
        
       }

     public List<Produtos> listar() throws SQLException {
         
         PreparedStatement st = null;
         ResultSet rs = null;        
        
         
         List<Produtos> produtos = new ArrayList<>();
         try {
             st = con.prepareStatement("SELECT * FROM produtos");
             rs = st.executeQuery();
             
             
             while (rs.next()){
                 Produtos produto = new Produtos();
                 produto.setCodigo(rs.getInt("codigo"));
                 produto.setMarca(rs.getString("marca"));
                 produto.setModelo(rs.getString("modelo"));
                 produto.setNome_P(rs.getString("nome_P"));
                 produto.setQuantidade(rs.getInt("quantidade"));
                 produto.setTipo(rs.getString("tipo"));
                 produto.setValor(rs.getDouble("valor"));
                 produtos.add(produto);
             
             
             }
         } catch (Exception e) {
             
              JOptionPane.showMessageDialog(null, "Erro : " +e);
         }finally{
             st.close();
             rs.close();
             con.close();
             
         }
         
         return produtos;
         
         
     }


} 
