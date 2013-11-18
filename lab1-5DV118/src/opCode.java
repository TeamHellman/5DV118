
public class opCode {
    String opcode;
    char type = ' ';

    public opCode(String opcode, char type){
	this.type=type;
	this.opcode=opcode;
    }
    public String getOpcode(){
	return opcode;
    }
    public char getType(){
	return type;
    }
}
