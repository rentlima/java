package erp.controllernovo;

import erp.jdbc.ConnectionFactory;
import erp.objects.Produtos;
import erp.objects.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class ControllerVenda {

    int codProd;
    int codigo;
    ConnectionFactory conexao = new ConnectionFactory();

    public void adicionar(Venda obj) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        achacodigoProduto(obj.getNomeProduto());

        try {
            PreparedStatement pst = con.prepareStatement("insert into tbitemvenda(idVenda , idProduto , qtd_produto)values(?,?,?) ");
            pst.setInt(1, obj.getId());
            pst.setInt(2, codProd);
            pst.setInt(3, obj.getQtdItens());
            pst.execute();

            // Baixa de estoque  
            int quant = 0, resultado = 0;
            ResultSet rs = null;
            Statement stm;
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select  * from produtos where nome = '" + obj.getNomeProduto() + "'");
            rs.first();
            quant = rs.getInt("quantidade");
            resultado = quant - obj.getQtdItens();
            pst = con.prepareStatement("update produtos set quantidade = ?  where nome = ? ");
            pst.setInt(1, resultado);
            pst.setString(2, obj.getNomeProduto());
            pst.execute();
            //JOptionPane.showMessageDialog(null, "Produto adicionado");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro : " + ex);
        }

    }

    public void achacodigoProduto(String nome) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery("select * from produtos where nome ='" + nome + "' ");
        rs.first();
        codProd = rs.getInt("codigo");

    }

    public void finalizarVenda(Venda mod) {
        acharCliente(mod.getNomeCliente());
        try {
            Connection con = ConnectionFactory.getConnection();
            ResultSet rs = null;
            PreparedStatement st = con.prepareStatement("update tbvendas set data=?,subtotal=?,nomeCliente=?,cpfCliente=?,id_cliente=? , tipo_pagamento=?  where id= ?");
            st.setString(1, mod.getData());
            st.setFloat(2, mod.getSubTotal());
            st.setString(3, mod.getNomeCliente());
            st.setString(4, mod.getCpfCliente());
            st.setInt(5, codigo);
            st.setString(6, mod.getPagamento());
            st.setInt(7, mod.getId());
            st.execute();
            JOptionPane.showMessageDialog(null, "Venda Finalizada");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }

    }

    public void attProduto(int codigo_IV) throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement st;
        Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery("select * from tbvendas inner join tbitemvenda on tbvendas.id  = tbitemvenda.idVenda inner join produtos on tbitemvenda.idProduto = produtos.codigo where codigo_IV = '" + codigo_IV + "'");

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

            } while (rs.next());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }

    }

    public void cancelarVendaItensTotal() throws SQLException {

        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement st;
        Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
        rs = stm.executeQuery("select * from tbvendas inner join tbitemvenda on tbvendas.id  = tbitemvenda.idVenda inner join produtos on tbitemvenda.idProduto = produtos.codigo where subtotal =0");

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
            st = con.prepareStatement("delete from tbvendas where subtotal = ?");
            st.setInt(1, 0);
            st.execute();
            st.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Venda Cancelada. ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }

    }

    public void cancelarVenda(int codVenda) throws SQLException {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement st = con.prepareStatement("delete from tbvendas where id = ?");
        st.setInt(1, codVenda);
        st.executeUpdate();

        JOptionPane.showMessageDialog(null, "Venda Cancelada. ");

    }

    public void acharCliente(String nome) {

        try {
            Connection con = ConnectionFactory.getConnection();
            ResultSet rs = null;
            Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select * from clientes where nome = '" + nome + "' ");
            rs.first();
            codigo = rs.getInt("id");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }

    }

    public void excluirVenda(int codVenda) {

        try {
            Connection con = ConnectionFactory.getConnection();
            String sql = "delete from tbvendas where id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, codVenda);

            st.executeUpdate();

            JOptionPane.showMessageDialog(null, "Venda Excluida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }

    }

}
