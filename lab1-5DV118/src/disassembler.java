
public class disassembler {

	public void parser(String binary) {

		Mappings mapping = new Mappings();
		Instruction MIPS = new Instruction();
		String mnemonicFormat = "";
		String value = "null";
		opCode func = null;
		System.out.println(Long.toHexString(Long.parseLong(binary,2)));
		
		int opcode = Integer.parseInt(binary.substring(0, 6), 2);
		if (opcode == 28) {
			int id = Integer.parseInt(binary.substring(26, 32), 2);
			func = mapping.funct1.get(id);
			value = func.getOpcode();
		} else if (opcode == 1) {
			int id = Integer.parseInt(binary.substring(12, 16), 2);
			func = mapping.funct1.get(id);
			value = func.getOpcode();
		} else if (opcode == 0) {
			int id = Integer.parseInt(binary.substring(26, 32), 2);
			func = mapping.funct2.get(id);
			value = func.getOpcode();
			if (id == 1) {
				id = Integer.parseInt(binary.substring(16, 16), 2);
				func = mapping.mov1.get(id);
				value = func.getOpcode();
			}
		} else if ((opcode >= 16) && (opcode <= 19)) {
			int z = opcode - 16;
			int id = Integer.parseInt(binary.substring(7, 11), 2);
			func = mapping.rs.get(id);
			value = func.getOpcode();
			if (id == 0 || id == 2 || id == 4 || id == 6) {
				value = mapping.rs.get(id).getOpcode();
				value = value + z;
			}
			if ((id == 8) && (z > 0)) {
				id = Integer.parseInt(binary.substring(15, 16), 2);
				value = mapping.funct1.get(id).getOpcode();
				value = value.replaceAll("z", String.valueOf(z));
			}
			if (id == 16) {

			}
			if (id == 17) {

			}
		} else {
			func = mapping.opCode.get(opcode);	    
			value = mapping.opCode.get(opcode).getOpcode();
		}

		MIPS.setFormat(func.getType());


		if (func.getType() == 'r' || func.getType() == 'i') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);

			int rtT = Integer.parseInt(binary.substring(11, 16), 2);
			String rsS = mapping.register.get(rsT);
			String rtS = mapping.register.get(rtT);
			if (func.getType() == 'r') {

				short rdT = (short)Integer.parseInt(binary.substring(16, 21), 2);
				String rdS = mapping.register.get(rdT);
				mnemonicFormat = value + " " +  rdS + " " + rsS + " " + rtS;
			} else if (func.getType() == 'i'){
				int immediate = Integer.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rsS + " " + rtS + " " + immediate;
			}

		} else if(func.getType() == 'j') {
			int where = Integer.parseInt(binary.substring(6, 32), 2);
			mnemonicFormat = value + " " + where; 

		}
		MIPS.setMnemonicFormat(mnemonicFormat);
	}

}
