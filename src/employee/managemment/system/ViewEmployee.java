package employee.managemment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class ViewEmployee extends JFrame implements ActionListener{
    
    JTable table;
    Choice cemp;
    JButton search,print,update,back;
    
    ViewEmployee(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel scb=new JLabel("Search by employee Id");
        scb.setBounds(20, 20, 250, 30);
        scb.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        add(scb);
        
        cemp=new Choice();
        cemp.setBounds(280, 27, 150, 30);
        add(cemp);
        
        
        table =new JTable();
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
           
            while(rs.next()){
                cemp.add(rs.getString("empId"));
            } 
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
         
        }catch(Exception e){
            e.printStackTrace();
        
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,60);
        add(jsp);
        
        search =new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this); 
        add(search);
        
        print =new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this); 
        add(print);
       
        
        update =new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this); 
        add(update);
        
        
        back =new JButton("Back");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this); 
        add(back);
        
        
        
        setSize(900,600);
        setLocation(200,50);
        setVisible(true);
        
    
    }
    
    public void actionPerformed(ActionEvent a){
     if(a.getSource()==search){   
         String query="select * from employee where empId = '"+cemp.getSelectedItem()+"'";
         try {
             Conn c=new Conn();
             ResultSet rs=c.s.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(rs));
         }catch(Exception f){
             f.printStackTrace();
         }
         
    }else if(a.getSource()==print){
        try {
            table.print();
        }catch(Exception s){
            s.printStackTrace();
            
        }
        
    }else if(a.getSource()==update){
        setVisible(false);
        new UpdateEmployee(cemp.getSelectedItem());
        
    }else{
        setVisible(false);
        new Home();
    }
    }
    public static void main(String args[]){
        new ViewEmployee();
    }
}
