
package erp.controllernovo;

import erp.dao.DAOProdutosItemVenda;
import erp.objects.ModelProdutosItemVenda;
import java.util.ArrayList;

/**
 *
 * @author Renato
 */
public class ControllerProdutosItemVenda {
    
    private DAOProdutosItemVenda dAOProdutosItemVenda = new DAOProdutosItemVenda();
   
    
    public ArrayList<ModelProdutosItemVenda> getListaProdutosItemVendaController(int codVenda){
        return this.dAOProdutosItemVenda.getListaProdutosItemVendaDAO(codVenda);
        
    }
}
