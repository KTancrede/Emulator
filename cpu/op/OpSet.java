package pobj.tme6.cpu.op;

import pobj.tme6.cpu.ICPUState;

public class OpSet implements IOpCode<ICPUState> {
	@Override
	public int execute(ICPUState state) {
		int argument=state.fetch();
		state.setA(argument);
		return 2;
	}
}
