/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.State;

import Business.AControlClass.CitytoState;
import Business.Ecosystem.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.GovernmentEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Information.EnviornmentCondition;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.StateWorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author Cassiopeia
 */
public class StateHealthOfficeWorkArea extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Network network;
    private UserAccount userAccount;
    private Ecosystem ecosystem;

    /**
     * Creates new form StateHealthOfficeWorkArea
     */
    public StateHealthOfficeWorkArea(JPanel upc, Network jNetwork, Ecosystem ec) {

        this.setPreferredSize(new Dimension(800, 550));
        network = jNetwork;
        userProcessContainer = upc;
        ecosystem = ec;
        userAccount = network.getUserAccountDirectory().getUserAccountList().get(0);
        initComponents();

        jComboBoxLocal.removeAllItems();
        String display = network.getNetWorkName() + " Health Center";
        jStateNameLabel.setText(display);

        populateCityAirTable();
        populateComboBox();
        populateEnterpriseTable();

        jLabel6.setVisible(false);
        jComboBox1.setVisible(false);
        jComboBoxLocal.setVisible(false);
        jLabel7.setVisible(false);
        nameJTextField.setVisible(false);
        populateCityCB();
        populateEnterCb();
        jTextField1.setText(calculatAve());
        findMax(jCityAirTable, 1);
        findMax(jLocalTable, 2);

    }

    public void findMax(JTable jt, int m) {
        int temp;
        int max;
        int indexT = 0;
        max = Integer.parseInt(jt.getValueAt(0, m).toString());
        for (int i = 1; i < jt.getRowCount(); i++) {
            temp = Integer.parseInt(jt.getValueAt(i, m).toString());
            if (temp > max) {
                max = temp;
                indexT = i;
            }
        }

        try {
            int z = indexT;
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
            for (int i = 0; i < jt.getColumnCount(); i++) {
                jt.getColumn(jt.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String calculatAve() {
        String ave;
        int api = 0;
        for (int j = 0; j < jCityAirTable.getRowCount(); j++) {
            api = Integer.parseInt(jCityAirTable.getValueAt(j, 1).toString()) + api;
        }
        ave = String.valueOf(api / jCityAirTable.getRowCount());
        return ave;
    }

    public void populateEnterCb() {
        jCityCom.removeAllItems();
        for (CitytoState citytoState : ecosystem.getCityToStateList().getCityToStateList()) {
            if (citytoState.getState().equals(network.getNetWorkName())) {
                jCityCom.addItem(citytoState.getCity());
            }
        }

        for (int i = 0; i < jCityCom.getItemCount(); i++) {
            String city = jCityCom.getItemAt(i).toString();
            for (int j = i + 1; j < jCityCom.getItemCount(); j++) {
                if (city.equals(jCityCom.getItemAt(j).toString())) {
                    jCityCom.removeItemAt(j);
                    j = j - 1;
                }
            }
        }
    }

    public void populateCityCB() {
        jComboBox1.removeAllItems();
        for (Enterprise enter : network.getEnterpriseDirectory().getEnterpriseList()) {
            if (enter.getEnterpriseType().getValue().equals("City Government")) {
                jComboBox1.addItem(enter);
            }
        }

    }

    public void populateEnterpriseTable() {

        DefaultTableModel model = (DefaultTableModel) jEnterpriseTable.getModel();
        model.setRowCount(0);

        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            Object row[] = new Object[3];
            row[0] = enterprise;
            row[1] = enterprise.getEnterpriseType().getValue();
            row[2] = "Need One";
            for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                if (ua.getEmployeeStatus().equals("Hospital") || ua.getEmployeeStatus().equals("Mayor")) {
                    row[2] = ua.getUsername();
                }
            }
            ((DefaultTableModel) jEnterpriseTable.getModel()).addRow(row);
        }
    }

    public void populateCityAirTable() {
        DefaultTableModel model = (DefaultTableModel) jCityAirTable.getModel();
        model.setRowCount(0);
        DefaultTableModel model1 = (DefaultTableModel) jLocalTable.getModel();
        model1.setRowCount(0);

        for (EnviornmentCondition enterprise : ecosystem.getEnviornmentConditionDirectory().getEnviornmentConditionList()) {
            if (network.getNetWorkName().equals(enterprise.getCitytoState().getState())) {
                Object row[] = new Object[2];
                row[0] = enterprise.getCitytoState().getCity();
                row[1] = enterprise.getAirCondition();
                ((DefaultTableModel) jCityAirTable.getModel()).addRow(row);

                for (int i = 0; i < jCityAirTable.getRowCount(); i++) {
                    String city = jCityAirTable.getValueAt(i, 0).toString();
                    for (int j = i + 1; j < jCityAirTable.getRowCount(); j++) {
                        if (city.equals(jCityAirTable.getValueAt(j, 0).toString())) {
                            int api = (Integer.parseInt(jCityAirTable.getValueAt(j, 1).toString()) + Integer.parseInt(jCityAirTable.getValueAt(i, 1).toString())) / 2;
                            model.setValueAt(api, i, 1);
                            ((DefaultTableModel) jCityAirTable.getModel()).removeRow(j);
                        }
                    }
                }

                Object rw[] = new Object[3];
                rw[0] = enterprise.getCitytoState().getCity();
                rw[1] = enterprise.getCitytoState().getLocal();
                rw[2] = enterprise.getAirCondition();
                ((DefaultTableModel) jLocalTable.getModel()).addRow(rw);
            }
        }
    }

    public void populateComboBox() {

        enterpriseTypeJComboBox.removeAllItems();

        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            enterpriseTypeJComboBox.addItem(type);
        }

        jMessageType.removeAllItems();
        jMessageType.addItem("Warning");
        jMessageType.addItem("Reminder");
        jMessageType.addItem("Important");

        jReceiverCB.removeAllItems();
        for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
            for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                if (enterprise.getEnterpriseType().getValue().equals("City Government")) {
                    jReceiverCB.addItem(ua);
                }
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

        jStateNameLabel = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jCityAirTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLocalTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEnterpriseTable = new javax.swing.JTable();
        jEnterAdmin = new javax.swing.JButton();
        enterpriseTypeJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        submitJButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jCityCom = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxLocal = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jMessageType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSendBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jReceiverCB = new javax.swing.JComboBox();
        jQRButton = new javax.swing.JButton();

        jStateNameLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jStateNameLabel.setForeground(new java.awt.Color(255, 153, 0));
        jStateNameLabel.setText("jLabel1");

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jCityAirTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCityAirTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "City", "API"
            }
        ));
        jScrollPane3.setViewportView(jCityAirTable);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("State Average API");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 102));
        jLabel9.setText("City Average API");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("City", jPanel5);

        jLocalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "City", "Local", "AirCondition"
            }
        ));
        jScrollPane4.setViewportView(jLocalTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Local", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Air Overall", jPanel2);

        jEnterpriseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Name", "Enterprise Type", "Enterprise Admin"
            }
        ));
        jScrollPane1.setViewportView(jEnterpriseTable);

        jEnterAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jEnterAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-edit-icon.png"))); // NOI18N
        jEnterAdmin.setText("Create Enterprise Admin");
        jEnterAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEnterAdminActionPerformed(evt);
            }
        });

        enterpriseTypeJComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enterpriseTypeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseTypeJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseTypeJComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Enterprise Type");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Enterprise Name");

        nameJTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        submitJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        submitJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add-icon.png"))); // NOI18N
        submitJButton.setText("Create Enterprise");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Hospital Address");

        jCityCom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCityCom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Enterprise Name");

        jComboBoxLocal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxLocal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCityCom, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterpriseTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxLocal, 0, 143, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(submitJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jEnterAdmin)))
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(enterpriseTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCityCom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEnterAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Manage Enterprise", jPanel1);

        jMessageType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jMessageType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Message Type");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Content");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jSendBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jSendBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-edit-icon.png"))); // NOI18N
        jSendBtn.setText("Send To Mayor");
        jSendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Receiver");

        jReceiverCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jReceiverCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jQRButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jQRButton.setText("QRCode");
        jQRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQRButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jMessageType, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jReceiverCB, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jQRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jMessageType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jReceiverCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jQRButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Send Message", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jStateNameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jStateNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) enterpriseTypeJComboBox.getSelectedItem();

        if (type == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return;
        } else {
            String judge = enterpriseTypeJComboBox.getSelectedItem().toString();
            if (judge.equals("Hospital") && jComboBoxLocal.getSelectedIndex() > -1 && nameJTextField.getText().length() > 0) {
                String name = nameJTextField.getText();
                Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, type);
                ((HospitalEnterprise) enterprise).setHospitalCity(jComboBox1.getSelectedItem().toString());
                ((HospitalEnterprise) enterprise).setHospitalCommunity(jComboBoxLocal.getSelectedItem().toString());
                populateEnterpriseTable();
                JOptionPane.showMessageDialog(null, "Successfully Create!");
                nameJTextField.setText("");
            } else if (judge.equals("CityGovernment")) {

                String name = jCityCom.getSelectedItem().toString();
                int i = 0;
                int j = 0;

                for (Enterprise s : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (s instanceof GovernmentEnterprise) {
                        if (s.toString().equals(name)) {
                            break;
                        } else {
                            i = i + 1;
                        }
                    }
                }

                for (Enterprise s : network.getEnterpriseDirectory().getEnterpriseList()) {
                    if (s instanceof GovernmentEnterprise) {
                        j = j + 1;
                    }
                }

                if (i == j) {
                    Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, type);
                    populateEnterpriseTable();
                    JOptionPane.showMessageDialog(null, "Successfully Create!");
                } else {
                    JOptionPane.showMessageDialog(null, "Existed!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Check!");
            }

        }


    }//GEN-LAST:event_submitJButtonActionPerformed

    private void jEnterAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEnterAdminActionPerformed
        int selectedRow = jEnterpriseTable.getSelectedRow();

        if (selectedRow >= 0 && jEnterpriseTable.getValueAt(selectedRow, 2).toString().equals("Need One")) {
            Enterprise enterpriseIn = (Enterprise) jEnterpriseTable.getValueAt(selectedRow, 0);
            EnterpriseAdminCreateJPanel manageEnterpriseAdminJPanel = new EnterpriseAdminCreateJPanel(userProcessContainer, enterpriseIn);
            userProcessContainer.add("EnterpriseAdminCreateJPanel", manageEnterpriseAdminJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } else {
            JOptionPane.showMessageDialog(null, "Select One Enterprise Without Admin!");
        }
    }//GEN-LAST:event_jEnterAdminActionPerformed

    private void jSendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendBtnActionPerformed

        String message = jTextArea1.getText();

        StateWorkRequest request = new StateWorkRequest();
        request.setMessage(message);
        request.setMessageType(jMessageType.getSelectedItem().toString());
        request.setSender(userAccount);
        request.setReceiver((UserAccount) jReceiverCB.getSelectedItem());
        request.setStatus("Sent");

        UserAccount messageReceiver = (UserAccount) jReceiverCB.getSelectedItem();
        messageReceiver.getWorkQueue().getWorkRequestList().add(request);
        userAccount.getWorkQueue().getWorkRequestList().add(request);
        JOptionPane.showMessageDialog(null, "Sent Successfully!");
    }//GEN-LAST:event_jSendBtnActionPerformed

    private void enterpriseTypeJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseTypeJComboBoxActionPerformed
        if (enterpriseTypeJComboBox.getSelectedItem() != null) {
            String judge = enterpriseTypeJComboBox.getSelectedItem().toString();
            if (judge.equals("Hospital")) {
                jLabel6.setVisible(true);
                jComboBox1.setVisible(true);
                jComboBoxLocal.setVisible(true);
                jLabel7.setVisible(true);
                nameJTextField.setVisible(true);
                jCityCom.setVisible(false);
                jLabel4.setVisible(false);
                populateCityCB();
            } else {
                jLabel6.setVisible(false);
                jComboBox1.setVisible(false);
                jComboBoxLocal.setVisible(false);
                jLabel7.setVisible(false);
                nameJTextField.setVisible(false);
                jCityCom.setVisible(true);
                jLabel4.setVisible(true);
            }
        }
    }//GEN-LAST:event_enterpriseTypeJComboBoxActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        Object object = jComboBox1.getSelectedItem();
        if (object != null) {
            jComboBoxLocal.removeAllItems();
            for (CitytoState citytoState : ecosystem.getCityToStateList().getCityToStateList()) {
                if (citytoState.getCity().equals(jComboBox1.getSelectedItem().toString())) {
                    jComboBoxLocal.addItem(citytoState.getLocal());
                }
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jQRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQRButtonActionPerformed

        String details = userAccount.getUsername() + "sent following " + jMessageType.getSelectedItem().toString() + " type message to " + jReceiverCB.getSelectedItem().toString() + " The Message is " + jTextArea1.getText();
        ByteArrayOutputStream out;
        out = QRCode.from(details).to(ImageType.JPG).stream();

        File f = new File("MyChannel.jpg");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(f);
            fos.write(out.toByteArray());
            fos.flush();
//            JOptionPane.showMessageDialog(null, "Created!");
        } catch (Exception e) {
        }

        Image image = null;
        try {
            // Read from a file
            File sourceimage = new File("MyChannel.jpg");  //source.gif图片要与HelloJava.java同在一目录下
            image = ImageIO.read(sourceimage);

        } catch (IOException e) {
        }

        // Use a label to display the image
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        //关闭窗口--退出调试
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }//GEN-LAST:event_jQRButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox enterpriseTypeJComboBox;
    private javax.swing.JTable jCityAirTable;
    private javax.swing.JComboBox jCityCom;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBoxLocal;
    private javax.swing.JButton jEnterAdmin;
    private javax.swing.JTable jEnterpriseTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTable jLocalTable;
    private javax.swing.JComboBox jMessageType;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JButton jQRButton;
    private javax.swing.JComboBox jReceiverCB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jSendBtn;
    private javax.swing.JLabel jStateNameLabel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
