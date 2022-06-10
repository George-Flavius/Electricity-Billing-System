/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author gflav
 */
public class CustomerDetails extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    String x[]={"Customer Name","Meter Number","Address","City","State","Email","Phone Number"};
    String y[][] = new String[40][18];
    int i=0, j=0;
    CustomerDetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(400,150);
        try{
            Conn c1= new Conn();
            String s1 = "Select * from customer";
            ResultSet rs = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("Name");
                y[i][j++]=rs.getString("Meter");
                y[i][j++]=rs.getString("Address");
                y[i][j++]=rs.getString("City");
                y[i][j++]=rs.getString("State");
                y[i][j++]=rs.getString("Email");
                y[i][j++]=rs.getString("Phone Number");
                i++;
                j=0;
            }
            t1= new JTable(y,x);
        }catch(Exception e){
            e.printStackTrace();
        }
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    public static void main(String[] args){
        new CustomerDetails().setVisible(true);
    }
    
}
