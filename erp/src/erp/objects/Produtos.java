package erp.objects;

/**
 *
 * @author Renato
 */
public class Produtos  {
    
    private Integer codigo;
    private String nome_P;
    private String tipo;
    private Integer quantidade;
    private Float custo_c;
    private Float valor_v;
    private String cod_forn;

    public Produtos() {
    }
    
    public String getCod_forn() {
        return cod_forn;
    }

    public void setCod_forn(String cod_forn) {
        this.cod_forn = cod_forn;
    }

    public Produtos(int codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public Float getCusto_c() {
        return custo_c;
    }

    public void setCusto_c(Float custo_c) {
        this.custo_c = custo_c;
    }

    public Float getValor_v() {
        return valor_v;
    }

    public void setValor_v(Float valor_v) {
        this.valor_v = valor_v;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    

    
    
    
    
}
