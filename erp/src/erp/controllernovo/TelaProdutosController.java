
package erp.controllernovo;

import erp.dao.ProdutosDAO;
import erp.jdbc.ConnectionFactory;
import erp.objects.Produtos;
import erp.view.ProdutosCadJD;
import java.sql.Connection;

/**
 *
 * @author Renato
 */
public class TelaProdutosController {
    ProdutosCadJD view = null;
    
    
    public TelaProdutosController(ProdutosCadJD view){
        this.view = view;
    }
    
    public void excluirProdutos(){
        int codigo = Integer.parseInt(view.getTblProdutos().getValueAt(view.getTblProdutos().getSelectedRow(), 0).toString());
        Produtos p = new Produtos(codigo);
        Connection con = ConnectionFactory.getConnection();
        ProdutosDAO dao = new ProdutosDAO(con);
        
        dao.deletarProduto(p);
    
    
    
    }

}
