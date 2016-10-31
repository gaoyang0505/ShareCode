/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Residence;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.ResidenceOrganization;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.MayorWorkRequest;
import Business.WorkQueue.ResidenceWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Cassiopeia
 */
public class ResMessageBox extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise en;

    /**
     * Creates new form MessageBox
     */
    public ResMessageBox(JPanel upc, UserAccount ac, Enterprise enterprise) {
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
        TableColumn tc4 = jReceivedTab.getTableHeader().getColumnModel().getColumn(4);
        tc4.setMaxWidth(0);
        tc4.setMinWidth(0);
        tc4.setPreferredWidth(0);

        TableColumn ts = jSendTa.getTableHeader().getColumnModel().getColumn(3);
        ts.setMaxWidth(0);
        ts.setMinWidth(0);
        ts.setPreferredWidth(0);
        jDisButton.setVisible(false);
        jAgrButton.setVisible(false);
    }

    public void populateReceiveTable() {
        DefaultTableModel model = (DefaultTableModel) jReceivedTab.getModel();
        model.setRowCount(0);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");

        Organization org = null;
        for (Organization organization : en.getOrganizationDirectory().getOrganizationList()) {

            if (organization instanceof ResidenceOrganization) {
                org = organization;
                break;
            }
        }

        for (WorkRequest workRequest : userAccount.getWorkQueue().getWorkRequestList()) {
            if (workRequest.getReceiver().equals(userAccount)) {
                Object row[] = new Object[5];
                row[0] = workRequest.getSender();
                row[1] = ft.format(workRequest.getRequestDate());
                row[2] = workRequest.getMessageType();
                row[3] = workRequest.getMessage();
                String resultkk = ((ResidenceWorkRequest) workRequest).getConnectionResult();
                if (workRequest.getMessageType().equals("Connection")) {
                    row[4] = resultkk == null ? "Processing" : resultkk;
                } else {
                    row[4] = "";
                }
                ((DefaultTableModel) jReceivedTab.getModel()).addRow(row);
            }
        }

        for (WorkRequest wr : org.getWorkQueue().getWorkRequestList()) {

            Object rw[] = new Object[5];
            rw[0] = wr.getSender();
            rw[1] = ft.format(wr.getRequestDate());
            rw[2] = wr.getMessageType();
            rw[3] = wr.getMessage();
            rw[4] = wr.getStatus();
            ((DefaultTableModel) jReceivedTab.getModel()).addRow(rw);
        }

        int emerge = -1;
        try {
            for (int wi = 0; wi < jReceivedTab.getRowCount(); wi++) {
                if (jReceivedTab.getValueAt(wi, 2).toString().equals("Emergency")) {
                    emerge = wi;
                }
                int z = emerge;
                DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

                    public Component getTableCellRendererComponent(JTable table,
                            Object value, boolean isSelected, boolean hasFocus,
                            int row, int column) {

                        if (row == z) {
                            setBackground(new Color(233, 109, 91));
                        } else {
                            setBackground(Color.white);
                        }

                        return super.getTableCellRendererComponent(table, value,
                                isSelected, hasFocus, row, column);
                    }
                };
                for (int i = 0; i < jReceivedTab.getColumnCount(); i++) {
                    jReceivedTab.getColumn(jReceivedTab.getColumnName(i)).setCellRenderer(tcr);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void populateSendTable() {
        DefaultTableModel model = (DefaultTableModel) jSendTa.getModel();
        model.setRowCount(0);
        SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yyyy");

        for (WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()) {
            if (wr.getSender().equals(userAccount)) {
                Object row[] = new Object[5];
                if (wr.getReceiver() != null) {
                    row[0] = wr.getReceiver();
                } else {
                    row[0] = "Relations";
                }
                row[1] = ft.format(wr.getRequestDate());
                row[2] = wr.getMessageType();
                row[3] = wr.getMessage();
                String resultkk = ((ResidenceWorkRequest) wr).getConnectionResult();
                if (wr.getMessageType().equals("Connection")) {
                    row[4] = resultkk == null ? "Processing" : resultkk;
                } else {
                    row[4] = "";
                }
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
        jAgrButton = new javax.swing.JButton();
        jDisButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSendTa = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jReceivedTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Date", "Type", "Title 4", "Status"
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

        jAgrButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jAgrButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/ok.png"))); // NOI18N
        jAgrButton.setText("Agree");
        jAgrButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAgrButtonActionPerformed(evt);
            }
        });

        jDisButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jDisButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/no.png"))); // NOI18N
        jDisButton.setText("Disagree");
        jDisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jAgrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAgrButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Received", jPanel1);

        jSendTa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reciver", "Date", "Type", "Content", "Result"
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

        if (jReceivedTab.getValueAt(selectedRow, 2).toString().equals("Connection") && jReceivedTab.getValueAt(selectedRow, 4).toString().equals("Processing")) {
            jDisButton.setVisible(true);
            jAgrButton.setVisible(true);
        } else {
            jDisButton.setVisible(false);
            jAgrButton.setVisible(false);
        }

        if (jReceivedTab.getValueAt(selectedRow, 1).toString().equals("Connection")) {

            TableColumn tc4 = jReceivedTab.getTableHeader().getColumnModel().getColumn(4);
            tc4.setMaxWidth(10);
            tc4.setMinWidth(10);
            tc4.setPreferredWidth(10);
        } else {
            TableColumn tc4 = jReceivedTab.getTableHeader().getColumnModel().getColumn(4);
            tc4.setMaxWidth(0);
            tc4.setMinWidth(0);
            tc4.setPreferredWidth(0);
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

    private void jAgrButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAgrButtonActionPerformed
        int selectedRow = jReceivedTab.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }
//        WorkRequest request = (WorkRequest) jReceivedTab.getValueAt(selectedRow, 3);
        ResidenceWorkRequest request = new ResidenceWorkRequest();
        for (WorkRequest requ : userAccount.getWorkQueue().getWorkRequestList()) {
            if (requ.getMessage().equals(jTextArea1.getText())) {
                request = (ResidenceWorkRequest) requ;
            }
        }

        request.setStatus("Done");
        ((ResidenceWorkRequest) request).setConnectionResult("Connect");
        populateSendTable();
        JOptionPane.showMessageDialog(null, "Connect Successfully!");
    }//GEN-LAST:event_jAgrButtonActionPerformed

    private void jDisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDisButtonActionPerformed
        int selectedRow = jReceivedTab.getSelectedRow();

        if (selectedRow < 0) {
            return;
        }
        WorkRequest request = (WorkRequest) jReceivedTab.getValueAt(selectedRow, 3);
        request.setStatus("Done");
        ((ResidenceWorkRequest) request).setConnectionResult("Disconnect");
        populateSendTable();
    }//GEN-LAST:event_jDisButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAgrButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jDisButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable jReceivedTab;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jSendTa;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
