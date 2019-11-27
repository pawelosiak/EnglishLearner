package extend.testModule;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingWorker;
import javax.swing.Timer;

/**
 *
 * @author pawel
 */
public class TestPanel extends javax.swing.JPanel {

    /**
     * Creates new form TestPanel
     * @param words 
     * @param level 
     */
    public TestPanel(List<String>words, String level) {
        
        end=false;
        this.difficult = level;
        this.data = words;
        counterWords = (words.size()/2);
        
       
        System.out.println(data.size());

        if(difficult.equals("begginer")) {
        	minutes = delayBegginer*(data.size()/2);
        	minutes=(minutes/1000)/60;
        	
        	System.out.println(minutes);
        }
        else if(difficult.equals("intermidiate")) {
        	 minutes = delayIntermediate*(data.size()/2);
        	minutes=(minutes/1000)/60;
        	
        	System.out.println(minutes);
        }
        else if(difficult.equals("expert")) {
        	minutes = delayExpert*(data.size()/2);
        	minutes=(minutes/1000)/60;
        	
        	System.out.println(minutes);
        }
        
        initComponents();
        
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
							timerLabel.setText("Time to end: 0"+String.valueOf(minutes)+":0"+String.valueOf(seconds));
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
					if(minutes==0 && seconds==60) {
						timerLabel.setText("Time to end: 01:00");
					}
					
				}
				if(minutes==0 && seconds==0) {
					end = true;
					timerLabel.setText("Time to end: 00:00");
					timeAll.stop();
					checkBtn.setText("END TEST");
					

				}
				
			}
			
		});

      try {
		masterTask.doInBackground();
	} catch (Exception e1) {
		
		e1.printStackTrace();
	}
        
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
        decisionLabel.setForeground(Color.DARK_GRAY);
        decisionLabel.setText("Your answear is: ");

        checkBtn.setText("CHECK");
        checkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			String action = checkBtn.getText();
			if(action.equals("CHECK")) {
				compareManual();
			}
			else if (action.equals("END TEST")) {
				masterTask.done();
			}
				
			}
        	
        });

        timerLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timerLabel.setText("Time to end:");
        timerLabel.setVisible(true);

        wordsCountLabel.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        wordsCountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wordsCountLabel.setText("Questions to end:  "+counterWords+"/"+data.size()/2);

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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkBtn;
    private javax.swing.JLabel decisionLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JTextField userAnswear;
    private javax.swing.JLabel wordsCountLabel;
    private List<String> data = new ArrayList<String>();
    private int minutes;
    private int seconds=0;
    private Timer timeAll;
    private String difficult;
    private MasterTask masterTask = new MasterTask();
    private final int delayBegginer = 180000;
    private final int delayIntermediate = 120000;
    private final int delayExpert = 60000;
    /**
     * Boolean value for ending test with time interval or data count.
     */
    private boolean end;
    // End of variables declaration//GEN-END:variables
    private int counterP=0;
    private int counterE = 1;
    private int counterWords ;
    private Thread question;
    private Thread equal;
    private Thread equalManual;
    private Thread decisionGood;
    private Thread decisionBad;
    private int counter;
    private String replace(String w) {
		  String word = w.replaceAll("ą", "a").replaceAll("Ą", "A").replaceAll("ć", "c").replaceAll("Ć", "C").replaceAll("ę", "e").replaceAll("Ę", "E").replaceAll("ł", "l").replaceAll("Ł", "L").replaceAll("ń", "n").replaceAll("Ń", "N").replaceAll("ó", "o").replaceAll("Ó", "O").replaceAll("ś", "s").replaceAll("Ś", "S").replaceAll("ż", "z").replaceAll("Ż", "Z").replaceAll("ź", "z").replaceAll("Ź", "Z");

		 return word;
	 }
    private synchronized void selectWord(){
    	question = new Thread(new Runnable() {
    		public void run() {
    			if(counterP<data.size()-1) {
    	    		questionLabel.setText(data.get(counterP));

    	    	}
    		}
    	});
    	
    	question.start();
    	compare();
    	
    }
    private synchronized void compare() {
    	
    	
    	equal = new Thread(new Runnable() {
    		String toCompare ;
    		String comparator;
    		public void run() {
    			counter = counterWords-1;
    			if(counterE<data.size()) {
    				comparator = data.get(counterE);
    			if(difficult.equals("begginer")) {
    				System.out.println("From list:"+comparator);

	    			try {
						Thread.sleep(delayBegginer);
						toCompare = replace(userAnswear.getText());
						System.out.println("From user:"+toCompare);
						if(toCompare.equals(comparator)) {
		    				good();
		    				counterE+=2;
		    				
		    				}
		    			else if(!toCompare.equals(comparator)) {
		    				bad();
		    				counterE+=2;
		    			}
						nextWord();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
	    		}
	    		if(difficult.equals("Intermidiate")) {
	    			System.out.println("From list:"+comparator);
	    			try {
						Thread.sleep(delayIntermediate);
						toCompare = replace(userAnswear.getText());
						System.out.println("From user:"+toCompare);
						if(toCompare.equals(comparator)) {
		    				good();
		    				counterE+=2;
		    				
		    				}
		    			else if(!toCompare.equals(comparator)) {
		    				bad();
		    				counterE+=2;
		    			}
						nextWord();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
	    		}
	    		if(difficult.equals("expert")) {
	    			System.out.println("From list:"+comparator);
	    			try {
						Thread.sleep(delayExpert);
						toCompare = replace(userAnswear.getText());
						System.out.println("From user:"+toCompare);
						if(toCompare.equals(comparator)) {
		    				good();
		    				counterE+=2;
		    				
		    				}
		    			else if(!toCompare.equals(comparator)) {
		    				bad();
		    				counterE+=2;
		    			}
						nextWord();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
	    		}
    			}if(counter == 0) {
    				try {
						Thread.sleep(100);
						toCompare = replace(userAnswear.getText());
						System.out.println("From user:"+toCompare);
						if(toCompare.equals(comparator)) {
		    				good();
		    				
		    				System.out.println(counter);
		    				}
		    			else if(!toCompare.equals(comparator)) {
		    				bad();
		    				
		    				System.out.println(counter);
		    			}
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
    				end = true;
    				checkBtn.setText("END TEST");
    		}
    		}
    	});
    	equal.start();
    	
    }
    private synchronized void nextWord() {
    	if(counterWords>0) {
    	counterWords-=1;
    	}
    	wordsCountLabel.setText("Questions to end:  "+counterWords+"/"+data.size()/2);
    	counterP+=2;
    	selectWord();
    	
    	
    }
    private synchronized void good() {
    	decisionGood = new Thread(new Runnable() {

			@Override
			public void run() {
				decisionLabel.setForeground(new Color(15,101,9));
				decisionLabel.setText("Your answear is: good");
				decisionLabel.setVisible(true);
				
					try {
						userAnswear.setText("");
						Thread.sleep(3000);
						decisionLabel.setForeground(Color.DARK_GRAY);
						decisionLabel.setText("Your answear is: ");
						

					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}

			}});
    	decisionGood.start();
    }
    private synchronized void bad() {
    	decisionBad = new Thread(new Runnable() {

			@Override
			public void run() {
				decisionLabel.setForeground(Color.RED);
				decisionLabel.setText("Your answear is: bad");
				decisionLabel.setVisible(true);
				
				try {
					userAnswear.setText("");
					Thread.sleep(3000);
					decisionLabel.setForeground(Color.DARK_GRAY);
					decisionLabel.setText("Your answear is: ");
					

				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}

			}});
    	decisionBad.start();
    }
    private synchronized void compareManual() {
    	equalManual = new Thread(new Runnable() {
    		String toCompare ;
    		String comparator;
    		
    		public void run() {
    			counter = counterWords-1;
    			if(counterE<data.size() && counter > 0) {
    				comparator = data.get(counterE);
    			
    				System.out.println("From list:"+comparator);

	    			try {
						Thread.sleep(100);
						toCompare = replace(userAnswear.getText());
						System.out.println("From user:"+toCompare);
						if(toCompare.equals(comparator)) {
		    				good();
		    				counterE+=2;
		    				System.out.println(counter);
		    				}
		    			else if(!toCompare.equals(comparator)) {
		    				bad();
		    				counterE+=2;
		    				System.out.println(counter);
		    			}
						nextWord();
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
    			}else if(counter == 0) {
    				try {
						Thread.sleep(100);
						toCompare = replace(userAnswear.getText());
						System.out.println("From user:"+toCompare);
						if(toCompare.equals(comparator)) {
		    				good();
		    				
		    				System.out.println(counter);
		    				}
		    			else if(!toCompare.equals(comparator)) {
		    				bad();
		    				
		    				System.out.println(counter);
		    			}
						
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
    				end = true;
    				checkBtn.setText("END TEST");
    			}
	    		
    		}
    		
    	});
    	equalManual.start();
    	
    }
    class MasterTask extends SwingWorker<Void, Void>{

		@Override
		protected Void doInBackground() throws Exception {
			timeAll.start();
			
			selectWord();
			

			return null;
		}

		@Override
		protected void done() {
			if(end) {
			try {
				Thread.sleep(1);
				Tester.testPanel.setVisible(false);
				Tester.lastPanel.setVisible(true);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		}
    }
	
}
