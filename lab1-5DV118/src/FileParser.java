import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Class that parse a file containing one MIPS-instruction 
 * per line. It can be in either decimal or hexadecimal, hexadecimal
 * instructions starts with "0x" to indicate that the following instruction
 * is in hexadecimal. 
 * 
 * @author oi11ejn, oi11hms, c11log
 *
 */
public class FileParser {
	
	/**
	 * The FileParser contains an ArrayList of instructions that contains
	 * the parsed instructions from the input file. 
	 */
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
			    instructions.add(MIPS);
			    String hex = strLine.substring(2);
			    String binary = hexToBin(hex);
			    MIPS.setInput(strLine);
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
			    MIPS.setInput(strLine);
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

	System.out.println(String.format("%1.5s%16s%19s%22s%23s", "Input", "Format", "HEX Decomposed", "DEC Decomposed", "Mnemonic" ));
	// Print the instructions parsed from the file
	for(int i=0; i < instructions.size(); i++){

	    if(instructions.get(i).getFormat() == 'X'){
		System.out.println(instructions.get(i).getInput() + "        " +  instructions.get(i).getHexDecomposed());
	    }else{
		System.out.println(String.format("%s %8.2s %20s %21s %22s", instructions.get(i).getInput(), instructions.get(i).getFormat(), instructions.get(i).getHexDecomposed(), instructions.get(i).getDecDecomposed(), instructions.get(i).getMnemonicFormat()));
	    }
	}
    }
    static String hexToBin(String s) {
	return new BigInteger(s, 16).toString(2);
    }

}
