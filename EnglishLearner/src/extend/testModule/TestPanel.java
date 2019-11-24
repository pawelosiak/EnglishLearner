package extend.testModule;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Timer;

/**
 *
 * @author pawel
 */
public class TestPanel extends javax.swing.JPanel implements ActionListener{

    /**
     * Creates new form TestPanel
     * @param words 
     * @param level 
     */
    public TestPanel(List<String>words, String level) {
        
        end=false;
        this.difficult = level;
        System.out.println(words.size());
       
        
        int delayBegginer = 180000;
    	int delayIntermediate = 120000;
    	int delayExpert = 60000;
    	
    	timerBeggin = new Timer(delayBegginer, this);
    	timerIntermediate = new Timer(delayIntermediate, this);
    	timerExpert = new Timer(delayExpert, this);
    	
        if(difficult.equals("begginer")) {
        	minutes = delayBegginer*(words.size()/2);
        	minutes=(minutes/1000)/60;
        	System.out.println(minutes);
        }
        else if(difficult.equals("intermidiate")) {
        	 minutes = delayIntermediate*(words.size()/2);
        	minutes=(minutes/1000)/60;
        	System.out.println(minutes);
        }
        else if(difficult.equals("expert")) {
        	minutes = delayExpert*(words.size()/2);
        	minutes=(minutes/1000)/60;
        	System.out.println(minutes);
        }
        
        timeAll = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				
				if(seconds == 0 && minutes>0) {
					seconds=60;
					
					if(minutes<10) {
						timerLabel.setText("Time to end: 0"+String.valueOf(minutes)+":00");
					}
					else if(minutes>=10) {
						timerLabel.setText("Time to end: "+String.valueOf(minutes)+":00");
					}
					minutes--;
				}else if(seconds < 60) {
					if(minutes<10 || seconds<10) {
						if(seconds<10) {
							timerLabel.setText("Time to end: "+String.valueOf(minutes)+":0"+String.valueOf(seconds));
						}else if(minutes<10 && seconds>=10 ) {
							timerLabel.setText("Time to end: 0"+String.valueOf(minutes)+":"+String.valueOf(seconds));
						}
						
					}
					
					else if(minutes>=10) {
						timerLabel.setText("Time to end: "+String.valueOf(minutes)+":"+String.valueOf(seconds));
					}
					
					}
				else if(seconds < 10) {
					if(minutes<10) {
						timerLabel.setText("Time to end: 0"+String.valueOf(minutes)+":0"+String.valueOf(seconds));
					}
					else if(minutes>=10) {
						timerLabel.setText("Time to end: "+String.valueOf(minutes)+":0"+String.valueOf(seconds));
					}
					
					}
				
				seconds--;
				if(seconds==0 && minutes!=0) {
					minutes--;
					if(minutes<10) {
						timerLabel.setText("Time to end: 0"+String.valueOf(minutes)+":00");
					}
					
					seconds=60;
					
				}
				if(minutes==0 && seconds==0) {
					timeAll.stop();
					timerLabel.setText("Test time is end.");
					try {
						Thread.sleep(100);
						end = true;
						
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		});
        timeAll.start();
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionLabel = new javax.swing.JLabel();
        userAnswear = new javax.swing.JTextField();
        decisionLabel = new javax.swing.JLabel();
        checkBtn = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();
        wordsCountLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));

        
        questionLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        questionLabel.setText("question text");

        userAnswear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        decisionLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        decisionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        decisionLabel.setText("decision good or bad");

        checkBtn.setText("CHECK");
        checkBtn.addActionListener(this);

        timerLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("Time to end:");
        timerLabel.setVisible(true);

        wordsCountLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        wordsCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wordsCountLabel.setText("Question:  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(decisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wordsCountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addComponent(userAnswear, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(questionLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(checkBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timerLabel)
                        .addComponent(wordsCountLabel))
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(questionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userAnswear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(decisionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(checkBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkBtn;
    private javax.swing.JLabel decisionLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JTextField userAnswear;
    private javax.swing.JLabel wordsCountLabel;
    
    private Timer timerBeggin;
    private Timer timerIntermediate;
    private Timer timerExpert;
    private int minutes;
    private int seconds=0;
    private Timer timeAll;
    private String difficult;
    /**
     * 
     */
    public static boolean end;
    // End of variables declaration//GEN-END:variables
	
}
