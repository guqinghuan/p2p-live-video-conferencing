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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.ioe.bct.p2pconference.core.P2PNetworkCore;
import org.ioe.bct.p2pconference.core.PrivateMsgManager;

import org.ioe.bct.p2pconference.dataobject.PeerResolver;
import org.ioe.bct.p2pconference.dataobject.ProtectedPeerGroup;
import org.ioe.bct.p2pconference.dataobject.TextMessage;
import org.ioe.bct.p2pconference.patterns.mediator.Colleague;
import org.ioe.bct.p2pconference.patterns.mediator.Mediator;





/**
 *
 * @author kusu
 */
public class ConferencePanel extends javax.swing.JPanel implements  Colleague {

    private Mediator confMediator;
    private PrivateMsgManager privateMsgManager;
   

    /** Creates new form ConferencePanel */
    public ConferencePanel() {
        initComponents();
        upperPanel.setVisible(false);
        jScrollPane1.setVisible(false);
    }

    public void initiateChatting(P2PNetworkCore netCore)
    {
        privateMsgManager=new PrivateMsgManager(AppMainFrame.getUserName(),netCore , confMediator);
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
        lowerpanel = new javax.swing.JPanel();
        midpanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createTitledBorder("ConferencePanel"));
        setLayout(new java.awt.BorderLayout());

        upperPanel.setLayout(new java.awt.BorderLayout());
        add(upperPanel, java.awt.BorderLayout.PAGE_START);
        add(lowerpanel, java.awt.BorderLayout.PAGE_END);

        midpanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setTabSize(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout midpanelLayout = new javax.swing.GroupLayout(midpanel);
        midpanel.setLayout(midpanelLayout);
        midpanelLayout.setHorizontalGroup(
            midpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        midpanelLayout.setVerticalGroup(
            midpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
        );

        add(midpanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

  
    public void receive(String message, Colleague sender, Object body) {
       if(message.equalsIgnoreCase(ConferenceMediator.CONT_SELECTION_CHANGED)) {

           lowerpanel.removeAll();
           if(sender instanceof ContactListPanel) {
              System.out.println("Loading contact info "+sender.getClass());
               upperPanel.removeAll();
               UserInfoPanel uinfo=new UserInfoPanel();
               if(body instanceof PeerResolver) {
                   uinfo.updateInfo((PeerResolver) body);
               }
               else
               {
                   JPanel jPanel=(JPanel)body;
                   currentSelectedPeer=jPanel.getName();
                  //Have to apply threading for this operation otherwise pipe is not resolved

                   privateMsgManager.addReceiver(currentSelectedPeer);
                   privateMsgManager.addSender(currentSelectedPeer);
                   
                  
               }
               upperPanel.add(uinfo,BorderLayout.CENTER);
               upperPanel.validate();

               upperPanel.setVisible(true);
           }
           
           else if(sender instanceof GroupsPanel ) {
                upperPanel.removeAll();

                ProtectedPeerGroup selectedGroup=(ProtectedPeerGroup)body;
                gPanel=new GroupInfoPanel(selectedGroup);
                upperPanel.add(gPanel,BorderLayout.CENTER);
                upperPanel.validate();
                upperPanel.setVisible(true);
           }

           upperPanel.setBorder(BorderFactory.createEtchedBorder());
           lowerpanel.setBorder(BorderFactory.createEtchedBorder());
           sendTextMsgPanel.setMediator(confMediator);
           lowerpanel.add(sendTextMsgPanel);
           lowerpanel.validate();
           lowerpanel.setVisible(true);
         
           jScrollPane1.setVisible(true);
           
          
       }

        else if (message.equalsIgnoreCase(ConferenceMediator.JOIN_GROUP)) {
            System.out.println("Group Joined successfully....");
            gPanel.updateComponents();

        }
        else if(message.equalsIgnoreCase(ConferenceMediator.SEND_TEXT_MSG))
            sendTextMesssage(body.toString());

       else if(message.equalsIgnoreCase(ConferenceMediator.RECEIVE_TEXT_MSG))
           receiveTextMessage(body.toString());
         } 

    public void sendTextMesssage(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        Date currentDate=Calendar.getInstance().getTime();
        String dateString=sdf.format(currentDate);
        TextMessage msg=new TextMessage(AppMainFrame.getUserName(), message, dateString);
        textData.put(currentSelectedPeer,msg);
        message=message.replaceAll("\n","");
        if(message.length()>30) {
            message+="\n";
        }
        jTextArea1.append(AppMainFrame.getUserName()+"\t"+message+"\t"+"\t"+dateString);
        privateMsgManager.sendDataToReceiver(message, currentSelectedPeer);
       
    }

    public void receiveTextMessage(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        Date currentDate=Calendar.getInstance().getTime();
        String dateString=sdf.format(currentDate);
        
    }

    
    
    private HashMap<String,TextMessage> textData=new HashMap<String,TextMessage>();
    
    private SendTextMessagePanel sendTextMsgPanel=new SendTextMessagePanel();
    private GroupInfoPanel gPanel;
    private String currentSelectedPeer="";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel lowerpanel;
    private javax.swing.JPanel midpanel;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
     private ConferenceManager confManager;
    
     
}
