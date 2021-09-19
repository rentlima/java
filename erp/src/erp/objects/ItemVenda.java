package erp.objects;

/*
*@author – Renato Lima
*/
public class ItemVenda extends Produtos{
    
    private Integer idItem;
    private Integer idVenda;
    private Float valorTotal;
    private int qtd_itens;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }
    
    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the qtd_itens
     */
    public int getQtd_itens() {
        return qtd_itens;
    }

    /**
     * @param qtd_itens the qtd_itens to set
     */
    public void setQtd_itens(int qtd_itens) {
        this.qtd_itens = qtd_itens;
    }
}
