package pobj.tme6.extra.m6502.op;

import pobj.tme6.extra.m6502.M6502;

public class OpPHA implements IOpCode2<M6502> {
	
	@Override
	public int execute(M6502 cpu) {
		cpu.push8(cpu.getA());
		return 3;
	}

	@Override
	public String disassemble(M6502 cpu) {
		return "PHA";
	}
}
