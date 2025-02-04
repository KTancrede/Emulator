package pobj.tme6.extra.m6502.op;

import pobj.tme6.extra.m6502.M6502;

public class OpCLD implements IOpCode2<M6502> {
	
	@Override
	public int execute(M6502 cpu) {
		cpu.setD(false);
		return 2;
	}

	@Override
	public String disassemble(M6502 cpu) {
		return "CLD";
	}
}
