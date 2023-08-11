package employee.managemment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener{
   
    
    JTextField tfdegree,tffname,tfsal,tfadd,tfpn,tfmail,tfdeg,tfan;
    JLabel tfid;
    JButton aad,ad;   
    String empId;
    
    UpdateEmployee(String empId){
        
        this.empId= empId;
  
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 40);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);
      
        JLabel lname=new JLabel("Name:");
        lname.setBounds(50, 100, 150, 30);
        lname.setFont(new Font("serif",Font.BOLD,20));
        add(lname);
        
        JLabel lab=new JLabel();
        lab.setBounds(200, 100, 150, 30);
        add(lab);
        
        
        JLabel lfaname=new JLabel("Father's Name:");
        lfaname.setBounds(50, 150, 150, 30);
        lfaname.setFont(new Font("serif",Font.BOLD,20));
        add(lfaname);
        
        tffname=new JTextField();
        tffname.setBounds(200, 150, 150, 30);
        add(tffname);
        
        JLabel ldfname=new JLabel("Date Of Birth:");
        ldfname.setBounds(50, 200, 150, 30);
        ldfname.setFont(new Font("serif",Font.BOLD,20));
        add(ldfname);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);
        
        JLabel lsalary=new JLabel("Salary:");
        lsalary.setBounds(50, 250, 150, 30);
        lsalary.setFont(new Font("serif",Font.BOLD,20));
        add(lsalary);
        
        tfsal=new JTextField();
        tfsal.setBounds(200, 250, 150, 30);
        add(tfsal);
        
        JLabel ladd=new JLabel("Addres:");
        ladd.setBounds(50, 300, 150, 30);
        ladd.setFont(new Font("serif",Font.BOLD,20));
        add(ladd);
        
        tfadd=new JTextField();
        tfadd.setBounds(200, 300, 150, 30);
        add(tfadd);       
        
        JLabel lphone=new JLabel("Phone No:");
        lphone.setBounds(50, 350, 150, 30);
        lphone.setFont(new Font("serif",Font.BOLD,20));
        add(lphone);
        
        tfpn=new JTextField();
        tfpn.setBounds(200, 350, 150, 30);
        add(tfpn);
        
        JLabel lmail=new JLabel("Email:");
        lmail.setBounds(50, 400, 150, 30);
        lmail.setFont(new Font("serif",Font.BOLD,20));
        add(lmail);
        
        tfmail=new JTextField();
        tfmail.setBounds(200, 400, 150, 30);
        add(tfmail);
        
        JLabel lhe=new JLabel("Higest Degree:");
        lhe.setBounds(50, 450, 150, 30);
        lhe.setFont(new Font("serif",Font.BOLD,20));
        add(lhe);
        
        tfdegree=new JTextField();
        tfdegree.setBounds(200, 450, 150, 30);
        add(tfdegree);
        
        
        JLabel ldeg=new JLabel("Designation:");
        ldeg.setBounds(500, 100, 150, 30);
        ldeg.setFont(new Font("serif",Font.BOLD,20));
        add(ldeg);
        
        tfdeg=new JTextField();
        tfdeg.setBounds(650, 100, 150, 30);
        add(tfdeg);
        
        JLabel ladn=new JLabel("Aadhar No:");
        ladn.setBounds(500, 150, 150, 30);
        ladn.setFont(new Font("serif",Font.BOLD,20));
        add(ladn);
        
        JLabel lbladhar=new JLabel();
        lbladhar.setBounds(650, 150, 150, 30);
        add(lbladhar);
        
        JLabel lemp=new JLabel("Employee Id:");
        lemp.setBounds(500, 200, 150, 30);
        lemp.setFont(new Font("serif",Font.BOLD,20));
        add(lemp);
        
        tfid=new JLabel();
        tfid.setBounds(650, 200, 150, 30);
        tfid.setFont(new Font("serif",Font.BOLD,20));
        add(tfid);
        
        try{
            Conn con=new Conn();
            String query = "select * from employee where empid ='"+empId+"'";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next()){
               lab.setText(rs.getString("name"));
               tffname.setText(rs.getString("fname"));
               lbldob.setText(rs.getString("dob"));
               tfsal.setText(rs.getString("salary"));
               tfadd.setText(rs.getString("address"));
               tfpn.setText(rs.getString("phoneNo"));
               tfmail.setText(rs.getString("Email"));
               tfdegree.setText(rs.getString("degree"));
               tfdeg.setText(rs.getString("Designation"));
               lbladhar.setText(rs.getString("AadharNo"));
               tfid.setText(rs.getString("empId"));
               

            }
            
            
        }catch(Exception a){
            a.printStackTrace();
        }
        
        
        
        
        aad=new JButton("Updatet Details");
        aad.setBounds(500,300,150,40);
        aad.setBackground(Color.black);
        aad.setForeground(Color.white);
        aad.addActionListener(this);
        add(aad);
        
        ad=new JButton("Back");
        ad.setBounds(670,300,150,40);
        ad.setBackground(Color.black);
        ad.setForeground(Color.white);
        ad.addActionListener(this);
        add(ad);
        
        
        setSize(900,600);
        setLocation(200,40);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==aad){
           
            String fname=tffname.getText();
            String salary=tfsal.getText();
            String address=tfadd.getText();
            String phone=tfpn.getText();
            String email=tfmail.getText();
            String degree=tfdegree.getText();
            String degisnation=tfdeg.getText();
            
            
            try{
                Conn con=new Conn();
                String Query="update employee set fname='"+fname+"',salary ='"+salary+"', address= '"+address+"',phoneNo = '"+phone+"',email= '"+email+"',degree ='"+degree+"',Designation= '"+degisnation+"'  where empId = '"+empId+"'";
                con.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null, "Details update successfully");
                setVisible(false);
                new Home();
                
                
                
                
            }catch(Exception afe){
               afe.printStackTrace();
            } 
        }else{
            setVisible(false);
            new Home();
        }
    } 
    
    public static  void main(String args[]){
        new UpdateEmployee("");
    }
    
}
