/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OLD;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author user
 */
public class TWall {
    
    public static void main(String[] args)
    {
        JFrame jf = new JFrame("Table example");
        
        String data[][] = {{"101", "One", "670000"},{"102","Two","780000"},{"101","Three","700000"}};
        String column[] = {"ID", "NAME", "SALARY"};
        final JTable jtb = new JTable(data, column);
        jtb.setCellSelectionEnabled(true);
        
        
        
        
        jtb.getModel().addTableModelListener(new TableModelListener(){
            
            public void tableChanged(TableModelEvent e)
            {
                
                String data = null;
                    
                int []row = jtb.getSelectedRows();
                int [] columns = jtb.getSelectedColumns();
                
                for(int i = 0; i < row.length; i++)
                {
                    for(int j = 0; j < columns.length; j++)
                    {
                        data = (String) jtb.getValueAt(row[i], columns[i]);
                        System.out.println("Table element selected is: " + data);
                    }
                }
                
                
            }
        
        });
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JScrollPane sp = new JScrollPane(jtb);
        jf.add(sp);
        jf.setSize(300,200);
        jf.setVisible(true);
        }
        
        
    
    
    
    
}
