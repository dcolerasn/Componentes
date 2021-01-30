package beans;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.Serializable;
import javax.swing.JTextField;

public class DniValidador extends JTextField implements Serializable, FocusListener{
    
    public static final String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    
    public DniValidador() {
        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(!valida(getText())) {
            setForeground(Color.RED);   
        }
        else {     
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
    }
   
    private static boolean valida(String dni) {
          String numeroDNI = dni.substring(0,dni.length()-1);
          int numero = Integer.parseInt(numeroDNI);
          String letra = dni.substring(dni.length()-1, dni.length());
          int num = numero%23;
          String letraV = letras.substring(num,num+1);
          
          return letra.equals(letraV);
    }
       
    
}