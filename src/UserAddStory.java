
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
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
public class UserAddStory extends javax.swing.JFrame {

    /**
     * Creates new form UserAddStory
     */
    String postid;
    File f;
    Dimension d;

    public UserAddStory(String post_id) {
        initComponents();
        d = Toolkit.getDefaultToolkit().getScreenSize();
        jScrollPane2.setSize(800, 800);
        setSize(d.getSize());
        setVisible(true);
        postid = post_id;
        getAllStories();
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jCaption = new javax.swing.JTextArea();
        jPhoto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel1.setText("ADD STORY HERE--->");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 390, 70);

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel2.setText("PHOTO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 130, 70, 60);

        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 240, 120, 50);

        jCaption.setColumns(20);
        jCaption.setRows(5);
        jScrollPane1.setViewportView(jCaption);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 410, 170, 130);
        getContentPane().add(jPhoto);
        jPhoto.setBounds(160, 140, 180, 220);

        jLabel4.setText("CAPTION");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 430, 90, 40);

        jButton2.setText("ADD STORY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(60, 580, 190, 70);

        mainPanel.setBackground(new java.awt.Color(0, 0, 0));
        mainPanel.setLayout(null);
        jScrollPane2.setViewportView(mainPanel);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(400, 10, 480, 750);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String caption = jCaption.getText();
        if (caption.isEmpty()) {
            JOptionPane.showMessageDialog(this, "This is a required field");
        } else if (f == null) {
            JOptionPane.showMessageDialog(this, "Please choose a photograph!");
        } else {
            try {
                HttpResponse<String> res = Unirest.post("http://localhost:8999/userAddStory")
                        .queryString("caption", caption)
                        .queryString("post_id", postid)
                        .field("photo", f)
                        .asString();
                if (res.getStatus() == 200) {
                    String response = res.getBody();
                    System.out.println("response is ----" + response);
                    if (response.equals("success")) {
                        JOptionPane.showMessageDialog(this, "Photo Added successfully");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int ans = chooser.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(f.getPath());
            Image resizedimg = icon.getImage().getScaledInstance(jPhoto.getWidth(), jPhoto.getHeight(), Image.SCALE_SMOOTH);
            jPhoto.setIcon(new ImageIcon(resizedimg));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void getAllStories() {
        try {
            HttpResponse<String> res = Unirest.get("http://localhost:8999/getAllStories")
                    .queryString("post_id", postid)
                    .asString();
            if (res.getStatus() == 200) {
                String response = res.getBody();
                System.out.println(response);
                if (response.equals("fails")) {
                    JOptionPane.showMessageDialog(this, "No stories  are added");
                } else {
                    System.out.println("Response---->" + response);
                    StringTokenizer st = new StringTokenizer(response, "~~");
                    int count = st.countTokens();
                    //mainPanel.removeAll();
                    mainPanel.setPreferredSize(new Dimension(d.width - 300, count * 330));
                    UserStoryPanelDesign obj[] = new UserStoryPanelDesign[count];
                    int x = 10, y = 10;
                    for (int i = 0; i < count; i++) {
                        final int a = i;
                        String userToken = st.nextToken();
                        StringTokenizer st2 = new StringTokenizer(userToken, ";;");
                        String story_id = st2.nextToken();

                        String photoPath = st2.nextToken();
                        String caption = st2.nextToken();
                        String date = st2.nextToken();
                        System.out.println("caption----->" + caption);
                        System.out.println("photoPath---->" + photoPath);
                        System.out.println("date----->" + date);
                        System.out.println("post_id--->" + story_id);
                        obj[i] = new UserStoryPanelDesign();
                        obj[i].jCaption.setText(caption);
                        obj[i].jDate.setText(date);
                        // obj[i].jPhoto.setText(photoPath);
                        try {
                            URL url = new URL(GlobalClass.serverAddress + "GetResource/" + photoPath);
                            //System.out.println("Path of Image Stored in server side--------------" + url);
                            BufferedImage img = ImageIO.read(url);
                            Image resizedimage = img.getScaledInstance(obj[i].jPhoto.getWidth(), obj[i].jPhoto.getHeight(), Image.SCALE_SMOOTH);
                            obj[i].jPhoto.setIcon(new ImageIcon(resizedimage));

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        obj[i].jdeletebtn.addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try {
                                    HttpResponse<String> res = Unirest.get("http://localhost:8999/deleteStory")
                                            .queryString("storyid", story_id)
                                            .asString();
                                    if (res.getStatus() == 200) {
                                        String response = res.getBody();
                                        if (response.equals("success")) {
                                            getAllStories();
                                        }
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }
                        });
                        obj[i].setBounds(x, y, 800, 300);

                        mainPanel.add(obj[i]);
                        y += 300;

                        mainPanel.repaint();
                        obj[i].repaint();
                    }
                    mainPanel.repaint();
                }

            }

        } catch (Exception e) {
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
            java.util.logging.Logger.getLogger(UserAddStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAddStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAddStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAddStory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserAddStory("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextArea jCaption;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jPhoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
