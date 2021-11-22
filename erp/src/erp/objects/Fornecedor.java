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

    private int id_fornecedor;
    private String nome_f;
    private String endereco;
    private String cidade;
    private String uf;
    private String cep;
    private String ie;
    private String cnpj;
    private String fone;
    private String email;

    public Fornecedor(String nome_f, String endereco, String cidade, String uf, String cep, String ie, String cnpj, String fone, String email) {
        this.nome_f = nome_f;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.ie = ie;
        this.cnpj = cnpj;
        this.fone = fone;
        this.email = email;
    }

    public Fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public Fornecedor(String nome_f) {
        this.nome_f = nome_f;
    }

    public Fornecedor() {

    }


    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    /**
     * @return the nome_f
     */
    public String getNome_f() {
        return nome_f;
    }

    /**
     * @param nome_f the nome_f to set
     */
    public void setNome_f(String nome_f) {
        this.nome_f = nome_f;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the ie
     */
    public String getIe() {
        return ie;
    }

    /**
     * @param ie the ie to set
     */
    public void setIe(String ie) {
        this.ie = ie;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
