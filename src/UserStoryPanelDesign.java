/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADITI SURI
 */
public class UserStoryPanelDesign extends javax.swing.JPanel {

    /**
     * Creates new form UserStoryPanelDesign
     */
    public UserStoryPanelDesign() {
        initComponents();
      //  setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDate = new javax.swing.JLabel();
        jPhoto = new javax.swing.JLabel();
        jCaption = new javax.swing.JLabel();
        jdeletebtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
        add(jDate);
        jDate.setBounds(190, 20, 250, 40);
        add(jPhoto);
        jPhoto.setBounds(30, 80, 170, 110);
        add(jCaption);
        jCaption.setBounds(30, 220, 150, 40);

        jdeletebtn.setText("DELETE STORY");
        add(jdeletebtn);
        jdeletebtn.setBounds(300, 120, 220, 60);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jCaption;
    public javax.swing.JLabel jDate;
    public javax.swing.JLabel jPhoto;
    public javax.swing.JButton jdeletebtn;
    // End of variables declaration//GEN-END:variables
}
