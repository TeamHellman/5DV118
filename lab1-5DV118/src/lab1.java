import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.math.BigInteger;

public class lab1 {

	static String hexToBin(String s) {
		return new BigInteger(s, 16).toString(2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader reader;
		// Read File
		try {
			File file = new File(args[0]);
			if (file.exists()) {
				reader = new BufferedReader(new FileReader(file));
				String strLine;
				while ((strLine = reader.readLine()) != null) {

					ArrayList<String> hexVal = new ArrayList<String>();
					if (strLine.length() > 0) {
						hexVal.add(0, strLine);

						if (hexVal.get(0).substring(0, 2)
								.equalsIgnoreCase("0x")) {
							String hex = hexVal.get(0).substring(2);
							Long intValue = Long.parseLong(hex, 16);
							Long dividedByBig = intValue
									/ (int) Math.pow(2, 26);
							String hexe = Long.toHexString(dividedByBig);
							System.out.println(hexVal.get(0).substring(2));
							System.out.println(hexe);
							String binary = hexToBin(hex);
							while (binary.length() < 32) {
								binary = "0" + binary;

							}
							System.out.println(binary);
							disassembler test = new disassembler();
							test.hashmap(binary);
						}
					}

				}
				reader.close();
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
