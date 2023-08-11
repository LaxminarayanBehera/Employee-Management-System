package employee.managemment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login  extends JFrame implements ActionListener{
    
    JTextField tfu,tfp;
    
    Login(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel username=new JLabel("User name");
        username.setBounds(40,20,100,30);
        add(username);
        
        tfu=new JTextField();
        tfu.setBounds(150, 20, 150, 30);
        add(tfu);
       
        JLabel pass=new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        
        tfp=new JTextField();
        tfp.setBounds(150, 70, 150, 30);
        add(tfp);
        
  
        
        JButton jbc=new JButton("Click");
        jbc.setBounds(150,140,150,30);
        jbc.setBackground(Color.black);
        jbc.setForeground(Color.white);
        jbc.addActionListener(this);
        add(jbc);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/user.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username=tfu.getText();
            String password=tfp.getText();
            Conn c=new Conn();
            String query="select * from login where username ='"+username+"' and password='"+password+"'";
            //Statement st = conn.createStatement();
            ResultSet rs=c.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new Home();
            }else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
                }catch(Exception e){
                    e.printStackTrace();
                }
    }

  
        
    public static void main(String args[]){
     new Login();
    }
 }

