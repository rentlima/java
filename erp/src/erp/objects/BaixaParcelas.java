
package erp.objects;

/**
 *
 * @author Renato
 */
public class BaixaParcelas {
    
    
    
    
    private int codParcela;
    private String datavenc;
    private int codVenda;
    private float valor ;

    /**
     * @return the codParcela
     */
    public int getCodParcela() {
        return codParcela;
    }

    /**
     * @param codParcela the codParcela to set
     */
    public void setCodParcela(int codParcela) {
        this.codParcela = codParcela;
    }

    /**
     * @return the datavenc
     */
    public String getDatavenc() {
        return datavenc;
    }

    /**
     * @param datavenc the datavenc to set
     */
    public void setDatavenc(String datavenc) {
        this.datavenc = datavenc;
    }

    /**
     * @return the codVenda
     */
    public int getCodVenda() {
        return codVenda;
    }

    /**
     * @param codVenda the codVenda to set
     */
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

}
