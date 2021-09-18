
package erp.objects;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Renato
 */
public class ModeloTabela extends AbstractTableModel {
    
    private ArrayList linhas=null;
    private String[] colunas =null;
    
    
    public ModeloTabela(ArrayList lin,String[] col){
        setLinhas(lin);
        setColunas(col);
        
    }
    

    
    public ArrayList getLinhas(){
        return linhas;
    }
    public void setLinhas(ArrayList lin){
        linhas = lin;
    }
    public String[] getColunas(){
        return colunas;
    }
    public void setColunas(String[] col){
        colunas = col;
    }
    
    public int getColumnCount(){
        return colunas.length;
    }
    
    public int getRowCount(){
        return linhas.size();
    }
    
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    public Object getValueAt(int numLin,int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
    public void removeRow(int row) {
        linhas.remove(row);
    }
    

}
