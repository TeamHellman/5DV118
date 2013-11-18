import java.util.HashMap;

public class disassembler {

    public void hashmap(String binary) {

	HashMap<Integer, opCode> opCode = new HashMap<Integer, opCode>();
	opCode.put(0x02, new opCode("00", 'r'));
	opCode.put(0x02, new opCode("01", 'r'));
	opCode.put(0x02, new opCode("j", 'j'));
	opCode.put(0x03, new opCode("jal", 'j'));
	opCode.put(0x04, new opCode("beq", 'i'));
	opCode.put(0x05, new opCode("bne", 'i'));
	opCode.put(0x06, new opCode("blez", 'i'));
	opCode.put(0x07, new opCode("bgtz", 'i'));
	opCode.put(0x08, new opCode("addi", 'i'));
	opCode.put(0x09, new opCode("addiu", 'i'));
	opCode.put(0x0a, new opCode("slti", 'i'));
	opCode.put(0x0b, new opCode("sltiu", 'i'));
	opCode.put(0x0c, new opCode("andi", 'i'));
	opCode.put(0x0d, new opCode("ori", 'i'));
	opCode.put(0x0e, new opCode("xori", 'i'));
	opCode.put(0x0f, new opCode("lui", 'i'));
	opCode.put(0x14, new opCode("beql", 'i'));
	opCode.put(0x15, new opCode("bnel", 'i'));
	opCode.put(0x16, new opCode("blezl", 'i'));
	opCode.put(0x17, new opCode("bgtzl", 'i'));

	opCode.put(0x18, new opCode("18", 'r'));
	opCode.put(0x19, new opCode("19", 'r'));
	opCode.put(0x1a, new opCode("1a", 'r'));
	opCode.put(0x1b, new opCode("1b", 'r'));
	opCode.put(0x1c, new opCode("1c", 'r'));
	opCode.put(0x1d, new opCode("1d", 'r'));
	opCode.put(0x1e, new opCode("1e", 'r'));
	opCode.put(0x1f, new opCode("1f", 'r'));
	opCode.put(0x20, new opCode("lb", 'r'));
	opCode.put(0x21, new opCode("lh", 'r'));
	opCode.put(0x22, new opCode("lwl", 'r'));
	opCode.put(0x23, new opCode("lw", 'r'));
	opCode.put(0x24, new opCode("lbu", 'r'));
	opCode.put(0x25, new opCode("lhu", 'r'));
	opCode.put(0x26, new opCode("lwr", 'r'));
	opCode.put(0x28, new opCode("sb", 'r'));
	opCode.put(0x29, new opCode("sh", 'r'));
	opCode.put(0x2a, new opCode("swl", 'r'));
	opCode.put(0x2b, new opCode("sw", 'r'));
	opCode.put(0x2e, new opCode("swr", 'r'));
	opCode.put(0x2f, new opCode("cache", 'r'));
	opCode.put(0x30, new opCode("ll", 'r'));
	opCode.put(0x31, new opCode("lwc1", 'r'));
	opCode.put(0x32, new opCode("lwc2", 'r'));
	opCode.put(0x33, new opCode("pref", 'r'));
	opCode.put(0x35, new opCode("ldc1", 'r'));
	opCode.put(0x36, new opCode("ldc2", 'r'));
	opCode.put(0x38, new opCode("sc", 'r'));
	opCode.put(0x39, new opCode("swc1", 'r'));
	opCode.put(0x3a, new opCode("swc2", 'r'));
	opCode.put(0x3d, new opCode("sdc1", 'r'));
	opCode.put(0x3e, new opCode("sdc2", 'r'));

	HashMap<Integer, opCode> funct1 = new HashMap<Integer, opCode>();
	funct1.put(0, new opCode("madd", 'r'));
	funct1.put(1, new opCode("maddu", 'r'));
	funct1.put(2, new opCode("mul", 'r'));
	funct1.put(4, new opCode("msubu", 'r'));
	funct1.put(33, new opCode("clz", 'r'));
	funct1.put(34, new opCode("clo", 'r'));

	HashMap<Integer, opCode> funct2 = new HashMap<Integer, opCode>();
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

	HashMap<Integer, opCode> funct3 = new HashMap<Integer, opCode>();
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

	HashMap<Integer, opCode> funct4 = new HashMap<Integer, opCode>();
	funct4.put(1, new opCode("tlbr", 'r'));
	funct4.put(2, new opCode("tlbwi", 'r'));
	funct4.put(6, new opCode("tlbwr", 'r'));
	funct4.put(8, new opCode("tlbp", 'r'));
	funct4.put(24, new opCode("eret", 'r'));
	funct4.put(31, new opCode("deret", 'r'));

	HashMap<Integer, opCode> rs = new HashMap<Integer, opCode>();
	rs.put(0, new opCode("mfc", 'x'));
	rs.put(2, new opCode("cfc", 'x'));
	rs.put(4, new opCode("mtc", 'x'));
	rs.put(6, new opCode("ctc", 'x'));
	rs.put(32, new opCode("cop0", 'x'));
	rs.put(33, new opCode("cop1s", 'r'));
	rs.put(17, new opCode("cop1d", 'r'));

	HashMap<Integer, String> register = new HashMap<Integer, String>();
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

	HashMap<Integer, opCode> rt = new HashMap<Integer, opCode>();
	rt.put(0, new opCode("bltz", 'x'));
	rt.put(1, new opCode("bgez", 'x'));
	rt.put(2, new opCode("bitzl", 'x'));
	rt.put(3, new opCode("bgezl", 'x'));
	rt.put(8, new opCode("tgei", 'x'));
	rt.put(9, new opCode("tgeiu", 'r'));
	rt.put(10, new opCode("tlti", 'r'));
	rt.put(11, new opCode("tltiu", 'r'));
	rt.put(12, new opCode("tegi", 'r'));
	rt.put(14, new opCode("tnei", 'r'));
	rt.put(16, new opCode("bltzal", 'r'));
	rt.put(17, new opCode("bgezal", 'r'));
	rt.put(18, new opCode("bltall", 'r'));
	rt.put(19, new opCode("bgczall", 'r'));

	HashMap<Integer, opCode> rs8 = new HashMap<Integer, opCode>();
	rs8.put(0, new opCode("bczf", 'x'));
	rs8.put(1, new opCode("bczt", 'x'));
	rs8.put(2, new opCode("bczfl", 'x'));
	rs8.put(3, new opCode("bcztl", 'x'));

	HashMap<Integer, opCode> mov1 = new HashMap<Integer, opCode>();
	mov1.put(0, new opCode("movf", 'x'));
	mov1.put(1, new opCode("movt", 'x'));

	HashMap<Integer, opCode> mov2 = new HashMap<Integer, opCode>();
	mov2.put(0, new opCode("movf.", 'x'));
	mov2.put(1, new opCode("movt.", 'x'));

	String value = "null";

	opCode func = null;
	int opcode = Integer.parseInt(binary.substring(0, 6), 2);
	if (opcode == 28) {
	    int id = Integer.parseInt(binary.substring(26, 32), 2);
	    func = funct1.get(id);
	    value = func.getOpcode();
	} else if (opcode == 1) {
	    int id = Integer.parseInt(binary.substring(12, 16), 2);
	    func = funct1.get(id);
	    value = func.getOpcode();
	} else if (opcode == 0) {
	    int id = Integer.parseInt(binary.substring(26, 32), 2);
	    func = funct2.get(id);
	    value = func.getOpcode();
	    if (id == 1) {
		id = Integer.parseInt(binary.substring(16, 16), 2);
		func = mov1.get(id);
		value = func.getOpcode();
	    }
	} else if ((opcode >= 16) && (opcode <= 19)) {
	    int z = opcode - 16;
	    int id = Integer.parseInt(binary.substring(7, 11), 2);
	    func = rs.get(id);
	    value = func.getOpcode();
	    if (id == 0 || id == 2 || id == 4 || id == 6) {
		value = rs.get(id).getOpcode();
		value = value + z;
	    }
	    if ((id == 8) && (z > 0)) {
		id = Integer.parseInt(binary.substring(15, 16), 2);
		value = funct1.get(id).getOpcode();
		value = value.replaceAll("z", String.valueOf(z));
	    }
	    if (id == 16) {

	    }
	    if (id == 17) {

	    }
	} else {
	    func = opCode.get(opcode);
	    value = opCode.get(opcode).getOpcode();
	}



	System.err.print(value + " ");
	if (func.getType() == 'r' || func.getType() == 'i') {
	    int rsT = Integer.parseInt(binary.substring(6, 11), 2);

	    int rtT = Integer.parseInt(binary.substring(11, 16), 2);
	    String rsS = register.get(rsT);
	    String rtS = register.get(rtT);
	    if (func.getType() == 'r') {

		short rdT = (short)Integer.parseInt(binary.substring(16, 21), 2);
		String rdS = register.get(rdT);
		System.err.println(" " + rdS + " " + rsS + " " + rtS);
	    }else if (func.getType() == 'i'){
		int immediate = Integer.parseInt(binary.substring(16, 32), 2);
		System.err.println(rsS + " " + rtS + " " + immediate);
	    }

	} else if(func.getType() == 'j') {
	    int where = Integer.parseInt(binary.substring(6, 32), 2);
	    System.err.println("" + where);
	}else {
	}
	    System.err.print("\n");
	}

    }
