/**
 * An instruction-object contains information about a MIPS-instruction. 
 * 
 * @author oi11ejn, oi11hms, c11log
 *
 */
public class Instruction {
	public String input;
	public String hex;
	public String dec;
	public String hexDecomposed;
	public String decDecomposed;
	public String mnemonicFormat;
	public char format;

	/**
	 * Returns the input from the text-file. Either a hexadecimal or decimal
	 * number.
	 * @return
	 */
	public String getInput() {
		return input;
	}
	/**
	 * Sets the input value.
	 * @param input
	 */
	public void setInput(String input){
		this.input = input;
	}
	/**
	 * Returns the decimal decomposed version of the instruction.
	 * @return
	 */
	public String getDecDecomposed() {
		return decDecomposed;
	}
	/**
	 * Sets the decimal decomposed version of the instruction.
	 * @param decDecomposed
	 */
	public void setDecDecomposed(String decDecomposed) {
		this.decDecomposed = decDecomposed;
	}
	/**
	 * Returns the hexadecimal decomposed version of the instruction.
	 * @return
	 */
	public String getHexDecomposed() {
		return hexDecomposed;
	}
	/**
	 * Sets the hexadecimal decomposed version of the instruction.
	 * @param decDecomposed
	 */
	public void setHexDecomposed(String hexDecomposed) {
		this.hexDecomposed = hexDecomposed;
	}
	/**
	 * Returns the decimal value of the instruction.
	 * @return
	 */
	public String getDec() {
		return dec;
	}
	/**
	 * Sets the decimal value of the instruction.
	 * @param dec
	 */
	public void setDec(String dec) {
		this.dec = dec;
	}
	/**
	 * Returns the mnemonic representation of the instruction. 
	 * @return
	 */
	public String getMnemonicFormat() {
		return mnemonicFormat;
	}
	/**
	 * Sets the mnemonic representation of the instruction. 
	 * @param mnemonicFormat
	 */
	public void setMnemonicFormat(String mnemonicFormat) {
		this.mnemonicFormat = mnemonicFormat;
	}
	/**
	 * Returns the format of the instruction. 
	 * @return
	 */
	public char getFormat() {
		return format;
	}
	/**
	 * Sets the format of the instruction. 
	 * @param format
	 */
	public void setFormat(char format) {
		this.format = format;
	}


}
