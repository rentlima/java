
package erp.controllernovo;

import erp.dao.ProdutosDAO;
import erp.objects.Produtos;
import java.util.ArrayList;

/**
 *
 * @author Renato
 */
public class ControllerProdutos {
    ProdutosDAO dao = new ProdutosDAO();
    
    public boolean alterarEstoque(ArrayList<Produtos> lista){
        return dao.alterarEstoque(lista);
    
}

}
