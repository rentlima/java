/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import erp.jdbc.ConnectionFactory;
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

    public void adicionarFornecedor(Fornecedor obj) {
        try {
            String sql = "INSERT INTO fornecedores (nome_f,endereco, cidade, uf, cep, ie, cnpj, email ,fone) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, obj.getNome_f());
            stm.setString(2, obj.getEndereco());
            stm.setString(3, obj.getCidade());
            stm.setString(4, obj.getUf());
            stm.setString(5, obj.getCep());
            stm.setString(6, obj.getIe());
            stm.setString(7, obj.getCnpj());
            stm.setString(8, obj.getEmail());
            stm.setString(9, obj.getFone());

            stm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cadastrado. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro " + e);

        }

    }

    public void updateFornecedor(Fornecedor obj) {

        try {
            String sql = "update fornecedores set  nome_f=?, endereco=?, cidade=?,uf = ?, cep=?,ie=?,cnpj=?,email=?,fone=? where id = ? ";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, obj.getNome_f());
            st.setString(2, obj.getEndereco());
            st.setString(3, obj.getCidade());
            st.setString(4, obj.getUf());
            st.setString(5, obj.getCep());
            st.setString(6, obj.getIe());
            st.setString(7, obj.getCnpj());
            st.setString(8, obj.getEmail());
            st.setString(9, obj.getFone());
            st.setInt(10, obj.getId_fornecedor());

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Fornecedor Alterado.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public void deleteFornecedor(Fornecedor obj){
        
        try {
            String sql = "delete from fornecedores where id=?";
            
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, obj.getId_fornecedor());
            
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fornecedor Excluido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }

    // metodo para listar todas as linhas da tabela fornecedores ordenado por ID
    public ResultSet listarFornecedor() {
        String sql = "SELECT * FROM fornecedores ORDER BY id";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(sql);
            return st.executeQuery();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro : " + e);
            return null;
        }

    }

}
