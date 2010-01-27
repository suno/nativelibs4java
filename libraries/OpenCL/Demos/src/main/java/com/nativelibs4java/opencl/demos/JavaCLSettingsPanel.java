/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JavaCLSettingsPanel.java
 *
 * Created on 3 janv. 2010, 04:06:51
 */

package com.nativelibs4java.opencl.demos;

import com.nativelibs4java.opencl.CLDevice;
import com.nativelibs4java.opencl.CLPlatform;
import com.nativelibs4java.opencl.JavaCL;
import com.nativelibs4java.opencl.demos.hardware.HardwareReport;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLCapabilitiesChooser;
import javax.media.opengl.GLProfile;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author ochafik
 */
public class JavaCLSettingsPanel extends javax.swing.JPanel {

    public void removeOpenGLComponents() {
        configFromGLCheck.getParent().remove(configFromGLCheck);
        awtRenderingCheck.getParent().remove(awtRenderingCheck);
        invalidate();
    }
    
    /** Creates new form JavaCLSettingsPanel */
    public JavaCLSettingsPanel() {
        initComponents();

        Border border = UIManager.getBorder( "TitledBorder.aquaVariant" );
        if (border == null)
            border = new EtchedBorder();
        settingsPanel.setBorder(new TitledBorder(border, "OpenCL & OpenGL Settings"));
        platformCombo.setModel(new DefaultComboBoxModel(getPlatforms().toArray()));
        platformChanged(null);
        normalButtActionPerformed(null);
    }

    public boolean isDirectGLRendering() {
        return awtRenderingCheck.isSelected();
    }
    public void setDirectGLRendering(boolean b) {
        awtRenderingCheck.setSelected(b);
    }

    public CLDevice getDevice() {
        return (CLDevice)deviceCombo.getSelectedItem();
    }

    public List getPlatforms() {
        CLPlatform[] platforms = JavaCL.listPlatforms();
        boolean hasSharing = false;
        plat: for (CLPlatform platform : platforms)
            if (platform.isGLSharingSupported())
                for (CLDevice device : platform.listAllDevices(false)) 
                    if (device.isGLSharingSupported()) {
                        hasSharing = true;
                        break plat;
                    }

        configFromGLCheck.setEnabled(hasSharing);
        configFromGLCheck.setToolTipText("Did not find any OpenCL platform with OpenGL sharing support.");
        
        return Arrays.asList(platforms);
    }

    public List getGLProfiles() {
        List list = new ArrayList();
        list.add(GLProfile.GL2);
        return list;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        settingsPanel = new javax.swing.JPanel();
        fastestButt = new javax.swing.JButton();
        safestButt = new javax.swing.JButton();
        normalButt = new javax.swing.JButton();
        detailsButt = new javax.swing.JButton();
        awtRenderingCheck = new javax.swing.JCheckBox();
        configFromGLCheck = new javax.swing.JCheckBox();
        platformLab = new javax.swing.JLabel();
        platformCombo = new javax.swing.JComboBox();
        deviceLab = new javax.swing.JLabel();
        deviceCombo = new javax.swing.JComboBox();

        fastestButt.setText("Fastest (unstable)");
        fastestButt.setToolTipText("Best performance, typically unstable.");
        fastestButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastestButtActionPerformed(evt);
            }
        });

        safestButt.setText("Safest (slow)");
        safestButt.setToolTipText("Choose this if you've experienced crashes or black screens with the other modes");
        safestButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                safestButtActionPerformed(evt);
            }
        });

        normalButt.setFont(normalButt.getFont().deriveFont(normalButt.getFont().getStyle() | java.awt.Font.BOLD));
        normalButt.setText("Normal (advised)");
        normalButt.setToolTipText("Usually the best compromise.");
        normalButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalButtActionPerformed(evt);
            }
        });

        detailsButt.setText("Details");
        detailsButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailsButtActionPerformed(evt);
            }
        });

        awtRenderingCheck.setSelected(true);
        awtRenderingCheck.setText("Direct OpenGL AWT Rendering (faster)");
        awtRenderingCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                awtRenderingCheckActionPerformed(evt);
            }
        });

        configFromGLCheck.setText("Configure from OpenGL context");
        configFromGLCheck.setToolTipText("Attempt to share data between OpenCL and OpenGL. \nThis is not well supported by existing graphic card drivers might crash the program.");
        configFromGLCheck.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                configFromGLChanged(evt);
            }
        });
        configFromGLCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configFromGLCheckActionPerformed(evt);
            }
        });

        platformLab.setText("Platform");

        platformCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        platformCombo.setMinimumSize(new java.awt.Dimension(16, 27));
        platformCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                platformChanged(evt);
            }
        });
        platformCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platformComboActionPerformed(evt);
            }
        });

        deviceLab.setText("Device");

        deviceCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        deviceCombo.setMinimumSize(new java.awt.Dimension(16, 27));

        org.jdesktop.layout.GroupLayout settingsPanelLayout = new org.jdesktop.layout.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(settingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(settingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(platformLab)
                    .add(deviceLab))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(settingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(settingsPanelLayout.createSequentialGroup()
                        .add(fastestButt)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(normalButt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(safestButt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(configFromGLCheck)
                    .add(awtRenderingCheck)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, settingsPanelLayout.createSequentialGroup()
                        .add(platformCombo, 0, 354, Short.MAX_VALUE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(detailsButt))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, deviceCombo, 0, 448, Short.MAX_VALUE))
                .addContainerGap())
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, settingsPanelLayout.createSequentialGroup()
                .add(settingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(safestButt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(fastestButt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(normalButt, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(configFromGLCheck)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(settingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(platformCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(platformLab)
                    .add(detailsButt))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(settingsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(deviceCombo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(deviceLab))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(awtRenderingCheck))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(settingsPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(settingsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void configFromGLCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configFromGLCheckActionPerformed
        
    }//GEN-LAST:event_configFromGLCheckActionPerformed

    private void awtRenderingCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_awtRenderingCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_awtRenderingCheckActionPerformed

    private void platformComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platformComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platformComboActionPerformed

    private void platformChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_platformChanged
        CLPlatform platform = (CLPlatform)platformCombo.getSelectedItem();
        if (platform != null) {
            CLDevice[] devices = platform.listAllDevices(true);
            deviceCombo.setModel(new DefaultComboBoxModel(devices));
            setDevice(platform.getBestDevice());
        } else {
            deviceCombo.setModel(new DefaultComboBoxModel(new Object[0]));
        }
    }//GEN-LAST:event_platformChanged


    private void fastestButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastestButtActionPerformed
        selectBestDevice();
        if (awtRenderingCheck.isEnabled())
            awtRenderingCheck.setSelected(true);
        if (configFromGLCheck.isEnabled())
            configFromGLCheck.setSelected(true);
    }//GEN-LAST:event_fastestButtActionPerformed

    private void normalButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_normalButtActionPerformed
        selectBestDevice();
        if (awtRenderingCheck.isEnabled())
            awtRenderingCheck.setSelected(true);
        if (configFromGLCheck.isEnabled())
            configFromGLCheck.setSelected(false);
    }//GEN-LAST:event_normalButtActionPerformed

    private void safestButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_safestButtActionPerformed
        selectBestDevice();
        if (awtRenderingCheck.isEnabled())
            awtRenderingCheck.setSelected(false);
        if (configFromGLCheck.isEnabled())
            configFromGLCheck.setSelected(false);
    }//GEN-LAST:event_safestButtActionPerformed

    private void configFromGLChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_configFromGLChanged
        platformCombo.setEnabled(!configFromGLCheck.isSelected());
        deviceCombo.setEnabled(!configFromGLCheck.isSelected());
        platformLab.setEnabled(!configFromGLCheck.isSelected());
        deviceLab.setEnabled(!configFromGLCheck.isSelected());
    }//GEN-LAST:event_configFromGLChanged

    private void detailsButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsButtActionPerformed
        CLPlatform platform = (CLPlatform)platformCombo.getSelectedItem();
        if (platform != null) {
            JComponent c = HardwareReport.getHardwareReportComponent(platform);
            c.setMaximumSize(new Dimension(600, 600));
            c.setPreferredSize(new Dimension(600, 600));
            JOptionPane.showMessageDialog(this, c, "HardwareReport for platform '" + platform.getName() + "'", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_detailsButtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox awtRenderingCheck;
    private javax.swing.JCheckBox configFromGLCheck;
    private javax.swing.JButton detailsButt;
    private javax.swing.JComboBox deviceCombo;
    private javax.swing.JLabel deviceLab;
    private javax.swing.JButton fastestButt;
    private javax.swing.JButton normalButt;
    private javax.swing.JComboBox platformCombo;
    private javax.swing.JLabel platformLab;
    private javax.swing.JButton safestButt;
    private javax.swing.JPanel settingsPanel;
    // End of variables declaration//GEN-END:variables

    private void setDevice(CLDevice device) {
        if (device == null) {
            deviceCombo.setSelectedIndex(-1);
            return;
        }

        CLPlatform platform = device.getPlatform();
        if (!platform.equals(platformCombo.getSelectedItem()))
            platformCombo.setSelectedItem(platform);

        for (int i = 0, len = deviceCombo.getModel().getSize(); i < len; i++) {
            CLDevice d = (CLDevice)deviceCombo.getModel().getElementAt(i);
            if (device.equals(d)) {
                deviceCombo.setSelectedItem(d);
                break;
            }
        }
    }

    private void selectBestDevice() {
        setDevice(JavaCL.getBestDevice());
    }

    public boolean isGLSharingEnabled() {
        return configFromGLCheck.isEnabled() && configFromGLCheck.isSelected();
    }

    public void setGLSharingEnabled(boolean b) {
        if (configFromGLCheck.isEnabled())
            configFromGLCheck.setSelected(b);
    }

}