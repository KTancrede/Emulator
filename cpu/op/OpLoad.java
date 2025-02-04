package pobj.tme6.cpu.op;

import pobj.tme6.cpu.ICPUState;

public class OpLoad implements IOpCode<ICPUState> {
	@Override
	public int execute(ICPUState state) {
		int val=state.getMemory().read(state.fetch());
		state.setA(val);
		return 2;
	}
}
