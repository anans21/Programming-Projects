/**
 *
 * @author Sameer Anand
 * 
 */

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class GUI extends javax.swing.JFrame {

    JFileChooser fileChooser;
    
    ScanFolders scanFolders;
    
    TopN topN;

    public GUI() {
       
        initComponents();
        
        fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nLabel = new javax.swing.JLabel();
        nTF = new javax.swing.JTextField();
        openButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nLabel.setText("Enter N: ");
        getContentPane().add(nLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));
        getContentPane().add(nTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 100, -1));

        openButton.setText("Open");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });
        getContentPane().add(openButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 320, -1));

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 430, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed


        try {
            
            int value = fileChooser.showOpenDialog(null);
            
            if (value == JFileChooser.APPROVE_OPTION) {

                scanFolders = new ScanFolders();
            
                int n = Integer.parseInt(nTF.getText());
                
                topN = new TopN(n, new FileComparator());

                scanFolders.scan(fileChooser.getSelectedFile(), topN);

                textArea.setText("");
                
                for (File file : topN.getTopNFiles()) {
                
                    textArea.append(file.getName() + " : " + file.length()+ " bytes\n");
                
                }

            } else {
                
                JOptionPane.showMessageDialog(null, "Select a directoty first.");
            
            }
        
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Error occured. Try again.");
        
        }
    }//GEN-LAST:event_openButtonActionPerformed

    public static void main(String args[]) {

        new GUI().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nLabel;
    private javax.swing.JTextField nTF;
    private javax.swing.JButton openButton;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

}