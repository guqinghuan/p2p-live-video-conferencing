/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserInfoPanel.java
 *
 * Created on Dec 25, 2010, 5:33:20 PM
 */

package org.ioe.bct.p2pconference.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.jxta.exception.PeerGroupException;
import org.ioe.bct.p2pconference.patterns.mediator.Mediator;
import org.ioe.bct.p2pconference.ui.controls.ConferenceMode;
import org.ioe.bct.p2pconference.ui.controls.ConferenceManager;
import java.awt.Image;
import net.jxta.protocol.PipeAdvertisement;
import org.ioe.bct.p2pconference.core.P2PNetworkCore;
import org.ioe.bct.p2pconference.core.SocketClient;
import org.ioe.bct.p2pconference.core.SocketServer;
import org.ioe.bct.p2pconference.dataobject.JXTAPeerResolver;
import org.ioe.bct.p2pconference.dataobject.PeerResolver;
import org.ioe.bct.p2pconference.patterns.mediator.Colleague;
import org.ioe.bct.p2pconference.ui.controls.CallDialogThread;
import org.ioe.bct.p2pconference.ui.controls.ConferenceMediator;


/**
 *
 * @author kusu
 */
public class UserInfoPanel extends javax.swing.JPanel  implements Colleague{
    private P2PNetworkCore netCore;
   private SocketServer socketServer;
   private SocketClient socketClient;
   private Mediator confMediator;
   private String currentSelectedPeer;
   private CallDialogThread callingDialogThread;
    /** Creates new form UserInfoPanel */
    public UserInfoPanel(P2PNetworkCore netCore,Mediator me){
        initComponents();
        jTabbedPane1.setTitleAt(0, "General");
        jTabbedPane1.setTitleAt(1, "Technical");
        this.netCore=netCore;
        this.confMediator=me;
   
        videocallButtton.setVisible(false);
    }
    public void setNetCore(P2PNetworkCore core) {
        this.netCore=core;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        uuidLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ipLabel = new javax.swing.JLabel();
        peerTypeLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        videocallButtton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(75, 75));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        jTabbedPane1.setRequestFocusEnabled(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Name:");

        nameLabel.setText("N/A");

        jLabel5.setText("Email:");

        jLabel6.setText("Status:");

        emailLabel.setText("N/A");

        statusLabel.setText("N/A");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(statusLabel)))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(statusLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        uuidLabel.setText("jLabel7");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PeerType:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel3.setText("UUID");

        jLabel2.setText("IP:");

        ipLabel.setText("jLabel6");

        peerTypeLabel.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ipLabel)
                    .addComponent(uuidLabel)
                    .addComponent(peerTypeLabel))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ipLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(uuidLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(peerTypeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jButton1.setText("Make Call");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        videocallButtton.setText("Video Call");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(videocallButtton)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(videocallButtton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Technical");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        callingDialogThread=new CallDialogThread(confMediator);
        callingDialogThread.start();
       confMediator.sendMessage(ConferenceMediator.PRIVATE_VOICE_CALL_SYNC, this, ConferenceMediator.AUDIO_REQUEST_CODE);

//        confManager.startConference(mode);

    }//GEN-LAST:event_jButton1ActionPerformed

    public void startCall() {
        callingDialogThread.stopThread("Call Accepted...");
          try {
            // TODO add your handling code here:
            socketServer = new SocketServer(netCore, AppMainFrame.getUserName(),currentSelectedPeer);
        } catch (IOException ex) {
            Logger.getLogger(UserInfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PeerGroupException ex) {
            Logger.getLogger(UserInfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
         socketClient=new SocketClient(netCore,AppMainFrame.getUserName(),currentSelectedPeer);


        socketServer.buildModuleAdvertisement();
        socketServer.buildModuleSpecificationAdvertisement(socketServer.createSocketAdvertisement());
        class ServerThreadHandler implements Runnable{
            public void run()
            {
                System.out.println("Server Thread begins");
                socketServer.initializeServer();
                socketServer.runServer();

            }
        }
        class PublishThreadHandler implements Runnable{
            public void run()
            {
                System.out.println("Publishing Thread begins");
                while(true)
                {

                    try {
                         System.out.println("Publishing Thread begins");
                        socketServer.publishModuleAdvertisement();
                        socketServer.publishModuleSpecificationAdvertisement();
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        class ClientThreadHandler implements Runnable{
            public void run()
            {
                PipeAdvertisement pipeAdv;
                while((pipeAdv=socketClient.getPipeAdvertisement())==null){
                    try{
                        Thread.sleep(5000);
                    }
                    catch(InterruptedException ex)
                    {
                        System.out.println(ex.getMessage());
                    }

                }
                socketClient.runClient();
            }
        }
        Thread serverThread=new Thread(new ServerThreadHandler());
        serverThread.start();
        Thread publishThread=new Thread(new PublishThreadHandler());
        publishThread.start();
        Thread clientThread=new Thread(new ClientThreadHandler());
        clientThread.start();
        
    }
public void updateInfo(PeerResolver p) {
        //throw new UnsupportedOperationException("Not supported yet.");

        nameLabel.setText(p.getName());
        ipLabel.setText(p.getIP());
        emailLabel.setText(p.getEmail());
        uuidLabel.setText(p.getUUID());
        peerTypeLabel.setText(p.getType());
        statusLabel.setText(p.getStatus());
    }
    public void setPeer(String peerName)
        {
          currentSelectedPeer=peerName;
          PeerResolver resolver=new JXTAPeerResolver(peerName,netCore);
          updateInfo(resolver);
      }
    public void receive(String message, Colleague sender, Object body) {
        if(message.equals(ConferenceMediator.PRIVATE_CALL_ACCPTED)) {
            System.out.println("Call Accepted...");
           
            startCall();

        }else if(message.equals(ConferenceMediator.PRIVATE_CALL_REJECTED)) {
            System.out.println("Call Rejected...");
            callingDialogThread.stopThread("Call Rejected...");
        }

    }

    public void setMediator(Mediator m) {
        confMediator=m;
        m.addColleague(this);
    }

    ConferenceMode mode=new ConferenceMode(ConferenceMode.SINGLE,true);
    private ConferenceManager confManager;
    private Image userThumbnail;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel peerTypeLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel uuidLabel;
    private javax.swing.JButton videocallButtton;
    // End of variables declaration//GEN-END:variables


    

}
