/**
 * The opCode-object contains a String holding the name of the opcode and
 * the format of the opcode. 
 * @author oi11ejn, oi11hms, c11log
 *
 */
public class opCode {
    String opcode;
    char format = ' ';

    public opCode(String opcode, char format){
	this.format=format;
	this.opcode=opcode;
    }
    public String getOpcode(){
	return opcode;
    }
    public char getType(){
	return format;
    }
}
