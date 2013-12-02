import java.math.BigInteger;


public class disassembler {

	public void parser(String binary, Instruction MIPS ) {

		Mappings mapping = new Mappings();

		String mnemonicFormat = "";
		String value = "null";
		opCode func = null;
		String hexDecompose = null;
		String decDecompose = null;
		int id = 0;
		//System.out.println(Long.toHexString(Long.parseLong(binary,2)));

		int opcode = Integer.parseInt(binary.substring(0, 6), 2);
		if (opcode == 28) {
			id = Integer.parseInt(binary.substring(26, 32), 2);

			func = mapping.funct1.get(id);
			value = func.getOpcode();
		} else if (opcode == 1) {
			id = Integer.parseInt(binary.substring(12, 16), 2);

			func = mapping.funct1.get(id);
			value = func.getOpcode();
		} else if (opcode == 0) {
			id = Integer.parseInt(binary.substring(26, 32), 2);

			func = mapping.funct2.get(id);
			value = func.getOpcode();
			if (id == 1) {
				id = Integer.parseInt(binary.substring(16, 16), 2);

				func = mapping.mov1.get(id);
				value = func.getOpcode();
			}
		} else if ((opcode >= 16) && (opcode <= 19)) {
			int z = opcode - 16;
			id = Integer.parseInt(binary.substring(7, 11), 2);

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
		hexDecompose = "[0x" + new BigInteger(binary.substring(0, 6), 2).toString(16);
		MIPS.setFormat(func.getType());

		if (func.getType() == 'r' || func.getType() == 'i') {

			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int rtT = Integer.parseInt(binary.substring(11, 16), 2);


			String rsS = mapping.register.get(rsT);
			String rtS = mapping.register.get(rtT);
			if (func.getType() == 'r') {
				int rdT = (int)Integer.parseInt(binary.substring(16, 21), 2);
				String rdS = mapping.register.get(rdT);
				mnemonicFormat = value + " " +  rdS + " " + rsS + " " + rtS;
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(16);
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(11, 16), 2).toString(16);
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(16, 21), 2).toString(16);
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(21, 26), 2).toString(16);
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(16);

				decDecompose = "[" + new BigInteger(binary.substring(0, 6), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(11, 16), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(16, 21), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(21, 26), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(10);
			} else if (func.getType() == 'i'){
				int immediate = Integer.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rsS + " " + rtS + " " + immediate;
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(16);
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(11, 16), 2).toString(16);
				hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(16, 32), 2).toString(16);

				decDecompose = "[" + new BigInteger(binary.substring(0, 6), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(11, 16), 2).toString(10);
				decDecompose = decDecompose + " " + new BigInteger(binary.substring(16, 32), 2).toString(10);
			}

		} else if(func.getType() == 'j') {
			int where = Integer.parseInt(binary.substring(6, 32), 2);
			mnemonicFormat = value + " " + where;

		} else if(func.getType() == 'l') {
			mnemonicFormat = value;
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(6, 26), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "[" + new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(6, 26), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if(func.getType() == 'm') {
			int rdT = (int)Integer.parseInt(binary.substring(16, 21), 2);
			String rdS = mapping.register.get(rdT);
			mnemonicFormat = value + " " + rdS;
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(6, 16), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(16, 21), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(21, 26), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "[" + new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(6, 16), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(16, 21), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(21, 26), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if(func.getType() == 'n') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			String rsS = mapping.register.get(rsT);
			mnemonicFormat = value + " " + rsS;
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(11, 26), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "[" + new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(11, 26), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if(func.getType() == 'o') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int rdT = Integer.parseInt(binary.substring(6, 11), 2);
			String rsS = mapping.register.get(rsT);
			String rdS = mapping.register.get(rdT);
			mnemonicFormat = value + " " + rsS + " " + rdS;
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(16, 21), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(21, 26), 2).toString(16);
			hexDecompose = hexDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "[" + new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(16, 21), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(21, 26), 2).toString(10);
			decDecompose = decDecompose + " " + new BigInteger(binary.substring(26, 32), 2).toString(10);
		} 
		if(value == null){
			mnemonicFormat = "Instruction not known";
		}
		hexDecompose = hexDecompose + "]";
		decDecompose = decDecompose + "]";
		MIPS.setMnemonicFormat(mnemonicFormat);
		MIPS.setHexDecomposed(hexDecompose);
		MIPS.setDecDecomposed(decDecompose);
	}

}
