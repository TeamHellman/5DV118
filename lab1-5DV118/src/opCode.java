/**
 * The opCode-object contains a String holding the name of the opcode and
 * the format of the opcode. 
 * @author oi11ejn, oi11hms, c11log
 *
 */
public class opCode {
    String opcode;
    char format = ' ';
    
    /**
     * Creates a new opcode-object with a opcode and a format. 
     * 
     * @param opcode
     * @param format
     */
    public opCode(String opcode, char format){
	this.format=format;
	this.opcode=opcode;
    }
    /**
     * Returns the opcode. 
     * @return
     */
    public String getOpcode(){
	return opcode;
    }
    
    /**
     * Returns the format.
     * @return
     */
    public char getType(){
	return format;
    }
}
