package app;

import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import extend.testModule.FuzzyLogic;

/**
 * @author pawel
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JLabel.setDefaultLocale(Locale.ROOT);
		SwingUtilities.invokeLater(new Runnable() {
			

			@Override
			public void run() {

				new AppWindow();
				
				
			}
		});

	}

}
