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
public class Produtos {
    private int codigo;
    private String nome_P;
    private String tipo;
    private String marca;
    private String modelo;
    private double valor;
    private int quantidade;

    public Produtos() {
    }

    
    public Produtos(int codigo, String nome_P, String tipo, String marca, String modelo, double valor, int quantidade) {
        this.codigo = codigo;
        this.nome_P = nome_P;
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    

    public Produtos(int codigo) {
        this.codigo = codigo;
    }

    public Produtos(String modelo) {
        this.modelo = modelo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome_P() {
        return nome_P;
    }

    public void setNome_P(String nome_P) {
        this.nome_P = nome_P;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
}
