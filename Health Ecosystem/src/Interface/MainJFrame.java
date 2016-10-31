/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.DB4OUtil.DB4OUtil;
import Business.Ecosystem.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Cassiopeia
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    // private JPanel userProcessContainer;
    private Ecosystem system;
    private DB4OUtil dB4OUtil;

    public MainJFrame() {
        
        this.setPreferredSize(new Dimension(800, 600));
        this.setResizable(false);
   
        initComponents();
        dB4OUtil = DB4OUtil.getInstance();
        system = dB4OUtil.retrieveSystem();
//
//        this.setSize(535, 419);
//        Timer timer = new Timer();  
//        /* void java.util.Timer.schedule(TimerTask task, long delay) */  
//        timer.schedule(new TimerTask() {  
//            public void run() {  
//                EcoSystemJPanel panel = new EcoSystemJPanel(userProcessContainer);
//                userProcessContainer.add("EcoSystemJPanel",panel);
//                CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
//                cardLayout.next(userProcessContainer);
//                
//            }  
//        }, 1000);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLoginBtn = new javax.swing.JButton();
        jLogOutBtn = new javax.swing.JButton();
        jUserNameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordText = new javax.swing.JPasswordField();
        mainProcessContainer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jSplitPane1.setDividerLocation(50);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLoginBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLoginBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Log-Out-icon.png"))); // NOI18N
        jLoginBtn.setText("Login");
        jLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginBtnActionPerformed(evt);
            }
        });

        jLogOutBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLogOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logout-icon.png"))); // NOI18N
        jLogOutBtn.setText("Log Out");
        jLogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogOutBtnActionPerformed(evt);
            }
        });

        jUserNameText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("User Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUserNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(jLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jUserNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        mainProcessContainer.setLayout(new java.awt.CardLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/original_XCsR_3a6e0000354f1260.png"))); // NOI18N
        mainProcessContainer.add(jLabel3, "card2");

        jSplitPane1.setRightComponent(mainProcessContainer);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginBtnActionPerformed
        // Get user name
        String userName = jUserNameText.getText();
        // Get Password
        char[] passwordCharArray = jPasswordText.getPassword();
        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the system user account directory if you have the user
        UserAccount userAccount = system.getUserAccountDirectory().authenticateUser(userName, password);
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        Network inNetwork = null;
        if (userAccount == null) {
            for (Network network : system.getNetworkList()) {
                userAccount = network.getUserAccountDirectory().authenticateUser(userName, password);
                if (userAccount == null) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        userAccount = enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                        if (userAccount == null) {
                            //Step3: Check against each organization inside that enterprise
                            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
                                if (userAccount != null) {
                                    inNetwork = network;
                                    inEnterprise = enterprise;
                                    inOrganization = organization;
                                
                                    break;
                                }
                            }
                        } else {
                            inEnterprise = enterprise;
                            
                            break;
                        }
                        if (inOrganization != null) {
                            break;
                        }
                    }
                    if (inEnterprise != null) {
                        break;
                    }
                } else {
                    inNetwork = network;
                }
                if (inNetwork != null) {
                    break;
                }
            }
        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid Credentails!");
            return;
        } else {
            mainProcessContainer.removeAll();
            mainProcessContainer.add("workArea", userAccount.getRole().createWorkArea(mainProcessContainer, userAccount, inOrganization, inEnterprise, inNetwork, system));
            CardLayout layout = (CardLayout) mainProcessContainer.getLayout();
            layout.next(mainProcessContainer);
            jPasswordText.setText("");
            jUserNameText.setText("");
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            jPasswordText.setVisible(false);
            jUserNameText.setVisible(false);
            jLoginBtn.setVisible(false);
        }
    }//GEN-LAST:event_jLoginBtnActionPerformed

    private void jLogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogOutBtnActionPerformed

        mainProcessContainer.removeAll();
        MainJFrame blankJP = new MainJFrame();

        mainProcessContainer.add("blank", blankJP.mainProcessContainer);
        CardLayout crdLyt = (CardLayout) mainProcessContainer.getLayout();
        crdLyt.next(mainProcessContainer);

        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jPasswordText.setVisible(true);
        jUserNameText.setVisible(true);
        jLoginBtn.setVisible(true);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_jLogOutBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jLogOutBtn;
    private javax.swing.JButton jLoginBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordText;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField jUserNameText;
    private javax.swing.JPanel mainProcessContainer;
    // End of variables declaration//GEN-END:variables
}
