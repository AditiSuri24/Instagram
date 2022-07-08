
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ADITI SURI
 */
public class UserHomeFrame extends javax.swing.JFrame {

    String user;
    /**
     * Creates new form UserHomeFrame
     */
    Dimension d;
    String post_id;

    public UserHomeFrame(String username) {
        initComponents();
        user = username;
        jwelcome.setText("-----Welcome ----- " + ">>>" + user);
        d = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(d.getSize());
        setVisible(true);
        fetchFollowing();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jwelcome = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jwelcome.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        getContentPane().add(jwelcome);
        jwelcome.setBounds(280, 50, 990, 70);

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 420, 240, 90);

        jButton2.setText("EDIT PROFILE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 330, 240, 80);

        jButton3.setText("SEARCH USER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 230, 240, 80);

        jButton4.setText("MY FOLLOWERS");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 520, 240, 80);

        jButton5.setText("MY FOLLOWING");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(20, 610, 240, 80);

        jButton6.setText("ADD POST");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(20, 700, 240, 80);

        mainPanel.setBackground(new java.awt.Color(153, 255, 255));
        mainPanel.setLayout(null);
        jScrollPane1.setViewportView(mainPanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(270, 230, 1020, 550);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel1.setText("POSTS FROM PEOPLE YOU ARE FOLLOWING");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(500, 160, 550, 60);

        jLabel2.setBackground(new java.awt.Color(204, 204, 255));
        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel2.setText("WOULD YOU LIKE TO?");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 160, 430, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        UserChangePasswordFrame obj = new UserChangePasswordFrame(user);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        UserEditProfile obj = new UserEditProfile(user);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        UserSearchFrame obj = new UserSearchFrame(user);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        UserMyFollowers obj = new UserMyFollowers(user);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        UserAddPost obj = new UserAddPost(user);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        UserMyFollowing obj = new UserMyFollowing(user);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void fetchFollowing() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/fetchFollowingPost")
                    .queryString("loggedinuser", user)
                    .asString();
            if (res.getStatus() == 200) {
                String response = res.getBody();
                System.out.println(response);
                if (response.equals("fails")) {
                    JOptionPane.showMessageDialog(this, "No Followers!!!!");
                } else {
                    System.out.println("Response---->" + response);
                    StringTokenizer st = new StringTokenizer(response, "~~");
                    int count = st.countTokens();
                    mainPanel.removeAll();
                    mainPanel.setPreferredSize(new Dimension(d.width - 300, count * 330));
                    UserFollowingPostsPanel obj[] = new UserFollowingPostsPanel[count];
                    int x = 10, y = 10;
                    for (int i = 0; i < count; i++) {
                        final int a = i;
                        String userToken = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(userToken, ";;");

                        String follow_to = st2.nextToken();
                        int post_id = Integer.parseInt(st2.nextToken());
                        String date_time = st2.nextToken();
                        String caption = st2.nextToken();
                        String photo = st2.nextToken();
                        String is_like = st2.nextToken();
                        String count_like = st2.nextToken();

                        System.out.println("follow_to----->" + follow_to);
                        System.out.println("post_id---->" + post_id);
                        System.out.println("date----->" + date_time);
                        System.out.println("caption--->" + caption);
                        obj[i] = new UserFollowingPostsPanel();

                        obj[i].jCaption.setText(caption);
                        obj[i].jName.setText(follow_to);

                        obj[i].jDate.setText(date_time);
                        obj[i].jLike.setText(count_like);
                        obj[i].jLikebtn.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
//                            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                                try {

                                    HttpResponse<String> httpResponse = Unirest.get(GlobalClass.serverAddress + "likepost")
                                            .queryString("post_id", post_id + "")
                                            .queryString("username", user)
                                            .asString();

                                    if (httpResponse.getStatus() == 200) {
                                        String ans = httpResponse.getBody();
                                        System.out.println(ans);
                                        JOptionPane.showMessageDialog(rootPane, ans);
                                        fetchFollowing();

                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }

                        }
                        );
                        obj[i].addMouseListener(new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
//                            super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                                User_Show_Stories obj = new User_Show_Stories(post_id);
                            }

                        }
                        );
                        //   obj[i].jPhoto.setText(photoPath);
                        try {
                            URL url = new URL(GlobalClass.serverAddress + "GetResource/" + photo);
                            //System.out.println("Path of Image Stored in server side--------------" + url);
                            BufferedImage img = ImageIO.read(url);
                            Image resizedimage = img.getScaledInstance(obj[i].jPhoto.getWidth(), obj[i].jPhoto.getHeight(), Image.SCALE_SMOOTH);
                            obj[i].jPhoto.setIcon(new ImageIcon(resizedimage));

                            obj[i].setBounds(x, y, 800, 300);

                            mainPanel.add(obj[i]);
                            y += 300;
                            mainPanel.repaint();
                            obj[i].repaint();

                            mainPanel.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserHomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserHomeFrame("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jwelcome;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
