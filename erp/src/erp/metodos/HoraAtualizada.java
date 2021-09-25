
package erp.metodos;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Renato
 */
public class HoraAtualizada {
    
    
    public static void start(final JLabel labelhorario) {
        Thread atualizaHora  = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        Date date = new Date();
                        StringBuffer data = new StringBuffer();
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                        labelhorario.setText(data.toString() + sdf.format(date));
                        Thread.sleep(1000);
                        labelhorario.revalidate();
                    }
                } catch (Exception ex) {
                     ex.printStackTrace();
                }
                
                
                
            }
        });
        
        atualizaHora.start();
        
                }
        
        
        
    }
    
    


