package extend.testModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author pawel
 */
public class StartPanel extends javax.swing.JPanel implements ItemListener{

   
    /**
     * Creates new form StartPanel
     * @param u 
     */
    public StartPanel(String user) {
    	this.u = user;
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

    	System.out.println(this.getParent());
        welcomeLabel = new javax.swing.JLabel();
        startBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        levelBegginer = new javax.swing.JCheckBox();
        levelIntermidiate = new javax.swing.JCheckBox();
        levelExpert = new javax.swing.JCheckBox();

       
        welcomeLabel.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setLabelFor(this);
        welcomeLabel.setText("Welcome in test mode "+ u +".");
        welcomeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        welcomeLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please select difficulty level and press START");

        levelBegginer.setText("BEGINNER");

        levelIntermidiate.setText("INTERMEDIATE");
        levelExpert.setText("EXPERT");
        
        levelBegginer.addItemListener(this);
        levelIntermidiate.addItemListener(this);
        levelExpert.addItemListener(this);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap(49, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(13)
        							.addComponent(welcomeLabel, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(126)
        									.addComponent(levelIntermidiate))
        								.addComponent(levelBegginer))
        							.addGap(55)
        							.addComponent(levelExpert))
        						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(143)
        					.addComponent(Tester.startBtn)
        					.addGap(50)
        					.addComponent(Tester.exitBtn)))
        			.addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(welcomeLabel)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel1)
        			.addGap(56)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(levelBegginer)
        				.addComponent(levelIntermidiate)
        				.addComponent(levelExpert))
        			.addGap(61)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(Tester.startBtn)
        				.addComponent(Tester.exitBtn))
        			.addContainerGap(63, Short.MAX_VALUE))
        );
        
        
        this.setLayout(layout);
       
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox levelBegginer;
    private javax.swing.JCheckBox levelExpert;
    private javax.swing.JCheckBox levelIntermidiate;
    private javax.swing.JButton startBtn;
    private javax.swing.JLabel welcomeLabel;
    /**
     * 
     */
    public String level;
    /**
     * Variable for user name data;
     */
    public String u;
    /**
     * Button for close test module.
     */
   
    // End of variables declaration//GEN-END:variables
    
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Object source = arg0.getSource();
		int state = arg0.getStateChange();
		
		switch (state) {

		case 1: {

			if (source.equals(levelBegginer)) {
				levelIntermidiate.setEnabled(false);
				levelExpert.setEnabled(false);
				level = "begginer";
				System.out.println(level);
				
			}
			
			else if(source.equals(levelIntermidiate)) {
				levelBegginer.setEnabled(false);
				levelExpert.setEnabled(false);
				level = "intermidiate";
				System.out.println(level);
				
			}

			else if(source.equals(levelExpert)) {
				levelIntermidiate.setEnabled(false);
				levelBegginer.setEnabled(false);
				level = "expert";
				System.out.println(level);
				
			}

			
			break;
			}
			
		
		case 0: {
			levelBegginer.setEnabled(true);
			levelIntermidiate.setEnabled(true);
			levelExpert.setEnabled(true);
			level = null;
			System.out.println(level);
			
			break;
		}
		default: {
			levelBegginer.setEnabled(true);
			levelIntermidiate.setEnabled(true);
			levelExpert.setEnabled(true);
			level = null;
			System.out.println(level);
			
			break;
		}
		
	

		}
		
			
		
		
	}
}
