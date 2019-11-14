package app;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JPanel;

import extend.ResourceLoader;

/**
 * 
 */

/**
 * @author Ozzy
 *
 */
public class ObrazPanel extends JPanel {

	/**
	 * 
	 */

	private BufferedImage image;
	private JDialog dialog = new JDialog();

	public ObrazPanel() {

		File imageFile = new File("Logo.png");
		imageFile.setReadable(true);
		try {
			image = ImageIO.read(ResourceLoader.load("Logo.png"));
		} catch (IOException e) {
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
			dialog.setTitle(e.getMessage());
			dialog.setVisible(true);
			
		}

		Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
		setPreferredSize(dimension);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, 0, 0, this);
	}
}
