import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.math.BigInteger;

public class FileParser {
	static ArrayList<Instruction> instructions = new ArrayList<Instruction>();
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
							Instruction MIPS = new Instruction();
							MIPS.setHex(strLine);
							instructions.add(MIPS);
							String hex = strLine.substring(2);
							String binary = hexToBin(hex);
							while (binary.length() < 32) {
								binary = "0" + binary;
							}			
							disassembler test = new disassembler();
							test.parser(binary, MIPS);
						} 
						else {
							Instruction MIPS = new Instruction();
							instructions.add(MIPS);
							String binary = new BigInteger(strLine).toString(2);
							String hex = new BigInteger(strLine).toString(16);
							MIPS.setHex("0x" + hex);
							while (binary.length() < 32) {
								binary = "0" + binary;
							}
							disassembler test = new disassembler();
							test.parser(binary, MIPS);
						}
					}
				}
				reader.close();
			}	
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		// Print
		for(int i=0; i < instructions.size(); i++){
			System.out.println("HEX: " + instructions.get(i).getHex() + " Format: " + instructions.get(i).getFormat() + " Mnemonic: " + instructions.get(i).getMnemonicFormat());			
		}

	

}
	static String hexToBin(String s) {
		return new BigInteger(s, 16).toString(2);
	}

}
