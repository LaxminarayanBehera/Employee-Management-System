package employee.managemment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    Splash(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);  
        
        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(190,30,1200,70);
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.orange);
        add(heading);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton b=new JButton("Click hear to continue");
        b.setBounds(440,440,300,50);
        b.setBackground(Color.black);
        b.setForeground(Color.white);
        b.addActionListener(this);
        image.add(b);
        
        setSize(1170,650);
        setLocation(50,20);
        setVisible(true);
        
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
            
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                
            }
        }
        
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login();
        
    }
    
    
    public static void main(String args[]){
        new Splash();
    }
    
}
