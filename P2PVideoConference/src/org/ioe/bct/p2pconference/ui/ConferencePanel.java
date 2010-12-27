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

import org.ioe.bct.p2pconference.ui.controls.ConferenceMediator;
import org.ioe.bct.p2pconference.ui.controls.ConferenceManager;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
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
        upperPanel.setVisible(false);

        

        
       
        
    }
    public void setMediator(Mediator m) {
        this.confMediator=m;
        confMediator.addColleague(this);
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

        upperPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("ConferencePanel"));
        setLayout(new java.awt.BorderLayout());

        upperPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        upperPanel.setLayout(new java.awt.BorderLayout());
        add(upperPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

  
    public void receive(String message, Colleague sender, Object body) {
       if(message.equalsIgnoreCase(ConferenceMediator.CONT_SELECTION_CHANGED)) {
            
           if(sender instanceof ContactListPanel) {
              System.out.println("Loading contact info "+sender.getClass());
               upperPanel.removeAll();
               UserInfoPanel uinfo=new UserInfoPanel();
               if(body instanceof PeerResolver) {
                   uinfo.updateInfo((PeerResolver) body);
               }
               upperPanel.add(uinfo,BorderLayout.CENTER);
               upperPanel.validate();
              

           }
           
           else if(sender instanceof GroupsPanel ) {
                upperPanel.removeAll();
                GroupInfoPanel gPanel=new GroupInfoPanel();
                upperPanel.add(gPanel,BorderLayout.CENTER);
                upperPanel.validate();

           }
           
           upperPanel.setVisible(true);
       }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
     private ConferenceManager confManager;
    
     
}
