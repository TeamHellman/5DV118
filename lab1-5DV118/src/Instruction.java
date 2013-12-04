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

	public String getInput() {
		return input;
	}
	public void setInput(String input){
		this.input = input;
	}
	public String getDecDecomposed() {
		return decDecomposed;
	}
	public void setDecDecomposed(String decDecomposed) {
		this.decDecomposed = decDecomposed;
	}
	public String getHexDecomposed() {
		return hexDecomposed;
	}
	public void setHexDecomposed(String hexDecomposed) {
		this.hexDecomposed = hexDecomposed;
	}
	public String getDec() {
		return dec;
	}
	public void setDec(String dec) {
		this.dec = dec;
	}
	public String getMnemonicFormat() {
		return mnemonicFormat;
	}
	public void setMnemonicFormat(String mnemonicFormat) {
		this.mnemonicFormat = mnemonicFormat;
	}
	public char getFormat() {
		return format;
	}
	public void setFormat(char format) {
		this.format = format;
	}


}
