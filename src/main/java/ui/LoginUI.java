package ui;

import java.awt.Color;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khoa
 */
public class LoginUI extends javax.swing.JFrame {
    final String path_ubuntu = "/src/main/java/images/";
    final String path_win = "\\src\\main\\java\\images\\";
    String os = System.getProperty("os.name").toLowerCase();
    final private String dir;
    private static String public_ip;
    private static int port;
    /**
     * Creates new form ui.LoginUI
     */
    public LoginUI() {
        if (os.equals("linux")) {
            dir = System.getProperty("user.dir") + path_ubuntu;
        } else {
            dir = System.getProperty("user.dir") + path_win;
        }
        initComponents();
        this.signin_pane.setVisible(true);
        this.signup_pane.setVisible(false);
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
        signup_choice = new javax.swing.JButton();
        login_choice = new javax.swing.JButton();
        signup_pane = new javax.swing.JPanel();
        sigup_label = new javax.swing.JLabel();
        name_signup_label = new javax.swing.JLabel();
        name_signup_input = new javax.swing.JTextField();
        Separator_name_signup = new javax.swing.JSeparator();
        user_signup_label = new javax.swing.JLabel();
        user_signup_input = new javax.swing.JTextField();
        jSeparator_user_signup = new javax.swing.JSeparator();
        pass_signup_label = new javax.swing.JLabel();
        Separator_pass_signup = new javax.swing.JSeparator();
        pass_signup_input = new javax.swing.JPasswordField();
        name_logo = new javax.swing.JLabel();
        user_signup_logo = new javax.swing.JLabel();
        pass_signup_logo = new javax.swing.JLabel();
        signup_but = new javax.swing.JButton();
        signin_pane = new javax.swing.JPanel();
        login_label = new javax.swing.JLabel();
        user_label = new javax.swing.JLabel();
        pass_label = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        pass_input = new javax.swing.JPasswordField();
        user_input = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        login_but = new javax.swing.JButton();
        backgeound_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat Box");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new Color(0,0,0,60));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        signup_choice.setBackground(new java.awt.Color(0, 51, 51));
        signup_choice.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        signup_choice.setForeground(new java.awt.Color(255, 255, 255));
        signup_choice.setText("Sign Up");
        signup_choice.setBorderPainted(false);
        signup_choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signup_choiceMouseClicked(evt);
            }
        });
        jPanel1.add(signup_choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 250, 80));

        login_choice.setBackground(new java.awt.Color(0, 51, 51));
        login_choice.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        login_choice.setForeground(new java.awt.Color(255, 255, 255));
        login_choice.setText("Login");
        login_choice.setBorderPainted(false);
        login_choice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_choiceMouseClicked(evt);
            }
        });
        jPanel1.add(login_choice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 250, 80));

        signup_pane.setBackground(new java.awt.Color(0, 51, 51));
        signup_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sigup_label.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        sigup_label.setForeground(new java.awt.Color(255, 255, 255));
        sigup_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sigup_label.setText("Sign Up");
        signup_pane.add(sigup_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 360, 72));

        name_signup_label.setBackground(new java.awt.Color(0, 51, 51));
        name_signup_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        name_signup_label.setForeground(new java.awt.Color(0, 153, 153));
        name_signup_label.setText("Name");
        name_signup_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                name_signup_labelMouseClicked(evt);
            }
        });
        signup_pane.add(name_signup_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 260, 30));

        name_signup_input.setBackground(new java.awt.Color(0, 51, 51));
        name_signup_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name_signup_input.setForeground(new java.awt.Color(255, 255, 255));
        name_signup_input.setBorder(null);
        name_signup_input.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        signup_pane.add(name_signup_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 260, 30));
        signup_pane.add(Separator_name_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 260, 10));

        user_signup_label.setBackground(new java.awt.Color(0, 51, 51));
        user_signup_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        user_signup_label.setForeground(new java.awt.Color(0, 153, 153));
        user_signup_label.setText("Username");
        user_signup_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                user_signup_labelMouseClicked(evt);
            }
        });
        signup_pane.add(user_signup_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 260, 30));

        user_signup_input.setBackground(new java.awt.Color(0, 51, 51));
        user_signup_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_signup_input.setForeground(new java.awt.Color(255, 255, 255));
        user_signup_input.setBorder(null);
        signup_pane.add(user_signup_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 260, 30));
        signup_pane.add(jSeparator_user_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 260, -1));

        pass_signup_label.setBackground(new java.awt.Color(0, 51, 51));
        pass_signup_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pass_signup_label.setForeground(new java.awt.Color(0, 153, 153));
        pass_signup_label.setText("Password");
        pass_signup_label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pass_signup_labelMouseClicked(evt);
            }
        });
        signup_pane.add(pass_signup_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, 30));
        signup_pane.add(Separator_pass_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 260, 10));

        pass_signup_input.setBackground(new java.awt.Color(0, 51, 51));
        pass_signup_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass_signup_input.setForeground(new java.awt.Color(255, 255, 255));
        pass_signup_input.setBorder(null);
        signup_pane.add(pass_signup_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 260, 30));

        name_logo.setIcon(new javax.swing.ImageIcon(dir + "icons8_name_48px_1.png")); // NOI18N
        signup_pane.add(name_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        user_signup_logo.setIcon(new javax.swing.ImageIcon(dir + "icons8_user_48px_1.png")); // NOI18N
        signup_pane.add(user_signup_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        pass_signup_logo.setIcon(new javax.swing.ImageIcon(dir + "icons8_password_48px_1.png")); // NOI18N
        signup_pane.add(pass_signup_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        signup_but.setBackground(new java.awt.Color(0, 102, 102));
        signup_but.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        signup_but.setForeground(new java.awt.Color(255, 255, 255));
        signup_but.setText("Sign Up");
        signup_but.setBorderPainted(false);
//        signup_but.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                signup_butActionPerformed(evt);
//            }
//        });
        signup_pane.add(signup_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 130, 40));

        jPanel1.add(signup_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 360, 510));

        signin_pane.setBackground(new java.awt.Color(0, 51, 51));
        signin_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_label.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        login_label.setForeground(new java.awt.Color(255, 255, 255));
        login_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login_label.setText("Login");
        signin_pane.add(login_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 360, 72));

        user_label.setBackground(new java.awt.Color(0, 51, 51));
        user_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        user_label.setForeground(new java.awt.Color(0, 153, 153));
        user_label.setText("Username");
//        user_label.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                user_labelMouseClicked(evt);
//            }
//        });
        signin_pane.add(user_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 260, 30));

        pass_label.setBackground(new java.awt.Color(0, 51, 51));
        pass_label.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pass_label.setForeground(new java.awt.Color(0, 153, 153));
        pass_label.setText("Password");
//        pass_label.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                pass_labelMouseClicked(evt);
//            }
//        });
        signin_pane.add(pass_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 260, 30));
        signin_pane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 260, -1));
        signin_pane.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 260, 10));

        pass_input.setBackground(new java.awt.Color(0, 51, 51));
        pass_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pass_input.setForeground(new java.awt.Color(255, 255, 255));
        pass_input.setBorder(null);
        pass_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pass_inputKeyPressed(evt);
            }
        });
        signin_pane.add(pass_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 260, 30));

        user_input.setBackground(new java.awt.Color(0, 51, 51));
        user_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_input.setForeground(new java.awt.Color(255, 255, 255));
        user_input.setBorder(null);
        signin_pane.add(user_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 260, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(dir + "icons8_user_48px_1.png")); // NOI18N
        signin_pane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(dir + "icons8_password_48px_1.png")); // NOI18N
        signin_pane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, -1, -1));

        login_but.setBackground(new java.awt.Color(0, 102, 102));
        login_but.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        login_but.setForeground(new java.awt.Color(255, 255, 255));
        login_but.setText("Sign In");
        login_but.setBorderPainted(false);
//        login_but.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                login_butActionPerformed(evt);
//            }
//        });
        signin_pane.add(login_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 130, 40));

        jPanel1.add(signin_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 360, 510));

        backgeound_label.setBackground(new Color(0,0,0,125));
        backgeound_label.setIcon(new javax.swing.ImageIcon(dir + "background.jpg")); // NOI18N
        jPanel1.add(backgeound_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 0, 800, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 865, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void user_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_labelMouseClicked
        user_input.setVisible(true);
        user_label.setVisible(false);
    }//GEN-LAST:event_user_labelMouseClicked

    private void pass_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_labelMouseClicked
        pass_input.setVisible(true);
        pass_label.setVisible(false);
    }//GEN-LAST:event_pass_labelMouseClicked

    private void signup_choiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signup_choiceMouseClicked
        signup_pane.setVisible(true);
        signin_pane.setVisible(false);
    }//GEN-LAST:event_signup_choiceMouseClicked

    private void login_choiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_choiceMouseClicked
        signup_pane.setVisible(false);
        signin_pane.setVisible(true);
    }//GEN-LAST:event_login_choiceMouseClicked

    private void name_signup_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name_signup_labelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_name_signup_labelMouseClicked

    private void user_signup_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_signup_labelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_user_signup_labelMouseClicked

    private void pass_signup_labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pass_signup_labelMouseClicked
        pass_input.setVisible(true);
        pass_label.setVisible(false);
    }//GEN-LAST:event_pass_signup_labelMouseClicked

    private void login_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_butActionPerformed
        int login = JOptionPane.showConfirmDialog(this, "Are you sure", "Sign In",JOptionPane.YES_NO_OPTION);
        if (login == 0) logIn();
        this.setVisible(false);
    }//GEN-LAST:event_login_butActionPerformed

    private void pass_inputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pass_inputKeyPressed
        if (evt.getKeyCode() == 10)
            logIn();
    }//GEN-LAST:event_pass_inputKeyPressed

    private void signup_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_butActionPerformed
        int option = JOptionPane.showConfirmDialog(this, "Are you sure?", "Sign Up", JOptionPane.YES_NO_OPTION);
        if (option == 0)
        {
            String name_user = name_signup_input.getText();
            String user = user_signup_input.getText();
            String pass = new String (pass_signup_input.getPassword());
            System.out.println(name_user + " " + user + " " + pass);
        }
    }//GEN-LAST:event_signup_butActionPerformed
    
    private void logIn(){
        String user_name = user_input.getText();
        String pass = new String(pass_input.getPassword());
        if (user_name.isEmpty() || pass.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Inavlid input!");
        }
//        else{
//            this.mainUI.getClient().sendReq("login-" + user_name + pass);
//        }
        System.out.println(user_name + pass);
    }
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
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }

    public JButton getLogin_but() {return this.login_but;}
    public String getUser_input() {return this.user_input.getText();}
    public String getPass_input() {return new String(this.pass_input.getPassword());}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator Separator_name_signup;
    private javax.swing.JSeparator Separator_pass_signup;
    private javax.swing.JLabel backgeound_label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator_user_signup;
    private javax.swing.JButton login_but;
    private javax.swing.JButton login_choice;
    private javax.swing.JLabel login_label;
    private javax.swing.JLabel name_logo;
    private javax.swing.JTextField name_signup_input;
    private javax.swing.JLabel name_signup_label;
    private javax.swing.JPasswordField pass_input;
    private javax.swing.JLabel pass_label;
    private javax.swing.JPasswordField pass_signup_input;
    private javax.swing.JLabel pass_signup_label;
    private javax.swing.JLabel pass_signup_logo;
    private javax.swing.JPanel signin_pane;
    private javax.swing.JButton signup_but;
    private javax.swing.JButton signup_choice;
    private javax.swing.JPanel signup_pane;
    private javax.swing.JLabel sigup_label;
    private javax.swing.JTextField user_input;
    private javax.swing.JLabel user_label;
    private javax.swing.JTextField user_signup_input;
    private javax.swing.JLabel user_signup_label;
    private javax.swing.JLabel user_signup_logo;
    // End of variables declaration//GEN-END:variables
}
