
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
