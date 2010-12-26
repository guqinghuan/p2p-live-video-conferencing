/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BaseSidePanel.java
 *
 * Created on Nov 5, 2010, 9:31:08 AM
 */

package org.ioe.bct.p2pconference.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author kusu
 */
public class BaseSidePanel extends javax.swing.JPanel {

     private BufferedImage image;
     private String fileName;

     public void setFileName(String name) {
         this.fileName=name;
         loadImage();
     }
        public final void loadImage() {
        File imageFile = new File(fileName);
        if (imageFile.exists()) {
            System.out.println("FILE EXISTS");
        }
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "I/O Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    /** Creates new form BaseSidePanel */
    public BaseSidePanel() {
        initComponents();
    }

    public void paint(Graphics g) {
//        super.paintComponents(g);
        g.drawImage(image, 0, 0, null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}