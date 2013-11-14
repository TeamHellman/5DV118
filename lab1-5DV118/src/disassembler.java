import java.util.HashMap;


public class disassembler {


 public void hashmap(String binary){
     HashMap<Integer, opCode> opCode  = new HashMap<Integer, opCode>();
     opCode.put(0x02, new opCode("j", 'r'));
     opCode.put(0x03, new opCode("jal", 'r'));
     opCode.put(0x04, new opCode("beq", 'r'));
     opCode.put(0x05, new opCode("bne", 'r'));
     opCode.put(0x06, new opCode("blez", 'r'));
     opCode.put(0x07, new opCode("bgtz", 'r'));
     opCode.put(0x08, new opCode("addi", 'r'));
     opCode.put(0x09, new opCode("addiu", 'r'));
     opCode.put(0x0a, new opCode("slti", 'r'));
     opCode.put(0x0b, new opCode("sltiu", 'r'));
     opCode.put(0x0c, new opCode("andi", 'r'));
     opCode.put(0x0d, new opCode("ori", 'r'));
     opCode.put(0x0e, new opCode("xori", 'r'));
     opCode.put(0x0f, new opCode("lui", 'r'));
     opCode.put(0x14, new opCode("beql", 'r'));
     opCode.put(0x15, new opCode("bnel", 'r'));
     opCode.put(0x16, new opCode("blezl", 'r'));
     opCode.put(0x17, new opCode("bgtzl", 'r'));

     HashMap<Integer, opCode> opCode1  = new HashMap<Integer, opCode>();
     opCode1.put(0, new opCode("madd", 'r'));
     opCode1.put(1, new opCode("maddu", 'r'));
     opCode1.put(2, new opCode("mul", 'r'));
     opCode1.put(4, new opCode("msubu", 'r'));
     opCode1.put(33, new opCode("clz", 'r'));
     opCode1.put(34, new opCode("clo", 'r'));

     HashMap<Integer, opCode> opCode2  = new HashMap<Integer, opCode>();
     opCode2.put(0, new opCode("sll", 'r'));
     opCode2.put(2, new opCode("slr", 'r'));
     opCode2.put(3, new opCode("sra", 'r'));
     opCode2.put(4, new opCode("sllv", 'r'));
     opCode2.put(6, new opCode("srlv", 'r'));
     opCode2.put(7, new opCode("srav", 'r'));
     opCode2.put(8, new opCode("jr", 'r'));
     opCode2.put(9, new opCode("jalr", 'r'));
     opCode2.put(10, new opCode("movz", 'r'));
     opCode2.put(11, new opCode("movn", 'r'));
     opCode2.put(12, new opCode("syscall", 'r'));
     opCode2.put(13, new opCode("break", 'r'));
     opCode2.put(15, new opCode("sync", 'r'));
     opCode2.put(16, new opCode("mfhi", 'r'));
     opCode2.put(17, new opCode("mthi", 'r'));
     opCode2.put(18, new opCode("mflo", 'r'));
     opCode2.put(19, new opCode("mtlo", 'r'));
     opCode2.put(24, new opCode("mult", 'r'));
     opCode2.put(25, new opCode("multu", 'r'));
     opCode2.put(26, new opCode("div", 'r'));
     opCode2.put(27, new opCode("divu", 'r'));
     opCode2.put(32, new opCode("add", 'r'));
     opCode2.put(33, new opCode("addu", 'r'));
     opCode2.put(34, new opCode("sub", 'r'));
     opCode2.put(35, new opCode("subu", 'r'));
     opCode2.put(36, new opCode("and", 'r'));
     opCode2.put(37, new opCode("or", 'r'));
     opCode2.put(38, new opCode("xor", 'r'));
     opCode2.put(39, new opCode("nor", 'r'));
     opCode2.put(42, new opCode("slt", 'r'));
     opCode2.put(43, new opCode("sltu", 'r'));
     opCode2.put(48, new opCode("tge", 'r'));
     opCode2.put(49, new opCode("tgeu", 'r'));
     opCode2.put(50, new opCode("tlt", 'r'));
     opCode2.put(51, new opCode("tltu", 'r'));
     opCode2.put(52, new opCode("teq", 'r'));
     opCode2.put(54, new opCode("tne", 'r'));

     HashMap<Integer, opCode> opCode3  = new HashMap<Integer, opCode>();
     opCode3.put(1, new opCode("tlbr", 'r'));
     opCode3.put(2, new opCode("tlbwi", 'r'));
     opCode3.put(6, new opCode("tlbwr", 'r'));
     opCode3.put(8, new opCode("tlbp", 'r'));
     opCode3.put(24, new opCode("eret", 'r'));
     opCode3.put(31, new opCode("deret", 'r'));




     String value = "null";
     int opcode= Integer.parseInt(binary.substring(0, 6), 2);
     if(opcode == 0 || opcode == 28){
	 int id= Integer.parseInt(binary.substring(27, 32), 2);
	 System.err.println("id = " + id + "\n" );
	 value = opCode1.get(id).getOpcode();
     }
     else{
	 value = opCode.get(opcode).getOpcode();
     }

     System.err.println(opcode + " = " + value);

 }
}
