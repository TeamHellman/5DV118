import java.util.HashMap;


public class Mappings {
	public HashMap<Integer, opCode> opCode = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> funct1 = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> funct2 = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> funct3 = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> funct4 = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> rs = new HashMap<Integer, opCode>();
	public HashMap<Integer, String> register = new HashMap<Integer, String>();
	public HashMap<Integer, opCode> rt = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> rs8 = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> mov1 = new HashMap<Integer, opCode>();
	public HashMap<Integer, opCode> mov2 = new HashMap<Integer, opCode>();
	public HashMap<Integer, String> shamt = new HashMap<Integer, String>();
	public Mappings(){

		opCode.put(0x02, new opCode("00", 'r'));
		opCode.put(0x02, new opCode("01", 'r'));
		opCode.put(0x02, new opCode("j", 'j'));
		opCode.put(0x03, new opCode("jal", 'j'));
		opCode.put(0x04, new opCode("beq", 'i'));
		opCode.put(0x05, new opCode("bne", 'i'));
		opCode.put(0x06, new opCode("blez", 'v'));
		opCode.put(0x07, new opCode("bgtz", 'v'));
		opCode.put(0x08, new opCode("addi", 'i'));
		opCode.put(0x09, new opCode("addiu", 'i'));
		opCode.put(0x0a, new opCode("slti", 'i'));
		opCode.put(0x0b, new opCode("sltiu", 'i'));
		opCode.put(0x0c, new opCode("andi", 'i'));
		opCode.put(0x0d, new opCode("ori", 'i'));
		opCode.put(0x0e, new opCode("xori", 'i'));
		opCode.put(0x0f, new opCode("lui", 'h'));
		opCode.put(0x14, new opCode("beql", 'i'));
		opCode.put(0x15, new opCode("bnel", 'i'));
		opCode.put(0x16, new opCode("blezl", 'i'));
		opCode.put(0x17, new opCode("bgtzl", 'i'));
		opCode.put(0x1c, new opCode("1c", 'r'));
		opCode.put(0x20, new opCode("lb", 'y'));
		opCode.put(0x21, new opCode("lh", 'y'));
		opCode.put(0x22, new opCode("lwl", 'y'));
		opCode.put(0x23, new opCode("lw", 'y'));
		opCode.put(0x24, new opCode("lbu", 'y'));
		opCode.put(0x25, new opCode("lhu", 'y'));
		opCode.put(0x26, new opCode("lwr", 'y'));
		opCode.put(0x28, new opCode("sb", 'y'));
		opCode.put(0x29, new opCode("sh", 'y'));
		opCode.put(0x2a, new opCode("swl", 'y'));
		opCode.put(0x2b, new opCode("sw", 'y'));
		opCode.put(0x2e, new opCode("swr", 'y'));
		opCode.put(0x2f, new opCode("cache", 'i'));
		opCode.put(0x30, new opCode("ll", 'y'));
		opCode.put(0x31, new opCode("lwc1", 'z'));
		opCode.put(0x32, new opCode("lwc2", 'i'));
		opCode.put(0x33, new opCode("pref", 'i'));
		opCode.put(0x35, new opCode("ldc1", 'i'));
		opCode.put(0x36, new opCode("ldc2", 'i'));
		opCode.put(0x38, new opCode("sc", 'y'));
		opCode.put(0x39, new opCode("swc1", 'z'));
		opCode.put(0x3a, new opCode("swc2", 'i'));
		opCode.put(0x3d, new opCode("sdc1", 'z'));
		opCode.put(0x3e, new opCode("sdc2", 'i'));


		funct1.put(0, new opCode("madd", 'p'));
		funct1.put(1, new opCode("maddu", 'p'));
		funct1.put(2, new opCode("mul", 'r'));
		funct1.put(4, new opCode("msubu", 'r'));
		funct1.put(33, new opCode("clz", 'o'));
		funct1.put(34, new opCode("clo", 'o'));


		funct2.put(0, new opCode("sll", 'g'));
		funct2.put(2, new opCode("srl", 'g'));
		funct2.put(3, new opCode("sra", 'g'));
		funct2.put(4, new opCode("sllv", 'r'));
		funct2.put(6, new opCode("srlv", 'r'));
		funct2.put(7, new opCode("srav", 'r'));
		funct2.put(8, new opCode("jr", 'n'));
		funct2.put(9, new opCode("jalr", 'o'));
		funct2.put(10, new opCode("movz", 'r'));
		funct2.put(11, new opCode("movn", 'r'));
		funct2.put(12, new opCode("syscall", 'l'));
		funct2.put(13, new opCode("break", 'k'));
		funct2.put(15, new opCode("sync", 'r'));
		funct2.put(16, new opCode("mfhi", 'm'));
		funct2.put(17, new opCode("mthi", 'n'));
		funct2.put(18, new opCode("mflo", 'm'));
		funct2.put(19, new opCode("mtlo", 'n'));
		funct2.put(24, new opCode("mult", 'p'));
		funct2.put(25, new opCode("multu", 'p'));
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
		funct2.put(48, new opCode("tge", 'p'));
		funct2.put(49, new opCode("tgeu", 'p'));
		funct2.put(50, new opCode("tlt", 'p'));
		funct2.put(51, new opCode("tltu", 'p'));
		funct2.put(52, new opCode("teq", 'p'));
		funct2.put(54, new opCode("tne", 'p'));
		funct2.put(100, new opCode("nop", 'l'));


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


		funct4.put(1, new opCode("tlbr", 'r'));
		funct4.put(2, new opCode("tlbwi", 'r'));
		funct4.put(6, new opCode("tlbwr", 'r'));
		funct4.put(8, new opCode("tlbp", 'r'));
		funct4.put(24, new opCode("eret", 'r'));
		funct4.put(31, new opCode("deret", 'r'));


		rs.put(0, new opCode("mfc", 'q'));
		rs.put(2, new opCode("cfc", 'f'));
		rs.put(4, new opCode("mtc", 's'));
		rs.put(6, new opCode("ctc", 'f'));
		rs.put(32, new opCode("cop0", 'f'));
		rs.put(33, new opCode("cop1s", 'r'));
		rs.put(17, new opCode("cop1d", 'r'));


		register.put(0, "$zero");
		register.put(1, "$at");
		register.put(2, "$v0");
		register.put(3, "$v1");
		register.put(4, "$a0");
		register.put(5, "$a1");
		register.put(6, "$a2");
		register.put(7, "$a3");
		register.put(8, "$t0");
		register.put(9, "$t1");
		register.put(10, "$t2");
		register.put(11, "$t3");
		register.put(12, "$t4");
		register.put(13, "$t5");
		register.put(14, "$t6");
		register.put(15, "$t7");
		register.put(16, "$s0");
		register.put(17, "$s1");
		register.put(18, "$s2");
		register.put(19, "$s3");
		register.put(20, "$s4");
		register.put(21, "$s5");
		register.put(22, "$s6");
		register.put(23, "$s7");
		register.put(24, "$t8");
		register.put(25, "$t9");
		register.put(26, "$k0");
		register.put(27, "$k1");
		register.put(28, "$gp");
		register.put(29, "$sp");
		register.put(30, "$fp");
		register.put(31, "$ra");


		rt.put(0, new opCode("bltz", 'v'));
		rt.put(1, new opCode("bgez", 'v'));
		rt.put(2, new opCode("bltzl", 'i'));
		rt.put(3, new opCode("bgezl", 'i'));
		rt.put(8, new opCode("tgei", 'x'));
		rt.put(9, new opCode("tgeiu", 'x'));
		rt.put(10, new opCode("tlti", 'x'));
		rt.put(11, new opCode("tltiu", 'x'));
		rt.put(12, new opCode("tegi", 'i'));
		rt.put(14, new opCode("tnei", 'x'));
		rt.put(16, new opCode("bltzal", 'v'));
		rt.put(17, new opCode("bgezal", 'v'));
		rt.put(18, new opCode("bltzall", 'i'));
		rt.put(19, new opCode("bgczall", 'i'));


		rs8.put(0, new opCode("bczf", 'g'));
		rs8.put(1, new opCode("bczt", 'g'));
		rs8.put(2, new opCode("bczfl", 'g'));
		rs8.put(3, new opCode("bcztl", 'g'));


		mov1.put(0, new opCode("movf", 't'));
		mov1.put(1, new opCode("movt", 't'));


		mov2.put(0, new opCode("movf.", 't'));
		mov2.put(1, new opCode("movt.", 't'));

		shamt.put(0, "add");
		shamt.put(1, "addu");
		shamt.put(2, "and");
		shamt.put(3, "clo");
		shamt.put(4, "clz");
		shamt.put(5, "mul");
		shamt.put(6, "nor");
		shamt.put(7, "or");
		shamt.put(8, "sllv");
		shamt.put(9, "srav");
		shamt.put(10, "srlv");
		shamt.put(11, "sub");
		shamt.put(12, "subu");
		shamt.put(13, "slt");
		shamt.put(14, "sltu");


	}
}
