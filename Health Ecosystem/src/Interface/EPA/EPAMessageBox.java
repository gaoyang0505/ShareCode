/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.EPA;

import Business.Enterprise.Enterprise;
import Business.Organization.DiplomacyOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MayorWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Cassiopeia
 */
public class EPAMessageBox extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise en;

    /**
     * Creates new form MessageBox
     */
    public EPAMessageBox(JPanel upc, UserAccount ac, Enterprise enterprise) {
        initComponents();
        userProcessContainer = upc;
        userAccount = ac;
        en = enterprise;
        populateReceiveTable();
        populateSendTable();
        TableColumn tc = jReceivedTab.getTableHeader().getColumnModel().getColumn(3);
        tc.setMaxWidth(0);
        tc.setMinWidth(0);
        tc.setPreferredWidth(0);

        TableColumn ts = jSendTa.getTableHeader().getColumnModel().getColumn(3);
        ts.setMaxWidth(0);
        ts.setMinWidth(0);
        ts.setPreferredWidth(0);
    }

    public void populateReceiveTable() {
        DefaultTableModel model = (DefaultTableModel) jReceivedTab.getModel();
        model.setRowCount(0);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");

        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()) {
            if (wr.getReceiver() != null && wr.getReceiver().equals(userAccount)) {
                Object row[] = new Object[4];
                row[0] = wr.getSender();
                row[1] = ft.format(wr.getRequestDate());
                row[2] = wr.getMessageType();
                row[3] = wr.getMessage();
                ((DefaultTableModel) jReceivedTab.getModel()).addRow(row);
            }
        }

    }

    public void populateSendTable() {
        DefaultTableModel model = (DefaultTableModel) jSendTa.getModel();
        model.setRowCount(0);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");

        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()) {
            if (wr.getSender().equals(userAccount)) {
                Object row[] = new Object[4];
                if (wr.getReceiver() != null) {
                    row[0] = wr.getReceiver();
                } else {
                    row[0] = "All Diplomacy";
                }
                row[1] = ft.format(wr.getRequestDate());
                row[2] = wr.getMessageType();
                row[3] = wr.getMessage();
                ((DefaultTableModel) jSendTa.getModel()).addRow(row);
            }
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jReceivedTab = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSendTa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jSendAgainBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jReceivedTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Date", "Type", "Title 4"
            }
        ));
        jReceivedTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jReceivedTabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jReceivedTab);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Message Details");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );

        jTabbedPane1.addTab("Received", jPanel1);

        jSendTa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reciver", "Date", "Type", "Content"
            }
        ));
        jSendTa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSendTaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jSendTa);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Message Details");

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jSendAgainBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSendAgainBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/message-already-read-icon.png"))); // NOI18N
        jSendAgainBtn.setText("Send Again");
        jSendAgainBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendAgainBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSendAgainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jSendAgainBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sended", jPanel2);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/arrow-back-icon.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jReceivedTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jReceivedTabMouseClicked
        int selectedRow = jReceivedTab.getSelectedRow();
        String mes;
        mes = jReceivedTab.getValueAt(selectedRow, 3).toString();
        if (selectedRow >= 0) {
            jTextArea1.setText(mes);
        }
    }//GEN-LAST:event_jReceivedTabMouseClicked

    private void jSendTaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSendTaMouseClicked
        int selectedRow = jSendTa.getSelectedRow();
        String mesJ;
        mesJ = jSendTa.getValueAt(selectedRow, 3).toString();
        if (selectedRow >= 0) {
            jTextArea2.setText(mesJ);
        }
    }//GEN-LAST:event_jSendTaMouseClicked

    private void jSendAgainBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendAgainBtnActionPerformed

        int selectedRow = jSendTa.getSelectedRow();
        MayorWorkRequest request = new MayorWorkRequest();
        String message = jTextArea2.getText();

        if (selectedRow > -1) {
            request.setMessage(message);
            request.setMessageType(jSendTa.getValueAt(selectedRow, 2).toString());
            request.setSender(userAccount);
            request.setReceiver((UserAccount) jSendTa.getValueAt(selectedRow, 0));
            request.setStatus("Sent");

            UserAccount messageReceiver = (UserAccount) jSendTa.getValueAt(selectedRow, 0);
            messageReceiver.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Sent Successfully!");

            populateSendTable();

        } else {
            JOptionPane.showMessageDialog(null, "Sent Successfully!");
        }
// TODO add your handling code here:
//        dfdrdytfgicduvoyngyubdyseoygnoymgubdyvsev;
    }//GEN-LAST:event_jSendAgainBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jReceivedTab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jSendAgainBtn;
    private javax.swing.JTable jSendTa;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
