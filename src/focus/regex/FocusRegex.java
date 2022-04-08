/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package focus.regex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.paint.Color;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author julio
 */
public class FocusRegex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      frame fr = new frame();
      fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
}
class frame extends JFrame  implements FocusListener,ActionListener{
    JTextField txt1;
    JTextField txt2;
    JButton btn,btnBlue,btnRed;
    public frame(){
        btn=new JButton("ingresar");
        btn.setBounds(50,350,400,50);
      
        txt1 =new JTextField();
        txt2=new JTextField();
        txt1.setBounds(10,50,350,50);
        txt2.setBounds(10,150,350,50);
        setSize(500,700);
      
        setLocationRelativeTo(null);
        setTitle("expresiones regulares ");
        setResizable(false);
                setLayout(null);
        setVisible(true);
        add(btn);
        add(txt1);
        add(txt2);
        btn.addActionListener(this);
        txt1.addFocusListener(this);
       
       
    }
  
    public static boolean validarEmail(String email){
        
        Pattern patron =  Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        Matcher  matcher=patron.matcher(email);
        return matcher.find();
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (frame.validarEmail(txt1.getText())) {
            JOptionPane.showMessageDialog(null,"correo ingresado satisfactoriamente","mensaje",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"formato de correo incorrecto","mensaje error",JOptionPane.ERROR_MESSAGE);
            txt1.setText("");
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        try{
              int num=Integer.parseInt(txt2.getText());
              num++;
              JOptionPane.showMessageDialog(null, num);
              
        }catch(NumberFormatException ex){
            
            JOptionPane.showMessageDialog(null, ex,"mensaje error",JOptionPane.ERROR_MESSAGE);
            txt2.setText("");
        }
    }
  
}
class Panel extends JPanel{
    public Panel(){
        
       
    }
        class Action extends AbstractAction{
        public Action(String nombre,Icon icono,Color color_btn){
          
            putValue(Action.NAME,nombre);
             putValue(Action.SMALL_ICON,icono);
              putValue(Action.SHORT_DESCRIPTION,"poner lamina color"+nombre);
               putValue("color_de_fondo",color_btn);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c=(Color)getValue("color_de_fondo");
           
        }
        
    }
}

