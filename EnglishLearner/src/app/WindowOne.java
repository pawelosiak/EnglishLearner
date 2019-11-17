package app;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import extend.Teacher;
import extend.testModule.*;


/**
 * @author Ozzy
 *
 */
public class WindowOne extends JFrame implements ActionListener, ItemListener {

	/**
	 * 
	 */

	private JCheckBox nauka = new JCheckBox("Learn", false);
	private JCheckBox test = new JCheckBox("Test - disabled", false);
	private JCheckBox tworzenie = new JCheckBox("Add test/lern file", false);
	private JCheckBox dodanie = new JCheckBox("Add item to test/lern file", false);
	private Dimension rozmiar = new Dimension(640, 280);
	private JPanel boxy = new JPanel();
	private JPanel guziki = new JPanel();
	private JPanel all = new JPanel();
	private JPanel wprowadzanie = new JPanel();
	private JPanel wprowadzanie1 = new JPanel();
	private JButton startLearn = new JButton("START_LERN");
	private JButton startTest = new JButton("START_TEST");
	private JButton create = new JButton("CREATE");
	private JButton add = new JButton("MODIFY");
	private JButton exit = new JButton("BACK");
	private JButton dod = new JButton("ADD");
	private JButton dodE = new JButton("ADD");
	private JButton zak = new JButton("END");
	private JButton zakE = new JButton("END");
	private JTextField polski = new JTextField("", 30);
	private JTextField polskiE = new JTextField("", 30);
	private JTextField angielski = new JTextField("", 30);
	private JTextField angielskiE = new JTextField("", 30);
	private JTextArea temp = new JTextArea();
	private JTextArea temp1 = new JTextArea();
	private File defined;
	private File plik;
	private PrintWriter pw;
	private Scanner sc, sc1, sc2;
	private JFileChooser fc;
	private FileNameExtensionFilter filter = new FileNameExtensionFilter("txt", ".txt");
	public static String u;
	Teacher tea;
	Tester testWin;
	/**
	 * 
	 */
	public ActionListener listener;

	private boolean gotWordP(String w) {
		boolean get = false;
		if (w != null) {
			get = true;
		}
		if(get && w.length()<1) {
			get=false;
		}
		return get;
	}
	
	private boolean gotWordE(String w) {
		boolean get = false;
		if (w != null) {
			get = true;
		}
		if(get && w.length()<2) {
			get=false;
		}
		return get;
	}
	private String replace(String w) {
		  String word = w.replaceAll("ą", "a").replaceAll("Ą", "A").replaceAll("ć", "c").replaceAll("Ć", "C").replaceAll("ę", "e").replaceAll("Ę", "E").replaceAll("ł", "l").replaceAll("Ł", "L").replaceAll("ń", "n").replaceAll("Ń", "N").replaceAll("ó", "o").replaceAll("Ó", "O").replaceAll("ś", "s").replaceAll("Ś", "S").replaceAll("ż", "z").replaceAll("Ż", "Z").replaceAll("ź", "z").replaceAll("Ź", "Z");

		 return word;
	 }
	// get polish word
	private String getP() {

		return replace(polski.getText());
	}

	// add polish word
	private String addP() {

		return replace(polskiE.getText());
	}

	// add polish word
	private String addE() {

		return angielskiE.getText();
	}

	// get english word
	private String getE() {

		return angielski.getText();
	}

	private void content() {

		plik = fc.getSelectedFile();

		try {
			sc = new Scanner(plik);

			while (sc.hasNext()) {
				temp.append(sc.nextLine()+"\n");

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	private void added() {

		plik = fc.getSelectedFile();

		try {
			sc = new Scanner(plik);

			while (sc.hasNext()) {
				temp1.append(sc.nextLine()+"\n");

			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}

	private void edited() {

		plik = fc.getSelectedFile();
		
		try {
			PrintWriter pw1 = new PrintWriter(plik);
			sc1 = new Scanner(temp.getText());
			sc2 = new Scanner(temp1.getText());

			while (sc1.hasNext()) {
				String[] word = sc1.next().split("\n");
				for(int i=0; i<word.length; i++) {
				pw1.println(word[i]);
				}

			}
			while (sc2.hasNext()) {
				String[] word = sc2.next().split("\n");
				for(int i=0; i<word.length; i++) {
				pw1.println(word[i]);
				}
			}

			pw1.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	private PrintWriter open() {

		plik = fc.getSelectedFile();

		try {
			pw = new PrintWriter(plik);

		} catch (IOException e3) {

			e3.printStackTrace();
		}

		return pw;
	}

	private void writer() {

		pw.println(getP());
		pw.println(getE());

	}

	private void adder() {

		
		pw.append(addP()+"\n");
		pw.append(addE()+"\n");

	}

	/**
	 * 
	 */
	public WindowOne() {

		setResizable(true);
		setTitle("English Learner v 0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(rozmiar);
		setLocation(200, 100);

		test.setForeground(Color.RED);
		nauka.addItemListener(this);
		//test.addItemListener(this);
		tworzenie.addItemListener(this);
		dodanie.addItemListener(this);

		startLearn.addActionListener(this);
		startTest.addActionListener(this);
		create.addActionListener(this);
		add.addActionListener(this);
		exit.addActionListener(this);
		zak.addActionListener(this);
		dod.addActionListener(this);
		dodE.addActionListener(this);
		zakE.addActionListener(this);
		startLearn.setEnabled(false);
		startTest.setEnabled(false);
		create.setEnabled(false);
		add.setEnabled(false);
		

		
		boxy.setLayout(new GridLayout(4, 1));
		boxy.add(nauka);
		boxy.add(test);
		boxy.add(tworzenie);
		boxy.add(dodanie);

		polski.setToolTipText("Słówko musi mieć minimum jedną literę!");
		angielski.setToolTipText("Słówko musi mieć minimum dwie litery!");
		wprowadzanie.setLayout(new GridLayout(3, 1));
		wprowadzanie.add(new JLabel("Write polish word :"));
		wprowadzanie.add(polski);
		wprowadzanie.add(new JLabel("Write english translation :"));
		wprowadzanie.add(angielski);
		wprowadzanie.add(dod);
		wprowadzanie.add(zak);
		wprowadzanie.setVisible(true);

		polskiE.setToolTipText("Słówko musi mieć minimum jedną literę!");
		angielskiE.setToolTipText("Słówko musi mieć minimum dwie litery!");
		wprowadzanie1.setLayout(new GridLayout(3, 1));
		wprowadzanie1.add(new JLabel("Write polish word :"));
		wprowadzanie1.add(polskiE);
		wprowadzanie1.add(new JLabel("Write english translation :"));
		wprowadzanie1.add(angielskiE);
		wprowadzanie1.add(dodE);
		wprowadzanie1.add(zakE);
		wprowadzanie1.setVisible(false);

		guziki.setLayout(new FlowLayout(FlowLayout.LEFT));
		guziki.add(startLearn);
		guziki.add(startTest);
		guziki.add(create);
		guziki.add(add);
		guziki.add(exit);

		all.setLayout(new GridLayout(4, 1));
		all.add(boxy);
		all.add(guziki);
		all.add(wprowadzanie);
		all.add(wprowadzanie1);

		add(all);

		pack();
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if (source == startLearn) {

			tea = new Teacher();
			tea.u = WindowOne.u;
			this.dispose();
		}

		if (source == startTest) {

		}

		if (source == create) {
			String path = "EnglishLearner/"+u;
			defined = new File(path);
			fc = new JFileChooser(defined);
			fc.addChoosableFileFilter(filter);
			JOptionPane.showConfirmDialog(null, "Dodaj .txt na końcu nazwy pliku aby utworzyć plik tekstowy!", "Important!", DISPOSE_ON_CLOSE, JOptionPane.INFORMATION_MESSAGE);
			

			if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				
				create.setEnabled(false);
				exit.setEnabled(false);
				tworzenie.setEnabled(false);
				wprowadzanie.setVisible(true);
				
				open();

			}
		}

		if (source == add) {

			defined = new File("EnglishLearner/" + u);
			
			fc = new JFileChooser(defined);
			fc.addChoosableFileFilter(filter);

			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

				dodanie.setEnabled(false);
				add.setEnabled(false);
				exit.setEnabled(false);
				wprowadzanie1.setVisible(true);
				content();
				open();

			}

		}

		if (source == exit) {

			JFrame app = new AppWindow();
			app.setVisible(true);
			this.dispose();
		}

		if (source == dod) {

			if(gotWordP(getP()) && gotWordE(getE())) {
			writer();
			polski.setText("");
			angielski.setText("");
			}
			else if(!gotWordP(getP()) && !gotWordE(getE())) {
				JOptionPane.showConfirmDialog(null, "Pola do wprowadzania są puste lub źle uzupełnione!", "Wrong value", DISPOSE_ON_CLOSE, JOptionPane.ERROR_MESSAGE);
			}
			else if(!gotWordP(getP())) {
				JOptionPane.showConfirmDialog(null, "Uzupełnij polskie słówko!", "Wrong value", DISPOSE_ON_CLOSE, JOptionPane.ERROR_MESSAGE);
			}else if(!gotWordE(getE())) {
				JOptionPane.showConfirmDialog(null, "Uzupełnij angielskie słówko!", "Wrong value", DISPOSE_ON_CLOSE, JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if (source == zak) {

			pw.close();
			create.setEnabled(true);
			exit.setEnabled(true);
			tworzenie.setEnabled(true);
			wprowadzanie.setVisible(false);

		}

		if (source == dodE) {

			if(gotWordP(addP()) && gotWordE(addE())) {
			adder();
			polskiE.setText("");
			angielskiE.setText("");
			}
			else if(!gotWordP(addP()) && !gotWordE(addE())) {
				JOptionPane.showConfirmDialog(null, "Pola do wprowadzania są puste lub źle uzupełnione!", "Wrong value", DISPOSE_ON_CLOSE, JOptionPane.ERROR_MESSAGE);
			}
			else if(!gotWordP(addP())) {
				JOptionPane.showConfirmDialog(null, "Uzupełnij polskie słówko!", "Wrong value", DISPOSE_ON_CLOSE, JOptionPane.ERROR_MESSAGE);
			}else if(!gotWordE(addE())) {
				JOptionPane.showConfirmDialog(null, "Uzupełnij angielskie słówko!", "Wrong value", DISPOSE_ON_CLOSE, JOptionPane.ERROR_MESSAGE);
			}

		}

		if (source == zakE) {

			pw.close();
			added();
			edited();
			dodanie.setEnabled(true);
			add.setEnabled(true);
			exit.setEnabled(true);
			wprowadzanie1.setVisible(false);
		}
	}

	@Override

	public void itemStateChanged(ItemEvent e) {

		int source1 = e.getStateChange();
		Object source = e.getSource();

		switch (source1) {

		case 1: {

			if (source.equals(nauka)) {

				startLearn.setEnabled(true);
				test.setEnabled(false);
				tworzenie.setEnabled(false);
				dodanie.setEnabled(false);
				
			}
			
			else if(source.equals(test)) {

				startTest.setEnabled(true);
				nauka.setEnabled(false);
				tworzenie.setEnabled(false);
				dodanie.setEnabled(false);
				
			}

			else if(source.equals(tworzenie)) {

				create.setEnabled(true);
				nauka.setEnabled(false);
				test.setEnabled(false);
				dodanie.setEnabled(false);
				all.add(wprowadzanie);
				
			}

			else if(source.equals(dodanie)) {

				add.setEnabled(true);
				nauka.setEnabled(false);
				test.setEnabled(false);
				tworzenie.setEnabled(false);
				all.add(wprowadzanie1);
				
			}
			break;
			}
			
		
		case 0: {
			startLearn.setEnabled(false);
			startTest.setEnabled(false);
			create.setEnabled(false);
			add.setEnabled(false);
			nauka.setEnabled(true);
			test.setEnabled(true);
			tworzenie.setEnabled(true);
			dodanie.setEnabled(true);
			
			break;
		}
		default: {
			startLearn.setEnabled(false);
			startTest.setEnabled(false);
			create.setEnabled(false);
			add.setEnabled(false);
			nauka.setEnabled(true);
			test.setEnabled(true);
			tworzenie.setEnabled(true);
			dodanie.setEnabled(true);
	
			break;
		}
		
	

		}

	}

}
