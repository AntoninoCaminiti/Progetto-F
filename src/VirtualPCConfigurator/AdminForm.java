/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPCConfigurator;


import Components.GCardLoader;
import Components.HDriveLoader;
import Components.MBLoader;
import Components.CPULoader;
import Components.RAMLoader;
import Components.PSLoader;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;




/**
 *
 * @author user
 */
public class AdminForm {
    
    DBConnection dbconn = new DBConnection();
    CPULoader cp1 = new CPULoader();
    MBLoader mb1 = new MBLoader();
    PSLoader ps1 = new PSLoader();
    RAMLoader ram = new RAMLoader();
    GCardLoader gc1 = new GCardLoader();
    HDriveLoader hd1 = new HDriveLoader();
    
    JFrame jf = new JFrame("VPCC");
    
    JPanel plogin = new JPanel();
    JPanel pcomps = new JPanel();
    JPanel pCPU = new JPanel();
    JPanel pMB = new JPanel();
    JPanel pPS = new JPanel();
    JPanel pRAM = new JPanel();
    JPanel pGCard = new JPanel();
    JPanel pHDrive = new JPanel();
    
    JTextField username = new JTextField();
    JPasswordField pass = new JPasswordField();
    
    JButton jbtlogin = new JButton("Login");
    JButton jbtShowCPU = new JButton("CPU");
    JButton jbtCPU = new JButton("Add CPU");
    JButton jbtShowMB = new JButton("MotherBoard");
    JButton jbtMB = new JButton("Add MotherBoard");
    JButton jbtShowPS = new JButton("PowerSupply");
    JButton jbtPS = new JButton("Add PowerSupply");
    JButton jbtShowRAM = new JButton("RAM");
    JButton jbtRAM = new JButton("Add RAM");
    JButton jbtShowGCard = new JButton("Graphics Card");
    JButton jbtGCard = new JButton("Add Graphics Card");
    JButton jbtShowHDrive = new JButton("Hard Drive");
    JButton jbtHDrive = new JButton("Add Hard Drive");
    
    
    JButton deleteCPU = new JButton("Remove");
    JButton deleteMB = new JButton("Remove");
    JButton deletePS = new JButton("Remove");
    JButton deleteRAM = new JButton("Remove");
    JButton deleteGCard = new JButton("Remove");
    JButton deleteHDrive = new JButton("Remove");
    
    JButton clearInfo = new JButton("Clear data");
    JButton view = new JButton("View DB");
    JButton disconnect = new JButton("Disconnect");
    JButton exit = new JButton("Exit");
    
    JLabel jlbuser = new JLabel("Username");
    JLabel jlbpass = new JLabel("Password");
    JLabel jlblogin = new JLabel("Login to");
    JLabel jlbcomps = new JLabel("Components database");
    //String
    JLabel jLOne = new JLabel();
    JLabel jLTwo = new JLabel();
    JLabel jLThree = new JLabel();
    JLabel jLFour = new JLabel();
    JLabel jLFive = new JLabel();
    JLabel jLSix = new JLabel();
    //Int
    JLabel jLSeven = new JLabel();
    JLabel jLEight = new JLabel();
    JLabel jLNine = new JLabel();
    JLabel jLX = new JLabel();
    JLabel jLXI = new JLabel();
    //Double
    JLabel jLXII = new JLabel();
    JLabel jLXIII = new JLabel();
    
    //Strings
    JTextField jSOne = new JTextField("");
    JTextField jSTwo = new JTextField("");
    JTextField jSThree = new JTextField("");
    JTextField jSFour = new JTextField("");
    JTextField jSFive = new JTextField("");
    JTextField jSSix = new JTextField("");
    //Integers
    JTextField jI1 = new JTextField("");
    JTextField jI2 = new JTextField("");
    JTextField jI3 = new JTextField("");
    JTextField jI4 = new JTextField("");
    JTextField jI5 = new JTextField("");
    //Doubles
    JTextField jD1 = new JTextField("");
    JTextField jD2 = new JTextField("");
    
    JTable jCPU = new JTable();
    JTable jMB = new JTable();
    JTable jPS = new JTable();
    JTable jRAM = new JTable();
    JTable jGCard = new JTable();
    JTable jHDrive = new JTable();
    JScrollPane spCPU;
    JScrollPane spMB;
    JScrollPane spPS;
    JScrollPane spRAM;
    JScrollPane spGCard;
    JScrollPane spHDrive;
    DefaultTableModel cpuModel;
    DefaultTableModel mbModel;
    DefaultTableModel psModel;
    DefaultTableModel ramModel;
    DefaultTableModel gcardModel;
    DefaultTableModel hdriveModel;
    Object[] row;
    String buffer;
    Boolean selected = false;
    
    
    public AdminForm()
    {
        
        
        jbtlogin.setBounds(150, 190, 100, 30);
        username.setBounds(150,90,100,30);
        pass.setBounds(150, 140, 100, 30);
        jlbuser.setBounds(164, -20, 100, 30);
        jlbuser.setSize(150,200);
        jlbpass.setBounds(164, 30, 100, 30);
        jlbpass.setSize(200,200);
        jlblogin.setBounds(164, 10, 100, 30);
        jlblogin.setSize(250,20);
        jlbcomps.setBounds(120, 30, 100, 30);
        jlbcomps.setSize(250,20);
        
        view.setBounds(0, 0, 100,30);
        exit.setBounds(720,440,100,30);
        
        disconnect.setBounds(600, 440, 120,30);
        disconnect.setEnabled(false);
        
        clearInfo.setBounds(10,140,120,30);
        jbtShowCPU.setBounds(10,20,100,30);
        jbtCPU.setBounds(10,111,100,30);
        jbtCPU.setVisible(false);
        jbtShowMB.setBounds(105,20,140,30);
        jbtMB.setBounds(10,111,160,30);
        jbtMB.setVisible(false);
        jbtShowPS.setBounds(244,20,140,30);
        jbtPS.setBounds(10,111,160,30);
        jbtPS.setVisible(false);
        jbtShowRAM.setBounds(383,20,140,30);
        jbtRAM.setBounds(10,111,100,30);
        jbtRAM.setVisible(false);
        jbtShowGCard.setBounds(522,20,140,30);
        jbtGCard.setBounds(10,111,170,30);
        jbtGCard.setVisible(false);
        jbtShowHDrive.setBounds(661,20,140,30);
        jbtHDrive.setBounds(10,111,150,30);
        jbtHDrive.setVisible(false);
        
        pcomps.add(jbtMB);
        pcomps.add(jbtShowCPU);
        pcomps.add(jbtShowMB);
        pcomps.add(jbtShowPS);
        pcomps.add(jbtShowRAM);
        pcomps.add(jbtRAM);
        pcomps.add(jbtShowGCard);
        pcomps.add(jbtGCard);
        pcomps.add(jbtShowHDrive);
        pcomps.add(jbtHDrive);
        jf.add(pcomps);
        
        
        
        pcomps.setBounds(0, 0, 840,430);
        pcomps.setVisible(false);
        pcomps.setLayout(null);
        plogin.add(jbtlogin);
        plogin.add(jlbcomps);
        plogin.add(jlblogin);
        plogin.add(jlbpass);
        plogin.add(jlbuser);
        plogin.add(username);
        plogin.add(pass);
        plogin.setBounds(0, 0, 840,230);
        
        plogin.setBackground(Color.lightGray); 
        plogin.setVisible(true);
        plogin.setLayout(null);
        
        username.setText("sql11176424");
        pass.setText("fDFSkH9nVq");
        
        initCPUTable();
        initMBTable();
        initPSTable();
        initRAMTable();
        initGCardTable();
        initHDriveTable();
        
        enableCPUActions();
        enableMBActions();
        enablePSActions();
        enableRAMActions();
        enableGCardActions();
        enableHDriveActions();
        enableGUIActions();
        
        
        pcomps.add(pCPU);
        pcomps.add(pMB);
        pcomps.add(pPS);
        pcomps.add(pRAM);
        pcomps.add(pGCard);
        pcomps.add(pHDrive);
        jf.add(disconnect);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.add(exit);
        jf.add(plogin);
        jf.setSize(820,470);
        jf.setLayout(null);
        jf.setVisible(true);
    }
    
    private void clearData()
    {
                jSOne.setText("");
                jSTwo.setText("");
                jSThree.setText("");
                jSFour.setText("");
                jSFive.setText("");
                jSSix.setText("");
                jI1.setText("");
                jI2.setText("");
                jI3.setText("");
                jI4.setText("");
                jI5.setText("");
                jD1.setText("");
                jD2.setText("");
    }
    
    private void enableGUIActions()
    {
        exit.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                if(!disconnect.isEnabled())
                {
                    jf.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Disconnect from DB first", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
        
        clearInfo.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                clearData();
            }
            
        });
        
        jbtlogin.addActionListener(new ActionListener(){
        
            
            
            public void actionPerformed(ActionEvent e){
                
                plogin.setVisible(false);
                pcomps.setVisible(true);
                
                if(dbconn.setUP(username.getText(), pass.getText()))
                {
                    try
                    {
                        
                        dbconn.Connect();
                        
                        System.out.println("Connected to MySQL!");
                        
                        disconnect.setEnabled(true);
                        
                        jbtlogin.setEnabled(false);
                        
                    }
                    catch(SQLException sq)
                    {
                        
                    }
                }
                else
                {
                    System.err.println("Errore userpass");
                }
                
            }
        
        
        
        });
        
        disconnect.addActionListener(new ActionListener(){
            
           public void actionPerformed(ActionEvent ae) 
           {
               plogin.setVisible(true);
               pcomps.setVisible(false);
               
               try
               {
                dbconn.closeall();
                jbtlogin.setEnabled(true);
                disconnect.setEnabled(false);
                
                
               }
               catch(SQLException e)
               {
                   
               }
           }
            
        });
    }
    
    private void enableCPUActions()
    {
        jbtShowCPU.addActionListener(new ActionListener(){
            Boolean show = false;
            
            
            public void actionPerformed(ActionEvent ae)
            {
                buffer = null;
                initCPUPanel();
                fillCPU();
                tableCPU();
                
                if(show == false)
                {
                    show = true;
                    clearData();
                    deleteCPU.setVisible(true);
                    jbtShowMB.setEnabled(false);
                    jbtShowPS.setEnabled(false);
                    jbtShowRAM.setEnabled(false);
                    jbtShowGCard.setEnabled(false);
                    jbtShowHDrive.setEnabled(false);
                    pCPU.setVisible(true);
                    jbtCPU.setVisible(true);
                    jSOne.setVisible(true);
                    jSTwo.setVisible(true);
                    jSThree.setVisible(true);
                    jLOne.setVisible(true);
                    jLTwo.setVisible(true);
                    jLThree.setVisible(true);
                    jLSeven.setVisible(true);
                    jLEight.setVisible(true);
                    jLNine.setVisible(true);
                    jLX.setVisible(true);
                    jLXIII.setVisible(true);
                    jD1.setVisible(true);
                    jI1.setVisible(true);
                    jI2.setVisible(true);
                    jI3.setVisible(true);
                    jD2.setVisible(true);
                    spCPU.setVisible(true);
                    jCPU.setVisible(true);
                    clearInfo.setVisible(true);
                    
                }
                else
                {
                    show = false;
                    deleteCPU.setVisible(false);
                    jbtShowMB.setEnabled(true);
                    jbtShowPS.setEnabled(true);
                    jbtShowRAM.setEnabled(true);
                    jbtShowGCard.setEnabled(true);
                    jbtShowHDrive.setEnabled(true);
                    pCPU.setVisible(false);
                    jbtCPU.setVisible(false);
                    jSOne.setVisible(false);
                    jSTwo.setVisible(false);
                    jSThree.setVisible(false);
                    jLOne.setVisible(false);
                    jLTwo.setVisible(false);
                    jLThree.setVisible(false);
                    jLSeven.setVisible(false);
                    jLEight.setVisible(false);
                    jLNine.setVisible(false);
                    jLX.setVisible(false);
                    jLXIII.setVisible(false);
                    jD1.setVisible(false);
                    jI1.setVisible(false);
                    jI2.setVisible(false);
                    jI3.setVisible(false);
                    jD2.setVisible(false);
                    spCPU.setVisible(false);
                    clearInfo.setVisible(false);
                    
                }
                
            }
            
        });
        
        jbtCPU.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                
                
                dbconn.filldbCPU(jSOne.getText(), jSTwo.getText(), jSThree.getText(), Double.parseDouble(jD1.getText()), Integer.parseInt(jI1.getText()), Integer.parseInt(jI2.getText()), Integer.parseInt(jI3.getText()), Double.parseDouble(jD2.getText()));
                fillCPU();
                tableCPU();
                
            }
            
        });
        
        deleteCPU.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                if(selected == true)
                {
                String [] pt = buffer.split("#");
                dbconn.removeFromCPU(pt[0], pt[1], pt[2], Double.parseDouble(pt[3]), Integer.parseInt(pt[4]), Integer.parseInt(pt[5]), Double.parseDouble(pt[6]));
                fillCPU();
                cpuModel.setRowCount(0);
                
                
                updateCPU();
                jCPU.getSelectionModel().setSelectionInterval(-1, -1);
                }
                
            }
            
        });
    }
    private void fillCPU()
    {
        cp1.cleanAll();
        dbconn.loadCPU(cp1);
        //cp1.printAll();
    }
    private void tableCPU()
    {
        
        String column[]={"Brand","Model","Socket", "Frequency", "Cores","TDP", "Price"};         
        row = new Object[8];
        
        jCPU.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, column));
       
        
        
        cpuModel = (DefaultTableModel)jCPU.getModel();
        
        
        
        
        ListSelectionModel select= jCPU.getSelectionModel();
        
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() 
        {  
             public void valueChanged(ListSelectionEvent e) { 
                 if(e.getValueIsAdjusting()){
                     int c = jCPU.getSelectedRow();
                     
                     jCPU.addColumnSelectionInterval(0, 6);
                     selected = true;
                     TableModel tCPU = jCPU.getModel();
                     
                     
                     buffer = tCPU.getValueAt(c, 0)+"#"+tCPU.getValueAt(c, 1)+"#"+tCPU.getValueAt(c, 2)+"#"+tCPU.getValueAt(c, 3)+"#"+tCPU.getValueAt(c, 4)+"#"+tCPU.getValueAt(c, 5)+"#"+tCPU.getValueAt(c, 6);
                     
                     
                 }
             }

        });
        
        updateCPU();
        pCPU.add(spCPU);
        
    }
    private void updateCPU()
    {
        
        for(int i = 0; i < cp1.listBrands().size(); i++)
       {
           row[0] = cp1.listBrands().get(i);
           row[1] = cp1.listModels().get(i);
           row[2] = cp1.listSockets().get(i);
           row[3] = cp1.listFrequencies().get(i);
           row[4] = cp1.listCores().get(i);
           row[5] = cp1.listTDPs().get(i);
           //row[6] = cp1.listQuantities().get(i);
           row[6] = cp1.listPrices().get(i);
           cpuModel.addRow(row);
       }
        
    }
    private void initCPUTable()
    {
        
        spCPU=new JScrollPane(jCPU);
        
        spCPU.setBounds(10,180,600,180);
        
    }
    private void initCPUPanel()
    {
        
        deleteCPU.setBounds(130,140,100,30);
        jSOne.setBounds(10, 30, 100, 25);
        jSTwo.setBounds(110, 30, 100, 25);
        jSThree.setBounds(210, 30, 100, 25);
        jD1.setBounds(10, 80, 100, 25);
        jI1.setBounds(110, 80, 100, 25);
        jI2.setBounds(210, 80, 100, 25);
        jI3.setBounds(310, 80, 100, 25);
        jD2.setBounds(410, 80, 100, 25);
        
        jLOne.setBounds(10,10,50,25);
        jLOne.setText("Brand");
        jLOne.setVisible(false);
        jLTwo.setBounds(110,10,50,25);
        jLTwo.setText("Model");
        jLTwo.setVisible(false);
        jLThree.setBounds(210,10,50,25);
        jLThree.setText("Socket");
        jLThree.setVisible(false);
        jLSeven.setBounds(10,59,100,25);
        jLSeven.setText("Speed");
        jLSeven.setVisible(false);
        jLEight.setBounds(110,59,100,25);
        jLEight.setText("Cores");
        jLEight.setVisible(false);
        jLNine.setBounds(210,59,100,25);
        jLNine.setText("TDP");
        jLNine.setVisible(false);
        jLX.setBounds(310,59,100,25);
        jLX.setText("Quantity");
        jLX.setVisible(false);
        jLXIII.setBounds(410,59,100,25);
        jLXIII.setText("Price");
        jLXIII.setVisible(false);
        
        jSOne.setVisible(false);
        jSTwo.setVisible(false);
        jSThree.setVisible(false);
        jD1.setVisible(false);
        jI1.setVisible(false);
        jI2.setVisible(false);
        jI3.setVisible(false);
        jD2.setVisible(false);
        
        pCPU.add(jSOne);
        pCPU.add(jSTwo);
        pCPU.add(jSThree);
        pCPU.add(jLOne);
        pCPU.add(jLTwo);
        pCPU.add(jLThree);
        pCPU.add(jLSeven);
        pCPU.add(jLEight);
        pCPU.add(jLNine);
        pCPU.add(jLX);
        pCPU.add(jLXIII);
        pCPU.add(jD1);
        pCPU.add(jI1);
        pCPU.add(jI2);
        pCPU.add(jI3);
        pCPU.add(jD2);
        pCPU.add(deleteCPU);
        pCPU.add(jbtCPU);
        
        clearInfo.setVisible(false);
        pCPU.add(clearInfo);
        pCPU.setBounds(5,55,800,370);
        pCPU.setBackground(Color.white);
        pCPU.setVisible(false);
        pCPU.setLayout(null);
    }
    
    private void enableMBActions()
    {
        deleteMB.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                if(selected == true)
                {
                String [] pt = buffer.split("#");
                dbconn.removeFromMotherBoard(pt[0], pt[1], pt[2], pt[3], pt[4], Integer.parseInt(pt[5]), Integer.parseInt(pt[6]), Integer.parseInt(pt[7]), Double.parseDouble(pt[8]));
                fillMB();
                mbModel.setRowCount(0);
                
                
                updateMB();
                jMB.getSelectionModel().setSelectionInterval(-1, -1);
                }
                
            }
            
        });
        
        jbtShowMB.addActionListener(new ActionListener(){
            Boolean show = false;
            public void actionPerformed(ActionEvent ae)
            {
                buffer = null;
                initMBPanel();
                fillMB();
                tableMB();
                if(show == false)
                {
                    show = true;
                    clearData();
                    deleteMB.setVisible(true);
                    jbtShowCPU.setEnabled(false);
                    jbtShowPS.setEnabled(false);
                    jbtShowRAM.setEnabled(false);
                    jbtShowGCard.setEnabled(false);
                    jbtShowHDrive.setEnabled(false);
                    pMB.setVisible(true);
                    jbtMB.setVisible(true);
                    jSOne.setVisible(true);
                    jSTwo.setVisible(true);
                    jSFour.setVisible(true);
                    jSThree.setVisible(true);
                    jSFive.setVisible(true);
                    jLOne.setVisible(true);
                    jLTwo.setVisible(true);
                    jLThree.setVisible(true);
                    jLFour.setVisible(true);
                    jLFive.setVisible(true);
                    jLEight.setVisible(true);
                    jLNine.setVisible(true);
                    jLX.setVisible(true);
                    jLXIII.setVisible(true);
                    jD1.setVisible(true);
                    jI4.setVisible(true);
                    jI5.setVisible(true);
                    jI2.setVisible(true);
                    jD2.setVisible(true);
                    spMB.setVisible(true);
                    clearInfo.setVisible(true);
                    
                }
                else
                {
                    show = false;
                    deleteMB.setVisible(false);
                    jbtShowCPU.setEnabled(true);
                    jbtShowPS.setEnabled(true);
                    jbtShowRAM.setEnabled(true);
                    jbtShowGCard.setEnabled(true);
                    jbtShowHDrive.setEnabled(true);
                    pMB.setVisible(false);
                    jbtMB.setVisible(false);
                    jSOne.setVisible(false);
                    jSTwo.setVisible(false);
                    jSFour.setVisible(false);
                    jSThree.setVisible(false);
                    jSFive.setVisible(false);
                    jLOne.setVisible(false);
                    jLTwo.setVisible(false);
                    jLThree.setVisible(false);
                    jLFour.setVisible(false);
                    jLFive.setVisible(false);
                    jLEight.setVisible(false);
                    jLNine.setVisible(false);
                    jLX.setVisible(false);
                    jLXIII.setVisible(false);
                    jI4.setVisible(false);
                    jI5.setVisible(false);
                    jI2.setVisible(false);
                    jD2.setVisible(false);
                    spMB.setVisible(false);
                    clearInfo.setVisible(false);
                    
                }
                
            }
            
        });
        
        jbtMB.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                dbconn.filldbMB(jSOne.getText(), jSTwo.getText(), jSThree.getText(), jSFour.getText(), jSFive.getText(), Integer.parseInt(jI4.getText()), Integer.parseInt(jI5.getText()), Integer.parseInt(jI2.getText()), Double.parseDouble(jD2.getText()));
                fillMB();
                tableMB();
            }
            
        });
    }
    private void fillMB()
    {
        mb1.cleanAll();
        dbconn.loadMB(mb1);
        
    }
    private void tableMB()
    {
        
        String column[]={"Brand","Model","Chipset", "Socket", "FormFactor","RamSlots", "MaxRam", "TDP", "Price"};
        row = new Object[9];
        
        jMB.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, column));
       
        
        
        mbModel = (DefaultTableModel)jMB.getModel();
        
        
        
        
        ListSelectionModel select= jMB.getSelectionModel();
        
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() 
        {  
             public void valueChanged(ListSelectionEvent e) { 
                 if(e.getValueIsAdjusting()){
                     int c = jMB.getSelectedRow();
                     
                     jMB.addColumnSelectionInterval(0, 6);
                     selected = true;
                     TableModel tMB = jMB.getModel();
                     
                     
                     buffer = tMB.getValueAt(c, 0)+"#"+tMB.getValueAt(c, 1)+"#"+tMB.getValueAt(c, 2)+"#"+tMB.getValueAt(c, 3)+"#"+tMB.getValueAt(c, 4)+"#"+tMB.getValueAt(c, 5)+"#"+tMB.getValueAt(c, 6)+"#"+tMB.getValueAt(c, 7)+"#"+tMB.getValueAt(c, 8);
                     
                     
                 }
             }

        });
        
        updateMB();
        pMB.add(spMB);
        
    }
    private void initMBTable()
    {
        
        spMB=new JScrollPane(jMB);
        
        spMB.setBounds(10,180,600,180);
        
    }
    private void updateMB()
    {
        
       for(int i = 0; i < mb1.listBrands().size(); i++)
       {
           row[0] = mb1.listBrands().get(i);
           row[1] = mb1.listModels().get(i);
           row[2] = mb1.listChipsets().get(i);
           row[3] = mb1.listSockets().get(i);
           row[4] = mb1.listFormfactors().get(i);
           row[5] = mb1.listramslots().get(i);
           row[6] = mb1.listmaxrams().get(i);
           row[7] = mb1.listTDPs().get(i);
           //row[8] = cp1.listQuantities().get(i);
           row[8] = mb1.listPrices().get(i);
           
           
           mbModel.addRow(row);
           
       }
        
    }
    private void initMBPanel()
    {
        deleteMB.setBounds(130,140,100,30);
        jSOne.setBounds(10, 30, 100, 25);
        jSTwo.setBounds(110, 30, 100, 25);
        jSThree.setBounds(210, 30, 100, 25);
        jSFour.setBounds(310, 30, 100,25);
        jSFive.setBounds(410,30,100,25);
        jI4.setBounds(10,80,100,25);
        jI5.setBounds(110,80,100,25);
        jI2.setBounds(210, 80, 100, 25);
        jD2.setBounds(310, 80, 100, 25);
        
        jLOne.setBounds(10,10,50,25);
        jLOne.setText("Brand");
        jLOne.setVisible(false);
        jLTwo.setBounds(110,10,50,25);
        jLTwo.setText("Model");
        jLTwo.setVisible(false);
        jLThree.setBounds(210,10,60,25);
        jLThree.setText("Chipset");
        jLThree.setVisible(false);
        jLFour.setBounds(310,10,100,25);
        jLFour.setText("Socket");
        jLFour.setVisible(false);
        jLFive.setBounds(410,10,100,25);
        jLFive.setText("Form Factor");
        jLFive.setVisible(false);
        jLEight.setBounds(10,59,100,25);
        jLEight.setText("RAM Slots");
        jLEight.setVisible(false);
        jLNine.setBounds(110,59,100,25);
        jLNine.setText("MAX RAM");
        jLNine.setVisible(false);
        jLX.setBounds(210,59,50,25);
        jLX.setText("TDP");
        jLX.setVisible(false);
        jLXIII.setBounds(310,59,50,25);
        jLXIII.setText("Price");
        jLXIII.setVisible(false);
        
        jSOne.setVisible(false);
        jSTwo.setVisible(false);
        jSThree.setVisible(false);
        jSFour.setVisible(false);
        jSFive.setVisible(false);
        jI4.setVisible(false);
        jI5.setVisible(false);
        jI2.setVisible(false);
        jD2.setVisible(false);
        pMB.add(jSOne);
        pMB.add(jSTwo);
        pMB.add(jSThree);
        pMB.add(jSFour);
        pMB.add(jSFive);
        pMB.add(jLOne);
        pMB.add(jLTwo);
        pMB.add(jLThree);
        pMB.add(jLFour);
        pMB.add(jLFive);
        pMB.add(jLEight);
        pMB.add(jLNine);
        pMB.add(jLX);
        pMB.add(jLXIII);
        
        pMB.add(jI4);
        pMB.add(jI5);
        pMB.add(jI2);
        pMB.add(jD2);
        pMB.add(deleteMB);
        pMB.add(jbtMB);
        
        clearInfo.setVisible(false);
        pMB.add(clearInfo);
        pMB.setBounds(5,55,800,370);
        pMB.setBackground(Color.yellow);
        pMB.setVisible(false);
        pMB.setLayout(null);
    }
    
    private void enablePSActions()
    {
        deletePS.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                if(selected == true)
                {
                String [] pt = buffer.split("#");
                dbconn.removeFromPowerSupply(pt[0], pt[1], pt[2], pt[3], pt[4], Integer.parseInt(pt[5]), pt[6], Double.parseDouble(pt[7]));
                fillPS();
                psModel.setRowCount(0);
                
                
                updatePS();
                jPS.getSelectionModel().setSelectionInterval(-1, -1);
                }
                
            }
            
        });
        
        jbtShowPS.addActionListener(new ActionListener(){
            Boolean show = false;
            
            public void actionPerformed(ActionEvent ae)
            {
                buffer = null;
                initPSPanel();
                fillPS();
                tablePS();
                if(show == false)
                {
                    show = true;
                    clearData();
                    deletePS.setVisible(true);
                    jbtShowCPU.setEnabled(false);
                    jbtShowMB.setEnabled(false);
                    jbtShowRAM.setEnabled(false);
                    jbtShowGCard.setEnabled(false);
                    jbtShowHDrive.setEnabled(false);
                    pPS.setVisible(true);
                    jbtPS.setVisible(true);
                    jSOne.setVisible(true);
                    jSTwo.setVisible(true);
                    jSThree.setVisible(true);
                    jSFour.setVisible(true);
                    jSFive.setVisible(true);
                    jLOne.setVisible(true);
                    jLTwo.setVisible(true);
                    jLThree.setVisible(true);
                    jLFour.setVisible(true);
                    jLFive.setVisible(true);
                    jLSix.setVisible(true);
                    jLSeven.setVisible(true);
                    jLEight.setVisible(true);
                    jI1.setVisible(true);
                    jSSix.setVisible(true);
                    jD2.setVisible(true);
                    spPS.setVisible(true);
                    clearInfo.setVisible(true);
                    
                }
                else
                {
                    show = false;
                    deletePS.setVisible(false);
                    jbtShowCPU.setEnabled(true);
                    jbtShowMB.setEnabled(true);
                    jbtShowRAM.setEnabled(true);
                    jbtShowGCard.setEnabled(true);
                    jbtShowHDrive.setEnabled(true);
                    pPS.setVisible(false);
                    jbtPS.setVisible(false);
                    jbtPS.setVisible(false);
                    jSOne.setVisible(false);
                    jSTwo.setVisible(false);
                    jSThree.setVisible(false);
                    jSFour.setVisible(false);
                    jSFive.setVisible(false);
                    jLOne.setVisible(false);
                    jLTwo.setVisible(false);
                    jLThree.setVisible(false);
                    jLFour.setVisible(false);
                    jLFive.setVisible(false);
                    jLSix.setVisible(false);
                    jLSeven.setVisible(false);
                    jLEight.setVisible(false);
                    jI1.setVisible(false);
                    jSSix.setVisible(false);
                    jD2.setVisible(false);
                    spPS.setVisible(false);
                    clearInfo.setVisible(false);
                    
                }
                
            }
            
        });
        
        jbtPS.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                dbconn.filldbPS(jSOne.getText(), jSTwo.getText(), jSThree.getText(), jSFour.getText(), jSFive.getText(), Integer.parseInt(jI1.getText()), jSSix.getText(), Double.parseDouble(jD2.getText()));
                //System.out.println(jbrand.getText() + jmodel.getText() + jchipset.getText() + jsocket.getText() + jformfactor.getText() + Integer.parseInt(jramslot.getText()) + Integer.parseInt(jmaxram.getText()) + Integer.parseInt(jtdp.getText()) + Double.parseDouble(jprice.getText()));
                fillPS();
                tablePS();
            }
            
        });
    }
    private void fillPS()
    {
        ps1.cleanAll();
        dbconn.loadPS(ps1);
    }
    private void tablePS()
    {
        String column[]={"Brand","Model","Series", "Form", "Efficiency","MaxTDP", "Modular", "Price"};
        row = new Object[8];
        
        jPS.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, column));
       
        
        
        psModel = (DefaultTableModel)jPS.getModel();
        
        
        
        
        ListSelectionModel select= jPS.getSelectionModel();
        
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() 
        {  
             public void valueChanged(ListSelectionEvent e) { 
                 if(e.getValueIsAdjusting()){
                     int c = jPS.getSelectedRow();
                     
                     jPS.addColumnSelectionInterval(0, 6);
                     selected = true;
                     TableModel tPS = jPS.getModel();
                     
                     
                     buffer = tPS.getValueAt(c, 0)+"#"+tPS.getValueAt(c, 1)+"#"+tPS.getValueAt(c, 2)+"#"+tPS.getValueAt(c, 3)+"#"+tPS.getValueAt(c, 4)+"#"+tPS.getValueAt(c, 5)+"#"+tPS.getValueAt(c, 6)+"#"+tPS.getValueAt(c, 7);
                     
                     
                 }
             }

        });
        
        updatePS();
        pPS.add(spPS);
    }
    private void initPSTable()
    {
        spPS=new JScrollPane(jPS);
        spPS.setBounds(10,180,600,180);
    }
    private void updatePS()
    {
        for(int i = 0; i < ps1.listBrands().size(); i++)
       {
           row[0] = ps1.listBrands().get(i);
           row[1] = ps1.listModels().get(i);
           row[2] = ps1.listSeries().get(i);
           row[3] = ps1.listForms().get(i);
           row[4] = ps1.listEfficiencies().get(i);
           row[5] = ps1.listMaxTDPs().get(i);
           row[6] = ps1.listModulars().get(i);
           row[7] = ps1.listPrices().get(i);
           //row[8] = cp1.listQuantities().get(i);
           
           psModel.addRow(row);
       }
    }
    private void initPSPanel()
    {
        deletePS.setBounds(130,140,100,30);
        jSOne.setBounds(10, 30, 100, 25);
        jSTwo.setBounds(110, 30, 100, 25);
        jSThree.setBounds(210, 30, 100, 25);
        jSFour.setBounds(310, 30, 100,25);
        jSFive.setBounds(410,30,100,25);
        jI1.setBounds(10,80,100,25);
        jSSix.setBounds(510,30,100,25);
        jD2.setBounds(110, 80, 100, 25);
        
        jLOne.setBounds(10, 10, 50, 25);
        jLTwo.setBounds(110, 10, 50, 25);
        jLThree.setBounds(210, 10, 50, 25);
        jLFour.setBounds(310, 10, 50, 25);
        jLFive.setBounds(410, 10, 100, 25);
        jLSix.setBounds(510, 10, 100, 25);
        jLSeven.setBounds(10, 59,100,25);
        jLEight.setBounds(110, 59, 100, 25);
        jLOne.setText("Brand");
        jLTwo.setText("Model");
        jLThree.setText("Series");
        jLFour.setText("Form");
        jLFive.setText("Efficiency");
        jLSix.setText("Modular");
        jLSeven.setText("TDP Max");
        jLEight.setText("Price");
        jSOne.setVisible(false);
        jSTwo.setVisible(false);
        jSThree.setVisible(false);
        jSFour.setVisible(false);
        jSFive.setVisible(false);
        jI1.setVisible(false);
        jSSix.setVisible(false);
        jD2.setVisible(false);
        jLOne.setVisible(false);
        jLTwo.setVisible(false);
        jLThree.setVisible(false);
        jLFour.setVisible(false);
        jLFive.setVisible(false);
        jLSix.setVisible(false);
        jLSeven.setVisible(false);
        jLEight.setVisible(false);
        
        pPS.add(jSOne);
        pPS.add(jSTwo);
        pPS.add(jSThree);
        pPS.add(jSFour);
        pPS.add(jSFive);
        pPS.add(jLOne);
        pPS.add(jLTwo);
        pPS.add(jLThree);
        pPS.add(jLFour);
        pPS.add(jLFive);
        pPS.add(jLSix);
        pPS.add(jLSeven);
        pPS.add(jLEight);
        pPS.add(jI1);
        pPS.add(jSSix);
        pPS.add(jD2);
        pPS.add(deletePS);
        pPS.add(jbtPS);
        
        
        clearInfo.setVisible(false);
        pPS.add(clearInfo);
        pPS.setBounds(5,55,800,370);
        pPS.setBackground(Color.orange);
        pPS.setVisible(false);
        pPS.setLayout(null);
    }
    
    private void enableRAMActions()
    {
        jbtShowRAM.addActionListener(new ActionListener(){
            Boolean show = false;
            public void actionPerformed(ActionEvent ae)
            {
                buffer = null;
                initRAMPanel();
                fillRAM();
                tableRAM();
                
                
                if(show == false)
                {
                    show = true;
                    clearData();
                    deleteRAM.setVisible(true);
                    jbtShowCPU.setEnabled(false);
                    jbtShowMB.setEnabled(false);
                    jbtShowPS.setEnabled(false);
                    jbtShowGCard.setEnabled(false);
                    jbtShowHDrive.setEnabled(false);
                    jbtRAM.setVisible(true);
                    pRAM.setVisible(true);
                    jSOne.setVisible(true);
                    jSTwo.setVisible(true);
                    jSThree.setVisible(true);
                    jSFour.setVisible(true);
                    jI1.setVisible(true);
                    jI2.setVisible(true);
                    jI3.setVisible(true);
                    jI4.setVisible(true);
                    jD2.setVisible(true);
                    jLOne.setVisible(true);
                    jLTwo.setVisible(true);
                    jLThree.setVisible(true);
                    jLFour.setVisible(true);
                    jLFive.setVisible(true);
                    jLSix.setVisible(true);
                    jLSeven.setVisible(true);
                    jLEight.setVisible(true);
                    jLNine.setVisible(true);
                    spRAM.setVisible(true);
                    clearInfo.setVisible(true);
                    
                }
                else
                {
                    show = false;
                    deleteRAM.setVisible(false);
                    jbtShowCPU.setEnabled(true);
                    jbtShowMB.setEnabled(true);
                    jbtShowPS.setEnabled(true);
                    jbtShowGCard.setEnabled(true);
                    jbtShowHDrive.setEnabled(true);
                    jbtRAM.setVisible(false);
                    pRAM.setVisible(false);
                    jbtRAM.setVisible(false);
                    jSOne.setVisible(false);
                    jSTwo.setVisible(false);
                    jSThree.setVisible(false);
                    jSFour.setVisible(false);
                    jI1.setVisible(false);
                    jI2.setVisible(false);
                    jI3.setVisible(false);
                    jI4.setVisible(false);
                    jD2.setVisible(false);
                    jLOne.setVisible(false);
                    jLTwo.setVisible(false);
                    jLThree.setVisible(false);
                    jLFour.setVisible(false);
                    jLFive.setVisible(false);
                    jLSix.setVisible(false);
                    jLSeven.setVisible(false);
                    jLEight.setVisible(false);
                    jLNine.setVisible(false);
                    spRAM.setVisible(false);
                    clearInfo.setVisible(false);
                    
                }
                
            }
            
        });
        
        deleteRAM.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                if(selected == true)
                {
                String [] pt = buffer.split("#");
                dbconn.removeFromRAM(pt[0], pt[1], pt[2], pt[3], Integer.parseInt(pt[4]), Integer.parseInt(pt[5]), Integer.parseInt(pt[6]), Integer.parseInt(pt[7]), Double.parseDouble(pt[8]));
                fillRAM();
                ramModel.setRowCount(0);
                
                
                updateRAM();
                jRAM.getSelectionModel().setSelectionInterval(-1, -1);
                }
                
            }
            
        });
        
        jbtRAM.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                
                
                dbconn.filldbRAM(jSOne.getText(), jSTwo.getText(), jSThree.getText(), jSFour.getText(), Integer.parseInt(jI1.getText()), Integer.parseInt(jI2.getText()), Integer.parseInt(jI3.getText()), Integer.parseInt(jI4.getText()),Double.parseDouble(jD2.getText()));
                fillRAM();
                tableRAM();
            }
            
        });
    }
    private void fillRAM()
    {
        ram.cleanAll();
        dbconn.loadRAM(ram);
    }
    private void tableRAM()
    {
        String column[]={"Brand","Model","Type", "Speed", "TDP","NumberOfModules", "SizeOfModules", "Size","Price"};
        row = new Object[9];
        
        jRAM.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, column));
       
        ramModel = (DefaultTableModel)jRAM.getModel();
        
        
        ListSelectionModel select= jRAM.getSelectionModel();
        
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() 
        {  
             public void valueChanged(ListSelectionEvent e) { 
                 if(e.getValueIsAdjusting()){
                     int c = jRAM.getSelectedRow();
                     
                     jRAM.addColumnSelectionInterval(0, 6);
                     selected = true;
                     TableModel tRAM = jRAM.getModel();
                     
                     buffer = tRAM.getValueAt(c, 0)+"#"+tRAM.getValueAt(c, 1)+"#"+tRAM.getValueAt(c, 2)+"#"+tRAM.getValueAt(c, 3)+"#"+tRAM.getValueAt(c, 4)+"#"+tRAM.getValueAt(c, 5)+"#"+tRAM.getValueAt(c, 6)+"#"+tRAM.getValueAt(c, 7)+"#"+tRAM.getValueAt(c, 8);
                     
                     
                 }
             }

        });
        updateRAM();
        pRAM.add(spRAM);
    }
    private void initRAMTable()
    {
        spRAM = new JScrollPane(jRAM);
        spRAM.setBounds(10,180,600,180);
    }
    private void updateRAM()
    {
        for(int i = 0; i < ram.listBrands().size(); i++)
       {
           row[0] = ram.listBrands().get(i);
           row[1] = ram.listModels().get(i);
           row[2] = ram.listTypes().get(i);
           row[3] = ram.listSpeeds().get(i);
           row[4] = ram.listTDPs().get(i);
           row[5] = ram.listNOMs().get(i);
           row[6] = ram.listSOMs().get(i);
           row[7] = ram.listSizes().get(i);
           row[8] = ram.listPrices().get(i);
           //row[8] = cp1.listQuantities().get(i);
           
           ramModel.addRow(row);
       }
    }
    private void initRAMPanel()
    {
        deleteRAM.setBounds(130,140,100,30);
        jSOne.setBounds(10, 30, 100, 25);
        jSTwo.setBounds(110, 30, 100, 25);
        jSThree.setBounds(210, 30, 100, 25);
        jSFour.setBounds(310, 30, 100, 25);
        jI1.setBounds(10, 80, 100, 25);
        jI2.setBounds(110, 80, 100, 25);
        jI3.setBounds(210, 80, 100, 25);
        jI4.setBounds(310, 80, 100, 25);
        jD2.setBounds(410, 80, 100, 25);
        
        jLOne.setBounds(10, 10, 50, 25);
        jLTwo.setBounds(110, 10, 50, 25);
        jLThree.setBounds(210, 10, 50, 25);
        jLFour.setBounds(310, 10, 50, 25);
        jLFive.setBounds(10, 59, 100, 25);
        jLSix.setBounds(110, 59, 100, 25);
        jLSeven.setBounds(210, 59,100,25);
        jLEight.setBounds(310, 59, 100, 25);
        jLNine.setBounds(410, 59, 100, 25);
        
        jLOne.setText("Brand");
        jLTwo.setText("Model");
        jLThree.setText("Type");
        jLFour.setText("TypeSpeed");
        jLFive.setText("TDP");
        jLSix.setText("NumOfModules");
        jLSeven.setText("SizeOfModules");
        jLEight.setText("Size");
        jLNine.setText("Price");
        
        jSOne.setVisible(false);
        jSTwo.setVisible(false);
        jSThree.setVisible(false);
        jSFour.setVisible(false);
        jI1.setVisible(false);
        jI2.setVisible(false);
        jI3.setVisible(false);
        jI4.setVisible(false);
        jD2.setVisible(false);
        jLOne.setVisible(false);
        jLTwo.setVisible(false);
        jLThree.setVisible(false);
        jLFour.setVisible(false);
        jLFive.setVisible(false);
        jLSix.setVisible(false);
        jLSeven.setVisible(false);
        jLEight.setVisible(false);
        jLNine.setVisible(false);
        
        pRAM.add(jSOne);
        pRAM.add(jSTwo);
        pRAM.add(jSThree);
        pRAM.add(jSFour);
        pRAM.add(jI1);
        pRAM.add(jI2);
        pRAM.add(jI3);
        pRAM.add(jI4);
        pRAM.add(jD2);
        pRAM.add(jLOne);
        pRAM.add(jLTwo);
        pRAM.add(jLThree);
        pRAM.add(jLFour);
        pRAM.add(jLFive);
        pRAM.add(jLSix);
        pRAM.add(jLSeven);
        pRAM.add(jLEight);
        pRAM.add(jLNine);
        pRAM.add(deleteRAM);
        pRAM.add(jbtRAM);
        
        clearInfo.setVisible(false);
        pRAM.add(clearInfo);
        pRAM.setBounds(5,55,800,370);
        pRAM.setBackground(Color.blue);
        pRAM.setVisible(false);
        pRAM.setLayout(null);
    }
    
    private void enableGCardActions()
    {
        jbtShowGCard.addActionListener(new ActionListener(){
            Boolean show = false;
            public void actionPerformed(ActionEvent ae)
            {
                buffer = null;
                initGCardPanel();
                fillGCard();
                tableGCard();
                
                if(show == false)
                {
                    show = true;
                    clearData();
                    deleteGCard.setVisible(true);
                    jbtShowCPU.setEnabled(false);
                    jbtShowMB.setEnabled(false);
                    jbtShowPS.setEnabled(false);
                    jbtShowRAM.setEnabled(false);
                    jbtShowHDrive.setEnabled(false);
                    jbtGCard.setVisible(true);
                    pGCard.setVisible(true);
                    jSOne.setVisible(true);
                    jSTwo.setVisible(true);
                    jSThree.setVisible(true);
                    jSFour.setVisible(true);
                    jI1.setVisible(true);
                    jI2.setVisible(true);
                    jD1.setVisible(true);
                    jD2.setVisible(true);
                    jLOne.setVisible(true);
                    jLTwo.setVisible(true);
                    jLThree.setVisible(true);
                    jLFour.setVisible(true);
                    jLFive.setVisible(true);
                    jLSix.setVisible(true);
                    jLSeven.setVisible(true);
                    jLEight.setVisible(true);
                    spGCard.setVisible(true);
                    clearInfo.setVisible(true);
                    
                }
                else
                {
                    show = false;
                    deleteGCard.setVisible(false);
                    jbtShowCPU.setEnabled(true);
                    jbtShowMB.setEnabled(true);
                    jbtShowPS.setEnabled(true);
                    jbtShowRAM.setEnabled(true);
                    jbtShowHDrive.setEnabled(true);
                    jbtGCard.setVisible(false);
                    pGCard.setVisible(false);
                    jbtGCard.setVisible(false);
                    jSOne.setVisible(false);
                    jSTwo.setVisible(false);
                    jSThree.setVisible(false);
                    jSFour.setVisible(false);
                    jI1.setVisible(false);
                    jI2.setVisible(false);
                    jD1.setVisible(false);
                    jD2.setVisible(false);
                    jLOne.setVisible(false);
                    jLTwo.setVisible(false);
                    jLThree.setVisible(false);
                    jLFour.setVisible(false);
                    jLFive.setVisible(false);
                    jLSix.setVisible(false);
                    jLSeven.setVisible(false);
                    jLEight.setVisible(false);
                    spGCard.setVisible(true);
                    clearInfo.setVisible(false);
                    
                }
                
            }
            
        });
        
        jbtGCard.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                dbconn.filldbGCard(jSOne.getText(), jSTwo.getText(), jSThree.getText(), jSFour.getText(), Integer.parseInt(jI1.getText()), Integer.parseInt(jI2.getText()), Double.parseDouble(jD1.getText()),Double.parseDouble(jD2.getText()));
                //System.out.println(jbrand.getText() + jmodel.getText() + jchipset.getText() + jsocket.getText() + jformfactor.getText() + Integer.parseInt(jramslot.getText()) + Integer.parseInt(jmaxram.getText()) + Integer.parseInt(jtdp.getText()) + Double.parseDouble(jprice.getText()));
                fillGCard();
                tableGCard();
            }
            
        });
        
        deleteGCard.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                if(selected == true)
                {
                    String [] pt = buffer.split("#");
                    dbconn.removeFromGCard(pt[0], pt[1], pt[2], pt[3], Integer.parseInt(pt[4]), Integer.parseInt(pt[5]), Double.parseDouble(pt[6]), Double.parseDouble(pt[7]));
                    fillGCard();
                    gcardModel.setRowCount(0);
                    updateGCard();
                    jGCard.getSelectionModel().setSelectionInterval(-1, -1);
                }
                
            }
            
        });
    }
    private void fillGCard()
    {
        gc1.cleanAll();
        dbconn.loadGCard(gc1);
    }
    private void tableGCard()
    {
        String column[]={"Brand","Model","Series", "Chipset", "Memory","TDP", "Clock", "Price"};
        row = new Object[8];
        
        jGCard.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, column));
       
        gcardModel = (DefaultTableModel)jGCard.getModel();
        
        
        ListSelectionModel select= jGCard.getSelectionModel();
        
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() 
        {  
             public void valueChanged(ListSelectionEvent e) { 
                 if(e.getValueIsAdjusting()){
                     int c = jGCard.getSelectedRow();
                     
                     jGCard.addColumnSelectionInterval(0, 6);
                     selected = true;
                     TableModel tGCard = jGCard.getModel();
                     
                     buffer = tGCard.getValueAt(c, 0)+"#"+tGCard.getValueAt(c, 1)+"#"+tGCard.getValueAt(c, 2)+"#"+tGCard.getValueAt(c, 3)+"#"+tGCard.getValueAt(c, 4)+"#"+tGCard.getValueAt(c, 5)+"#"+tGCard.getValueAt(c, 6)+"#"+tGCard.getValueAt(c, 7);
                     
                     
                 }
             }

        });
        updateGCard();
        pGCard.add(spGCard);
    }
    private void initGCardTable()
    {
        spGCard = new JScrollPane(jGCard);
        spGCard.setBounds(10,180,600,180);
    }
    private void updateGCard()
    {
        for(int i = 0; i < gc1.listBrands().size(); i++)
       {
           row[0] = gc1.listBrands().get(i);
           row[1] = gc1.listModels().get(i);
           row[2] = gc1.listSeries().get(i);
           row[3] = gc1.listChipsets().get(i);
           row[4] = gc1.listMemory().get(i);
           row[5] = gc1.listTDPs().get(i);
           row[6] = gc1.listClocks().get(i);
           row[7] = gc1.listPrices().get(i);
           //row[7] = cp1.listQuantities().get(i);
           
           gcardModel.addRow(row);
       }
    }
    private void initGCardPanel()
    {
        deleteGCard.setBounds(130,140,100,30);
        jSOne.setBounds(10, 30, 100, 25);
        jSTwo.setBounds(110, 30, 100, 25);
        jSThree.setBounds(210, 30, 100, 25);
        jSFour.setBounds(310, 30, 100, 25);
        jI1.setBounds(10, 80, 100, 25);
        jI2.setBounds(110, 80, 100, 25);
        jD1.setBounds(210,80,100,25);
        jD2.setBounds(310, 80, 100, 25);
        
        jLOne.setBounds(10, 10, 50, 25);
        jLTwo.setBounds(110, 10, 50, 25);
        jLThree.setBounds(210, 10, 50, 25);
        jLFour.setBounds(310, 10, 100, 25);
        jLFive.setBounds(10, 59, 100, 25);
        jLSix.setBounds(110, 59, 100, 25);
        jLSeven.setBounds(210, 59,100,25);
        jLEight.setBounds(310, 59, 100, 25);
        
        
        jLOne.setText("Brand");
        jLTwo.setText("Model");
        jLThree.setText("Series");
        jLFour.setText("Chipset");
        jLFive.setText("Memory");
        jLSix.setText("TDP");
        jLSeven.setText("Clock");
        jLEight.setText("Price");
        
        
        jSOne.setVisible(false);
        jSTwo.setVisible(false);
        jSThree.setVisible(false);
        jSFour.setVisible(false);
        jI1.setVisible(false);
        jI2.setVisible(false);
        jD1.setVisible(false);
        jD2.setVisible(false);
        jLOne.setVisible(false);
        jLTwo.setVisible(false);
        jLThree.setVisible(false);
        jLFour.setVisible(false);
        jLFive.setVisible(false);
        jLSix.setVisible(false);
        jLSeven.setVisible(false);
        jLEight.setVisible(false);
        
        pGCard.add(jSOne);
        pGCard.add(jSTwo);
        pGCard.add(jSThree);
        pGCard.add(jSFour);
        pGCard.add(jI1);
        pGCard.add(jI2);
        pGCard.add(jD1);
        pGCard.add(jD2);
        pGCard.add(jLOne);
        pGCard.add(jLTwo);
        pGCard.add(jLThree);
        pGCard.add(jLFour);
        pGCard.add(jLFive);
        pGCard.add(jLSix);
        pGCard.add(jLSeven);
        pGCard.add(jLEight);
        pGCard.add(deleteGCard);
        pGCard.add(jbtGCard);
        
        clearInfo.setVisible(false);
        pGCard.add(clearInfo);
        pGCard.setBounds(5,55,800,370);
        pGCard.setBackground(Color.red);
        pGCard.setVisible(false);
        pGCard.setLayout(null);
    }
    
    private void enableHDriveActions()
    {
        jbtShowHDrive.addActionListener(new ActionListener(){
            Boolean show = false;
            public void actionPerformed(ActionEvent ae)
            {
                buffer = null;
                initHDrivePanel();
                fillHDrive();
                tableHDrive();
                
                if(show == false)
                {
                    show = true;
                    clearData();
                    deleteHDrive.setVisible(true);
                    jbtShowCPU.setEnabled(false);
                    jbtShowMB.setEnabled(false);
                    jbtShowPS.setEnabled(false);
                    jbtShowRAM.setEnabled(false);
                    jbtShowGCard.setEnabled(false);
                    jbtHDrive.setVisible(true);
                    pHDrive.setVisible(true);
                    jSOne.setVisible(true);
                    jSTwo.setVisible(true);
                    jSThree.setVisible(true);
                    jSFour.setVisible(true);
                    jSFive.setVisible(true);
                    jI1.setVisible(true);
                    jI2.setVisible(true);
                    jI3.setVisible(true);
                    jD2.setVisible(true);
                    jLOne.setVisible(true);
                    jLTwo.setVisible(true);
                    jLThree.setVisible(true);
                    jLFour.setVisible(true);
                    jLFive.setVisible(true);
                    jLSix.setVisible(true);
                    jLSeven.setVisible(true);
                    jLEight.setVisible(true);
                    jLNine.setVisible(true);
                    spHDrive.setVisible(true);
                    clearInfo.setVisible(true);
                    
                }
                else
                {
                    show = false;
                    deleteHDrive.setVisible(false);
                    jbtShowCPU.setEnabled(true);
                    jbtShowMB.setEnabled(true);
                    jbtShowPS.setEnabled(true);
                    jbtShowRAM.setEnabled(true);
                    jbtShowGCard.setEnabled(true);
                    jbtHDrive.setVisible(false);
                    pHDrive.setVisible(false);
                    jSOne.setVisible(false);
                    jSTwo.setVisible(false);
                    jSThree.setVisible(false);
                    jSFour.setVisible(false);
                    jSFive.setVisible(false);
                    jI1.setVisible(false);
                    jI2.setVisible(false);
                    jI3.setVisible(false);
                    jD2.setVisible(false);
                    jLOne.setVisible(false);
                    jLTwo.setVisible(false);
                    jLThree.setVisible(false);
                    jLFour.setVisible(false);
                    jLFive.setVisible(false);
                    jLSix.setVisible(false);
                    jLSeven.setVisible(false);
                    jLEight.setVisible(false);
                    jLNine.setVisible(false);
                    spGCard.setVisible(false);
                    clearInfo.setVisible(false);
                    
                }
                
            }
            
        });
        
        jbtHDrive.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                
                
                dbconn.filldbHDrive(jSOne.getText(), jSTwo.getText(), jSThree.getText(), jSFour.getText(), jSFive.getText(), Integer.parseInt(jI1.getText()), Integer.parseInt(jI2.getText()), Integer.parseInt(jI3.getText()),Double.parseDouble(jD2.getText()));
                //System.out.println(jbrand.getText() + jmodel.getText() + jchipset.getText() + jsocket.getText() + jformfactor.getText() + Integer.parseInt(jramslot.getText()) + Integer.parseInt(jmaxram.getText()) + Integer.parseInt(jtdp.getText()) + Double.parseDouble(jprice.getText()));
                fillHDrive();
                tableHDrive();
            }
            
        });
        
        deleteHDrive.addActionListener(new ActionListener(){
           
            public void actionPerformed(ActionEvent ae)
            {
                if(selected == true)
                {
                    String [] pt = buffer.split("#");
                    dbconn.removeFromHDrive(pt[0], pt[1], pt[2], pt[3], pt[4], Integer.parseInt(pt[5]), Integer.parseInt(pt[6]), Integer.parseInt(pt[7]), Double.parseDouble(pt[8]));
                    fillHDrive();
                    hdriveModel.setRowCount(0);
                    updateHDrive();
                    jHDrive.getSelectionModel().setSelectionInterval(-1, -1);
                }
                
            }
            
        });
    }
    private void fillHDrive()
    {
        hd1.cleanAll();
        dbconn.loadHDrive(hd1);
    }
    private void tableHDrive()
    {
        String column[]={"Brand","Model","Series", "Form", "Type","Size", "TDP", "Cache", "Price"};
        row = new Object[9];
        
        jHDrive.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, column));
       
        hdriveModel = (DefaultTableModel)jHDrive.getModel();
        
        
        ListSelectionModel select= jHDrive.getSelectionModel();
        
        select.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
        select.addListSelectionListener(new ListSelectionListener() 
        {  
             public void valueChanged(ListSelectionEvent e) { 
                 if(e.getValueIsAdjusting()){
                     int c = jHDrive.getSelectedRow();
                     
                     jHDrive.addColumnSelectionInterval(0, 6);
                     selected = true;
                     TableModel tHDrive = jHDrive.getModel();
                     
                     buffer = tHDrive.getValueAt(c, 0)+"#"+tHDrive.getValueAt(c, 1)+"#"+tHDrive.getValueAt(c, 2)+"#"+tHDrive.getValueAt(c, 3)+"#"+tHDrive.getValueAt(c, 4)+"#"+tHDrive.getValueAt(c, 5)+"#"+tHDrive.getValueAt(c, 6)+"#"+tHDrive.getValueAt(c, 7)+"#"+tHDrive.getValueAt(c, 8);
                     
                     
                 }
             }

        });
        updateHDrive();
        pHDrive.add(spHDrive);
    }
    private void initHDriveTable()
    {
        spHDrive = new JScrollPane(jHDrive);
        spHDrive.setBounds(10,180,600,180);
    }
    private void updateHDrive()
    {
        for(int i = 0; i < hd1.listBrands().size(); i++)
       {
           row[0] = hd1.listBrands().get(i);
           row[1] = hd1.listModels().get(i);
           row[2] = hd1.listSeries().get(i);
           row[3] = hd1.listForms().get(i);
           row[4] = hd1.listTypes().get(i);
           row[5] = hd1.listSizes().get(i);
           row[6] = hd1.listTDPs().get(i);
           row[7] = hd1.listCaches().get(i);
           row[8] = hd1.listPrices().get(i);
           //row[8] = cp1.listQuantities().get(i);
           
           hdriveModel.addRow(row);
       }
    }
    private void initHDrivePanel()
    {
        deleteHDrive.setBounds(130,140,100,30);
        jSOne.setBounds(10, 30, 100, 25);
        jSTwo.setBounds(110, 30, 100, 25);
        jSThree.setBounds(210, 30, 100, 25);
        jSFour.setBounds(310, 30, 100, 25);
        jSFive.setBounds(410, 30, 100, 25);
        jI1.setBounds(10, 80, 100, 25);
        jI2.setBounds(110, 80, 100, 25);
        jI3.setBounds(210, 80, 100, 25);
        jD2.setBounds(310, 80, 100, 25);
        
        jLOne.setBounds(10, 10, 50, 25);
        jLTwo.setBounds(110, 10, 50, 25);
        jLThree.setBounds(210, 10, 50, 25);
        jLFour.setBounds(310, 10, 50, 25);
        jLFive.setBounds(410, 10, 100, 25);
        jLSix.setBounds(10, 59, 100, 25);
        jLSeven.setBounds(110, 59,100,25);
        jLEight.setBounds(210, 59, 100, 25);
        jLNine.setBounds(310, 59, 100, 25);
        
        jLOne.setText("Brand");
        jLTwo.setText("Model");
        jLThree.setText("Series");
        jLFour.setText("Form");
        jLFive.setText("Type");
        jLSix.setText("Size");
        jLSeven.setText("TDP");
        jLEight.setText("Cache");
        jLNine.setText("Price");
        
        jSOne.setVisible(false);
        jSTwo.setVisible(false);
        jSThree.setVisible(false);
        jSFour.setVisible(false);
        jSFive.setVisible(false);
        jI1.setVisible(false);
        jI2.setVisible(false);
        jI3.setVisible(false);
        jD2.setVisible(false);
        jLOne.setVisible(false);
        jLTwo.setVisible(false);
        jLThree.setVisible(false);
        jLFour.setVisible(false);
        jLFive.setVisible(false);
        jLSix.setVisible(false);
        jLSeven.setVisible(false);
        jLEight.setVisible(false);
        jLNine.setVisible(false);
        
        pHDrive.add(jSOne);
        pHDrive.add(jSTwo);
        pHDrive.add(jSThree);
        pHDrive.add(jSFour);
        pHDrive.add(jSFive);
        pHDrive.add(jI1);
        pHDrive.add(jI2);
        pHDrive.add(jI3);
        pHDrive.add(jD2);
        pHDrive.add(jLOne);
        pHDrive.add(jLTwo);
        pHDrive.add(jLThree);
        pHDrive.add(jLFour);
        pHDrive.add(jLFive);
        pHDrive.add(jLSix);
        pHDrive.add(jLSeven);
        pHDrive.add(jLEight);
        pHDrive.add(jLNine);
        pHDrive.add(deleteHDrive);
        pHDrive.add(jbtHDrive);
        
        clearInfo.setVisible(false);
        pHDrive.add(clearInfo);
        pHDrive.setBounds(5,55,800,370);
        pHDrive.setBackground(Color.green);
        pHDrive.setVisible(false);
        pHDrive.setLayout(null);
    }
    
    public static void main(String[] args)
    {
        AdminForm rd = new AdminForm();
        
    }
    
}