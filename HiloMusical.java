/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
/**
 *
 * @author dzuser
 */
public class HiloMusical  implements Runnable {
    
    AdvancedPlayer repro;
    public JFileChooser opina = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("Música en MP3 porfa!!!", "mp3");
    public File rola;
            
    public AdvancedPlayer music() {
        
        try{
            
    opina.setFileFilter(filtro);
    opina.setDialogTitle("Escucha una rolita pa'l desestréssss!!!");
    //String ruteo = JOptionPane.showInputDialog(null, "Escribe la ruta de archivos", "Selecciona ruta");
    //File onde = new File(ruteo);
    //opina.setCurrentDirectory(onde);
    rola = null;
    
    int x = opina.showOpenDialog(null);
    if (x == JFileChooser.APPROVE_OPTION) 
        rola = opina.getSelectedFile();
    repro = new AdvancedPlayer(new FileInputStream (rola));
        
        }
        
        catch(Exception e) {
            System.out.println(e);
        }
        return repro;
    }
    
    public void iniciar() {
                
        try {
            music().play();
            
        } catch (JavaLayerException ex) {
            Logger.getLogger(HiloMusical.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
}
    
    public void escriberola (JLabel jl) {
        jl.setText(opina.getSelectedFile().toString());
    }
    
    
    @Override
    public void run() {
        String orden = Thread.currentThread().getName();
        Dados d = new Dados();
        
        if (orden.equals("dale"))
            iniciar();
        
}
    
}