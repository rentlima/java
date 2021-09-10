/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.objects;

/**
 *
 * @author Renato
 */
public class Fornecedor {
    
    String nome_f;
    int id_fornecedor;

    public Fornecedor(String nome_f, int id_fornecedor) {
        this.nome_f = nome_f;
        this.id_fornecedor = id_fornecedor;
    }

    public Fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public Fornecedor(String nome_f) {
        this.nome_f = nome_f;
    }
    

    public Fornecedor() {
        
    }

    public String getNome() {
        return nome_f;
    }

    public void setNome(String nome_f) {
        this.nome_f = nome_f;
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }
    
    
    
    
}
