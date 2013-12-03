import java.math.BigInteger;

public class disassembler {

	public int parser(String binary, Instruction MIPS) {

		Mappings mapping = new Mappings();

		String mnemonicFormat = "";
		String value = "null";
		opCode func = null;
		String hexDecompose = null;
		String decDecompose = null;
		int id = 0;

		int opcode = Integer.parseInt(binary.substring(0, 6), 2);

		if (opcode == 28) {
			id = Integer.parseInt(binary.substring(26, 32), 2);

			func = mapping.funct1.get(id);
			if (func == null) {
				MIPS.setFormat('X');
				MIPS.setHexDecomposed("Partial legality - level 1, opcode = 28, funct = "
						+ id + ".");
				return -1;
			}
			value = func.getOpcode();

		} else if (opcode == 1) {
			id = Integer.parseInt(binary.substring(11, 16), 2);

			func = mapping.rt.get(id);
			if (func == null) {
				MIPS.setFormat('X');
				MIPS.setHexDecomposed("Partial legality - level 1, opcode = 1, rt = "
						+ id + ".");
				return -1;
			}
			value = func.getOpcode();
		} else if (opcode == 0) {
			id = Integer.parseInt(binary.substring(26, 32), 2);

			func = mapping.funct2.get(id);
			if (func == null) {
				MIPS.setFormat('X');
				MIPS.setHexDecomposed("Partial legality - level 1, opcode = 0, funct = "
						+ id + ".");
				return -1;
			}
			value = func.getOpcode();
			if (id == 1) {
				id = Integer.parseInt(binary.substring(16, 16), 2);

				func = mapping.mov1.get(id);
				if (func == null) {
					MIPS.setFormat('X');
					MIPS.setHexDecomposed("Partial legality - level 2, funct = "
							+ id + ".");
					return -1;
				}
				value = func.getOpcode();
			} if (id == 0) {
				int shamt = Integer.parseInt(binary.substring(21, 26), 2);
				if(shamt == 0) {
					func = mapping.funct2.get(100);
					value = "nop";
					MIPS.setFormat('l');
				}
			}
		} else if ((opcode >= 16) && (opcode <= 19)) {
			int z = opcode - 16;
			id = Integer.parseInt(binary.substring(7, 11), 2);

			func = mapping.rs.get(id);
			if (func == null) {
				MIPS.setFormat('X');
				MIPS.setHexDecomposed("Partial legality - level 1, opcode = "
						+ opcode + ", rs = " + id + ".");
				return -1;
			}
			value = func.getOpcode();
			if (id == 0 || id == 2 || id == 4 || id == 6) {
				func = mapping.rs.get(id);
				if (func == null) {
					MIPS.setFormat('X');
					MIPS.setHexDecomposed("partial legality - level 2, opcode = "
							+ opcode + ", funct = " + id + ".");
					return -1;
				}
				value = func.getOpcode();
				value = value + z;
			}
			if ((id == 8) && (z > 0)) {
				id = Integer.parseInt(binary.substring(15, 16), 2);

				func = mapping.funct1.get(id);
				if (func == null) {
					MIPS.setFormat('X');
					MIPS.setHexDecomposed("partial legality - level 2, opcode = "
							+ opcode + ", funct = " + id + ".");
					return -1;
				}
				value = func.getOpcode();
				value = value.replaceAll("z", String.valueOf(z));
			}
			if (id == 16) {
				MIPS.setFormat('X');
				MIPS.setHexDecomposed("Instruction not supported");
				return -1;
			}
			if (id == 17) {
				MIPS.setFormat('X');
				MIPS.setHexDecomposed("partial legality - level 2, opcode = "
						+ opcode + ", funct = " + id + ".");
				return -1;
			}
		} else {
			func = mapping.opCode.get(opcode);

			if (func == null) {
				MIPS.setFormat('X');
				MIPS.setHexDecomposed("Instruction not known, OP = " + opcode
						+ ".");
				return -1;
			}
			value = func.getOpcode();
		}
		hexDecompose = "[0x"
				+ new BigInteger(binary.substring(0, 6), 2).toString(16);
		MIPS.setFormat(func.getType());

		if (func.getType() == 'r' || func.getType() == 'i') {

			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int rtT = Integer.parseInt(binary.substring(11, 16), 2);

			String rsS = mapping.register.get(rsT);
			String rtS = mapping.register.get(rtT);
			if (func.getType() == 'r') {
				int rdT = (int) Integer.parseInt(binary.substring(16, 21), 2);
				String rdS = mapping.register.get(rdT);
				mnemonicFormat = value + " " + rdS + ", " + rsS + ", " + rtS;
				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(6, 11), 2)
								.toString(16);
				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(11, 16), 2)
								.toString(16);
				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(16, 21), 2)
								.toString(16);
				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(21, 26), 2)
								.toString(16);
				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(26, 32), 2)
								.toString(16);

				decDecompose = "["
						+ new BigInteger(binary.substring(0, 6), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(6, 11), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(11, 16), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(16, 21), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(21, 26), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(26, 32), 2)
								.toString(10);
			} else if (func.getType() == 'i') {
				if (value.charAt(value.length() - 1) == 'u') {
					int immediate = Integer.parseInt(binary.substring(16, 32),
							2);
					mnemonicFormat = value + " " + rsS + ", " + rtS + ", "
							+ immediate;
				} else {
					short immediate = (short) Integer.parseInt(
						binary.substring(16, 32), 2);
					mnemonicFormat = value + " " + rsS + ", " + rtS + ", "
							+ immediate;
				}

				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(6, 11), 2)
								.toString(16);
				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(11, 16), 2)
								.toString(16);
				hexDecompose = hexDecompose
						+ " "
						+ new BigInteger(binary.substring(16, 32), 2)
								.toString(16);

				decDecompose = "["
						+ new BigInteger(binary.substring(0, 6), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(6, 11), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(11, 16), 2)
								.toString(10);
				decDecompose = decDecompose
						+ " "
						+ new BigInteger(binary.substring(16, 32), 2)
								.toString(10);
			}

		} else if (func.getType() == 'h') {
			int rtT = Integer.parseInt(binary.substring(11, 16), 2);
			String rtS = mapping.register.get(rtT);
			if (value.charAt(value.length() - 1) == 'u') {
				int immT = Integer.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rtS + ", " + immT;
			} else {
				short immT = (short) Integer.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rtS + ", " + immT;
			}

			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(10);
		} else if (func.getType() == 'j') {
			int where = Integer.parseInt(binary.substring(6, 32), 2);
			mnemonicFormat = value + " " + where;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 32), 2).toString(10);

		} else if (func.getType() == 'k') {
			int codeT = (int) Integer.parseInt(binary.substring(6, 26), 2);
			String codeS = mapping.register.get(codeT);
			mnemonicFormat = value + " " + codeS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 26), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 26), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if (func.getType() == 'l') {
			mnemonicFormat = value;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 26), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 26), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if (func.getType() == 'm') {
			int rdT = (int) Integer.parseInt(binary.substring(16, 21), 2);
			String rdS = mapping.register.get(rdT);
			mnemonicFormat = value + " " + rdS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(21, 26), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(21, 26), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if (func.getType() == 'n') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			String rsS = mapping.register.get(rsT);
			mnemonicFormat = value + " " + rsS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 26), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 26), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if (func.getType() == 'o') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int rdT = Integer.parseInt(binary.substring(16, 21), 2);
			String rsS = mapping.register.get(rsT);
			String rdS = mapping.register.get(rdT);
			mnemonicFormat = value + " " + rsS + ", " + rdS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(21, 26), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(21, 26), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if (func.getType() == 'p') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int rtT = Integer.parseInt(binary.substring(11, 16), 2);
			String rsS = mapping.register.get(rsT);
			String rtS = mapping.register.get(rtT);
			mnemonicFormat = value + " " + rsS + ", " + rtS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 26), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 26), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if (func.getType() == 'q') {
			int rtT = Integer.parseInt(binary.substring(11, 16), 2);
			int rdT = Integer.parseInt(binary.substring(16, 21), 2);
			String rtS = mapping.register.get(rtT);
			String rdS = mapping.register.get(rdT);
			mnemonicFormat = value + " " + rtS + ", " + rdS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(21, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(21, 32), 2).toString(10);
		} else if (func.getType() == 's') {
			int rdT = Integer.parseInt(binary.substring(16, 21), 2);
			int rtT = Integer.parseInt(binary.substring(11, 16), 2);
			String rtS = mapping.register.get(rtT);
			String rdS = mapping.register.get(rdT);
			mnemonicFormat = value + " " + rdS + ", " + rtS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(21, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(21, 32), 2).toString(10);
		} else if (func.getType() == 't') {
			int rdT = Integer.parseInt(binary.substring(16, 21), 2);
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int ccT = Integer.parseInt(binary.substring(11, 14), 2);
			String rdS = mapping.register.get(rdT);
			String rsS = mapping.register.get(rsT);
			String ccS = mapping.register.get(ccT);
			mnemonicFormat = value + " " + rdS + ", " + rsS + ", " + ccS;
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 14), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(14, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(21, 26), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 14), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(14, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 21), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(21, 26), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(26, 32), 2).toString(10);
		} else if (func.getType() == 'v') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			String rsS = mapping.register.get(rsT);
			if (value.charAt(value.length() - 1) == 'u') {
				int labelT = Integer.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rsS + ", " + labelT;
			} else {
				short labelT = (short) Integer
					.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rsS + ", " + labelT;
			}

			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(10);
		} else if (func.getType() == 'x') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			String rsS = mapping.register.get(rsT);
			if (value.charAt(value.length() - 1) == 'u') {
				int immT = Integer.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rsS + ", " + immT;
			} else {
				short immT = (short) Integer.parseInt(binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rsS + ", " + immT;
			}

			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(10);
		} else if (func.getType() == 'y') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int rtT = Integer.parseInt(binary.substring(11, 16), 2);
			String rsS = mapping.register.get(rsT);
			String rtS = mapping.register.get(rtT);
			if (value.charAt(value.length() - 1) == 'u') {
				int addressT = Integer.parseInt(binary.substring(16, 32), 2);

				mnemonicFormat = value + " " + rtS + ", " + addressT + "(" + rsS + ")";
			} else {
				short addressT = (short) Integer.parseInt(
						binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + rtS + ", " + addressT + "(" + rsS + ")";
			}

			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(10);
		} else if (func.getType() == 'z') {
			int rsT = Integer.parseInt(binary.substring(6, 11), 2);
			int ftT = Integer.parseInt(binary.substring(11, 16), 2);
			String rsS = mapping.register.get(rsT);
			String ftS = mapping.register.get(ftT);
			if (value.charAt(value.length() - 1) == 'u') {
				int addressT = Integer.parseInt(binary.substring(16, 32), 2);

				mnemonicFormat = value + " " + ftS + ", " + addressT + "(" + rsS + ")";
			} else {
				short addressT = (short) Integer.parseInt(
						binary.substring(16, 32), 2);
				mnemonicFormat = value + " " + ftS + ", " + addressT + "(" + rsS + ")";
			}

			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(16);
			hexDecompose = hexDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(16);

			decDecompose = "["
					+ new BigInteger(binary.substring(0, 6), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(6, 11), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(11, 16), 2).toString(10);
			decDecompose = decDecompose + " "
					+ new BigInteger(binary.substring(16, 32), 2).toString(10);
		}
		if (value == null) {
			mnemonicFormat = "Instruction not known";
		}
		hexDecompose = hexDecompose + "]";
		decDecompose = decDecompose + "]";
		MIPS.setMnemonicFormat(mnemonicFormat);
		MIPS.setHexDecomposed(hexDecompose);
		MIPS.setDecDecomposed(decDecompose);
		return 0;
	}

}
