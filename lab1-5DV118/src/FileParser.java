import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.math.BigInteger;

public class FileParser {

	public static void main(String[] args) {
		BufferedReader reader;

		try {
			File file = new File(args[0]);
			if (file.exists()) {
				reader = new BufferedReader(new FileReader(file));
				String strLine;
				while ((strLine = reader.readLine()) != null) {
					if (strLine.length() > 0) {
						
						if (strLine.substring(0, 2)
								.equalsIgnoreCase("0x")) {
							String hex = strLine.substring(2);
							String binary = hexToBin(hex);
							while (binary.length() < 32) {
								binary = "0" + binary;
							}			
							disassembler test = new disassembler();
							test.parser(binary);
						}
					}
				}
				reader.close();
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

		static String hexToBin(String s) {
			return new BigInteger(s, 16).toString(2);
		}
	

}
