package extend;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JDialog;

final public class ResourceLoader {

	static JDialog dialog = new JDialog();
	public static InputStream load(String path) 
	{
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		if(input == null) {
			input = ResourceLoader.class.getResourceAsStream("/"+path);
		}
		return input;
	}
	
	public static BufferedReader loadOBJ(String path) {
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(ResourceLoader.load(path)));

		return input;
	}
}
