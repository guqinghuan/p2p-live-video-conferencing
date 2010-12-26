/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConferencePanel.java
 *
 * Created on Dec 24, 2010, 4:12:47 PM
 */

package org.ioe.bct.p2pconference.ui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.ioe.bct.p2pconference.dataobject.PeerResolver;
import org.ioe.bct.p2pconference.prototype.patterns.mediator.Colleague;
import org.ioe.bct.p2pconference.prototype.patterns.mediator.Mediator;




/**
 *
 * @author kusu
 */
public class ConferencePanel extends javax.swing.JPanel implements  Colleague {

    private Mediator confMediator;

   

    /** Creates new form ConferencePanel */
    public ConferencePanel() {
        initComponents();
        setLayout(new BorderLayout());
        add(upperPanel,BorderLayout.NORTH);

    }
    public void setMediator(Mediator m) {
        this.confMediator=m;
    }

    public Mediator getMediator() {
        return this.confMediator;
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

  
    public void receive(String message, Colleague sender, Object body) {
       if(message.equalsIgnoreCase(ConferenceMediator.CONT_SELECTION_CHANGED)) {
           if(sender instanceof ContactListPanel) {
               upperPanel.removeAll();
               UserInfoPanel uinfo=new UserInfoPanel();
               if(body instanceof PeerResolver) {
                   uinfo.updateInfo((PeerResolver) body);
               }
               upperPanel.add(uinfo);
               upperPanel.repaint();
              

           }
           else if(sender instanceof GroupsPanel ) {
               

           }
       }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
     private ConferenceManager confManager;
    
     private JPanel upperPanel=new JPanel();
}