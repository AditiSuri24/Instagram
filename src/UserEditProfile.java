
//import static FiltersDemo.imageToBufferedImage;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.StringTokenizer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
public class UserEditProfile extends javax.swing.JFrame {

    /**
     * Creates new form UserEditProfile
     */
    File f;
    String user;
    BufferedImage img, changedimg;
    Image resizedImage;
      JFileChooser chooser = new JFileChooser();

    public UserEditProfile(String username) {
        initComponents();
        user = username;
        jUsername.setText(user);
        jUsername.setEditable(false);
        setSize(800, 800);
         jbg.setBounds(0, 0, 800, 800);
         ImageIcon icon = new ImageIcon("src/uploads/white.jpg");
            Image resizedimg = icon.getImage().getScaledInstance(jbg.getWidth(), jbg.getHeight(), Image.SCALE_SMOOTH);
            jbg.setIcon(new ImageIcon(resizedimg));
        setVisible(true);
        getUserDetail();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPhoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jUsername = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jPhone = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jbg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("EDIT PROFILE HERE!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 30, 410, 80);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 160, 170, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("EMAIL");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 240, 140, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("PHONE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 330, 140, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PHOTO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(70, 410, 80, 22);
        getContentPane().add(jPhoto);
        jPhoto.setBounds(370, 370, 210, 100);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 400, 140, 80);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("EDIT PROFILE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(380, 550, 260, 70);
        getContentPane().add(jUsername);
        jUsername.setBounds(350, 160, 150, 40);
        getContentPane().add(jEmail);
        jEmail.setBounds(350, 240, 150, 40);
        getContentPane().add(jPhone);
        jPhone.setBounds(350, 320, 150, 40);

        jButton3.setText("grayscale FILTER");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(30, 580, 160, 30);

        jButton4.setText("BRIGHTER FILTER");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(200, 580, 165, 29);

        jButton5.setText("NO FILTER");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(520, 700, 160, 30);

        jButton6.setText("DARKER FILTER");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(30, 640, 149, 30);

        jButton7.setText("BLUR FILTER");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(210, 640, 127, 29);

        jButton8.setText("NASHVILLE FILTER");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(390, 640, 180, 29);

        jButton9.setText("WALDEN FILTER");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9);
        jButton9.setBounds(20, 700, 160, 30);

        jButton10.setText("HEFE FILTER");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10);
        jButton10.setBounds(190, 700, 140, 30);

        jButton11.setText("LOFI FILTER");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(340, 700, 150, 30);

        jButton12.setFont(new java.awt.Font("Sitka Text", 1, 36)); // NOI18N
        jButton12.setText("Save changes");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton12);
        jButton12.setBounds(370, 490, 290, 50);

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 36)); // NOI18N
        jLabel6.setText("Apply Filter");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 490, 260, 60);

        jbg.setText("jLabel7");
        getContentPane().add(jbg);
        jbg.setBounds(0, 0, 51, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //get all data
        String email = jEmail.getText();
        String phone = jPhone.getText();
        if (user.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields Required");
        } else if (!email.contains("@") && email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.");
        } else if (phone.length()!= 10) {
            JOptionPane.showMessageDialog(this, "Please enter a 10 digit PhoneNumber.");
        } else if (f == null) {
            //send unirest get request
            try {
                HttpResponse<String> res = Unirest.get("http://localhost:8999/UserEditProfileWithoutPhoto")
                        .queryString("username", user)
                        .queryString("email", email)
                        .queryString("phone", phone)
                        .asString();
                if (res.getStatus() == 200) {
                    String response = res.getBody();
                    if (response.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Profile Edited Successfull");

                    } else {
                        JOptionPane.showMessageDialog(this, "An Error Occurred");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpResponse<String> res = Unirest.post("http://localhost:8999/UserEditProfileWithPhoto")
                        .queryString("username", user)
                        .queryString("email", email)
                        .queryString("phone", phone)
                        .field("photo", f)
                        .asString();
                if (res.getStatus() == 200) {
                    String response = res.getBody();
                    if (response.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Profile Edited Successfull");

                    } else {
                        JOptionPane.showMessageDialog(this, "An Error Occurred");
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
      
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
             try {
                //-------- step2
                img = ImageIO.read(f);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            ImageIcon icon = new ImageIcon(f.getPath());
            Image resizedimg = icon.getImage().getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
            jPhoto.setIcon(new ImageIcon(resizedimg));
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                GrayscaleFilter obj = new GrayscaleFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
         int ans = chooser.showSaveDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            try {
                ImageIO.write(changedimg, "jpg", f);
                JOptionPane.showMessageDialog(this, "File saved successfully !");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                DarkerFilter obj = new DarkerFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                BrighterFilter obj = new BrighterFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                BlurFilter obj = new BlurFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                NashvilleFilter obj = new NashvilleFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                WaldenFilter obj = new WaldenFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                HefeFilter obj = new HefeFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                LoFiFilter obj = new LoFiFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         new Thread(new Runnable() {
            public void run() {
                NoFilter obj = new NoFilter();
                BufferedImage grayimg = obj.filter(img);
                resizedImage = grayimg.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                changedimg = imageToBufferedImage(resizedImage);
                jPhoto.setIcon(new ImageIcon(changedimg));
                repaint();
            }
        }).start();
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void getUserDetail() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getUserDetail")
                    .queryString("username", user)
                    .asString();
            if (res.getStatus() == 200) {
                String response = res.getBody();
                System.out.println(response);
                if (response.equals("fails")) {
                    JOptionPane.showMessageDialog(this, " Error occured");

                } else {
                    StringTokenizer st = new StringTokenizer(response, ";;");
                    String email = st.nextToken();
                    String phone = st.nextToken();
                    String photo = st.nextToken();
                    jEmail.setText(email);
                    jPhone.setText(phone);
                //    jPhoto.setText(photo);
                    try {
                    URL url = new URL(GlobalClass.serverAddress + "GetResource/" + photo);
                    //System.out.println("Path of Image Stored in server side--------------" + url);
                    BufferedImage img = ImageIO.read(url);
                    Image resizedimage = img.getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
                    jPhoto.setIcon(new ImageIcon(resizedimage));

                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  public static BufferedImage imageToBufferedImage(Image im) {
        BufferedImage bi = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics bg = bi.getGraphics();
        bg.drawImage(im, 0, 0, null);
        bg.dispose();
        return bi;
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
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserEditProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserEditProfile("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jPhone;
    private javax.swing.JLabel jPhoto;
    private javax.swing.JTextField jUsername;
    private javax.swing.JLabel jbg;
    // End of variables declaration//GEN-END:variables
}