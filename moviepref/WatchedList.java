/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package moviepref;

import java.sql.*;

/**
 *
 * @author shriv
 */
public class WatchedList extends javax.swing.JFrame {

    String user;
    int i=0;
    public Statement stmt;
    public Connection con;
    javax.swing.table.DefaultTableModel model=new javax.swing.table.DefaultTableModel(new Object [][] {

            },
           new String [] {
                "Watched", "Name", "Year", "Rating"
            });
    Boolean wat;
    public WatchedList(String Username)throws Exception {
        initComponents();
        user=Username;
        
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/moviepreference","root","password");  
        stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select MovieName,Year,UserRating,Status from "+user+"movies");  
        while(rs.next()){ 
        if (rs.getString(4).equals("Not Watched"))
        {
            wat=false;
        }
        else
        {
            wat=true;
        }
        model.addRow(new Object[]{wat,rs.getString(1),rs.getString(2),rs.getString(3)});
        i++;
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tab1 = new javax.swing.JTable(model){
            @Override
            public Class getColumnClass(int col)
            {
                if (col==0)
                {
                    return Boolean.class;
                }
                else{ return String.class;
                }
            }
            public boolean isCellEditable(int row,int col)
            {
                if ((col==1)||(col ==2))
                {
                    return false;
                }
                else
                {
                    return true;
                }
            }
        };
        b2 = new javax.swing.JButton();
        l1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 152));

        b1.setText("Back");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        Tab1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Tab1.setModel(model);
        Tab1.setShowGrid(true);
        jScrollPane1.setViewportView(Tab1);

        b2.setText("Done");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        l1.setFont(new java.awt.Font("Century Gothic", 0, 10)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(b2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(b1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(b1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        this.setVisible(false);
        try{
        new Watched(user).setVisible(true);}
        catch(Exception e){System.out.println(e);}        // TODO add your handling code here:
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        Boolean w;
        Boolean ch=true;
        for(int j=0;j<i;j++)
        {
            w=((Boolean) Tab1.getValueAt(j,0)).booleanValue();
           try{
            if (w){
                if(String.valueOf(Tab1.getValueAt(j, 3)).equals("N/A") || String.valueOf(Tab1.getValueAt(j, 3)).equals("null"))
                {
                    l1.setText("Incomplete Rating at Movie "+String.valueOf(Tab1.getValueAt(j, 1)));
                    ch=false;
                }
                else{
                stmt.execute("update "+user+"movies set Status='Watched',UserRating='"+String.valueOf(Tab1.getValueAt(j, 3))+"' where MovieName='"+String.valueOf(Tab1.getValueAt(j, 1))+"';");
             }
            }
           else
            {
              stmt.execute("update "+user+"movies set Status='Not Watched',UserRating='N/A' where MovieName='"+String.valueOf(Tab1.getValueAt(j, 1))+"';");  
            }
           }
            catch(Exception e){System.out.println(e);}
        }
        if(ch){
        this.setVisible(false);
        try{
        new Watched(user).setVisible(true);}
        catch(Exception e){System.out.println(e);}}
                
    }//GEN-LAST:event_b2ActionPerformed
    public static void main(String args[]) throws Exception
    {
        new WatchedList("").setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tab1;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    // End of variables declaration//GEN-END:variables
}
