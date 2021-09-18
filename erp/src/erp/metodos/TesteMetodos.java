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
        

Clientes c = new Clientes();

c.setNome("a");
c.setEndereco("b");
c.setCpf("123");
c.setTelefone("50403020");

ClientesDAO dao = new ClientesDAO();
dao.adicionarCliente(c);
        
            }
}