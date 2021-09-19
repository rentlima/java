
package erp.dao;

import erp.jdbc.ConnectionFactory;
import erp.objects.ItemVenda;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Renato
 */
public class ItemVendaDAO {
    
    private Connection con ;

    public ItemVendaDAO() {
        this.con =  new ConnectionFactory().getConnection();
    }
    
    public List<ItemVenda> listarItemVenda(int idVenda){
        try {
            String sql = "select p.valor_v , i.qtd_produto tbitemvenda as i inner join produtos on (i.idProduto = p.codigo) where i.idVenda = ?";
           
        
        
        
        } catch (Exception e) {
        }
        return listarItemVenda(idVenda);
    }
    

}
