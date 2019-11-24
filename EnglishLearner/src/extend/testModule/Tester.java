package extend.testModule;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import app.WindowOne;

/**
 *
 * @author pawel
 */
public class Tester extends javax.swing.JFrame implements ActionListener{

    
    /**
     * 
     */
    public static ActionListener listener;
	/**
     * 
     */
    public String u;
	StartPanel firstPanel ;
    /**
     * 
     */
    public static TestPanel testPanel ;
    /**
     * 
     */
    public static FinishPanel lastPanel;
    private final int width =600;
    private final int height = 400;
    private final Dimension sizeFrame = new Dimension(width, height);
    private final Dimension sizePanel = new Dimension(500 , 500);
    /**
     * List words for test.
     */
    public List<String> words = new ArrayList<String>();
    
    /**
     * Button for close test module from first welcome panel.
     */
    public static JButton exitBtn = new JButton("EXIT");
    
    /**
     * BUtton for close test module from finished panel.
     */
    public static JButton exitFinalBtn = new JButton("EXIT");
    /**
     * Button for starting test.
     */
    public static JButton startBtn = new JButton("START");
    
    private JFileChooser fc;
    private File defined;
    private BufferedReader br;
    private String wiersz = null;
    private WindowOne win;
    
    /**
     * Creates new form Tester.
     * @param user 
     * @param list 
     */
    public Tester(String user) {
        
    	this.u = user;
    	defined = new File("EnglishLearner/"+u);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setPreferredSize(sizeFrame);
        setResizable(false);
        this.setLocation(300,100);
        firstPanel = new StartPanel(u);
        firstPanel.getSize(sizePanel);
        firstPanel.setVisible(true);
        this.add(firstPanel);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        pack();
        open();
        
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));
        exitBtn.addActionListener(this);
        startBtn.addActionListener(this);
        exitFinalBtn.addActionListener(this);
        lastPanel = new FinishPanel();
        setVisible(false);
        pack();
    }

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
					
					e.printStackTrace();
				}


			String plik = new String(fc.getSelectedFile().toString());
			System.out.println(plik);
			System.out.println(words.toString());
			initComponents();
			this.setVisible(true);
		}

		else {
			
			win = new WindowOne(u);
			win.setVisible(true);
			this.dispose();

		}

	}
    /**
     * @param w
     * @return word
     */
    public String replace(String w) {
		  String word = w.replaceAll("ą", "a").replaceAll("Ą", "A").replaceAll("ć", "c").replaceAll("Ć", "C").replaceAll("ę", "e").replaceAll("Ę", "E").replaceAll("ł", "l").replaceAll("Ł", "L").replaceAll("ń", "n").replaceAll("Ń", "N").replaceAll("ó", "o").replaceAll("Ó", "O").replaceAll("ś", "s").replaceAll("Ś", "S").replaceAll("ż", "z").replaceAll("Ż", "Z").replaceAll("ź", "z").replaceAll("Ź", "Z");

		 return word;
	 }
    @Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == startBtn) {
			firstPanel.setVisible(false);
			testPanel = new TestPanel(words, firstPanel.level);
			testPanel.setSize(sizePanel);
			this.add(testPanel);
			testPanel.setVisible(true);
			if(TestPanel.end) {
				testPanel.setVisible(false);
				this.add(lastPanel);
				lastPanel.setVisible(true);
			}
			
		}
		if(e.getSource() == exitBtn || e.getSource() == exitFinalBtn) {
		System.out.println("button EXIT pressed.");
		win = new WindowOne(u);
		win.setVisible(true);
		this.dispose();
		}
		
		
	}
}
