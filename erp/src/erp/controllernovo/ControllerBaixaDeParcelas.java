
package erp.controllernovo;

import erp.jdbc.ConnectionFactory;
import erp.objects.BaixaParcelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato
 */
public class ControllerBaixaDeParcelas {
    
    
    public BaixaParcelas buscarParcelas(BaixaParcelas obj){
        
        try {
            
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Statement st = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
        rs = st.executeQuery("select * from parcela_venda where id_parcela_venda ="+obj.getCodParcela());
        rs.first();
        obj.setCodParcela(rs.getInt("id_parcela_venda"));
        obj.setCodVenda(rs.getInt("cod_venda"));
        obj.setDatavenc(rs.getString("datavenc"));
        obj.setValor(rs.getFloat("valor_parcela"));
        
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO : " +e);
            
        }
        return obj;
  
        
    }
    
    public void baixarParcelas(BaixaParcelas obj){
       
        try {
        Connection con = ConnectionFactory.getConnection();
        ResultSet rs = null;
        Statement st = con.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
        rs = st.executeQuery("select * from parcela_venda where id_parcela_venda ="+obj.getCodParcela()+"  and situacao = 'PAGO' ");
            
        if (rs.first()) {
                
                JOptionPane.showMessageDialog(null, "Está Parcela já está paga.");
            
            }else {
             
        try {

        String sql = "update parcela_venda set situacao = ? where id_parcela_venda = ? ";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, "PAGO");
        stm.setInt(2, obj.getCodParcela());
        stm.execute();
        stm.close();
        
        JOptionPane.showMessageDialog(null, "Parcela Baixada.");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }
            }

        
        
        
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro : " + e);
        }
        
        
        
        
        
        
        
        
    }

}
