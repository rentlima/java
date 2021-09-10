/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.metodos;

import erp.dao.ClientesDAO;
import erp.dao.FornecedorDAO;
import erp.dao.ProdutosDAO;
import erp.objects.Clientes;
import erp.objects.Fornecedor;
import erp.objects.Produtos;
import java.sql.SQLException;

/**
 *
 * @author Renato
 */
public class TesteMetodos {
    
    
    public static void main (String[] args) throws SQLException{
        

      Produtos p = new Produtos();
      p.setCodigo(4);
      
      ProdutosDAO dao = new ProdutosDAO();
      dao.deletarProduto(p);
        
            }
}