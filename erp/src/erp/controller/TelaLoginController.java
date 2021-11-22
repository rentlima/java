/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.controller;

import erp.dao.UsuariosDAO;
import erp.jdbc.ConnectionFactory;
import erp.objects.Usuarios;
import erp.telas.LoginNova;
import erp.telas.TelaPrincipal;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class TelaLoginController {
    
    //private TelaLogin view;
    private LoginNova view;

   /* public TelaLoginController(TelaLogin view) {
        this.view = view;
    }*/
    public TelaLoginController(LoginNova view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //buscar usuario da view
        String login = view.getTxtLogin().getText();
        String senha = view.getTxtSenha().getText();
        
        Usuarios usuarioAutenticar = new Usuarios(login , senha);
        
        // verificar se existe no BD
         Connection conexao = new ConnectionFactory().getConnection();
            
         UsuariosDAO usuariosDao = new UsuariosDAO(conexao);
         
        boolean existe = usuariosDao.existeNaDb(usuarioAutenticar);
            if (existe) {    // se existir , direcionar pro menu
                view.dispose(); // metodo ira fechar a janela atual; no caso a TelaLogin
                TelaPrincipal telaDeMenu = new TelaPrincipal();
                telaDeMenu.setVisible(true);
           
                
                
            }else {  // mensagem para o usuario , que não existe seu login na db.
                JOptionPane.showMessageDialog(view, "Login ou Senha invalidos");
            }
        
       
        
        
  
    }
    
    
    
    
}
