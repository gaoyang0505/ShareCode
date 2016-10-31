/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Mayor;


import Business.Enterprise.Enterprise;
import Business.Information.EnviornmentCondition;
import Business.Information.EnviornmentConditionDirectory;
import Business.Organization.DiplomacyOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.MayorWorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cassiopeia
 */
public class MayorWorkArea extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private String welcome;
    private EnviornmentConditionDirectory enList;
    /**
     * Creates new form MayorWorkArea
     */
    public MayorWorkArea(JPanel upc, Enterprise e, UserAccount ua, EnviornmentConditionDirectory list) {
        initComponents();
        
        userAccount = ua;
        userProcessContainer = upc;
        enterprise = e;
        enList = list;
        welcome = "Welcome " + enterprise + " Mayor";
        jLabelWelcome.setText(welcome);
        
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Warning");
        jComboBox1.addItem("Reminder");
        jComboBox1.addItem("Important");
        populateDipCB();
        populateCityAir();
    }
    
    public void populateCityAir(){
        DefaultTableModel model = (DefaultTableModel) jLocalTable.getModel();
        model.setRowCount(0);

        

        for (EnviornmentCondition env : enList.getEnviornmentConditionList()) {
            if (enterprise.toString().equals(env.getCitytoState().getCity())) {
                Object row[] = new Object[2];
                row[0] = env.getCitytoState().getLocal();
                row[1] = env.getAirCondition();
                ((DefaultTableModel) jLocalTable.getModel()).addRow(row);
            }
        }
    }

    public void populateDipCB(){
        jComboBox2.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof DiplomacyOrganization){
                for(UserAccount dipUser : organization.getUserAccountDirectory().getUserAccountList())
                    jComboBox2.addItem(dipUser);
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

        jMessageBoxBtn = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLocalTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jOrzBtn = new javax.swing.JButton();
        jEmpBtn = new javax.swing.JButton();
        jUserBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSendAllBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSendOneButton = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();
        jLabelWelcome = new javax.swing.JLabel();

        jMessageBoxBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMessageBoxBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/message-already-read-icon.png"))); // NOI18N
        jMessageBoxBtn.setText("Message Box");
        jMessageBoxBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMessageBoxBtnActionPerformed(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLocalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Community", "API"
            }
        ));
        jScrollPane2.setViewportView(jLocalTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check City Overall", jPanel1);

        jOrzBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jOrzBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/people-icon.png"))); // NOI18N
        jOrzBtn.setText("Manage Organization");
        jOrzBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOrzBtnActionPerformed(evt);
            }
        });

        jEmpBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jEmpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Preppy-icon.png"))); // NOI18N
        jEmpBtn.setText("Manage Emloyee");
        jEmpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmpBtnActionPerformed(evt);
            }
        });

        jUserBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Office-Girl-icon.png"))); // NOI18N
        jUserBtn.setText("Manage User Account");
        jUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(jEmpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jOrzBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(535, 535, 535))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jOrzBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jEmpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Manage Employee", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Message Type");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Content");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jSendAllBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSendAllBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/people-icon.png"))); // NOI18N
        jSendAllBtn.setText("Send To All Diplomacy Member");
        jSendAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendAllBtnActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Send to");

        jSendOneButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSendOneButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Preppy-icon.png"))); // NOI18N
        jSendOneButton.setText("Send");
        jSendOneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendOneButtonActionPerformed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox1, 0, 156, Short.MAX_VALUE))
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSendOneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48)
                                .addComponent(jSendAllBtn)))
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSendAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jSendOneButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Send Message", jPanel2);

        jLabelWelcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelWelcome.setForeground(new java.awt.Color(51, 204, 0));
        jLabelWelcome.setText("Welcome !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMessageBoxBtn)
                .addGap(57, 57, 57))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelWelcome)
                    .addComponent(jMessageBoxBtn))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jOrzBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOrzBtnActionPerformed
        ManageOrganizationJPanel manageEnterpriseJPanel = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("ManageOrganizationJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jOrzBtnActionPerformed

    private void jEmpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmpBtnActionPerformed
        ManageEmployeeJPanel manageEnterpriseJPanel = new ManageEmployeeJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("ManageEmployeeJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jEmpBtnActionPerformed

    private void jUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUserBtnActionPerformed
        
        ManageUserAccountJPanel manageEnterpriseJPanel = new ManageUserAccountJPanel(userProcessContainer, enterprise);
        userProcessContainer.add("ManageUserAccountJPanel", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jUserBtnActionPerformed

    private void jMessageBoxBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMessageBoxBtnActionPerformed
        MayorMessageBox manageEnterpriseJPanel = new MayorMessageBox(userProcessContainer, enterprise.getUserAccountDirectory().getUserAccountList().get(0),enterprise);
        userProcessContainer.add("MayorMessageBox", manageEnterpriseJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jMessageBoxBtnActionPerformed

    private void jSendAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendAllBtnActionPerformed
        String message = jTextArea1.getText();    
        MayorWorkRequest request = new MayorWorkRequest();
        request.setMessage(message);
        request.setMessageType(jComboBox1.getSelectedItem().toString());
        request.setSender(userAccount);
        request.setStatus("Sent");


        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof DiplomacyOrganization){
                org = organization;
                break;
            }
        }
        if (org!=null){
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue().getWorkRequestList().add(request);
            JOptionPane.showMessageDialog(null, "Sent Successfully!");
        }
    }//GEN-LAST:event_jSendAllBtnActionPerformed

    private void jSendOneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendOneButtonActionPerformed
        String message = jTextArea1.getText();    
        MayorWorkRequest request = new MayorWorkRequest();
        request.setMessage(message);
        request.setMessageType(jComboBox1.getSelectedItem().toString());
        request.setSender(userAccount);
        request.setReceiver((UserAccount)jComboBox2.getSelectedItem());
        request.setStatus("Sent");
        
        UserAccount messageReceiver = (UserAccount) jComboBox2.getSelectedItem();
        messageReceiver.getWorkQueue().getWorkRequestList().add(request);
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        JOptionPane.showMessageDialog(null, "Sent Successfully!");
    }//GEN-LAST:event_jSendOneButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JButton jEmpBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JTable jLocalTable;
    private javax.swing.JButton jMessageBoxBtn;
    private javax.swing.JButton jOrzBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jSendAllBtn;
    private javax.swing.JButton jSendOneButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jUserBtn;
    // End of variables declaration//GEN-END:variables
}