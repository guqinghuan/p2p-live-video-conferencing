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

import javax.swing.event.TableModelListener;
import org.ioe.bct.p2pconference.ui.controls.ConferenceMediator;
import org.ioe.bct.p2pconference.ui.controls.ConferenceManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.ioe.bct.p2pconference.dataobject.PeerResolver;
import org.ioe.bct.p2pconference.dataobject.ProtectedPeerGroup;
import org.ioe.bct.p2pconference.patterns.mediator.Colleague;
import org.ioe.bct.p2pconference.patterns.mediator.Mediator;





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
        jScrollPane1.setVisible(false);
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
        jTable1 = new javax.swing.JTable();

        setBorder(javax.swing.BorderFactory.createTitledBorder("ConferencePanel"));
        setLayout(new java.awt.BorderLayout());

        upperPanel.setLayout(new java.awt.BorderLayout());
        add(upperPanel, java.awt.BorderLayout.PAGE_START);
        add(lowerpanel, java.awt.BorderLayout.PAGE_END);

        midpanel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTable1.setModel(tm);
        jTable1.setDoubleBuffered(true);
        jTable1.setEnabled(false);
        jTable1.setFocusable(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(5, 5));
        jTable1.setRowSelectionAllowed(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

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
           jTable1.setGridColor(Color.white);
           jScrollPane1.setVisible(true);
           
          
       }

        else if (message.equalsIgnoreCase(ConferenceMediator.JOIN_GROUP)) {
            System.out.println("Group Joined successfully....");
            gPanel.updateComponents();

        }
        else if(message.equalsIgnoreCase(ConferenceMediator.SEND_TEXT_MSG))
            sendTextMesssage(body.toString());
            
         }

    public void sendTextMesssage(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a");
        Date currentDate=Calendar.getInstance().getTime();
        String dateString=sdf.format(currentDate);
        Message msg=new Message(AppMainFrame.getUserName(), message, dateString);
        tableData.add(msg);
        tm.fireTableDataChanged();
    }

    public void receiveTextMessage(String message) {
        
    }

    private class Message{
        private String mess;
        private String from;
        private String date;
        public Message(){}

        public Message(String frm,String msg,String date) {
            this.mess=msg;
            this.from=frm;
            this.date=date;
        }

        public String getMessage() {return mess;}
        public String getFrom() {return from;}
        public String getDate() {return date;}

    }

    private class MyTableModel extends AbstractTableModel {
        

            @Override
            public int getRowCount() {
                return tableData.size();
            }

            @Override
            public int getColumnCount() {
               return 3;
            }

            @Override
            public String getColumnName(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return "From";

                    case 1:
                        return "Message";
                    case 2:
                        return "Time";
                }
                return "";
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return String.class;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Message tablemsg=tableData.get(rowIndex);
                if(tablemsg==null) {return null;}
                switch (columnIndex) {
                    case 0:
                        return tablemsg.getFrom();
                    case 1:
                        return tablemsg.getMessage();
                    case 2:
                        return tablemsg.getDate();
                }
                return "";
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                 Message tablemsg=new Message();
                switch (columnIndex) {
                    case 0:
                        tablemsg.from=aValue.toString();
                    case 1:
                        tablemsg.mess=aValue.toString();
                    case 2:
                        tablemsg.date=aValue.toString();
                }
                tableData.add(tablemsg);
            }



    }

    public void initTable() {
//        tm=new MyTableModel();
//
//        msgtable=new JTable(tm);
//        jScrollPane1.add(msgtable);
//        jScrollPane1.validate();
        
    }

    private AbstractTableModel tm=new MyTableModel();
    private ArrayList<Message> tableData=new ArrayList<Message>();
    private JTable msgtable;
    private SendTextMessagePanel sendTextMsgPanel=new SendTextMessagePanel();
    private GroupInfoPanel gPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel lowerpanel;
    private javax.swing.JPanel midpanel;
    private javax.swing.JPanel upperPanel;
    // End of variables declaration//GEN-END:variables
     private ConferenceManager confManager;
    
     
}
