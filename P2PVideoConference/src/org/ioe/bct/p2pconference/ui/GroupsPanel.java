/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GroupsPanel.java
 *
 * Created on Nov 5, 2010, 12:29:08 PM
 */
package org.ioe.bct.p2pconference.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import org.ioe.bct.p2pconference.core.PeerGroupOrganizer;
import org.ioe.bct.p2pconference.dataobject.ProtectedPeerGroup;
import org.ioe.bct.p2pconference.patterns.mediator.Colleague;
import org.ioe.bct.p2pconference.patterns.mediator.Mediator;
import org.ioe.bct.p2pconference.ui.controls.ConferenceMediator;
import org.ioe.bct.p2pconference.ui.controls.GroupListener;

/**
 *
 * @author kusu
 */
public class GroupsPanel extends javax.swing.JPanel implements Colleague, GroupListener {

    private ArrayList<ProtectedPeerGroup> peerGroupsList = new ArrayList<ProtectedPeerGroup>();
    private ArrayList<JPanel> peerListUIPanelList = new ArrayList<JPanel>();
    private Mediator confMediator;
    private JPopupMenu popupMenu;
    private JMenuItem popupMenuJoinItem;
    private JMenuItem popupMenuGetInfoItem;

    /** Creates new form GroupsPanel */
    public GroupsPanel(Mediator m) {
        initComponents();
        confMediator = m;
        initPopupMenu();
    }

    public void receive(String message, Colleague sender, Object body) {
//        throw new UnsupportedOperationException("Not supported yet.");

        if (message.equalsIgnoreCase(ConferenceMediator.GROUP_ADDED)) {

            PeerGroupOrganizer orgn = (PeerGroupOrganizer) body;
            CreateGroupDialog rsender = (CreateGroupDialog) sender;

            peerGroupsList = orgn.getAllPeerGroups();
            System.out.println("TOTAL PEER GROUPS " + peerGroupsList.size());
            updateGroupList();
            rsender.dispose();
        }



    }

    private void updateGroupList() {
        peerListUIPanelList = new ArrayList<JPanel>();
        Iterator it = peerGroupsList.iterator();

        while (it.hasNext()) {
            ProtectedPeerGroup current = (ProtectedPeerGroup) it.next();
            String groupName = current.getGroupName();
            JLabel label = new JLabel(groupName);
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panel.add(label);
            peerListUIPanelList.add(panel);
            System.out.println(groupName);
        }
        groupsListUI.setListData(peerListUIPanelList.toArray());
        groupsListUI.setSelectedIndex(0);
    }

    public void setMediator(Mediator m) {

        m.addColleague(this);
    }

    public void updatePeerGroups(ArrayList<ProtectedPeerGroup> updatedPGs) {
        peerGroupsList = updatedPGs;
        updateGroupList();
    }

    private void initPopupMenu() {
        popupMenu = new JPopupMenu();
        popupMenuJoinItem = new JMenuItem("Join This Group");
        popupMenuGetInfoItem = new JMenuItem("Get Group Info");
        popupMenu.add(popupMenuJoinItem);
        popupMenu.add(popupMenuGetInfoItem);
        popupMenuJoinItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                joinSelctedGroup();
            }
        });

        popupMenuGetInfoItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                getGroupInfo();
            }
        });

    }

    private void joinSelctedGroup() {

        System.out.println("Joining the peer group...");
        int getSelectedDataItem = groupsListUI.getSelectedIndex();

        ProtectedPeerGroup selectedPeerGroup = peerGroupsList.get(getSelectedDataItem);
        joinGroupDialog = new JoinGroupDialog(null, selectedPeerGroup);
        joinGroupDialog.setMediator(confMediator);
        joinGroupDialog.setVisible(true);

    }

    private void getGroupInfo() {
        System.out.println("Getting the group Info...");
    }

    private void initList() {
        groupsListUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        groupsListUI.setCellRenderer(new ListCellRenderer() {

            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

                if (value instanceof JPanel) {
                    Component component = (Component) value;
                    component.setForeground(Color.white);
                    component.setBackground(isSelected ? Color.MAGENTA : Color.white);
                    return component;
                } else {
                    return new JLabel("");
                }
            }
        });

        groupsListUI.setListData(peerListUIPanelList.toArray());


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        groupsListUI = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        groupsListUI.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        groupsListUI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupsListUIMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                groupsListUIMouseReleased(evt);
            }
        });
        groupsListUI.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                groupsListUIValueChanged(evt);
            }
        });
        initList();
        jScrollPane1.setViewportView(groupsListUI);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void groupsListUIValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_groupsListUIValueChanged
        // TODO add your handling code here:

        sendSelectionChangedMessage();
    }//GEN-LAST:event_groupsListUIValueChanged

    private void groupsListUIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupsListUIMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_groupsListUIMouseClicked

    private void groupsListUIMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupsListUIMouseReleased
        // TODO add your handling code here:
        if (groupsListUI.getSelectedIndex() < 0) {
            return;
        }
        if (evt.isPopupTrigger()) {
            popupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_groupsListUIMouseReleased

    public void sendSelectionChangedMessage() {
        if (groupsListUI.getSelectedIndex() < 0) {
            return;
        }
        int selIndex = groupsListUI.getSelectedIndex();
        ProtectedPeerGroup selectedPG = peerGroupsList.get(selIndex);
        confMediator.sendMessage(ConferenceMediator.CONT_SELECTION_CHANGED, this, selectedPG);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList groupsListUI;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private JoinGroupDialog joinGroupDialog;
}
