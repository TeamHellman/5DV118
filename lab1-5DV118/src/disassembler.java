import java.util.HashMap;


public class disassembler {


 public void hashmap(String binary){
     HashMap<Integer, String> opCode  = new HashMap<Integer, String>();
     opCode.put(0x02, "j");
     opCode.put(0x03, "jal");
     opCode.put(0x04, "beq");
     opCode.put(0x05, "bne");
     opCode.put(0x06, "blez");
     opCode.put(0x07, "bgtz");
     opCode.put(0x08, "addi");
     opCode.put(0x09, "addiu");
     opCode.put(0x0a, "slti");
     opCode.put(0x0b, "sltiu");
     opCode.put(0x0c, "andi");
     opCode.put(0x0d, "ori");
     opCode.put(0x0e, "xori");
     opCode.put(0x0f, "lui");
     opCode.put(0x10, "-");
     opCode.put(0x11, "-");
     opCode.put(0x12, "-");
     opCode.put(0x13, "-");
     opCode.put(0x14, "beql");
     opCode.put(0x15, "bnel");
     opCode.put(0x16, "blezl");
     opCode.put(0x17, "bgtzl");

     HashMap<Integer, String> opCode1  = new HashMap<Integer, String>();
     opCode1.put(0, "madd");
     opCode1.put(1, "maddu");
     opCode1.put(2, "mul");
     opCode1.put(4, "msubu");
     opCode1.put(33, "clz");
     opCode1.put(34, "clo");

     String value = "null";
     int opcode= Integer.parseInt(binary.substring(0, 6), 2);
     if(opcode == 0 || opcode == 28){
	 int id= Integer.parseInt(binary.substring(27, 32), 2);
	 System.err.println("id = " + id + "\n" );
	 value = opCode1.get(id);
     }
     else{
	 value = opCode.get(opcode);
     }

     System.err.println(opcode + " = " + value);

 }
}
