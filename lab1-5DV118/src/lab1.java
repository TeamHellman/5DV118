import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class lab1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	       BufferedReader reader;
	        // Read Feeds File
	        try {
	            File file = new File(args[0]);
	            if (file.exists()) {
	                reader = new BufferedReader(new FileReader(file));
	                String strLine;
	                while ((strLine = reader.readLine()) != null) {

	                 System.out.println(strLine);

	                }
	                reader.close();
	            }
	        } catch (IOException e) {
	            System.err.println("Error: " + e.getMessage());
	        }

    }

}
