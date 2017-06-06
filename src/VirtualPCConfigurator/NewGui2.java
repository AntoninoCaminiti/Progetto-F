/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPCConfigurator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Utente
 */
public class NewGui2{
    Calculator calc = new Calculator();
    Watt wt = new Watt();
    Configuration cf = new Configuration();
     DecimalFormat dc = new DecimalFormat("0.00 €");
     DecimalFormat dc1 = new DecimalFormat("0.00 W");
     
     
    Double cpuPrice;
    Double mbPrice;
    Double hdrivePrice;
    Double gcardPrice;
    Double psPrice;
    Double ramPrice;
     
     
    private String user = "sql11176424";
    private String pass = "fDFSkH9nVq";
        
    Connection conn;
    Statement mystmt;
    ResultSet res;
     
    JList list1 = new JList();
    JList list2 = new JList();
    JList list3 = new JList();
    JList list4 = new JList();
    JList list5 = new JList();
    JList list6 = new JList();

             
        final JTextField T1= new JTextField();
        final JTextField T2= new JTextField();
        final JTextField T3= new JTextField();
        final JTextField T4= new JTextField(); 
        final JTextField T6 = new JTextField();
        final JTextField T7= new JTextField();
        
        
        final JTextField T5 = new JTextField();
        final JTextField T8 = new JTextField();
    
    
    
     public NewGui2(){
         
        JFrame JF = new JFrame();
        
        JButton showConf = new JButton("Show configuration");
        showConf.setBounds(600,600,190,25);
        
        JPanel P1 = new JPanel();
        JScrollPane jp1 = new JScrollPane(P1);
        JPanel P2 = new JPanel();
        JScrollPane jp2 = new JScrollPane(P2);
        JPanel P3 = new JPanel();
        JScrollPane jp3 = new JScrollPane(P3);
        JPanel P4 = new JPanel();
        JScrollPane jp4 = new JScrollPane(P4);
        JPanel P5 = new JPanel();
        JScrollPane jp5 = new JScrollPane(P5);
        JPanel P6= new JPanel();
        JScrollPane jp6 = new JScrollPane(P6);

        
        JLabel L1= new JLabel("Processore: ");
        JLabel L2= new JLabel("Memory: ");
        JLabel L3= new JLabel("HDD: ");
        JLabel L4= new JLabel("Graphics Card: ");
        JLabel L5= new JLabel("Motherboard: ");
        JLabel L6= new JLabel("PS: ");
        
        DefaultListModel model=new DefaultListModel();
       
        
        
        
        list1=new JList(model);
        try
        {
            Connect();
            res = mystmt.executeQuery("select * from cpu");
            
            while(res.next())
            {
                
                model.addElement(res.getString(1)+" "+res.getString(2));
                cpuPrice = res.getDouble(8);
                P1.add(list1);
                list1.setVisibleRowCount(1);
               
            list1.addListSelectionListener(new ListSelectionListener() {  
              
                public void valueChanged(ListSelectionEvent e) {   
                    String data = "";  
                    
                    if (list1.getSelectedIndex() != -1) {                       
                    data =  (String) list1.getSelectedValue();
                        
                    T1.setText(data);
                    
                        cf.saveCPU(data);
                    Calculate();
                    
                   } 
                    
                }
            });    
        }
            
        }
        catch(SQLException ex)
        {
            
        }
        
         DefaultListModel model1=new DefaultListModel();
                
        list2=new JList(model1);
        try
        {
            Connect();
            res = mystmt.executeQuery("select * from RAM");
            while(res.next())
            {
                
                model1.addElement(res.getString(1)+" "+res.getString(2)+" "+res.getInt(6)+" "+res.getInt(7)+"GB");
                ramPrice = res.getDouble(9);
                
                P2.add(list2);
                list2.setVisibleRowCount(1);
               
            list2.addListSelectionListener(new ListSelectionListener() {  
              
                public void valueChanged(ListSelectionEvent e) {   
                    String data = "";  
                    
                    if (list2.getSelectedIndex() != -1) {                       
                    data =  (String) list2.getSelectedValue();   
                    T2.setText(data);
                    cf.saveRAM(data);
                    
                    Calculate();
                   } 
                    
                }
            });    
        }
         
        }
        catch(SQLException ex)
        {
            
        }
        
        DefaultListModel model2=new DefaultListModel();
                
        list3=new JList(model2);
        try
        {
            Connect();
            res = mystmt.executeQuery("select * from hdrive");
            while(res.next())
            {
                
                model2.addElement(res.getString(1)+" "+res.getString(2)+" "+res.getInt(6)+"GB");
               
                hdrivePrice = res.getDouble(9);
                //final JList list1=new JList(model1);
                
                P3.add(list3);
                list3.setVisibleRowCount(1);
               
            list3.addListSelectionListener(new ListSelectionListener() {  
              
                public void valueChanged(ListSelectionEvent e) {   
                    String data = "";  
                    
                    if (list3.getSelectedIndex() != -1) {                       
                    data =  (String) list3.getSelectedValue();   
                    T3.setText(data);
                    cf.saveHDrive(data);
                    
                    Calculate();
                   } 
                    
                }
            });    
        }
            
        }
        catch(SQLException ex)
        {
            
        }
        
        DefaultListModel model3=new DefaultListModel();
                
        list4=new JList(model3);
        try
        {
            Connect();
            res = mystmt.executeQuery("select * from motherboard");
            while(res.next())
            {
                
                model3.addElement(res.getString(1)+" "+res.getString(2));
               
                mbPrice = res.getDouble(9);
                //final JList list1=new JList(model1);
                
                P4.add(list4);
                list4.setVisibleRowCount(1);
               
            list4.addListSelectionListener(new ListSelectionListener() {  
              
                public void valueChanged(ListSelectionEvent e) {   
                    String data = "";  
                    
                    if (list4.getSelectedIndex() != -1) {                       
                    data =  (String) list4.getSelectedValue();   
                    T4.setText(data);
                    cf.saveMB(data);
                    
                    Calculate();
                   } 
                    
                }
            });    
        }
            
        }
        catch(SQLException ex)
        {
            
        }
        DefaultListModel model4=new DefaultListModel();
                
        list5=new JList(model4);
        try
        {
            Connect();
            res = mystmt.executeQuery("select * from gcard");
            while(res.next())
            {
                
                model4.addElement(res.getString(1)+" "+res.getString(2));
               
                
                gcardPrice = res.getDouble(8);
                //final JList list1=new JList(model1);
                
                P5.add(list5);
                list5.setVisibleRowCount(1);
               
            list5.addListSelectionListener(new ListSelectionListener() {  
              
                public void valueChanged(ListSelectionEvent e) {   
                    String data = "";  
                    
                    if (list5.getSelectedIndex() != -1) {                       
                    data =  (String) list5.getSelectedValue();   
                    T5.setText(data);
                    cf.saveGCard(data);
                    
                    Calculate();
                   } 
                    
                }
            });    
        }
            
        }
        catch(SQLException ex)
        {
            
        }
        DefaultListModel model5=new DefaultListModel();
                
        list6=new JList(model5);
        try
        {
            Connect();
            res = mystmt.executeQuery("select * from PS");
            while(res.next())
            {
                
                model5.addElement(res.getString(1)+" "+res.getString(2));
               
                psPrice = res.getDouble(8);
                //final JList list1=new JList(model1);
                
                P6.add(list6);
                list6.setVisibleRowCount(1);
               
            list6.addListSelectionListener(new ListSelectionListener() {  
              
                public void valueChanged(ListSelectionEvent e) {   
                    String data = "";  
                    
                    if (list6.getSelectedIndex() != -1) {                       
                    data =  (String) list6.getSelectedValue();   
                    T6.setText(data);
                    cf.savePS(data);
                       
                    Calculate();
                   } 
                    
                }
            });    
        }
           
        }
        catch(SQLException ex)
        {
        }  
        
        
        
        
        
        showConf.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent ae)
            {
                showConfig();
                
            }
            
        
        });
        
        
     JF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
     JF.getContentPane();  
     
     JF.add(showConf);
     
     JF.add(jp1);
     JF.add(jp2);
     JF.add(jp3);
     JF.add(jp4);
     JF.add(jp5);
     JF.add(jp6);
     
     JF.add(T1);
     JF.add(T2);
     JF.add(T3);
     JF.add(T4);
     JF.add(T5);
     JF.add(T6);
     JF.add(T7);
     JF.add(T8);
     
     
     P1.add(list1);
     P2.add(list2);
     P3.add(list3);
     P4.add(list4);
     P5.add(list5);
     P6.add(list6);
     JF.setSize(1000, 1000);
     JF.setLayout(null);
     JF.setVisible(true);
     
     jp1.setBounds(0,10,180,200);
     jp2.setBounds(290, 10, 270, 200);
     jp3.setBounds(0, 220, 290, 200);
     jp4.setBounds(290, 220, 290, 200);
     jp5.setBounds(0, 430, 270, 200);
     jp6.setBounds(290, 430, 290, 200);
     
     
     T1.setBounds(590,10,300,25);
     T2.setBounds(590,50,300,25);
     T3.setBounds(590,100,300,25);
     T4.setBounds(590,150,300,25);
     T5.setBounds(590,200,300,25);
     T6.setBounds(590,250,300,25);
     T7.setBounds(590,300,300,25);
     T8.setBounds(590,350,300,25);
   
  }
     
     public void showConfig()
     {
         System.out.println("Your configuration is: ");
         System.out.println("CPU: " + cf.getCPU());
         System.out.println("Motherboard: " + cf.getMB());
         System.out.println("RAM: " + cf.getRAM());
         System.out.println("Power Supply: " + cf.getPS());
         System.out.println("HardDrive: " + cf.getHDrive());
         System.out.println("Graphics Card: " + cf.getGCard());
     }
     
     
     
    public void Connect() throws SQLException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            conn = DriverManager.getConnection("jdbc:mysql://sql11.freesqldatabase.com:3306/sql11176424?autoReconnect=true&useSSL=false", user, pass);
            mystmt = conn.createStatement();
            
            }
        catch(Exception ex)
        {
            System.err.println("Errore. Database non trovato");
        }
        
            
    }
    
    public Boolean setUP(String user, String pass)
    {
        if(!user.equals("") && !pass.equals(""))
        {
            this.user = user;
            
            this.pass = pass;
            
            return true;
        }
        else
            return false;
    }
    
    //close all connection from MySQL database
    public void closeall() throws SQLException
    {
        
            if(conn!=null)
            {
            conn.close();
            }
            if(mystmt !=null)
            {
            mystmt.close();
            }
            if(res!=null)
            {
            res.close();
            }
            System.out.println("MySQL connection closed");
        
    }
    
    public void Calculate(){
        
        //Clears the calculator object:
        calc.ClearCalc();
        wt.ClearWatt();
        
        //If anything in the text box, clear it:
        
        T7.setText("");
        
        //Local variable to hold subtotal:
        double dblSubTotal;
        int intSubTotal;
        String strSubTotal;
        String strSubTotal1;
        
         
        //Processor: Add base system price to subtotal:
        if (list1.getSelectedIndex()!= -1){
            calc.AddToSubTotal(cpuPrice);
            //wt.AddToSubTotal(upANDadd.GetIntProc01());
            dblSubTotal = calc.GetSubTotal();
            intSubTotal = wt.GetSubTotal();
        }
        
        
        //Memory: Add  base system price to subtotal:
        
         if (list2.getSelectedIndex()!= -1){
            calc.AddToSubTotal(ramPrice);
            //wt.AddToSubTotal(upANDadd.GetIntProc01());
            dblSubTotal = calc.GetSubTotal();
            intSubTotal = wt.GetSubTotal();
        }
          
        //HDD: Add  base system price to subtotal:
        
        if (list3.getSelectedIndex()!= -1){
            calc.AddToSubTotal(hdrivePrice);
            //wt.AddToSubTotal(upANDadd.GetIntProc01());
            dblSubTotal = calc.GetSubTotal();
            intSubTotal = wt.GetSubTotal();
        }
        
         //GC: Add  base system price to subtotal:
        
         if (list4.getSelectedIndex()!= -1){
            calc.AddToSubTotal(gcardPrice);
            //wt.AddToSubTotal(upANDadd.GetIntProc01());
            dblSubTotal = calc.GetSubTotal();
            intSubTotal = wt.GetSubTotal();
        }
        
        // Motherboard 
        
        if (list5.getSelectedIndex()!= -1){
            calc.AddToSubTotal(mbPrice);
            //wt.AddToSubTotal(upANDadd.GetIntProc01());
            dblSubTotal = calc.GetSubTotal();
            intSubTotal = wt.GetSubTotal();
        }
        
        
         if (list5.getSelectedIndex()!= -1){
            calc.AddToSubTotal(psPrice);
            //wt.AddToSubTotal(upANDadd.GetIntProc01());
            dblSubTotal = calc.GetSubTotal();
            intSubTotal = wt.GetSubTotal();
        }
      
        
        
          //Call calculator object to get subtotal:
        dblSubTotal = calc.GetSubTotal();
        intSubTotal = wt.GetSubTotal();
        
        //Uses the DecimalFormat object to convert to currency:
        strSubTotal = dc.format(dblSubTotal);  
        strSubTotal1 = dc1.format(intSubTotal);
        
        //Displays in text box:
        T5.setText(strSubTotal);
        T8.setText(strSubTotal1);
        
    }
    
    public static void main (String[] args){
         NewGui2 ng2=new NewGui2();
         
    }
     
}

