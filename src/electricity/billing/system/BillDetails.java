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
import net.proteanit.sql.DbUtils;
/**
 *
 * @author gflav
 */
public class BillDetails extends JFrame{
    JTable t1;
    String x[] = {"Meter Number","Month","Units","Total Bill","Status"};
    String y[][] = new String[40][8];
    int i=0, j=0;
    BillDetails(String meter){
        super("Bill Details");
        setSize(700,650);
        setLocation(600,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);        
        t1 = new JTable(y,x);        
        try{
            Conn c  = new Conn();
            String s1 = "select * from bill where meter = " + meter;
            ResultSet rs  = c.s.executeQuery(s1);
            
            t1.setModel(DbUtils.resultSetToTableModel(rs));            
        }catch(Exception e){
            e.printStackTrace();
        }
                
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(0, 0, 700, 650);
        add(sp);        
    }
    
    public static void main(String[] args){
        new BillDetails("").setVisible(true);
    }   
}
