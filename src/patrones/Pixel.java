package patrones;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Pixel extends JPanel {

    private boolean estado = false;
    Border border = LineBorder.createBlackLineBorder();
    
    public Pixel(double dato){
        setBorder(border);
        if(dato== 0){
            setBackground(Color.WHITE);
        }
        else {
            if(dato== 1)
                setBackground(Color.black);
        }
        
    }

    public boolean estadoCelula(){
        return estado;
    }
}
