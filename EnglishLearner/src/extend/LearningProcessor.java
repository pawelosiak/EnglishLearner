/**
 * 
 */
package extend;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a processor for learn module.
 * @author pawel
 */
public class LearningProcessor {
	
	private List<String> listWords = new ArrayList<String>();
	private int counterP=0;
	private int counterE=1;
	private Thread decision;
	
	/**
	 * Constructor with list of elements from file.
	 * 
	 * @param list
	 * 
	 */
	public LearningProcessor(List<String> list) {
		
		
		listWords = prepareList(list);
		System.out.println("Lista z klasy procesor: "+listWords.toString());

		
	}

	private List<String> prepareList(List<String> l) {
		 List<String> prep = new ArrayList<String>();
		for(int i=0; i<l.size(); i++) {
		String prepared = replace(l.get(i));
		prep.add(prepared);
	}
		l.clear();
		return prep;
	}
	
	/**
	 * 
	 * This method selecting the question word from list
	 * @throws InterruptedException 
	 */
	synchronized void selectWord() throws InterruptedException {
		
		if(counterP<listWords.size()-1) {

			Teacher.questionWord.setText(""+listWords.get(counterP));
			counterP+=2;
		}else {
			
					counterP=0;
					
		}
	}

	
	/**
	 * This method gets the answear from user interface and equals to list element
	 * @throws InterruptedException 
	 * 
	 */
	 public synchronized void checkAnswear() throws InterruptedException {
		 	String toCompare = replace(Teacher.answear.getText());
		 	String comparator;
		 	
		 if(counterE<listWords.size()) {
			 comparator = listWords.get(counterE);
			 
				 if(toCompare.equals(comparator)) {
					
					 	good();
						counterE+=2;

				 } 
				 else if(!toCompare.equals(comparator)){
				
					bad();
					counterE+=2;

				
				 }

		}else {
			counterE=1;
	}
		 
	}
	
		 
	
		
	 /**
	  *  This method removes polish letters from words. Accept as parameter String value.
	  *  
	 * @param w
	 * @return String word
	 * 
	 *
	 */
	public String replace(String w) {
		  String word = w.replaceAll("ą", "a").replaceAll("Ą", "A").replaceAll("ć", "c").replaceAll("Ć", "C").replaceAll("ę", "e").replaceAll("Ę", "E").replaceAll("ł", "l").replaceAll("Ł", "L").replaceAll("ń", "n").replaceAll("Ń", "N").replaceAll("ó", "o").replaceAll("Ó", "O").replaceAll("ś", "s").replaceAll("Ś", "S").replaceAll("ż", "z").replaceAll("Ż", "Z").replaceAll("ź", "z").replaceAll("Ź", "Z");
  
		 return word;
	 }
	
	/**
	 * This method repeats work of Thread
	 */
	public synchronized void nextWord() {
		try {
			selectWord();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Action for good answear
	 * @throws InterruptedException 
	 */
	public synchronized void good() throws InterruptedException {
		Teacher.decisionGood.setVisible(true);
		decision = new Thread(new Runnable() {
			 public void run() {
				System.out.println(Thread.currentThread().getState());
				
				try {
					
					Thread.sleep(3000);
					Teacher.decisionGood.setVisible(false);
			}catch(InterruptedException e) {
			 	e.printStackTrace();
			}
			}
		});
		decision.start();
		
		
		
		
		
	}
	/**
	 * Action for bad answear
	 * @throws InterruptedException 
	 */
	public void bad() throws InterruptedException {
		
		System.out.println(Thread.currentThread().getState());
		Teacher.decisionBad.setVisible(true);
		Teacher.decisionBad.setText("Wrong! Answear is: " + listWords.get(counterE));
		
		
		decision = new Thread(new Runnable() {
			 public void run() {
				System.out.println(Thread.currentThread().getState());
				
				try {
					
					Thread.sleep(3000);
					Teacher.decisionBad.setVisible(false);
			}catch(InterruptedException e) {
			 	e.printStackTrace();
			}
			}
		});
		decision.start();
		
		
		
	}
	
	/**
	 * This methods clears last starting processor content.
	 */
	public void clear() {
		
		listWords.clear();
		
		counterE=1;
		counterP=0;
		System.out.println("Lista z klasy procesor po czyszczeniu: "+listWords.toString());
	}
	
	
}

