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

     HashMap<Integer, opCode> funct1  = new HashMap<Integer, opCode>();
     funct1.put(0, new opCode("madd", 'r'));
     funct1.put(1, new opCode("maddu", 'r'));
     funct1.put(2, new opCode("mul", 'r'));
     funct1.put(4, new opCode("msubu", 'r'));
     funct1.put(33, new opCode("clz", 'r'));
     funct1.put(34, new opCode("clo", 'r'));

     HashMap<Integer, opCode> funct2  = new HashMap<Integer, opCode>();
     funct2.put(0, new opCode("sll", 'r'));
     funct2.put(2, new opCode("slr", 'r'));
     funct2.put(3, new opCode("sra", 'r'));
     funct2.put(4, new opCode("sllv", 'r'));
     funct2.put(6, new opCode("srlv", 'r'));
     funct2.put(7, new opCode("srav", 'r'));
     funct2.put(8, new opCode("jr", 'r'));
     funct2.put(9, new opCode("jalr", 'r'));
     funct2.put(10, new opCode("movz", 'r'));
     funct2.put(11, new opCode("movn", 'r'));
     funct2.put(12, new opCode("syscall", 'r'));
     funct2.put(13, new opCode("break", 'r'));
     funct2.put(15, new opCode("sync", 'r'));
     funct2.put(16, new opCode("mfhi", 'r'));
     funct2.put(17, new opCode("mthi", 'r'));
     funct2.put(18, new opCode("mflo", 'r'));
     funct2.put(19, new opCode("mtlo", 'r'));
     funct2.put(24, new opCode("mult", 'r'));
     funct2.put(25, new opCode("multu", 'r'));
     funct2.put(26, new opCode("div", 'r'));
     funct2.put(27, new opCode("divu", 'r'));
     funct2.put(32, new opCode("add", 'r'));
     funct2.put(33, new opCode("addu", 'r'));
     funct2.put(34, new opCode("sub", 'r'));
     funct2.put(35, new opCode("subu", 'r'));
     funct2.put(36, new opCode("and", 'r'));
     funct2.put(37, new opCode("or", 'r'));
     funct2.put(38, new opCode("xor", 'r'));
     funct2.put(39, new opCode("nor", 'r'));
     funct2.put(42, new opCode("slt", 'r'));
     funct2.put(43, new opCode("sltu", 'r'));
     funct2.put(48, new opCode("tge", 'r'));
     funct2.put(49, new opCode("tgeu", 'r'));
     funct2.put(50, new opCode("tlt", 'r'));
     funct2.put(51, new opCode("tltu", 'r'));
     funct2.put(52, new opCode("teq", 'r'));
     funct2.put(54, new opCode("tne", 'r'));

     HashMap<Integer, opCode> funct3  = new HashMap<Integer, opCode>();
     funct3.put(0, new opCode("add.", 'r'));
     funct3.put(1, new opCode("sub.", 'r'));
     funct3.put(2, new opCode("mul.", 'r'));
     funct3.put(3, new opCode("div.", 'r'));
     funct3.put(4, new opCode("sqrt.", 'r'));
     funct3.put(5, new opCode("abs.", 'r'));
     funct3.put(6, new opCode("mov.", 'r'));
     funct3.put(7, new opCode("neg.", 'r'));
     funct3.put(12, new opCode("round.w.", 'r'));
     funct3.put(13, new opCode("trunc.w.", 'r'));
     funct3.put(14, new opCode("cell.w.", 'r'));
     funct3.put(15, new opCode("floor.w.", 'r'));
     funct3.put(18, new opCode("movz.", 'r'));
     funct3.put(19, new opCode("movn.", 'r'));
     funct3.put(32, new opCode("cvt.s.", 'r'));
     funct3.put(33, new opCode("cvt.d.", 'r'));
     funct3.put(36, new opCode("cvt.w.", 'r'));
     funct3.put(48, new opCode("c.f.", 'r'));
     funct3.put(49, new opCode("c.un.", 'r'));
     funct3.put(50, new opCode("c.eq.", 'r'));
     funct3.put(51, new opCode("c.ueq.", 'r'));
     funct3.put(52, new opCode("c.olt.", 'r'));
     funct3.put(53, new opCode("c.ult.", 'r'));
     funct3.put(54, new opCode("c.ole.", 'r'));
     funct3.put(55, new opCode("c.ule.", 'r'));
     funct3.put(56, new opCode("c.sf.", 'r'));
     funct3.put(57, new opCode("c.ngle.", 'r'));
     funct3.put(58, new opCode("c.seq.", 'r'));
     funct3.put(59, new opCode("c.ngl.", 'r'));
     funct3.put(60, new opCode("c.lt.", 'r'));
     funct3.put(61, new opCode("c.nge.", 'r'));
     funct3.put(62, new opCode("c.le.", 'r'));
     funct3.put(63, new opCode("c.ngt.", 'r'));

     HashMap<Integer, opCode> funct4  = new HashMap<Integer, opCode>();
     funct4.put(1, new opCode("tlbr", 'r'));
     funct4.put(2, new opCode("tlbwi", 'r'));
     funct4.put(6, new opCode("tlbwr", 'r'));
     funct4.put(8, new opCode("tlbp", 'r'));
     funct4.put(24, new opCode("eret", 'r'));
     funct4.put(31, new opCode("deret", 'r'));

     HashMap<Integer, opCode> rs  = new HashMap<Integer, opCode>();
     rs.put(0, new opCode("mfc", 'x'));
     rs.put(2, new opCode("cfc", 'x'));
     rs.put(4, new opCode("mrc", 'x'));
     rs.put(6, new opCode("ctc", 'x'));
     rs.put(32, new opCode("cop0", 'x'));
     rs.put(33, new opCode("cop1s", 'r'));
     rs.put(17, new opCode("cop1d", 'r'));



     String value = "null";

     int opcode= Integer.parseInt(binary.substring(0, 6), 2);
     if(opcode == 0 || opcode == 28){
	 int id= Integer.parseInt(binary.substring(27, 32), 2);
	 System.err.println("id = " + id + "\n" );
	 value = funct1.get(id).getOpcode();
     }
     else{
	 value = opCode.get(opcode).getOpcode();
     }

     System.err.println(opcode + " = " + value);

 }
}
