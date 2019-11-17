package extend;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JDialog;

/**
 * @author pawel
 *
 */
final public class ResourceLoader {

	static JDialog dialog = new JDialog();
	/**
	 * @param path
	 * @return InputStream
	 */
	public static InputStream load(String path) 
	{
		InputStream input = ResourceLoader.class.getResourceAsStream(path);
		if(input == null) {
			input = ResourceLoader.class.getResourceAsStream("/"+path);
		}
		return input;
	}
	
	/**
	 * @param path
	 * @return BUfferedReader
	 */
	public static BufferedReader loadOBJ(String path) {
		
		
		BufferedReader input = new BufferedReader(new InputStreamReader(ResourceLoader.load(path)));

		return input;
	}
}
