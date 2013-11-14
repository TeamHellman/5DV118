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
new opCode(, 'r');
     HashMap<Integer, String> rs  = new HashMap<Integer, String>();
     opCode.put(0, "mfc");
     opCode.put(2, "cfc");
     opCode.put(4, "mrc");
     opCode.put(6, "ctc");
     opCode.put(32, "cop0");
     opCode.put(33, new opCode("cop1s", 'r');
     opCode.put(17, new opCode("cop1d", 'r');
     
     HashMap<Integer, String> opCode3  = new HashMap<Integer, String>();   
     opCode.put(0, "add.");
     opCode.put(1, "sub.");
     opCode.put(2, "mul.");
     opCode.put(3, "div.");
     opCode.put(4, "sqrt.");
     opCode.put(5, "abs.");
     opCode.put(6, "mov.");
     opCode.put(7, "neg.");
     opCode.put(12, "round.w.");
     opCode.put(13, "trunc.w.");
     opCode.put(14, "cell.w.");
     opCode.put(15, "floor.w.");
     opCode.put(18, "movz.");
     opCode.put(19, "movn.");
     opCode.put(32, "cvt.s.");
     opCode.put(33, "cvt.d.");
     opCode.put(36, "cvt.w.");
     opCode.put(48, "c.f.");
     opCode.put(49, "c.un.");
     opCode.put(50, "c.eq.");
     opCode.put(51, "c.ueq.");
     opCode.put(52, "c.olt.");
     opCode.put(53, "c.ult.");
     opCode.put(54, "c.ole.");
     opCode.put(55, "c.ule.");
     opCode.put(56, "c.sf.");
     opCode.put(57, "c.ngle.");
     opCode.put(58, "c.seq.");
     opCode.put(59, "c.ngl.");
     opCode.put(60, "c.lt.");
     opCode.put(61, "c.nge.");
     opCode.put(62, "c.le.");
     opCode.put(63, "c.ngt.");
     
     int opcode= Integer.parseInt(binary.substring(0, 6), 2);
     String value = opCode.get(opcode);
     System.err.println(opcode + " = " + value);

 }
}
