package extend.testModule;

/**
 *
 * @author pawel
 */
public class FinishPanel extends javax.swing.JPanel {

    /**
     * Creates new form FinishPanel
     */
    public FinishPanel() {
        initComponents();
        endMessageup.setText("                   Test is done.                           ");
        endMessageCenter.setText("Your result is : +result, so is +message type of result");
        endMessageDown.setText("Run test again or come back to learning mode for increase your skill");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endMessageup = new javax.swing.JLabel();
        endMessageCenter = new javax.swing.JLabel();
        endMessageDown = new javax.swing.JLabel();
        raportBtn = new javax.swing.JButton();
        
        

        endMessageup.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        endMessageup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endMessageup.setText("                   Test is done.                           ");
        endMessageup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        endMessageCenter.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        endMessageCenter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endMessageCenter.setText("Your result is : +result, so it's +message type of result");
        endMessageCenter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        endMessageDown.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        endMessageDown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endMessageDown.setText("Run test again or come back to learning mode for increase your skill");
        endMessageDown.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        raportBtn.setText("CREATE RAPORT?");
        raportBtn.setEnabled(false);
        raportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repeatBtnActionPerformed(evt);
            }
        });

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(endMessageCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endMessageDown, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                    .addComponent(endMessageup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(raportBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Tester.exitFinalBtn)
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(endMessageup)
                .addGap(18, 18, 18)
                .addComponent(endMessageCenter)
                .addGap(26, 26, 26)
                .addComponent(endMessageDown)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(raportBtn)
                    .addComponent(Tester.exitFinalBtn))
                .addGap(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void repeatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repeatBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repeatBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel endMessageCenter;
    private javax.swing.JLabel endMessageDown;
    private javax.swing.JLabel endMessageup;
   
    private javax.swing.JButton raportBtn;
    // End of variables declaration//GEN-END:variables
}
