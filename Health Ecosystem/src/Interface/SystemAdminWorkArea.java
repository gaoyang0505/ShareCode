/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.AControlClass.CityToStateList;
import Business.AControlClass.CitytoState;
import Business.AControlClass.OutExcel;
import Business.DB4OUtil.DB4OUtil;
import Business.Ecosystem.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Information.EnviornmentCondition;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.StateHealthWorkerRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Cassiopeia
 */
public class SystemAdminWorkArea extends javax.swing.JPanel {

    private final ImageIcon iconNo = new ImageIcon(getClass().getResource("/Interface/no.png"));
    private final ImageIcon iconOk = new ImageIcon(getClass().getResource("/Interface/ok.png"));
    private JPanel userProcessContainer;
    private Ecosystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    //For Excel
    private OutExcel mOExcel;
    private DefaultTableModel model;
    private File file;
    private File file1;
    private OutExcel mOExcel1;
    private DefaultTableModel model1;
    private CityToStateList citytoStateList;
    

    /**
     * Creates new form SystemAdminWorkArea
     */
    public SystemAdminWorkArea(JPanel upc, Ecosystem es) {
        this.setPreferredSize(new Dimension(800,550));
        initComponents();
        userProcessContainer = upc;
        system = es;
        iconLabel.setVisible(false);
        populateStateComboBox();
        populateTree();
        populateTable();
        citytoStateList = system.getCityToStateList();
        jStateComb.removeAllItems();
        jStateComb.addItem("Alabama");
        jStateComb.addItem("Alaska");
        jStateComb.addItem("Arizona");
        jStateComb.addItem("Arkansas");
        jStateComb.addItem("California");
        jStateComb.addItem("Connecticut");
        
        //For Excel
        mOExcel = new OutExcel();
        mOExcel1 = new OutExcel();
        model = (DefaultTableModel)jCTOS.getModel();
        model1 = (DefaultTableModel)jAirTable.getModel();
        file = new File("CityState.xls");
        file1 = new File("AirCondition.xls");

    }

    public void populateStateComboBox() {
        jStateCombox.removeAllItems();

        for (Network network : system.getNetworkList()) {
            if (network.getEmployeeDirectory().getEmployeeList().isEmpty()) {
                jStateCombox.addItem(network);
            }
        }
    }

    public void populateTree() {

        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        ArrayList<Network> networklist = system.getNetworkList();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Network network;
        Enterprise enterprise;
        Organization organization;

        DefaultMutableTreeNode networks = new DefaultMutableTreeNode("Networks");
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        root.insert(networks, 0);
        DefaultMutableTreeNode networkNode;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;

        for (int i = 0; i < networklist.size(); ++i) {
            network = networklist.get(i);
            networkNode = new DefaultMutableTreeNode(network.getNetWorkName());
            networks.insert(networkNode, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();

            for (int j = 0; j < enterpriseList.size(); ++j) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNode.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); ++k) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }
        model.reload();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) jStateTable.getModel();
        model.setRowCount(0);

        for (Network network : system.getNetworkList()) {
            for (UserAccount ua : network.getUserAccountDirectory().getUserAccountList()) {
                if (ua.getEmployeeStatus().equals("StateHealthWorkerRole")) {
                    Object row[] = new Object[2];
                    row[0] = ua.getEmployee().getNameEmployee();
                    row[1] = ua.getUsername();
                    ((DefaultTableModel) jStateTable.getModel()).addRow(row);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jCreateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        jStateComb = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jStateCombox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSUserNameText = new javax.swing.JTextField();
        iconLabel = new javax.swing.JLabel();
        jSPasswordText1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordText2 = new javax.swing.JPasswordField();
        jStateAdminCreateBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jStateTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jCTOS = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jAirTable = new javax.swing.JTable();

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jCreateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jCreateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-edit-icon.png"))); // NOI18N
        jCreateBtn.setText("Create");
        jCreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Network Name");

        jTree.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Eco-System");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree);

        jStateComb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jStateComb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jCreateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jStateComb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jStateComb, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manage State", jPanel1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Create Network Admin to State");

        jStateCombox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jStateCombox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("User Name");

        jSUserNameText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jSUserNameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jSUserNameTextFocusLost(evt);
            }
        });

        iconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/no.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Confirm Password");

        jStateAdminCreateBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jStateAdminCreateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/document-edit-icon.png"))); // NOI18N
        jStateAdminCreateBtn.setText("Create");
        jStateAdminCreateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStateAdminCreateBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 255));
        jLabel6.setText("Only Numbers and Characters");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasswordText2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSUserNameText, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSPasswordText1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jStateAdminCreateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(61, 61, 61)))
                        .addComponent(iconLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jStateCombox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jStateCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jSUserNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel6))
                    .addComponent(iconLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSPasswordText1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordText2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jStateAdminCreateBtn)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create State Health", jPanel2);

        jStateTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "State", "User Name"
            }
        ));
        jScrollPane2.setViewportView(jStateTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Browser State Health", jPanel3);

        jCTOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "State", "City", "Local"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jCTOS);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Import");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jAirTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jAirTable);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("Data Preperation", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateBtnActionPerformed
        
        String name = jStateComb.getSelectedItem().toString();
        int i = 0;

        for (Network network : system.getNetworkList()) {
            if (network.getNetWorkName().equals(name)) {
                break;
            } else {
                i = i + 1;
            }
        }

        if (i == system.getNetworkList().size()) {
            Network network = system.createAndAddNetwork();
            network.setNetWorkName(name);

            populateTree();
            populateStateComboBox();
        } else {
            JOptionPane.showMessageDialog(null, "Existed!");
        }

    }//GEN-LAST:event_jCreateBtnActionPerformed

    private void jSUserNameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSUserNameTextFocusLost
        iconLabel.setVisible(true);
        if (!isEligibleString(jSUserNameText.getText())) {
            iconLabel.setIcon(iconNo);
        } else {
            iconLabel.setIcon(iconOk);
        }
    }//GEN-LAST:event_jSUserNameTextFocusLost

    public boolean isEligibleString(String checkUserName) {
        if (jSUserNameText.getText().length() > 0) {
            return checkUserName.matches("^[a-z0-9A-Z]+$");
        } else {
            return false;
        }
    }


    private void jStateAdminCreateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStateAdminCreateBtnActionPerformed
        // TODO add your handling code here:
        if (isAllowedToCreateAccount()) {

            Network network = (Network) jStateCombox.getSelectedItem();
            char[] passwordCharArray = jSPasswordText1.getPassword();
            String password = String.valueOf(passwordCharArray);
            Employee employee = network.getEmployeeDirectory().createEmployee(jStateCombox.getSelectedItem().toString());
            UserAccount ua = network.getUserAccountDirectory().createUserAccount(jSUserNameText.getText(), password, "StateHealthWorkerRole", new StateHealthWorkerRole(), employee);

            jPasswordText2.setText("");
            jSPasswordText1.setText("");
            jSUserNameText.setText("");
            iconLabel.setVisible(false);

            populateStateComboBox();
            populateTable();

            JOptionPane.showMessageDialog(null, "Successfully Create!");
        } else {
            JOptionPane.showMessageDialog(null, "User Name or Password Has Problem, Retry!");
            jSPasswordText1.setText("");
            jPasswordText2.setText("");
            jSUserNameText.setText("");
            iconLabel.setVisible(false);

        }
    }//GEN-LAST:event_jStateAdminCreateBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mOExcel.readExcel(file, model, jCTOS);
        mOExcel1.readExcel(file1, model1, jAirTable);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        
        for(int j = 0; j<jCTOS.getRowCount(); j++){
            CitytoState citytoState = new CitytoState();
            citytoState.setCity(jCTOS.getValueAt(j, 1).toString());
            citytoState.setState(jCTOS.getValueAt(j, 0).toString());
            citytoState.setLocal(jCTOS.getValueAt(j, 2).toString());
            citytoStateList.addCity(citytoState);
        }
        for(int k = 0; k<jAirTable.getRowCount(); k++){
            EnviornmentCondition ec = new EnviornmentCondition();
            ec.getCitytoState().setState(jAirTable.getValueAt(k, 0).toString());
            ec.getCitytoState().setCity(jAirTable.getValueAt(k, 1).toString());
            ec.getCitytoState().setLocal(jAirTable.getValueAt(k, 2).toString());
            ec.setAirCondition((int)jAirTable.getValueAt(k, 3));
            system.getEnviornmentConditionDirectory().addAir(ec);
        }
        JOptionPane.showMessageDialog(null, "Successfully Create!");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public boolean isAllowedToCreateAccount() {
        char[] passwordCharArray = jSPasswordText1.getPassword();
        String password = String.valueOf(passwordCharArray);

        char[] conPasswordCharArray = jPasswordText2.getPassword();
        String conPassword = String.valueOf(conPasswordCharArray);

        int isNull = jSUserNameText.getText().length() * conPassword.length() * password.length();
        return jStateCombox.getSelectedIndex() > -1 && isNull > 0 && password.equals(conPassword) && isEligibleString(jSUserNameText.getText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLabel;
    private javax.swing.JTable jAirTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTable jCTOS;
    private javax.swing.JButton jCreateBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordText2;
    private javax.swing.JPasswordField jSPasswordText1;
    private javax.swing.JTextField jSUserNameText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jStateAdminCreateBtn;
    private javax.swing.JComboBox jStateComb;
    private javax.swing.JComboBox jStateCombox;
    private javax.swing.JTable jStateTable;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTree jTree;
    // End of variables declaration//GEN-END:variables
}
