package extend;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import app.AppWindow;
import app.WindowOne;

/**
 * This class is building learn module using LearningProcessor.
 * @author Ozzy
 * 
 */

public class Teacher extends JFrame implements ActionListener{

	public String u ;
	private Dimension rozmiar = new Dimension(640, 200);
	/**
	 * This button is running checkAnswear Thread
	 */
	public static JButton check = new JButton("CHECK");
	private JButton exit = new JButton(" END  ");
	private JPanel positionPanel = new JPanel();
	private JPanel decisionPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel wordsPanel = new JPanel();
	/**
	 * Label for good ansear.
	 */
	public static JLabel decisionGood;
	/**
	 * Label for bad answear.
	 */
	public static JLabel decisionBad = new JLabel();
	/**
	 * label for question text.
	 */
	public static JLabel questionWord = new JLabel(); 
	/**
	 * TextField for write user answear.
	 */
	public static JTextField answear = new JTextField("", 30);
	private Color color = new Color(15,101,9);
	private WindowOne win;
	private JFileChooser fc;
	private File defined ;
	private String wiersz = null;
	private List<String> words = new ArrayList<String>();
	private LearningProcessor proc;
	private BufferedReader br;

	private void open() {

		fc = new JFileChooser(defined);
		System.out.println(defined.getAbsolutePath());
		
		
		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			int i=0;
			File plik1 = fc.getSelectedFile();
				//pobieranie zawartości pliku do ArrayList
				try {
					br = new BufferedReader(new FileReader(plik1));
					while((wiersz=br.readLine()) != null) {

						
					System.out.println("Pobieranie zawartości pliku do listy. " + i);
					
					String prep = replace((wiersz.trim()));
					words.add(prep);
						i++;
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			String plik = new String(fc.getSelectedFile().toString());
			System.out.println(plik);
			System.out.println(words.toString());
			this.setVisible(true);
		}

		else {
			
			win = new WindowOne(u);
			win.setVisible(true);
			this.dispose();

		}

	}

	/**
	 * Constructor with parameter String user.
	 * @param user 
	 * 
	 */
	public Teacher(String user) {

		this.u = user;
		defined = new File("EnglishLearner/"+u);
		decisionGood = new JLabel("Well done! " + u);
		setResizable(false);
		setTitle("English Learner v 0.1 -beta version");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(rozmiar);
		setLocation(200, 100);
		
		check.addActionListener(this);
		exit.addActionListener(this);
		
		decisionGood.setForeground(color);
		decisionGood.setOpaque(isOpaque());
		decisionGood.setVisible(false);
		
		decisionBad.setForeground(Color.RED);
		decisionBad.setOpaque(isOpaque());
		decisionBad.setVisible(false);
		
		questionWord.setLocale(Locale.PRC);
		questionWord.setVisible(true);
		
		setLayout(new GridLayout(3, 1));
		
		positionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		wordsPanel.setLayout(new GridLayout(2, 1));
		wordsPanel.add(questionWord);
		wordsPanel.add(answear);

		positionPanel.add(wordsPanel);
		
		decisionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		decisionPanel.add(decisionGood);
		decisionPanel.add(decisionBad);
		
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		buttonPanel.add(check);
		buttonPanel.add(exit);

		add(positionPanel);
		add(decisionPanel);
		add(buttonPanel);
		pack();
		
		setVisible(false);
		open();

		proc = new LearningProcessor(words);
		words.clear();
		System.out.println(words.toString());
		questionThread.setName("questionThread");
		
		questionThread.start();
		System.out.println(Thread.currentThread().getName());
		
	}
	Thread questionThread = new Thread(new Runnable() {
		
		public void run() {

				try {
					proc.selectWord();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			
		}
	});

/**
 * Function to secure delete polish letters from any imported to list words from file. Accept String parameter.
 * @param w
 * @return String word
 */
	public String replace(String w) {
		  String word = w.replaceAll("ą", "a").replaceAll("Ą", "A").replaceAll("ć", "c").replaceAll("Ć", "C").replaceAll("ę", "e").replaceAll("Ę", "E").replaceAll("ł", "l").replaceAll("Ł", "L").replaceAll("ń", "n").replaceAll("Ń", "N").replaceAll("ó", "o").replaceAll("Ó", "O").replaceAll("ś", "s").replaceAll("Ś", "S").replaceAll("ż", "z").replaceAll("Ż", "Z").replaceAll("ź", "z").replaceAll("Ź", "Z");
  
		 return word;
	 }

	@Override
	public void actionPerformed(ActionEvent arg0) {

		Object source = arg0.getSource();
		
		
		try {
			questionThread.join();
			
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		Thread answearThread = new Thread(new Runnable() {
			public void run() {
				try {
					
						proc.checkAnswear();
						
	
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		answearThread.setName("answearThread");
		
		answearThread.start();

		if (source == check) {

			try {
				
				answearThread.join();

			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}finally {
	
				proc.nextWord();
				answear.setText("");
			}

		}
		if (source == exit) {
			
			words.clear();
			proc.clear();
			WindowOne a = new WindowOne(u);
			a.setVisible(true);
			this.dispose();
			System.out.println(answearThread.isAlive()+" "+questionThread.isAlive());
			
		}

	}

}
