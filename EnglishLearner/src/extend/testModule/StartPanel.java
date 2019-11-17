package extend.testModule;



/**
 *
 * @author pawel
 */
public class StartPanel extends javax.swing.JPanel {

   
    /**
     * Creates new form StartPanel
     */
    public StartPanel() {
        initComponents();
        welcomeLabel.setVisible(true);
        this.setVisible(true);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        levelBegginer = new javax.swing.JCheckBox();
        levelIntermidiate = new javax.swing.JCheckBox();
        levelExpert = new javax.swing.JCheckBox();

        welcomeLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setLabelFor(this);
        welcomeLabel.setText("Welcome in test mode.");
        welcomeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        welcomeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        startBtn.setText("START");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please select difficulty level and press START");

        levelBegginer.setText("BEGINNER");

        levelIntermidiate.setText("INTERMEDIATE");
        levelIntermidiate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                levelIntermidiateActionPerformed(evt);
            }
        });

        levelExpert.setText("EXPERT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(levelIntermidiate)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(startBtn))))
                            .addComponent(levelBegginer))
                        .addGap(55, 55, 55)
                        .addComponent(levelExpert))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(welcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelBegginer)
                    .addComponent(levelIntermidiate)
                    .addComponent(levelExpert))
                .addGap(61, 61, 61)
                .addComponent(startBtn)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void levelIntermidiateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_levelIntermidiateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_levelIntermidiateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox levelBegginer;
    private javax.swing.JCheckBox levelExpert;
    private javax.swing.JCheckBox levelIntermidiate;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
