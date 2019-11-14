package app;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

import javax.swing.*;

/**
 * 
 */

/**
 * @author Ozzy
 *
 */

public class AppWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */

	private Dimension rozmiar = new Dimension(640, 480);
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	private JPanel panel4 = new JPanel();
	private JPanel panel6 = new JPanel();
	private JTextField imie = new JTextField("", 15);
	private JButton next = new JButton("Next");
	private JButton exit = new JButton("Exit");
	private ObrazPanel panel5 = new ObrazPanel();
	private ActionListener listener;
	JDialog alert = new JDialog();
	JLabel message = new JLabel();
	WindowOne kol1;
	/**
	 * 
	 */
	public static String u = "";

	/**
	 * @return
	 * This method get user name to create directory for him.
	 */
	
	public String user() {
		String users = imie.getText();
		String user = users.replaceAll("ą", "a").replaceAll("Ą", "A").replaceAll("ć", "c").replaceAll("Ć", "C").replaceAll("ę", "e").replaceAll("Ę", "E").replaceAll("ł", "l").replaceAll("Ł", "L").replaceAll("ń", "n").replaceAll("Ń", "N").replaceAll("ó", "o").replaceAll("Ó", "O").replaceAll("ś", "s").replaceAll("Ś", "S").replaceAll("ż", "z").replaceAll("Ż", "Z").replaceAll("ź", "z").replaceAll("Ź", "Z");
		String upper = user.toUpperCase(Locale.ROOT);
		
		return upper;

	}

	/**
	 * 
	 */
	public AppWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("English Learner v 0.1");
		setPreferredSize(rozmiar);
		setLocation(200, 100);

		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 1));
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 1));
		panel4.setLayout(new GridLayout(7, 200));
		panel1.setSize(100, 100);

		panel1.add(new JLabel("Podaj imie:"));
		panel1.add(imie);
		panel2.add(next);
		panel2.add(exit);

		panel3.add(new JLabel("                           "));
		panel3.add(new JLabel("Witaj w programie do nauki "));
		panel3.add(new JLabel("                           "));
		panel3.add(new JLabel("                           "));
		panel3.add(new JLabel("                           "));
		panel3.add(new JLabel("                           "));
		panel3.add(new JLabel("                           "));
		panel3.add(new JLabel("języka angielskiego wzorowanym na klasycznym eTeacher."));
		panel3.add(new JLabel("                           "));
		panel3.add(new JLabel("Autor programu: Paweł Osiak"));
		panel6.setLayout(new FlowLayout(FlowLayout.CENTER));

		panel6.add(panel5);

		panel4.add(new JLabel());
		panel4.add(panel6);
		panel4.add(new JLabel());
		panel4.add(panel3);
		panel4.add(panel1);
		panel4.add(panel2);

		add(panel4);

		exit.addActionListener(this);
		next.addActionListener(this);

		alert.setSize(200, 200);
		alert.add(message);
		alert.pack();
		alert.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				alertClosing(we);
			}

		});
		pack();
		setVisible(true);
		
		try {
			Files.createDirectory(Paths.get("EnglishLearner").toAbsolutePath());
		}
		catch(Exception e){
			
		}

	}

	private void alertClosing(WindowEvent we) {

		kol1.setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		Object source = evt.getSource();
		AppWindow.u = user();

		if (source == next) {

			try {
				Files.createDirectory(Paths.get("EnglishLearner/" + u));
				
				kol1 = new WindowOne();
				WindowOne.u = u;
				kol1.setVisible(true);
				kol1.listener = listener;
				this.dispose();

			} catch (Exception e) {

				kol1 = new WindowOne();

//				message.setText(e.toString());
//				alert.setVisible(true);
//				alert.setTitle("Exception Message");
//				alert.setSize(400, 100);
//				alert.setResizable(true);
//				alert.setLocation(300, 300);
//				alert.setAlwaysOnTop(true);

				kol1.setEnabled(true);
				WindowOne.u = u;
				kol1.setVisible(true);
				kol1.listener = listener;
				this.dispose();
			}
		}

		if (source == exit) {

			System.exit(0);

		}

	}

}
