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
import java.sql.Statement;
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
            String sql = "INSERT INTO PRODUTOS(nome,tipo,quantidade,custo_c,valor_v,fornecedor) values(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,p.getNome_P());
            st.setString(2, p.getTipo());
            st.setInt(3, p.getQuantidade());
            st.setFloat(4, p.getCusto_c());
            st.setFloat(5, p.getValor_v());
            st.setString(6, p.getCod_forn());
            st.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Produto Cadastrado");   
            
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " +e);
        }
       
        
        
    }
    
    public void alterarProduto(Produtos p){
       try{
           String sql = "UPDATE produtos set nome=?,tipo=?,quantidade=?,custo_c=?,valor_v=?,fornecedor=? where codigo =?";
           PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,p.getNome_P());
            st.setString(2, p.getTipo());
            st.setInt(3, p.getQuantidade());
            st.setFloat(4, p.getCusto_c());
            st.setFloat(5, p.getValor_v());
            st.setString(6, p.getCod_forn());
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
                   
            st.executeUpdate();
            
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
                 produto.setNome_P(rs.getString("nome"));
                 produto.setTipo(rs.getString("tipo"));
                 produto.setQuantidade(rs.getInt("quantidade"));
                 produto.setCusto_c(rs.getFloat("custo_c"));
                 produto.setValor_v(rs.getFloat("valor_v"));
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
      
     public boolean alterarEstoque(ArrayList<Produtos> lista){
         try {
             for (int i = 0; i < lista.size(); i++) {

             String sql = "UPDATE produtos set quantidade ='"+lista.get(i).getQuantidade()+"' where nome = '"+lista.get(i).getNome_P()+"'";
             PreparedStatement st = con.prepareStatement(sql) ;
             
            
             
             }
             return true;
             } catch (Exception e) {
             return false;
             }
         
     }
     
     public void baixaEstoque(int id , int qtd_nova){
         try {
                Connection con = ConnectionFactory.getConnection();
                String sql = "UPDATE produtos set quantidade = ? where codigo = ? ";
                PreparedStatement st = con .prepareStatement(sql);  
                st.setInt(1, qtd_nova);
                st.setInt(2, id);
                st.execute();
                st.close();
                
         } catch (Exception e) {
         }
      
         
         
         
         
     }

} 
