
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
    ConnectionFactory conexao = new ConnectionFactory();
    public void adicionar(Venda obj) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        achacodigoProduto(obj.getNomeProduto());
        
        try {
            PreparedStatement pst = con.prepareStatement("insert into tbitemvenda(idVenda , idProduto , qtd_produto)values(?,?,?) ");
            pst.setInt(1, obj.getId());
            pst.setInt(2, codProd);
            pst.setInt(3, obj.getQtdItens());
            pst.execute();

           // Baixa de estoque  
            
            int quant = 0,resultado =0;
            ResultSet rs = null;
            Statement stm;
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery("select  * from produtos where nome = '"+obj.getNomeProduto()+"'");
            rs.first();
            quant = rs.getInt("quantidade");
            resultado = quant - obj.getQtdItens();
            pst = con.prepareStatement("update produtos set quantidade = ?  where nome = ? ");
            pst.setInt(1, resultado);
            pst.setString(2, obj.getNomeProduto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Produto adicionado");
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "Erro : " + ex);
        }
        
    }

    public void achacodigoProduto(String nome) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Statement stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs =  stm.executeQuery("select * from produtos where nome ='"+nome+"' ");
        rs.first();
        codProd = rs.getInt("codigo");
           
        }
        
        
        
     
    }

