
package erp.dao;

import erp.jdbc.ConnectionFactory;
import erp.objects.ItemVenda;
import erp.objects.ModelProdutosItemVenda;
import erp.objects.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class DAOProdutosItemVenda {
    
    public ArrayList<ModelProdutosItemVenda> getListaProdutosItemVendaDAO(int codVenda){
      ArrayList<ModelProdutosItemVenda> listaModelProdutosItemVendas = new ArrayList<>();
      ModelProdutosItemVenda modelProdutosItemVenda = new ModelProdutosItemVenda();
      Produtos modelProdutos = new Produtos();
      ItemVenda modelVendasProdutos = new ItemVenda();
      
        try {
           Connection con = ConnectionFactory.getConnection();
           ResultSet rs = null;
           Statement stm;
           stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
           rs = stm.executeQuery("select produtos.codigo, produtos.quantidade,produtos.nome, produtos.valor_v , tbitemvenda.idProduto , tbitemvenda.idVenda , tbitemvenda.qtd_produto from tbitemvenda inner join produtos on produtos.codigo = tbitemvenda.idProduto where tbitemvenda.idVenda = '"+codVenda+"';");
                              
           while(rs.next()){
               modelProdutosItemVenda = new ModelProdutosItemVenda();
               modelProdutos = new Produtos();
               modelVendasProdutos = new ItemVenda();
               
               modelProdutos.setCodigo(rs.getInt(1));
               modelProdutos.setQuantidade(rs.getInt(2));
               modelProdutos.setNome_P(rs.getString(3));
               modelProdutos.setValor_v(rs.getFloat(4));
               
               
               modelVendasProdutos.setIdItem(rs.getInt(5));
               modelVendasProdutos.setIdVenda(rs.getInt(6));
               modelVendasProdutos.setQtd_itens(rs.getInt(7));
               
               modelProdutosItemVenda.setModelProdutos(modelProdutos);
               modelProdutosItemVenda.setModelVendasProdutos(modelVendasProdutos);
               
               listaModelProdutosItemVendas.add(modelProdutosItemVenda);
               
               
               
           }                         
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"ERRO : "+ e);
        }
        return listaModelProdutosItemVendas;
        }
}
