/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.controller;

import erp.dao.UsuariosDAO;
import erp.jdbc.ConnectionFactory;
import erp.objects.Usuarios;
import erp.telas.CadastroLogin;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class CadastroLoginController {

    private CadastroLogin view;

    public CadastroLoginController(CadastroLogin view) {
        this.view = view;
    }

    public CadastroLoginController() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void salvarUsuario() {

        String login = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        Usuarios usuarioAutenticar = new Usuarios(login);
        Usuarios usuario = new Usuarios(login, senha);
        try {
            boolean existe = new UsuariosDAO().existeUserNaDB(usuarioAutenticar);
            if (existe) {
                JOptionPane.showMessageDialog(null, "Nome de usuário já cadastrado.");
            } else {

                try {
                    if (view.getjTextFieldUsuario().getText().isEmpty()
                            || view.getjPasswordFieldSenha().getText().isEmpty()
                            || view.getTxtConfirmaSenha().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos");

                    } else {
                        Connection conexao = new ConnectionFactory().getConnection();

                        UsuariosDAO usuariosDao = new UsuariosDAO(conexao);

                        usuariosDao.adicionarUsuario(usuario);

                        JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso.");

                        view.dispose();
                        /* metodo ira fechar a janela atual , no caso 
                               dessa seria a tela de CadastroLogin
                         */

                    }

                } catch (Exception ex) {

                }

            }

        } catch (Exception e) {
            Logger.getLogger(CadastroLogin.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
