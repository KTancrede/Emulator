package pobj.tme6.cpu.op;

import pobj.tme6.cpu.ICPUState;

public class OpAdd implements IOpCode<ICPUState> {
	@Override
	public int execute(ICPUState state) {
		state.setA(state.getA()+state.fetch());
		return 2;
	}
}
