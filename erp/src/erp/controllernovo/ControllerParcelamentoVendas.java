
package erp.controllernovo;

import erp.jdbc.ConnectionFactory;
import erp.objects.ModeloParcelamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class ControllerParcelamentoVendas {


    
    
    public void salvarParcelas(ModeloParcelamento obj) {
         Connection con = ConnectionFactory.getConnection();
       try{ 
       
        String sql = "INSERT INTO parcela_venda (cod_venda ,valor_venda , valor_total , numero_parcela , valor_parcela , datavenc) values (?,?,?,?,?,?) ";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, obj.getCodVenda());
        st.setFloat(2, obj.getValor_venda());
        st.setFloat(3, obj.getValor_total());
        st.setInt(4, obj.getNumeroParc());
        st.setFloat(5, obj.getValorParcela());
        st.setString(6, obj.getDataVenc());
        st.execute();
        
        
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"ERRO : " + e);
       }
        
      
        
    }
}

