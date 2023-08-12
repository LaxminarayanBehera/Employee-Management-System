package employee.managemment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class RemoveEmployee extends JFrame implements ActionListener{
    
    Choice cEmpId;
    JButton delete,back;
    
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labelempId=new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 150, 30);
        labelempId.setFont(new Font("sarif",Font.BOLD,20));
        add(labelempId);
        
        cEmpId=new Choice();
        cEmpId.setBounds(220 ,56, 150, 40);
        add(cEmpId);
        
        try{
            Conn c=new Conn();
            String query="select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));
            }
        }catch(Exception d){
            d.printStackTrace();
        }
        
        JLabel labelname =new JLabel("Name:");
        labelname.setBounds(50, 100, 150, 30);
        labelname.setFont(new Font("sarif",Font.BOLD,20));
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200, 100, 150, 30);
        add(lblname);
        
        JLabel labelphone=new JLabel("Phone No:");
        labelphone.setBounds(50, 150, 150, 30);
        labelphone.setFont(new Font("sarif",Font.BOLD,20));
        add(labelphone);
        
        JLabel lblphone=new JLabel();
        lblphone.setBounds(200, 150, 150, 30);
        add(lblphone);
        
        JLabel labelemail=new JLabel("Email:");
        labelemail.setBounds(50, 200, 150, 30);
        labelemail.setFont(new Font("sarif",Font.BOLD,20));
        add(labelemail);
        
        JLabel lblemail=new JLabel();
        lblemail.setBounds(200, 200, 150, 30);
        add(lblemail);
        
        try{
            Conn c=new Conn();
            String query="select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phoneNo"));
                lblemail.setText(rs.getString("email"));
            }
        }catch(Exception d){
            d.printStackTrace();
        }
        
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie){
                
        try{
            Conn c=new Conn();
            String query="select * from employee where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phoneNo"));
                lblemail.setText(rs.getString("email"));
            }
        }catch(Exception d){
            d.printStackTrace();
        }
            }
        });
        
        delete =new JButton("Delete");
        delete.setBounds(80, 300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.addActionListener(this);
        add(delete);
        
        back =new JButton("Back");
        back.setBounds(220, 300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
      
  
        
        setSize(1000,450);
        setLocation(150,50);
        setVisible(true);
     }
        
        public void actionPerformed(ActionEvent d){
            if(d.getSource()== delete){
                try{
                    Conn c=new Conn();
                    String query="delete from employee where empId='"+cEmpId.getSelectedItem()+"'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Employee Infermation Deleted Sucessfully");
                    setVisible(false);
                    
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
                new Home();
            }
        }    
        
    
   
    public static void main(String args[]){
        new RemoveEmployee();
    }
}