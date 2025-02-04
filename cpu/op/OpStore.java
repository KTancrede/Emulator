package pobj.tme6.cpu.op;

import pobj.tme6.cpu.ICPUState;

public class OpStore implements IOpCode<ICPUState> {
	@Override
	public int execute(ICPUState state) {
		state.getMemory().write(state.fetch(), state.getA());
		return 2;
	}
}
